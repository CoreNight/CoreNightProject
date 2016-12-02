package org.CoreNight;

import org.CoreNight.Entity.EntityBox;
import org.CoreNight.Entity.EntityPlayer;

import java.awt.*;
import java.util.Random;

import static org.lwjgl.opengl.GL11.glClearColor;

/**
 * Created by Brennan on 11/30/2016.
 */
public class GameManager{
    public static EntityPlayer player;
    public static Color background;
    public static float r = 0, g=0, b=0;
    public static int cycles = 0;
    public static int rowcount = 6;
    public static float speed = 1;
    public static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.BLUE,
            Color.GREEN

    };

    public static void init(){
        player = new EntityPlayer();


    }
    public static void tick(){

        speed *=1.001;
        Random rand = new Random();
        cycles++;
        if(cycles % 100 == 0){
            Color color;
            if(rand.nextInt(100)>80 && (speed/2)>.75){
                color = COLORS[rand.nextInt(COLORS.length)];
            }else{
                color = Color.LIGHT_GRAY;
            }

            EntityBox box = new EntityBox(rand.nextInt(rowcount), color);

        }
    }

    public static void updateColor(){
        float count = r + g + b + 1;
        background = new Color(r/count, g/count, b/count);
        glClearColor(r/count, g/count, b/count, 1.0f);
    }
    public static void addColor(Color color){
        float[] c = color.getRGBColorComponents(null);
        r += c[0];
        g += c[1];
        b += c[2];
        player.color = getContrastColor(background);
    }
    public static Color getContrastColor(Color color) {
        double y = (299 * color.getRed() + 587 * color.getGreen() + 114 * color.getBlue()) / 1000;
        return y >= 128 ? Color.black : Color.white;
    }

    private enum Mode {
        MENU,GAME;
    }
}
