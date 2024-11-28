package FullResource.core;

import arc.*;
import mindustry.game.*;
import arc.graphics.*;
import arc.math.*;
import arc.scene.event.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.blocks.storage.*;

public class Core1 {
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
