package informatis.ui.fragments.sidebar.windows.tools.tools;

import arc.graphics.gl.FrameBuffer;
import mindustry.graphics.Layer;

public class UnitVisualizer extends Tool {
    final float[] layers = { Layer.flyingUnit, Layer.flyingUnitLow, Layer.legUnit, Layer.groundUnit};
    final FrameBuffer buffer = new FrameBuffer();
    float alpha = 1;

}
/*
        Core.app.post(() -> {
            cachedTextures = new Seq[Vars.content.units().size];

            Seq<UnitType> unitTypes = Vars.content.units();
            for(int i = 0; i < cachedTextures.length; i++) {
                UnitType unitType = unitTypes.get(i);
                Seq<Object> regions = new Seq<>();
                for (var part : unitType.parts) {
                    regions.add(part);
                }
                regions.add((Object) null);

                for (var engine : unitType.engines) {
                    regions.add(engine);
                }
                regions.add((Object) null);

                regions.add(unitType.baseRegion);
                regions.add(unitType.legRegion);
                regions.add(unitType.region);
                regions.add(unitType.previewRegion);
                regions.add(unitType.shadowRegion);
                regions.add(unitType.cellRegion);
                regions.add(unitType.itemCircleRegion);
                regions.add(unitType.softShadowRegion);
                regions.add(unitType.jointRegion);
                regions.add(unitType.footRegion);
                regions.add(unitType.legBaseRegion);
                regions.add(unitType.baseJointRegion);
                regions.add(unitType.outlineRegion);
                regions.add(unitType.treadRegion);

                for(Weapon weapon : unitType.weapons) {
                    for (var part : weapon.parts) {
                        regions.add(part);
                    }
                    regions.add((Object) null);
                    regions.add(weapon.region);
                    regions.add(weapon.cellRegion);
                    regions.add(weapon.heatRegion);
                    regions.add(weapon.outlineRegion);
                }
                cachedTextures[i] = regions;
            }
        });
    }

    @Override
    public void setEnabled(boolean value) {
        super.setEnabled(value);
         if(this.isEnabled()) clearRegions();
         else restoreRegions();
    }

    private void restoreRegions() {
        Seq<UnitType> unitTypes = Vars.content.units();
        for(int i = 0; i < cachedTextures.length; i++) {
            Iterator<?> regions = cachedTextures[i].iterator();
            UnitType unitType = unitTypes.get(i);
            while(true) {
                DrawPart region = (DrawPart) regions.next();
                if(region == null) break;
                unitType.parts.add(region);
            }
            while(true) {
                UnitType.UnitEngine region = (UnitType.UnitEngine) regions.next();
                if(region == null) break;
                unitType.engines.add(region);
            }


            unitType.baseRegion = (TextureRegion) regions.next();
            unitType.legRegion = (TextureRegion) regions.next();
            unitType.region = (TextureRegion) regions.next();
            unitType.previewRegion = (TextureRegion) regions.next();
            unitType.shadowRegion = (TextureRegion) regions.next();
            unitType.cellRegion = (TextureRegion) regions.next();
            unitType.itemCircleRegion = (TextureRegion) regions.next();
            unitType.softShadowRegion = (TextureRegion) regions.next();
            unitType.jointRegion = (TextureRegion) regions.next();
            unitType.footRegion = (TextureRegion) regions.next();
            unitType.legBaseRegion = (TextureRegion) regions.next();
            unitType.baseJointRegion = (TextureRegion) regions.next();
            unitType.outlineRegion = (TextureRegion) regions.next();
            unitType.treadRegion = (TextureRegion) regions.next();

            for(Weapon weapon : unitType.weapons) {
                while(true) {
                    DrawPart part = (DrawPart) regions.next();
                    if(part == null) break;
                    weapon.parts.add(part);
                }
                weapon.region = (TextureRegion) regions.next();

                weapon.region = (TextureRegion) regions.next();
                weapon.cellRegion = (TextureRegion) regions.next();
                weapon.heatRegion = (TextureRegion) regions.next();
                weapon.outlineRegion = (TextureRegion) regions.next();
            }
        }
    }
    private void clearRegions() {
        Seq<UnitType> unitTypes = Vars.content.units();
        for(int i = 0; i < cachedTextures.length; i++) {
            UnitType unitType = unitTypes.get(i);
            unitType.parts.clear();
            unitType.engines.clear();

            unitType.baseRegion =
            unitType.legRegion =
            unitType.region =
            unitType.previewRegion =
            unitType.shadowRegion =
            unitType.cellRegion =
            unitType.itemCircleRegion =
            unitType.softShadowRegion =
            unitType.jointRegion =
            unitType.footRegion =
            unitType.legBaseRegion =
            unitType.baseJointRegion =
            unitType.outlineRegion =
            unitType.treadRegion = SVars.clear;
            unitType.wreckRegions = unitType.segmentRegions = unitType.segmentOutlineRegions = new TextureRegion[]{};
            unitType.treadRegions = new TextureRegion[][] {};

            for(Weapon weapon : unitType.weapons) {
                weapon.parts.clear();
                weapon.region = weapon.cellRegion = weapon.heatRegion = weapon.outlineRegion = SVars.clear;
            }
        }
   }
}
*/