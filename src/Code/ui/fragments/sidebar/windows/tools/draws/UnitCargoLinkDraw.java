package Code.ui.fragments.sidebar.windows.tools.draws;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import mindustry.ai.types.CargoAI;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.world.blocks.units.UnitCargoLoader;

public class UnitCargoLinkDraw extends OverDraw {
    public UnitCargoLinkDraw() {
        super("unitCargoLink");
    }

    @Override
    public void onBuilding(Building building) {
        if(building instanceof UnitCargoLoader.UnitTransportSourceBuild build) {
            Unit unit = build.unit;
            if(unit != null && unit.item() != null && unit.controller() instanceof CargoAI ai && ai.unloadTarget != null) {
                Building targetBuild = ai.unloadTarget;

                Lines.stroke(2);
                Draw.color(build.team.color);
                Draw.alpha(0.5f);
                Lines.line(build.x, build.y, unit.x, unit.y);
                Draw.color(unit.item().color);
                Draw.alpha(0.5f);
                Lines.line(unit.x, unit.y, targetBuild.x, targetBuild.y);
            }
        }
    }
}
