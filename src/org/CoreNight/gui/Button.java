package org.CoreNight.gui;

import org.CoreNight.util.Text;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 * Created by Brennan on 12/2/2016.
 */
public class Button{
    private int x, y, height, width;
    private Color background, highlight;
    private String text;
    public Button(int x, int y, int height, int width, Color background, Color highlight, String text){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.background = background;
        this.highlight = Color.WHITE;
        this.text = text;
    }

    public void onAction(){

    }
    public void drawWithHighlight(){
        glColor3ub((byte)highlight.getRed(),(byte)highlight.getGreen(),(byte)highlight.getBlue());
        glBegin(GL_QUADS);
            glVertex2f(this.x, this.y); //top left
            glVertex2f(this.x + this.width, this.y);
            glVertex2f(this.x + this.width, this.y + this.height);
            glVertex2f(this.x, this.y + this.height);
        glEnd();
        this.draw();
    }
    public void draw(){
        glColor3ub((byte)background.getRed(),(byte)background.getGreen(),(byte)background.getBlue());
        glBegin(GL_QUADS);
            glVertex2f(this.x+5, this.y+5); //top left
            glVertex2f(this.x + this.width -5, this.y +5); //top right
            glVertex2f(this.x + this.width -5, this.y + this.height -5); //bottom right
            glVertex2f(this.x +5, this.y + this.height - 5); //bottom left
        glEnd();
        this.drawText();
    }
    public void drawText(){
        Text.drawString(this.text, this.x + 10, this.y/2, 10, this.width - 20);
    }
}
