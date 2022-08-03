/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author hutch
 */
public class Controls implements KeyListener{
    
    public CopyOnWriteArrayList<Integer> pressed = new CopyOnWriteArrayList<>();
    
    private static Controls instance = null;
      
    public static Controls getInstance(){
        
        if(instance == null){
            
            instance = new Controls();
        }
        
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
          
        //paddle 1
        
        if(e.getKeyCode() == KeyEvent.VK_W){
            
            if(!pressed.contains(e.getKeyCode())){          //stops multiple entrys (paddle moves too fast)
                
                pressed.add(e.getKeyCode());                //adds keycode to copyOnWriteArrayList
            }
        }       
        if(e.getKeyCode() == KeyEvent.VK_S){
                       
               if(!pressed.contains(e.getKeyCode())){          //stops multiple entrys (paddle moves too fast)
                
                pressed.add(e.getKeyCode());                //adds keycode to copyOnWriteArrayList
            }
           
        }
        
        //paddle 2
        
        if(e.getKeyCode() == KeyEvent.VK_P){
            
               if(!pressed.contains(e.getKeyCode())){          //stops multiple entrys (paddle moves too fast)
                
                pressed.add(e.getKeyCode());                //adds keycode to copyOnWriteArrayList
            }
           
        }
        if(e.getKeyCode() == KeyEvent.VK_L){
            
               if(!pressed.contains(e.getKeyCode())){          //stops multiple entrys (paddle moves too fast)
                
                pressed.add(e.getKeyCode());                //adds keycode to copyOnWriteArrayList
            }
           
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE && !Main.playing){            //restarts game
                                
            Main.playing = true;
            Main.Game();
           
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
