package org.CoreNight.Entity;

import org.CoreNight.Main;

import java.awt.*;

/**
 * Created by Brennan on 11/17/2016.
 */
public class EntityPlayer extends EntityBox {
    int lives = 1;
    public EntityPlayer(){
        super();
        this.color = Color.BLACK;
        this.y = Main.height - 100;
        this.height = 100;

    }
    public void draw(){
        super.draw();
    }
    @Override
    public void update(){

    }
}
