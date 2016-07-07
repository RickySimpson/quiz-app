package com.example.android.sailingquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.sailingquiz.R.id.q6_a;
import static com.example.android.sailingquiz.R.id.q6_b;


public class MainActivity extends AppCompatActivity {

    private double score = 0;
    private boolean leftButtonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Check answers method
     *
     * @param leftButtonPressed did the user press the left button for question 6?
     */
    private void checkAnswers(boolean leftButtonPressed) {

        // Question 1
        RadioButton q1_false = (RadioButton) findViewById(R.id.false_option);
        boolean q1false = q1_false.isChecked();

        // If false is selected then add 1 to the score.
        if (q1false) {
            score = score + 1;
        }

        // Question 2
        RadioButton q2_c = (RadioButton) findViewById(R.id.q2_c); // Correct Answer.
        boolean q2c = q2_c.isChecked(); // Correct Answer.

        // If C is selected. Add 1 to the score
        if (q2c) {
            score = score + 1;
        }

        // Question 3
        CheckBox q3_a = (CheckBox) findViewById(R.id.q3_a); // Correct Answer.
        CheckBox q3_b = (CheckBox) findViewById(R.id.q3_b); // Correct Answer.
        CheckBox q3_c = (CheckBox) findViewById(R.id.q3_c);
        CheckBox q3_d = (CheckBox) findViewById(R.id.q3_d); // Correct Answer.

        boolean q3a = q3_a.isChecked(); // Correct Answer.
        boolean q3b = q3_b.isChecked(); // Correct Answer.
        boolean q3c = q3_c.isChecked();
        boolean q3d = q3_d.isChecked(); // Correct Answer.

        // If A, B and D are checked but not C. Add 1 to the score.
        if (q3a && q3b && q3d && !q3c) {
            score = score + 1;
        }

        // Question 4
        CheckBox q4_a = (CheckBox) findViewById(R.id.q4_a);
        CheckBox q4_b = (CheckBox) findViewById(R.id.q4_b); // Correct Answer.
        CheckBox q4_c = (CheckBox) findViewById(R.id.q4_c);
        CheckBox q4_d = (CheckBox) findViewById(R.id.q4_d); // Correct Answer.

        boolean q4a = q4_a.isChecked();
        boolean q4b = q4_b.isChecked(); // Correct Answer.
        boolean q4c = q4_c.isChecked();
        boolean q4d = q4_d.isChecked(); // Correct Answer.

        // If B and D are checked but not A or C. Add 1 to the score.
        if (q4b && q4d && !(q4a || q4c)) {
            score = score + 1;
        }

        // Question 5
        RadioButton q5_a = (RadioButton) findViewById(R.id.q5_a); // Correct Answer.
        boolean q5a = q5_a.isChecked(); // Correct Answer.

        // If A is selected. Add 1 to the score.
        if (q5a) {
            score = score + 1;
        }

        // Question 6

        // If the user pressed the left button. Add 1 to the score.
        if (leftButtonPressed) {
            score = score + 1;
        }
    }

    /**
     *
     * @param view This method is called when the Submit Quiz button is clicked.
     */
    public void submitQuiz(View view) {
        // Initialize score to 0.
        score = 0;

        // Check the users answers.
        checkAnswers(leftButtonPressed);

        //Round the score percentage to 2 decimal places
        double scorePercentage = Math.round((score / 6) * 100);

        //Get the users name from the EditText field.
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        System.out.println("Score: " + score);
        // If the scorePercentage is 100& show the first Toast. Else show the second Toast.
        if (scorePercentage > 99) {
            Toast.makeText(this, name + " the whiz, 100% wooo!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Congratulations " + name + ", your score: " +
                    scorePercentage + "%", Toast.LENGTH_LONG).show();
        }

    }

    /**
     *
     * @param view This method is called when the left or right buttons are clicked. Question 6.
     * @return boolean. True if the left button was clicked. False if the right button was clicked.
     */
    public boolean buttonHit(View view) {

        Button left_button = (Button) findViewById(q6_a); // Correct Answer.
        Button right_button = (Button) findViewById(q6_b);

        // Get the id of the button pressed and compare with the left button id.
        if (view.getId() == left_button.getId()) {
            leftButtonPressed = true;

            // Disable both buttons after one is pressed.
            left_button.setEnabled(false);
            right_button.setEnabled(false);
            return leftButtonPressed;
        } else {

            // Disable both buttons after one is pressed.
            left_button.setEnabled(false);
            right_button.setEnabled(false);
            return false;
        }
    }
}
