package informatis.ui.fragments;

import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.ImageButton;
import arc.scene.ui.layout.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.world.Tile;

import static informatis.SUtils.*;
import static arc.Core.*;

public class TileInfoFragment {
    private boolean waveShown;
    final Table tileInfoTable = new Table(Tex.buttonEdge4);
    final Table tileInfoContainer;

    public TileInfoFragment() {
        Table waveTable = (Table) scene.find("waves");
        Table infoTable = (Table) scene.find("infotable");
        waveTable.removeChild(infoTable);
        waveTable.row();
        tileInfoContainer = waveTable.table(titleInfoBody -> {
            titleInfoBody.left();
            titleInfoBody.stack(
                new Table(collapse -> {
                    collapse.collapser(tileInfoTable, true, () -> waveShown).growX();
                }).top(),
                new Table(collapseButton -> {
                    ImageButton button = new ImageButton(Icon.downOpen, Styles.clearTogglei);
                    button.clicked(() -> {
                        waveShown = !waveShown;

                        TextureRegionDrawable icon = waveShown ? Icon.upOpen : Icon.downOpen;
                        button.getStyle().imageUp = icon;
                        button.resizeImage(icon.imageSize());
                        button.setChecked(waveShown);
                    });
                    collapseButton.add(button);
                }).left().top()
            ).growX();
            titleInfoBody.row();
            titleInfoBody.add(infoTable).left();
        }).growX().get();
        rebuildTileInfoTable();
    }

    public void rebuildTileInfoTable() {
        tileInfoContainer.visible = settings.getBool("tileinfo");
        if(!tileInfoContainer.visible) return;

        tileInfoTable.clear();
        tileInfoTable.center();
        tileInfoTable.table(head -> {
            head.label(() -> {
                Tile tile = getTile();
                if(tile == null) return "(NaN, NaN)";
                return Strings.format("(@, @)", tile.x, tile.y);
            }).center();
        });
    }
}
