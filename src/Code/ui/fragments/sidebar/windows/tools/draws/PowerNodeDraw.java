package Code.ui.fragments.sidebar.windows.tools.draws;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.math.Mathf;
import arc.struct.IntSeq;
import arc.struct.Seq;
import mindustry.core.Renderer;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;

import static arc.Core.atlas;
import static Code.SUtils.getTarget;
import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class PowerNodeDraw extends OverDraw {
    final Seq<Building> linkedNodes = new Seq<>();

    public PowerNodeDraw() {
        super("powerNode");
    }

    @Override
    public void draw() {
        if(getTarget() instanceof Building build) {
            linkedNodes.clear();
            drawNodeLink(build);
        }
    }

    void drawNodeLink(Building node) {
        if(node.power == null) return;
        if(linkedNodes.contains(node)) return;

        linkedNodes.add(node);
        IntSeq seq = node.proximity().mapInt(Building::pos);
        seq.addAll(node.power.links);
        for(int i : seq.items) {
            Building other = world.build(i);
            if(other == null || other.power == null) return;
            float angle1 = Angles.angle(node.x, node.y, other.x, other.y),
                    vx = Mathf.cosDeg(angle1), vy = Mathf.sinDeg(angle1),
                    len1 = node.block.size * tilesize / 2f - 1.5f, len2 = other.block.size * tilesize / 2f - 1.5f;
            Draw.color(Color.white, Color.valueOf("98ff98"), (1f - node.power.graph.getSatisfaction()) * 0.86f + Mathf.absin(3f, 0.1f));
            Draw.alpha(Renderer.laserOpacity);
            Drawf.laser(atlas.find("Code-Slaser"), atlas.find("Code-Slaser"), atlas.find("Code-Slaser-end"), node.x + vx * len1, node.y + vy * len1, other.x - vx * len2, other.y - vy * len2, 0.25f);

            drawNodeLink(other);
        }
    }
}
