package org.CoreNight.util;

import org.CoreNight.Entity.EntityPlayer;
import org.CoreNight.GameManager;
import org.CoreNight.Main;
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

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods){
        if( GameManager.mode == GameManager.Mode.GAME){
            if(key == GLFW_KEY_LEFT && action != GLFW_RELEASE){
                player.row = player.row == 0 ? 0 : player.row - 1;
            }else if(key == GLFW_KEY_RIGHT && action != GLFW_RELEASE){
                player.row = player.row == GameManager.rowcount - 1 ?
                             GameManager.rowcount - 1 : player.row + 1;
            }
        }else if(GameManager.mode == GameManager.Mode.MENU){
            if(key == GLFW_KEY_UP && action != GLFW_RELEASE){
                GameManager.buttonIndex = GameManager.buttonIndex == 0 ? 0 : GameManager.buttonIndex - 1;
            }else if(key == GLFW_KEY_DOWN && action != GLFW_RELEASE){
                GameManager.buttonIndex = GameManager.buttonIndex == 1 ?
                             1 : GameManager.buttonIndex + 1;
            }
        }
        if(key == GLFW_KEY_ESCAPE){
            Main.running = false;
        }
    }
}
