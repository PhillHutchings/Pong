/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Rectangle;

/**
 *
 * @author hutch
 */
public interface commons {
    
    final int BOARD_WIDTH = 800;
    final int BOARD_HEIGHT = 600;
    int BALL_X = BOARD_WIDTH / 2;
    int BALL_Y = BOARD_HEIGHT / 2;
    int BALL_SIZE = 10;
    int BALL_START_X = (BOARD_WIDTH / 2) - BALL_SIZE;
    int BALL_START_Y = (BOARD_HEIGHT / 2) - BALL_SIZE;
    int PADDLE_HEIGHT = 80;
    int PADDLE_WIDTH = 10;
    int PADDLE_1_START_X = 20;
    int PADDLE_1_START_Y = (BOARD_HEIGHT / 2) -  PADDLE_HEIGHT / 2;
    int PADDLE_2_START_X = BOARD_WIDTH - 40;
    int PADDLE_2_START_Y = (BOARD_HEIGHT / 2) -  PADDLE_HEIGHT / 2;
    

  
}
