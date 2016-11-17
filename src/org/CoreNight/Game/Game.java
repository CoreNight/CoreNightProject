package org.CoreNight.Game;

import org.lwjgl.glfw.GLFW;

import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * Created by Brennan on 11/17/2016.
 */
public class Game {
    private long windowID;
    public Game(){

    }
    public static Game instance = new Game();

    public void init() {
        //init glfw
        if(GLFW.glfwInit() != true){
            System.err.println("Error initializing GLFW");
            System.exit(1);
        }
        windowID = GLFW.glfwCreateWindow(640, 480, "Core Night", NULL, NULL);

        if (windowID == NULL)
        {
            System.err.println("Error creating a window");
            System.exit(1);
        }
    }

    public void start(){
        float now, last, delta;

        last = 0;

        // Initialise the Game
        init();

        // Loop continuously and render and update
        while (GLFW.glfwWindowShouldClose(windowID) != true)
        {
            // Get the time
            now = (float) GLFW.glfwGetTime();
            delta = now - last;
            last = now;

            // Update and render
            update(delta);
            render(delta);

            // Poll the events and swap the buffers
            GLFW.glfwPollEvents();
            GLFW.glfwSwapBuffers(windowID);
        }

        // Dispose the game
        dispose();

        // Destroy the window
        GLFW.glfwDestroyWindow(windowID);
        GLFW.glfwTerminate();

        System.exit(0);
    }

    private void dispose() {
    }

    private void render(float delta) {
    }

    private void update(float delta) {
    }
}
