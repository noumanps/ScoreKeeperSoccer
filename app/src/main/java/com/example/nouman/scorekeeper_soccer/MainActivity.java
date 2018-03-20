package com.example.nouman.scorekeeper_soccer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nouman.scorekeeper_soccer.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Sets condition as match not started
    boolean matchStarted = false;

    //Team A Goals
    int goalsTeamA = 0;

    //Team B Goals
    int goalsTeamB = 0;

    //Team A penaltiy Goals
    int penaltyGoalsTeamA = 0;

    //Team B penaltiy Goals
    int penaltyGoalsTeamB = 0;

    int totalGoalsTeamA = 0;

    int totalGoalsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Starts the match
    public void startMatch(View view) {
        matchStarted = true;        //Sets condition as match started
    }

    //Increase the number of Goals by 1 for Team A
    public void addGoalForTeamA(View view) {
        if (matchStarted == true) {
            goalsTeamA = goalsTeamA + 1;
            TotalTeamAGoals();
        } else {
            Toast.makeText(getApplicationContext(), "Match Not Started Yet!!", Toast.LENGTH_LONG).show();
        }
    }

    //Increase the number of Goals-by-Penalty by 1 for Team A
    public void addPenaltyForTeamA(View view) {
        if (matchStarted == true) {
            penaltyGoalsTeamA = penaltyGoalsTeamA + 1;
            TotalTeamAGoals();
        } else {
            Toast.makeText(getApplicationContext(), "Match Not Started Yet!!", Toast.LENGTH_LONG).show();
        }
    }

    //Increase the number of Goals by 1 for Team B
    public void addGoalForTeamB(View view) {
        if (matchStarted == true) {
            goalsTeamB = goalsTeamB + 1;
            TotalTeamBGoals();
        } else {
            Toast.makeText(getApplicationContext(), "Match Not Started Yet!!", Toast.LENGTH_LONG).show();
        }
    }

    //Increase the number of Goals-by-Penalty by 1 for Team B
    public void addPenaltyForTeamB(View view) {
        if (matchStarted == true) {
            penaltyGoalsTeamB = penaltyGoalsTeamB + 1;
            TotalTeamBGoals();
        } else {
            Toast.makeText(getApplicationContext(), "Match Not Started Yet!!", Toast.LENGTH_LONG).show();
        }
    }

    //Adds goals and Goals-by-Penalty and display total goals for Team A
    public void TotalTeamAGoals() {
        totalGoalsTeamA = goalsTeamA + penaltyGoalsTeamA;
        displayForTeamA(totalGoalsTeamA);
    }

    //Adds goals and Goals-by-Penalty and display total goals for Team B
    public void TotalTeamBGoals() {
        totalGoalsTeamB = goalsTeamB + penaltyGoalsTeamB;
        displayForTeamB(totalGoalsTeamB);
    }

    //View who won the game
    public void matchResult(View view) {
        if (matchStarted == true) {
            resultDisplay();
        } else {
            Toast.makeText(getApplicationContext(), "Match Not Started Yet!!", Toast.LENGTH_LONG).show();
        }
    }

    //Detail Score Card of both the teams
    public void scoreCard(View view) {
        if (matchStarted == true) {
            scoreCardDisplay();
        } else {
            Toast.makeText(getApplicationContext(), "Match Not Started Yet!!", Toast.LENGTH_LONG).show();
        }
    }

    //Reset Goals of Both Teams to 0, and make text views blank.
    public void resetGoals(View view) {
        matchStarted = false;               //Sets condition as match not started

        goalsTeamA = 0;
        goalsTeamB = 0;

        penaltyGoalsTeamA = 0;
        penaltyGoalsTeamB = 0;

        TotalTeamAGoals();
        TotalTeamBGoals();

        TextView scoreCardForA = (TextView) findViewById(R.id.scoreCardTeamA);
        scoreCardForA.setText("");

        TextView scoreCardForB = (TextView) findViewById(R.id.scoreCardTeamB);
        scoreCardForB.setText("");

        TextView displayView = (TextView) findViewById(R.id.display_text);
        displayView.setText("");
    }

    //Display the number of goals for Team A on screen
    public void displayForTeamA(int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_a_goal);
        goalView.setText(String.valueOf(goal));
    }

    //Display the number of goals for Team B on screen
    public void displayForTeamB(int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_b_goal);
        goalView.setText(String.valueOf(goal));
    }

    //Display game's result
    public void resultDisplay() {

        TextView scoreCardForA = (TextView) findViewById(R.id.scoreCardTeamA);
        TextView scoreCardForB = (TextView) findViewById(R.id.scoreCardTeamB);
        scoreCardForA.setText("");
        scoreCardForB.setText("");

        TextView displayView = (TextView) findViewById(R.id.display_text);

        if (totalGoalsTeamA > totalGoalsTeamB) {
            displayView.setText("Team A Won!!");
        } else if (totalGoalsTeamB > totalGoalsTeamA) {
            displayView.setText("Team B Won!!");
        } else if (totalGoalsTeamA == totalGoalsTeamB) {
            displayView.setText("The Match Was A Draw!!");
        }
    }

    //Display Both Teams Score Cards
    public void scoreCardDisplay() {

        TextView displayView = (TextView) findViewById(R.id.display_text);
        displayView.setText("");

        TextView scoreCardForA = (TextView) findViewById(R.id.scoreCardTeamA);
        TextView scoreCardForB = (TextView) findViewById(R.id.scoreCardTeamB);

        scoreCardForA.setText("Team A \n" +
                "Total Number of Goals: " + totalGoalsTeamA + "\n" +
                "Goals: " + goalsTeamA + "\n" +
                "Penalty Goals: " + penaltyGoalsTeamA);

        scoreCardForB.setText("Team B \n" +
                "Total Number of Goals: " + totalGoalsTeamB + "\n" +
                "Goals: " + goalsTeamB + "\n" +
                "Penalty Goals: " + penaltyGoalsTeamB);
    }
}
