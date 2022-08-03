/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author hutch
 */
public class Main extends JFrame implements commons{

    private static Court court;
    public static boolean playing = false;
    
    public Main(){

        init();
    }
    
    private void init(){
                    
        court = new Court();
        
        court.score.setText("PRESS SPACEBAR");
        add(court);
        addKeyListener(Controls.getInstance());
        setTitle("Pong");
        setSize(BOARD_WIDTH, BOARD_HEIGHT);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        Game();
        
    }
    
    public static final void Game(){
        
        new javax.swing.Timer(10, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                if(playing){
                    
                    court.ball.move();
                    court.MovePaddles();
                    court.repaint();
                    
                }else{
                    
                    ((Timer)e.getSource()).stop();
                }         
            }
            
        }).start();
    }
    
    
    public static void main(String[] args) {
       
        java.awt.EventQueue.invokeLater(() -> {
        
            new Main().setVisible(true);
        });
    }
    
}
