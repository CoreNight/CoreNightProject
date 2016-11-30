package org.CoreNight.Entity;

import org.CoreNight.Main;

import java.awt.*;

import static org.lwjgl.glfw.GLFW.*;

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
        super.update();
        glfwWaitEvents();
        glfwWaitEventsTimeout(0d);

        if(glfwGetKey(Main.window, GLFW_KEY_LEFT) == GLFW_TRUE){
            this.row = row == 0 ? 0 : row - 1;
        }else if(glfwGetKey(Main.window, GLFW_KEY_RIGHT) == GLFW_TRUE){
            this.row = row == this.rowcount - 1 ? this.rowcount - 1 : row + 1;
        }
        System.out.println(this.row);
    }
}
