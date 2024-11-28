package FullResource.core;

import arc.*;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.scene.ui.Label;
import arc.scene.ui.Tooltip;
import arc.scene.ui.layout.Table;
import mindustry.content.UnitTypes;
import mindustry.core.UI;
import mindustry.game.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.gen.Groups;
import mindustry.type.*;
import mindustry.ui.Styles;
import mindustry.world.blocks.storage.*;

import static mindustry.Vars.iconSmall;

public class Core1 {
    Table window;
    float heat;
    final ObjectMap<Team, ItemData> itemData = new ObjectMap<>();

    public Core1() {
        resetUsed();
        Events.run(EventType.Trigger.update, () -> {
            heat += Time.delta;
            if (heat >= 60f) {
                heat = 0f;
                for (Team team : getTeams()) {
                    if (!itemData.containsKey(team)) itemData.put(team, new ItemData());
                    itemData.get(team).updateItems(team);
                }
            }
        });
    }

    public void buildBody(Table table) {
        window = table;

        table.background(Styles.black8).top();
        table.pane(Styles.noBarPane, rebuild()).grow().name("core-pane").get().setScrollingDisabled(true, false);
        Events.on(EventType.WorldLoadEvent.class, e -> resetUsed());
    }

    Table rebuild() {
        return new Table(table -> {
            table.top();
            for (Team team : getTeams()) {
                table.table(row -> {
                    row.center();
                    row.add(setTable(team)).margin(8f).row();
                }).growX().row();
            }
        });
    }

    public Table setTable(Team team) {
        return new Table(table -> {
            table.add(team.name).color(team.color).row();
            int max = Math.max(1, Math.round(window.getWidth() / 2 / 60));
            table.table(coretable -> {
                int row = 0;

                for (CoreBlock.CoreBuild core : team.cores()) {
                    coretable.table(tt -> {
                        tt.stack(
                                new Table(s -> {
                                    s.center();
                                    Tooltip.Tooltips option = new Tooltip.Tooltips();
                                    option.animations = false;
                                }),
                                new Table(h -> {
                                    h.bottom().defaults().height(9f).width(9f).growX();
                                    h.pack();
                                })
                        ).row();
                        Label label = new Label(Strings.format("(@, @)", core.tileX(), core.tileY()));
                        label.setFontScale(0.75f);
                        tt.add(label);
                    }).padTop(2).padLeft(4).padRight(4);
                    if (row++ % max == max - 1) {
                        coretable.row();
                    }
                }
            }).row();

            table.table(itemTable -> {
                int row = 0;

                CoreBlock.CoreBuild core = team.core();
                if (core == null || core.items == null) {
                    return;
                }
                for (int i = 0; i < Vars.content.items().size; i++) {
                    Item item = Vars.content.item(i);
                    if (!team.items().has(item)) continue;
                    itemTable.stack(
                            new Table(ttt -> ttt.add(UI.formatAmount(core.items.get(item))).minWidth(5 * 8f).left()),
                            new Table(ttt -> {
                                ttt.bottom().right();
                                if (itemData == null || itemData.get(team) == null) return;
                                int amount = itemData.get(team).updateItems.isEmpty() ? 0 : Mathf.floor(itemData.get(team).updateItems.get(item.id).amount);
                                Label label = new Label(amount + "/s");
                                label.setFontScale(0.65f);
                                label.setColor(amount > 0 ? Color.green : amount == 0 ? Color.orange : Color.red);
                                ttt.add(label).bottom().right().padTop(16f);
                                ttt.pack();
                            })).padRight(3).left();
                    if (row++ % max == max - 1) {
                        itemTable.row();
                    }
                }
            }).row();

            table.table(unitTable -> {
                int row = 0;

                for (UnitType unit : Vars.content.units()) {
                    if (unit != UnitTypes.block && Groups.unit.contains(u -> u.type == unit && u.team == team)) {
                        unitTable.table(tt -> {
                            tt.center();
                            tt.image(unit.uiIcon).size(iconSmall).padRight(3).tooltip(ttt -> ttt.background(Styles.black6).add(unit.localizedName).style(Styles.outlineLabel).margin(2f));
                            tt.add(UI.formatAmount(Groups.unit.count(u -> u.team == team && u.type == unit))).padRight(3).minWidth(5 * 8f).left();
                        });
                        if (row++ % max == max - 1) {
                            unitTable.row();
                        }
                    }
                }
            });
        });
    }

    public Seq<Team> getTeams() {
        return Seq.with(Team.all).filter(Team::active);
    }

    public void resetUsed() {
        for (Team team : getTeams()) {
            itemData.put(team, new ItemData());
        }
    }

    static class ItemData {
        final Seq<ItemStack> prevItems = new Seq<>();
        final Seq<ItemStack> updateItems = new Seq<>();

        ItemData() {
            resetItems();
        }

        public void resetItems() {
            Seq<ItemStack> stacks = Vars.content.items().map(item -> new ItemStack(item, 0));
            updateItems.clear().addAll(stacks);
            prevItems.clear().addAll(stacks);
        }

        public void updateItems(Team team) {
            CoreBlock.CoreBuild core = team.core();
            if (core == null || core.items == null) return;

            Seq<ItemStack> stack = updateItems;
            if (stack.isEmpty()) {
                Vars.content.items().each(i -> stack.add(new ItemStack(i, 0)));
            }

            for (Item item : Vars.content.items()) {
                stack.get(item.id).set(item, core.items.get(item) - prevItems.get(item.id).amount);
                prevItems.get(item.id).set(item, core.items.get(item));
            }
            prevItems.clear().addAll(Vars.content.items().map(i -> new ItemStack(i, core.items.get(i))));
        }
    }
}
