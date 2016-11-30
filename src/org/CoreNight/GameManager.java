package org.CoreNight;

import org.CoreNight.Entity.EntityBox;

import java.awt.*;
import java.util.Random;

import static org.lwjgl.opengl.GL11.glClearColor;

/**
 * Created by Brennan on 11/30/2016.
 */
public class GameManager{
    private static Color background;
    public static float r = 0, g=0, b=0;
    public static int cycles = 0;
    public static int rowcount = 6;
    public static float speed = 1;
    public static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.GRAY,
            Color.LIGHT_GRAY
    };
    public static void tick(){
        speed *=1.0005;
        Random rand = new Random();
        cycles++;
        if(cycles % 50 == 0){
            EntityBox box = new EntityBox(rand.nextInt(rowcount), COLORS[rand.nextInt(COLORS.length)]);

        }
    }

    public static void updateColor(){
        float count = r + g + b;

        glClearColor(r/count, g/count, b/count, 1.0f);
    }
    public static void addColor(Color color){
        float[] c = color.getRGBColorComponents(null);
        r += c[0];
        g += c[1];
        b += c[2];
    }
}
