package sg.edu.np.WhackAMole;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - The function doCheck() takes in button selected and computes a hit or miss and adjust the score accordingly.
        - The function doCheck() also decides if the user qualifies for the advance level and triggers for a dialog box to ask for user to decide.
        - The function nextLevelQuery() builds the dialog box and shows. It also triggers the nextLevel() if user selects Yes or return to normal state if user select No.
        - The function nextLevel() launches the new advanced page.
        - Feel free to modify the function to suit your program.
    */

    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView Score;
    private String left, middle, right;
    private Integer point = 1;

    final String TAG = "Whack-A-Mole 1.0!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);
        Score = (TextView) findViewById(R.id.Score);

        doCheck();
    }
    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");

        left = ButtonLeft.getText().toString();
        middle = ButtonMiddle.getText().toString();
        right = ButtonRight.getText().toString();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Paused Whack-A-Mole!");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stopped Whack-A-Mole!");
        finish();
    }

    private void doCheck() {
        /* Checks for hit or miss and if user qualify for advanced page.
            Triggers nextLevelQuery().
         */
        point = point - 1;

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button Left Clicked!");
                if(left == "*"){
                    point += 1;
                    Score.setText(""+point);
                    if(point%10 == 0){
                        nextLevelQuery();
                    }
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    point -= 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Missed, score deducted!");
                }
                onStart();
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                Log.v(TAG, "Button Middle Clicked!");
                if(middle == "*"){
                    point += 1;
                    Score.setText(""+point);
                    if(point%10 == 0){
                        nextLevelQuery();
                    }
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    point -= 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Missed, score deducted!");
                }
                onStart();
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                Log.v(TAG, "Button Right Clicked!");
                if(right == "*"){
                    point += 1;
                    Score.setText(""+point);
                    if(point%10 == 0){
                        nextLevelQuery();
                    }
                    Log.v(TAG, "Hit, score added!");
                }
                else{
                    point -= 1;
                    Score.setText(""+point);
                    Log.v(TAG, "Missed, score deducted!");
                }
                onStart();
            }
        });
    }

    private void nextLevelQuery(){
        /*
        Builds dialog box here.
        Log.v(TAG, "User accepts!");
        Log.v(TAG, "User decline!");
        Log.v(TAG, "Advance option given to user!");
        belongs here*/
        Log.v(TAG, "Advance option given to user!");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to advance to advanced mode?").setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Log.v(TAG, "User accepts!");
                nextLevel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Log.v(TAG, "User declines!");
                onResume();
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("Warning! Insane Whack-A-Mole Incoming!");
        alert.show();
    }

    private void nextLevel(){
        /* Launch advanced page */
        Intent nextLevel = new Intent(MainActivity.this, Main2Activity.class);
        nextLevel.putExtra("Score", point);
        startActivity(nextLevel);
    }

    private void setNewMole() {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        if(randomLocation == 0) {
            ButtonLeft.setText("*");
            ButtonMiddle.setText("O");
            ButtonRight.setText("O");
        }
        else if (randomLocation == 1){
            ButtonLeft.setText("O");
            ButtonMiddle.setText("*");
            ButtonRight.setText("O");
        }
        else{
            ButtonLeft.setText("O");
            ButtonMiddle.setText("O");
            ButtonRight.setText("*");
        }
    }
}