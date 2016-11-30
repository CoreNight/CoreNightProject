package org.CoreNight.Entity;

import org.CoreNight.Main;

import java.awt.*;

/**
 * Created by Brennan on 11/17/2016.
 */
public class Entity {
    public float x = 1, y = 1;
    public Color color;
    public float speed = 5f;

    public Entity(){
        EntityManager.put(this);
    }
    public void draw(){

    }
    public void update(){
        if( this.y > Main.height){
            EntityManager.remove(this);
        }else if(!(this instanceof EntityPlayer)){
            this.y += speed;
        }
    }
}
