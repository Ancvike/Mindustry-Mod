package informatis;

import arc.Core;
import arc.func.*;
import arc.math.geom.Position;
import arc.struct.Seq;
import arc.util.*;
import mindustry.Vars;
import mindustry.input.DesktopInput;
import mindustry.world.Tile;

import static arc.Core.*;
import static mindustry.Vars.*;

public class SUtils {

    /**
     * loop array with "final i", which can be referenced in callback scope.
     * @param array - just an array object to loop.
     * @param callback - callback function with "i" parameter.
     */
    public static <T> void loop(T[] array, Cons2<T, Integer> callback) {
        SUtils.loop(array, (t, i) -> {
            callback.get(t, i);
            return false;
        });
    }
    public static <T> void loop(T[] array, Func2<T, Integer, Boolean> callback) {
        for(int i = 0; i < array.length; i++) {
            if(callback.get(array[i], i)) break;
        }
    }

    /**
     * loop iterable object with "final i", which can be referenced in callback scope.
     * @param iterable - just an iterable object to loop.
     * @param callback - callback function with "i" parameter.
     */
    public static <T> void loop(Iterable<T> iterable, Func2<T, Integer, Boolean> callback) {
        int i = 0;
        for(T t : iterable) {
            if(callback.get(t, i)) break;
            i++;
        }
    }

    /**
     * for-loop with "final i", which can be referenced in callback scope.
     * @param number - max loop count number.
     * @param callback - callback function with "i" parameter.
     */
    public static void loop(int number, Cons<Integer> callback) {
        SUtils.loop(number, (i) -> {
            callback.get(i);
            return false;
        });
    }
    public static void loop(int number, Func<Integer, Boolean> callback) {
        for(int i = 0; i < number; i++) {
            if(callback.get(i)) break;
        }
    }

    public static <T, RT> RT[] pickFromArray(T[] array, Class<RT> returnType, Boolf<Integer> condition) {
        Seq<RT> list = new Seq<>();
        for(int i = 0; i < array.length; i++) {
            if(condition.get(i)) list.add((RT) array[i]);
        }
        return list.toArray(returnType);
    }

    /**
     * move camera to given coordination
     * @param x world unit x
     * @param y world unit y
     */
    public static void moveCamera(float x, float y) {
        if(control.input instanceof DesktopInput)
            ((DesktopInput) control.input).panning = true;
        Core.camera.position.set(x, y);
    }
    /**
     * move camera to given coordination
     * @param pos world unit coordination
     */
    public static void moveCamera(Position pos) {
        moveCamera(pos.getX(), pos.getY());
    }

    @Nullable
    public static Tile getTile(){
        return Vars.world.tileWorld(input.mouseWorldX(), input.mouseWorldY());
    }
}
