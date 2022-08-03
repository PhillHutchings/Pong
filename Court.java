/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author hutch
 */
public class Court extends JPanel implements commons{
    
    Paddle1 paddle1;
    Paddle2 paddle2;
    Ball ball;
    
    public int player1Score;
    public int player2Score;
    private int win = 10;
    
    protected JLabel score;
 
    public Court(){
        
        init();
     
    }
    
    private void init(){
        
        paddle1 = new Paddle1(this);
        paddle2 = new Paddle2(this);
        ball = new Ball(this);
        
        score = new JLabel("", SwingConstants.CENTER);
        score.setBounds((BOARD_WIDTH / 2) - 100, 10, 200, 30);
        score.setForeground(Color.WHITE);
        score.setFont(new Font("Serif", Font.BOLD, 20));
        add(score);
        score.setVisible(true);
        
        setLayout(null);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        
        if(Main.playing){           //stops the resetting of score when player gets to 10
            
            upDateScore();
        }
        
    }
    
    public void upDateScore(){
        
        if(player1Score < win && player2Score < win){      
            
            score.setText(player1Score + " | " + player2Score);
            
        }else{
            
            score.setText("Game Over");
            Main.playing = false;
            player1Score = 0;
            player2Score = 0;
            
            
        }
    }
    
    public void MovePaddles(){
        
        for(Integer btn : Controls.getInstance().pressed){                  //loops copyOnWriteArrayList
                    
            if(btn == KeyEvent.VK_W){       //paddle1 up
                 
                if(paddle1.getY() >= 0){            //checks paddle1 y is greater than 0
          
                    paddle1.moveY -= 2;             //moves paddle1 up
                         
                    //stopping the paddle1 from bouncing up and down
                    
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_S)){             //checks if down key (s) has been pressed previously
                        
                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_S));               //removes it from array if so
                    }
                    
                }else{          //removes keycode from array if paddle1 reaches top of screen,  paddle1 y = 0
                    
                    Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_W));       //removes the up (w) keycode from array
                    
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_S)){         //checks if down key (s) has been pressed previously
                        
                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_S));           //removes it from array if so
                        
                    }
                }
            }
            
            if(btn == KeyEvent.VK_S){               //paddle1 down
                 
                if(paddle1.getY() + PADDLE_HEIGHT + (PADDLE_HEIGHT /2) < BOARD_HEIGHT){         //checks if paddle1 y is less than the board height, altered to stop at bottom of paddle1
          
                    paddle1.moveY += 2;     //moves paddle1 down
                    
                    //stopping the paddle1 from bouncing up and down
                         
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_W)){            //checks if up key (w) has been pressed previously
                        
                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_W));              //removes it from array if so
                    }
                }else{         //removes keycode from array if paddle1 reaches bottom of screen,  paddle1 y = board height
                    
                    Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_S));      //removes the up (s) keycode from array
                    
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_W)){        //checks if up key (w) has been pressed previously
                        
                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_W));          //removes it from array if so
                    }
                }
                   
             }
            
            //same process for paddle2
            
            if(btn == KeyEvent.VK_P){

               if(paddle2.getY() >= 0){

                    paddle2.moveY -= 2;
                    
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_L)){

                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_L));
                    }

               }else{

                    Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_P));

                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_L)){

                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_L));
                    }
                }

            }
                 
            if(btn == KeyEvent.VK_L){
                 
                if(paddle2.getY() + PADDLE_HEIGHT + (PADDLE_HEIGHT /2) < BOARD_HEIGHT){
          
                    paddle2.moveY += 2;
                    
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_P)){
                        
                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_P));
                    }
                }else{
                   
                    Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_L));
                    
                    if(Controls.getInstance().pressed.contains(KeyEvent.VK_P)){
                        
                        Controls.getInstance().pressed.remove(Controls.getInstance().pressed.indexOf(KeyEvent.VK_P));
                    }
                }           
            }       
        }   
    }
}
