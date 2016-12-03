package org.CoreNight;
import static org.lwjgl.glfw.GLFW.*; //windows
import static org.lwjgl.opengl.GL11.*; //OpenGL
import static org.lwjgl.system.MemoryUtil.NULL;

import org.CoreNight.util.KeyboardHandler;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.glfw.GLFWVidMode;

import java.awt.*;

/**
 * Created by Brennan on 11/17/2016.
 */
public class Main implements Runnable {
    public Color background;
    private Thread thread;
    public boolean running = true;
    public static long window;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = screenSize.width;
    public static int height = screenSize.height;
    private GLFWKeyCallback callback;


    public static void main(String[] args) {
        Main game = new Main();
        game.start();
    }
    public void start(){
        running = true;
        //TODO change name.
        thread = new Thread(this, "GameName");
        thread.start();
    }
    public void init(){
        if(glfwInit() != true){
            System.err.println("GLFW failed to initialize");
        }
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        //TODO change name.
        window = glfwCreateWindow(width, height, "GameName", glfwGetPrimaryMonitor(), NULL);
        if(window == NULL){
            System.err.println("Window failed to be created");
        }

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, 0, 50);
        glfwMakeContextCurrent(window);
        glfwShowWindow(window);
        GL.createCapabilities();
        glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        glEnable(GL_DEPTH_TEST);

        //set up projection matrix; allows us to draw.
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        GameManager.mode = GameManager.Mode.GAME;
        GameManager.init();


        glfwSetKeyCallback(window, callback = new KeyboardHandler(GameManager.player));
        System.out.println("OpenGL: "+ glGetString(GL_VERSION));

    }
    public void update(){
        GameManager.tick(); //put game code somewhere else.
        glfwPollEvents();
    }
    public void render(){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        GameManager.render();
        glfwSwapBuffers(window);

    }

    /**
     * Main game loop
     */
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double delta = 0.0;
        double ns = 1000000000.0 / 60.0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            //limit to 60fps
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1.0){

                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                updates = 0;
                frames = 0;
            }

            if(glfwWindowShouldClose(window) == true){
                running = false;
            }
        }
    }
}
