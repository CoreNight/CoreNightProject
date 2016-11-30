package org.CoreNight.Entity;

import org.CoreNight.Main;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Brennan on 11/29/2016.
 */
public class EntityBox extends Entity{
    public int row;
    public int height = 100, rowcount = 6;
    public int width = Main.width / rowcount;
    public EntityBox(){
        this(0, Color.black);
    }

    public EntityBox(int row, Color color){
        super();
        this.row = row;
        this.color = color;
        this.y = 0;
        this.x = 0;

    }


    //@Override
    public void draw(){
        glColor3iv(this.getColor());
        glBegin(GL_QUADS);
            glVertex2i(this.x, this.y); //top left
            glVertex2i(this.x + this.width, this.y);
            glVertex2i(this.x + this.width, this.y + this.height);
            glVertex2i(this.x, this.y + this.height);
        glEnd();
    }

    public void update(){
        this.x = row * width;
    }
}
