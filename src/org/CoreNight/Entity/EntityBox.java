package org.CoreNight.Entity;

import org.CoreNight.GameManager;
import org.CoreNight.Main;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

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
        glColor3ub((byte)color.getRed(),(byte) color.getGreen(),(byte) color.getBlue());
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

        if(this.y + this.height > GameManager.player.y && this.row == GameManager.player.row && !(this instanceof EntityPlayer)) {
            GameManager.addColor(this.color);
            EntityManager.remove(this);
            if (this.y + this.height > GameManager.player.y && this.row == GameManager.player.row && !(this instanceof EntityPlayer)) {
                GameManager.addColor(this.color);
                EntityManager.remove(this);
                if (this.color.equals(Color.WHITE)) {
                    if (GameManager.player.lives == 1) {
                        System.exit(0);
                    } else {
                        GameManager.player.lives -= 1;
                    }
                }

                if (this.color.equals(Color.BLUE)) {
                    System.out.println("Blue color hit");
                    float origSpeed = GameManager.speed;
                    GameManager.speed = 1;
                    Timer t = new Timer();
                    t.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            GameManager.speed = origSpeed;
                            GameManager.background = new Color(0, 0, 0);
                        }
                    }, 5000, 1000);
                }

                if (this.color.equals(Color.GREEN)) {
                    GameManager.player.lives += 1;
                }

                if (this.color.equals(Color.RED)) {
                    // put red ability code here
                }
            }
        }
    }
}
