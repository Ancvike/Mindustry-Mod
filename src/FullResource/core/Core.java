package FullResource.core;

import FullResource.ui.UI;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.scene.ui.Label;
import arc.scene.ui.layout.Table;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.game.Team;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.Vars.iconSmall;
import static mindustry.Vars.state;

public class Core {
    public BaseDialog baseDialog_no = new BaseDialog("失败");
    public BaseDialog baseDialog_yes;
    Table window;
    final ObjectMap<Team, ItemData> itemData = new ObjectMap<>();

    public Core() {
        baseDialog_no_show();
        UI ui = new UI();
        ui.imageButton.clicked(this::onClick);
    }

    public void onClick() {
        if (!state.rules.waves && state.isCampaign()) {//区块是否占领
            //先检测核心是哪个,并get资源量及上限
            for (Team team : getTeams()) {
                baseDialog_yes.add(setTable(team));
            }
        } else {
            baseDialog_no.show();
        }
    }

    public void baseDialog_no_show() {
        baseDialog_no.cont.add("区块未占领,无法使用该功能").row();
        baseDialog_no.cont.image(arc.Core.atlas.find("full-resource-frog")).pad(20f).row();
        baseDialog_no.cont.button("了解", baseDialog_no::hide).size(100f, 50f);
    }

    public Table setTable(Team team) {
        return new Table(table -> {
            table.add(team.name).color(team.color).row();
            int max = Math.max(1, Math.round(window.getWidth() / 2 / 60));
            table.table(itemTable -> {
                int row = 0;

                CoreBlock.CoreBuild core = team.core();
                if (core == null || core.items == null) {
                    return;
                }
                for (int i = 0; i < Vars.content.items().size; i++) {
                    Item item = Vars.content.item(i);
                    if (!team.items().has(item)) continue;
                    itemTable.stack(new Table(ttt -> {
                        ttt.image(item.uiIcon).size(iconSmall).tooltip(tttt -> tttt.background(Styles.black6).add(item.localizedName).style(Styles.outlineLabel).margin(2f));
                        ttt.add(mindustry.core.UI.formatAmount(core.items.get(item))).minWidth(5 * 8f).left();
                    }), new Table(ttt -> {
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
        });
    }
    public Seq<Team> getTeams(){
        return Seq.with(Team.all).filter(Team::active);
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

//        public void updateItems(Team team){
//            CoreBlock.CoreBuild core = team.core();
//            if (core == null || core.items == null) return;
//
//            Seq<ItemStack> stack = updateItems;
//            if(stack.isEmpty()) {
//                Vars.content.items().each(i -> stack.add(new ItemStack(i, 0)));
//            }
//
//            for (Item item : Vars.content.items()) {
//                stack.get(item.id).set(item, core.items.get(item) - prevItems.get(item.id).amount);
//                prevItems.get(item.id).set(item, core.items.get(item));
//            }
//            prevItems.clear().addAll(Vars.content.items().map(i -> new ItemStack(i, core.items.get(i))));
//        }
    }
}
