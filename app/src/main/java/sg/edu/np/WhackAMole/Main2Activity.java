package sg.edu.np.WhackAMole;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 8.
        - The function doCheck() takes in button selected and computes a hit or miss and adjust the score accordingly.
        - The functions readTimer() and placeMoleTimer() are to inform the user X seconds before starting and loading new mole.
        - Feel free to modify the function to suit your program.
    */

    private Button Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9;
    TextView advancedScore;
    private Integer score;
    private String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    CountDownTimer myCountDown;
    CountDownTimer readyTimer;

    final String TAG = "Whack-A-Mole 2.0!";

    private void readyTimer(){
        /*  HINT:
            The "Get Ready" Timer.
            Log.v(TAG, "Ready CountDown!" + millisUntilFinished/ 1000);
            Toast message -"Get Ready In X seconds"
            Log.v(TAG, "Ready CountDown Complete!");
            Toast message - "GO!"
            belongs here.
            This timer countdown from 10 seconds to 0 seconds and stops after "GO!" is shown.
         */
        readyTimer = new CountDownTimer(11000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.v(TAG, "Ready Countdown!" + millisUntilFinished/1000);
                Toast.makeText(getApplicationContext(), "Get Ready in " + millisUntilFinished/1000 + "seconds", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFinish() {
                Log.v(TAG, "Countdown Complete!");
                Toast.makeText(getApplicationContext(), "GO!", Toast.LENGTH_SHORT).show();
                readyTimer.cancel();
                placeMoleTimer();
            }
        };
        readyTimer.start();
    }
    private void placeMoleTimer(){
        /* HINT:
           Creates new mole location each second.
           Log.v(TAG, "New Mole Location!");
           setNewMole();
           belongs here.
           This is an infinite countdown timer.
         */
        countDownTimer();
    }
    private static final int[] BUTTON_IDS = {
        /* HINT:
            Stores the 9 buttons IDs here for those who wishes to use array to create all 9 buttons.
            You may use if you wish to change or remove to suit your codes.*/
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Hint:
            This starts the countdown timers one at a time and prepares the user.
            This also prepares the existing score brought over.
            It also prepares the button listeners to each button.
            You may wish to use the for loop to populate all 9 buttons with listeners.
         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent recData = getIntent();
        score = recData.getIntExtra("Score", 0);
        advancedScore = (TextView) findViewById(R.id.advScore);
        advancedScore.setText(""+score);

        Log.v(TAG, "Current User Score: " + String.valueOf(score));

        Button1 = (Button) findViewById(R.id.button1);
        Button2 = (Button) findViewById(R.id.button2);
        Button3 = (Button) findViewById(R.id.button3);
        Button4 = (Button) findViewById(R.id.button4);
        Button5 = (Button) findViewById(R.id.button5);
        Button6 = (Button) findViewById(R.id.button6);
        Button7 = (Button) findViewById(R.id.button7);
        Button8 = (Button) findViewById(R.id.button8);
        Button9 = (Button) findViewById(R.id.button9);

        for(final int id : BUTTON_IDS){
            /*  HINT:
            This creates a for loop to populate all 9 buttons with listeners.
            You may use if you wish to remove or change to suit your codes.
            */
        }

        readyTimer();
        doCheck();
    }
    @Override
    protected void onStart(){
        super.onStart();

        b1 = Button1.getText().toString();
        b2 = Button2.getText().toString();
        b3 = Button3.getText().toString();
        b4 = Button4.getText().toString();
        b5 = Button5.getText().toString();
        b6 = Button6.getText().toString();
        b7 = Button7.getText().toString();
        b8 = Button8.getText().toString();
        b9 = Button9.getText().toString();
    }
    private void doCheck()
    {
        /* Hint:
            Checks for hit or miss
            Log.v(TAG, "Hit, score added!");
            Log.v(TAG, "Missed, point deducted!");
            belongs here.
        */
        Button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b1 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b2 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b3 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b4 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b5 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b6 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b7 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b8 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
        Button9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onStart();
                if(b9 == "*"){
                    score += 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    score -= 1;
                    advancedScore.setText(""+score);
                    Log.v(TAG, "Missed, score deducted!");
                }
            }
        });
    }

    public void setNewMole()
    {
        /* Hint:
            Clears the previous mole location and gets a new random location of the next mole location.
            Sets the new location of the mole.
         */
        Random ran = new Random();
        int randomLocation = ran.nextInt(9);

        if(randomLocation == 0) {
            Button1.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 1){
            Button2.setText("*");
            Button1.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 2){
            Button3.setText("*");
            Button2.setText("O");
            Button1.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 3){
            Button4.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button1.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 4){
            Button5.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button1.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 5){
            Button6.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button1.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 6){
            Button7.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button1.setText("O");
            Button8.setText("O");
            Button9.setText("O");
        }
        else if (randomLocation == 7){
            Button8.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button1.setText("O");
            Button9.setText("O");
        }
        else{
            Button9.setText("*");
            Button2.setText("O");
            Button3.setText("O");
            Button4.setText("O");
            Button5.setText("O");
            Button6.setText("O");
            Button7.setText("O");
            Button8.setText("O");
            Button1.setText("O");
        }
    }

    private void countDownTimer() {

        myCountDown = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setNewMole();
                Log.v(TAG, "New Mole Location!");
            }

            @Override
            public void onFinish() {
                myCountDown.start();
            }
        };
        myCountDown.start();
    }
}

