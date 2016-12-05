package org.CoreNight;

import org.CoreNight.Entity.EntityBox;
import org.CoreNight.Entity.EntityManager;
import org.CoreNight.Entity.EntityPlayer;
import org.CoreNight.gui.ButtonPlay;

import java.awt.*;
import java.util.Random;

import static org.lwjgl.opengl.GL11.glClearColor;

/**
 * Created by Brennan on 11/30/2016.
 */
public class GameManager{
    public static Mode mode;
    public static EntityPlayer player;
    public static Color background;
    public static float r = 0, g=0, b=0;
    public static int cycles = 0;
    public static int rowcount = 6;
    public static float speed = 1;
    static ButtonPlay play;
    public static int buttonIndex = 0;
    public static Color spawnOverride = null;
    public static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.BLUE,
            Color.GREEN
    };

    public static void init(){
        if(mode == Mode.GAME){
            player = new EntityPlayer();
        }
        else if(mode == Mode.MENU){
            glClearColor(0,0,0,0);
            play = new ButtonPlay(100, 100, 100, 100, Color.BLUE, Color.WHITE, "Play");
        }
    }

    public static void tick(){
        if(mode == Mode.GAME){
            GameManager.updateColor();
            EntityManager.updateEntities();

            speed *= 1.001;
            Random rand = new Random();
            cycles++;
            if(cycles % 100 == 0){
                Color color;
                if(spawnOverride != null){
                 color = spawnOverride;
                }else{
                    if(rand.nextInt(100) > 80 && (speed / 2) > .75){
                        color = COLORS[rand.nextInt(COLORS.length)];
                    }else{
                        color = Color.WHITE;
                    }
                }
                EntityBox box = new EntityBox(rand.nextInt(rowcount), color);
            }
        }
        else if(mode == Mode.MENU){

        }
    }

    public static void render(){
        if(mode == Mode.GAME){
            EntityManager.drawEntities();
        }else if(mode == Mode.MENU){
            if(buttonIndex == 0){
                play.drawWithHighlight();
                System.out.println(buttonIndex);
            }else if(buttonIndex == 1){
                play.draw();
            }else{

            }

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
        player.color = Color.DARK_GRAY;
    }

    public enum Mode {
        MENU,GAME
    }
}
