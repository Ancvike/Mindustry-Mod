package Code.FullResource;

import mindustry.content.SectorPresets;
import static mindustry.content.Planets.serpulo;
import mindustry.type.SectorPreset;

public class FullResource extends SectorPresets {
    public FullResource() {
        groundZero = new SectorPreset("groundZero", serpulo, 15){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 1;
            difficulty = 1;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};
    }
}