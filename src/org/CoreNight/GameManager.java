package org.CoreNight;

import org.CoreNight.Entity.EntityBox;

import java.awt.*;
import java.util.Random;

/**
 * Created by Brennan on 11/30/2016.
 */
public class GameManager{
    private static int cycles = 0;
    public static int rowcount = 6;
    public static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.BLUE,
            Color.GREEN
    };
    public static void tick(){
        Random rand = new Random();
        cycles++;
        if(cycles % 2  == 0){
            EntityBox box = new EntityBox(rand.nextInt(rowcount), COLORS[rand.nextInt(3)]);

        }
    }
}
