package com.example.funfacts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class README extends ActionBarActivity {

    private Button mBackToFunFactsFromReadme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readme);

        // assign the views from the layout file to the corresponding variables

        mBackToFunFactsFromReadme = (Button) findViewById(R.id.BackToFunFactsFromReadme);

        View.OnClickListener back = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(README.this, FunFactsActivity.class));
            }
        };
        mBackToFunFactsFromReadme.setOnClickListener(back);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_readme, menu);
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
