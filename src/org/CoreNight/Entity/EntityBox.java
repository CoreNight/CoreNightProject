package org.CoreNight.Entity;

import org.CoreNight.GameManager;
import org.CoreNight.Main;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Brennan on 11/29/2016.
 */
public class EntityBox extends Entity{
    public int row;
    public int height = 100;
    public int width = Main.width / GameManager.rowcount;
    public EntityBox(){
        this(0, Color.black);
    }

    public EntityBox(int row, Color color){
        super();
        this.row = row;
        this.color = color;
        this.y = 1;
        this.x = row*width;

    }


    public void draw(){
        glColor3ub((byte)color.getRed(),(byte) color.getBlue(),(byte) color.getGreen());
        glBegin(GL_QUADS);
            glVertex2f(this.x, this.y); //top left
            glVertex2f(this.x + this.width, this.y);
            glVertex2f(this.x + this.width, this.y + this.height);
            glVertex2f(this.x, this.y + this.height);
        glEnd();
    }

    public void update(){
        super.update();
        this.x = row * width;

        if(this.y + this.height > Main.player.y && this.row == Main.player.row && !(this instanceof EntityPlayer)){
            System.out.println("Collision!");;
            EntityManager.remove(this);
        }
    }
}
