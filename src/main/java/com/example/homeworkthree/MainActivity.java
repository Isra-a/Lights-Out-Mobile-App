package com.example.homeworkthree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LightsOutModel mGame;
    private Button[][] mButtons;
    private int mOnColor;
    private int mOffColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOnColor= ContextCompat.getColor(this,R.color.yellow);
        mOffColor=ContextCompat.getColor(this,R.color.black);
        mButtons=new Button[LightsOutModel.NUM_ROWS][LightsOutModel.NUM_COLS];

        GridLayout gridLayout=findViewById(R.id.light_grid);
        int childIndex=0;
        for(int row=0;row<LightsOutModel.NUM_ROWS;row++){
            for(int col=0;col<LightsOutModel.NUM_COLS;col++){
                mButtons[row][col]=(Button)gridLayout.getChildAt(childIndex);
                childIndex++;
            }
        }
        mGame=new LightsOutModel();
        StartGame();
    }
    private void StartGame(){
        mGame.newGame();
        SetColors();
    }

    public void onLightClick (View view){
        boolean buttonFound=false;
        for(int row=0;row<LightsOutModel.NUM_ROWS && !buttonFound;row++){
            for(int col=0;col<LightsOutModel.NUM_COLS && !buttonFound;col++){
                if(view == mButtons[row][col]){
                    mGame.selectLights(row,col);
                    buttonFound=true;
                }
            }
            SetColors();

        }
        if(mGame.isGameOver()){
            Toast.makeText(this,"Congratulations!",Toast.LENGTH_SHORT).show();
        }
    }
    public void SetNewGame(View view){StartGame();}
    public void SetColors(){
        for(int row=0;row<LightsOutModel.NUM_ROWS;row++){
            for(int col=0;col<LightsOutModel.NUM_COLS;col++){
                if(mGame.isLightOn(row,col)){
                    mButtons[row][col].setBackgroundColor(mOnColor);
                }
                else{
                    mButtons[row][col].setBackgroundColor(mOffColor);
                }
            }
        }
    }
}