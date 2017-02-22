package com.example.funfacts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FunFactsActivity extends ActionBarActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName(); //TAG for log message
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    //declare our View variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private TextView mTextViewInstructions;
    private TextView mTextViewReadMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assign the views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relative);
        mTextViewInstructions = (TextView) findViewById(R.id.TextViewInstructions);
        mTextViewReadMe = (TextView) findViewById(R.id.TextViewReadMe);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();

                //Update the screen with our dynamic fact
                mFactTextView.setText(fact);
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }

        };
        View.OnClickListener newPageInstruct = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FunFactsActivity.this, InstructionsActivity.class));
            }


        };
        View.OnClickListener newPageReadme = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FunFactsActivity.this, README.class));
            }




        };
        mShowFactButton.setOnClickListener(listener);
        mTextViewInstructions.setOnClickListener(newPageInstruct);
        mTextViewReadMe.setOnClickListener(newPageReadme);

        Toast.makeText(FunFactsActivity.this, "Yay! Our Activity was created!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the onCreate() method!");
    }
}

