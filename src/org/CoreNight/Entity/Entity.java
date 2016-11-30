package org.CoreNight.Entity;

import java.awt.*;

/**
 * Created by Brennan on 11/17/2016.
 */
public class Entity {
    public int x, y;
    public Color color;
    public double speed;

    public Entity(){
        EntityManager.put(this);
    }
    public void draw(){

    }
    public void update(){

    }
    public int[] getColor(){
        return new int[]{color.getRed(), color.getBlue(), color.getGreen()};
    }

}
