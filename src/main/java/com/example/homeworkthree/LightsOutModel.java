package com.example.homeworkthree;

import java.util.Random;

public class LightsOutModel {

    public static final int NUM_ROWS=3;
    public static final int NUM_COLS=3;
    private boolean[][] lights;
    public LightsOutModel() {
        lights=new boolean[NUM_ROWS][NUM_COLS];
    }

    public void newGame(){
        Random randintgenerator=new Random();
        for(int row=0;row<NUM_ROWS; row++){
            for(int col=0;col<NUM_COLS;col++){
                lights[row][col]=randintgenerator.nextBoolean();
            }
        }
    }

    public boolean isLightOn(int row, int col){return lights[row][col];}

    public void selectLights(int row, int col){
        lights[row][col]=!lights[row][col];

        if(row>0){
            lights[row-1][col]=!lights[row-1][col];
        }
        if(row<NUM_ROWS-1){
            lights[row+1][col]=lights[row+1][col];
        }

        if(col>0){
            lights[row][col-1]=!lights[row][col-1];
        }

        if(col<NUM_COLS-1){
            lights[row][col+1]=!lights[row][col+1];
        }

    }

    public boolean isGameOver() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (lights[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

}
