package org.CoreNight.util;

import org.CoreNight.Entity.EntityPlayer;
import org.CoreNight.GameManager;
import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by Brennan on 11/30/2016.
 */
public class KeyboardHandler extends GLFWKeyCallback{
    private static EntityPlayer player;
    public KeyboardHandler(EntityPlayer player){
        this.player = player;
    }
    public static boolean[] keys = new boolean[65536];

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods){
        if(key == GLFW_KEY_LEFT && action != GLFW_RELEASE){
            player.row = player.row == 0 ? 0 : player.row - 1;
        }else if(key ==GLFW_KEY_RIGHT && action != GLFW_RELEASE){
            player.row = player.row == GameManager.rowcount - 1 ? GameManager.rowcount - 1 : player.row + 1;
        }
        if(key == GLFW_KEY_ESCAPE){
            System.exit(0);
        }
    }
}
