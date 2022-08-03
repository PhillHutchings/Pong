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

/**
 *
 * @author hutch
 */
public class Ball implements commons{
    
    public int dirX = 3;
    public int dirY = 3;
    private int x = BALL_START_X;
    private int y = BALL_START_Y;
    Court court;
    
    public Ball(Court court){
        
        this.court = court;
        
    }
    
 
    public void draw(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        
        g2d.fillOval(x, y, BALL_SIZE, BALL_SIZE);
               
    }
    
    public void move(){
        
        if(y + dirY <= 0){
            
            dirY = 3;
        }
        
        if(y + dirY >= BOARD_HEIGHT - 50){
            
            dirY = -3;
                   
        }
               
        if(Paddle1Collision()){
            
            dirX = 3;
        }
        
        if(Paddle2Collision()){
            
            dirX = -3;
        }
        
        if(player1Score()){
            
            court.player1Score++;
            x = BALL_START_X;
            y = BALL_START_Y;
            dirX = -2;          //slower to give chance from half court as too fast at 3
        }
        
        if(player2Score()){
            
            court.player2Score++;
            x = BALL_START_X;
            y = BALL_START_Y;
            dirX = 2;            //slower to give chance from half court as too fast at 3
        }
        
        x = x + dirX;
        y = y + dirY;
        
    }
    
    public Rectangle getBounds(){
        
        return new Rectangle(x, y, BALL_SIZE, BALL_SIZE);
    }
    
    public boolean Paddle1Collision(){
        
        return getBounds().intersects(court.paddle1.getBounds());
    }
    
      public boolean Paddle2Collision(){
        
        return getBounds().intersects(court.paddle2.getBounds());
    }
      
    public boolean player1Score(){
          
        return x + dirX > BOARD_WIDTH;
    }
   
     public boolean player2Score(){
          
        return x + dirX < 0;
    }
}
