package com.artcode.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    //CREATE VARIABLES THAT REFERENCE OUR VIEWS
    private TextView answerTextView;
    private EditText num1, num2;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            -> Use our activity's findViewById method to get the views that we created in
            activity_main.xml
            -> We find these views by using the android:id attribute we defined in XML
            -> android:id="@+id/num_1" is found here using R.id.num_1
         */
        answerTextView = (TextView) findViewById(R.id.answer_text_view);
        num1 = (EditText) findViewById(R.id.num_1);
        num2 = (EditText) findViewById(R.id.num_2);
        addButton = (Button) findViewById(R.id.add_button);

        //add an event listener for our add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call our custom method here
                addTheNumbers();
            }
        });

    }

    //custom method/function for adding the numbers
    private void addTheNumbers(){
        /*
            ->  num1.getText().toString() converts whatever value that is currently entered inside
                the EditText into a String
            ->  Integer.valueOf() then converts the String into an integer. We cannot perform
                mathematical calculations with Strings, so we need to convert the string into an
                integer.
         */
        int number1 = Integer.valueOf(num1.getText().toString());
        int number2 = Integer.valueOf(num2.getText().toString());

        //perform addition of the two integers and store the answer in a variable called 'answer'
        int answer = number1 + number2;

        /*
            ->  call our answerTextView's setText method so that we set it's value to the answer of
                the calculation.
            ->  the method setText takes a string as an argument. This means that we have to change
                the integer into a string
            ->  We can do this by saying String.valueOf(answer), but a shorter method is to simply
                type (""+answer)
         */

        answerTextView.setText(""+answer);

        /*
            ->  When running the app, make sure that you give both EditTexts a value or the app is
                going to crash. This is because we haven't done a null check. We'll talk about null
                checks in the next class.
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
