package com.example.arun.projecttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {

    // The teams global scores
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    private Boolean hasATouchDown;
    private Boolean hasBTouchDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasATouchDown = false;
        hasBTouchDown = false;

        Button a_touchDownButton = (Button) findViewById(R.id.touch_down_a);
        Button a_fieldGoalButton = (Button) findViewById(R.id.field_goal_a);
        Button a_conversionButton = (Button) findViewById(R.id.conversion_a);
        Button a_incompleteButton = (Button) findViewById(R.id.incomplete_a);

        a_touchDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aTouchDown();
            }
        });

        a_fieldGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aFieldGoal();
            }
        });

        a_conversionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aConversion();
            }
        });

        a_incompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aIncomplete();
            }
        });



        Button b_touchDownButton = (Button) findViewById(R.id.touch_down_b);
        Button b_fieldGoalButton = (Button) findViewById(R.id.field_goal_b);
        Button b_conversionButton = (Button) findViewById(R.id.conversion_b);
        Button b_incompleteButton = (Button) findViewById(R.id.incomplete_b);

        b_touchDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bTouchDown();
            }
        });

        b_fieldGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bFieldGoal();
            }
        });

        b_conversionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bConversion();
            }
        });

        b_incompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bIncomplete();
            }
        });

        Button resetButton = (Button) findViewById(R.id.reset_button);

        resetButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resetScoreBoard();
            }
        });
    }

    private void showAOption(){
        Button a_touchDownButton = (Button) findViewById(R.id.touch_down_a);
        Button a_conversionButton = (Button) findViewById(R.id.conversion_a);
        Button a_incompleteButton = (Button) findViewById(R.id.incomplete_a);

        a_touchDownButton.setVisibility(View.INVISIBLE);
        a_conversionButton.setVisibility(View.VISIBLE);
        a_incompleteButton.setVisibility(View.VISIBLE);
    }

    private void hideAOption(){
        Button a_touchDownButton = (Button) findViewById(R.id.touch_down_a);
        Button a_conversionButton = (Button) findViewById(R.id.conversion_a);
        Button a_incompleteButton = (Button) findViewById(R.id.incomplete_a);
        Button a_fieldGoalButton = (Button) findViewById(R.id.field_goal_a);

        a_fieldGoalButton.setVisibility(View.VISIBLE);
        a_touchDownButton.setVisibility(View.VISIBLE);
        a_conversionButton.setVisibility(View.INVISIBLE);
        a_incompleteButton.setVisibility(View.INVISIBLE);
    }

    private void hideAllA(){
        Button a_touchDownButton = (Button) findViewById(R.id.touch_down_a);
        Button a_fieldGoalButton = (Button) findViewById(R.id.field_goal_a);
        Button a_conversionButton = (Button) findViewById(R.id.conversion_a);
        Button a_incompleteButton = (Button) findViewById(R.id.incomplete_a);

        a_touchDownButton.setVisibility(View.INVISIBLE);
        a_fieldGoalButton.setVisibility(View.INVISIBLE);
        a_conversionButton.setVisibility(View.INVISIBLE);
        a_incompleteButton.setVisibility(View.INVISIBLE);
    }

    private void hideAllB(){
        Button b_touchDownButton = (Button) findViewById(R.id.touch_down_b);
        Button b_fieldGoalButton = (Button) findViewById(R.id.field_goal_b);
        Button b_conversionButton = (Button) findViewById(R.id.conversion_b);
        Button b_incompleteButton = (Button) findViewById(R.id.incomplete_b);

        b_touchDownButton.setVisibility(View.INVISIBLE);
        b_conversionButton.setVisibility(View.INVISIBLE);
        b_fieldGoalButton.setVisibility(View.INVISIBLE);
        b_incompleteButton.setVisibility(View.INVISIBLE);
    }

    private void aTouchDown(){
        scoreTeamA += 6;
        hasATouchDown = true;
        displayForTeamA();
        showAOption();
        hideAllB();
    }

    private void aFieldGoal(){

        if(hasATouchDown){
            scoreTeamA += 1;
            hasATouchDown = false;
            hideAOption();
            hideBOption();
        }else{
            scoreTeamA += 3;
        }

        displayForTeamA();
    }

    private void aConversion(){
        if(hasATouchDown){
            scoreTeamA += 2;
            hasATouchDown = false;
            hideAOption();
            hideBOption();
        }

        displayForTeamA();
    }

    private void aIncomplete(){
        if(hasATouchDown){
            hasATouchDown = false;
            hideAOption();
            hideBOption();
        }
    }



    private void showBOption(){
        Button b_touchDownButton = (Button) findViewById(R.id.touch_down_b);
        Button b_conversionButton = (Button) findViewById(R.id.conversion_b);
        Button b_incompleteButton = (Button) findViewById(R.id.incomplete_b);

        b_touchDownButton.setVisibility(View.INVISIBLE);
        b_conversionButton.setVisibility(View.VISIBLE);
        b_incompleteButton.setVisibility(View.VISIBLE);
    }

    private void hideBOption(){
        Button b_touchDownButton = (Button) findViewById(R.id.touch_down_b);
        Button b_conversionButton = (Button) findViewById(R.id.conversion_b);
        Button b_incompleteButton = (Button) findViewById(R.id.incomplete_b);
        Button b_fieldGoalButton = (Button) findViewById(R.id.field_goal_b);

        b_fieldGoalButton.setVisibility(View.VISIBLE);
        b_touchDownButton.setVisibility(View.VISIBLE);
        b_conversionButton.setVisibility(View.INVISIBLE);
        b_incompleteButton.setVisibility(View.INVISIBLE);
    }

    private void bTouchDown(){
        scoreTeamB += 6;
        hasBTouchDown = true;
        displayForTeamB();
        showBOption();
        hideAllA();
    }

    private void bFieldGoal(){

        if(hasBTouchDown){
            scoreTeamB += 1;
            hasBTouchDown = false;
            hideBOption();
            hideAOption();

        }else{
            scoreTeamB += 3;
        }

        displayForTeamB();
    }

    private void bConversion(){
        if(hasBTouchDown){
            scoreTeamB += 2;
            hasBTouchDown = false;
            hideBOption();
            hideAOption();
        }

        displayForTeamB();
    }

    private void bIncomplete(){
        if(hasBTouchDown){
            hasBTouchDown = false;
            hideBOption();
            hideAOption();
        }
    }

    private void resetScoreBoard(){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA();
        displayForTeamB();
        hideAOption();
        hideBOption();
    }



    public void displayForTeamA(){
        TextView teamAScore = (TextView) findViewById(R.id.team_a_score);
        teamAScore.setText(String.valueOf(scoreTeamA));
    }

    public void displayForTeamB(){
        TextView teamAScore = (TextView) findViewById(R.id.team_b_score);
        teamAScore.setText(String.valueOf(scoreTeamB));
    }
}
