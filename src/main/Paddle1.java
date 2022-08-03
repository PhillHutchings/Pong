/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static main.commons.PADDLE_HEIGHT;
import static main.commons.PADDLE_WIDTH;

/**
 *
 * @author hutch
 */
public class Paddle1 implements commons{
    
    public int moveY;
    private static int y;
    private Court court;

    public Paddle1(Court court) {
        this.court = court;
    }
  
    
    public void draw(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(PADDLE_1_START_X, PADDLE_1_START_Y + moveY, PADDLE_WIDTH, PADDLE_HEIGHT);
        y = PADDLE_1_START_Y + moveY;
    }
    
    public void drawStop(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(PADDLE_1_START_X, PADDLE_1_START_Y + moveY, PADDLE_WIDTH, PADDLE_HEIGHT);
        y = PADDLE_1_START_Y + moveY;
    }


    public Rectangle getBounds() {
        
        return new Rectangle(PADDLE_1_START_X, PADDLE_1_START_Y + moveY, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public int getY() {
        
        return y;
    }
}
