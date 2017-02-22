package com.example.funfacts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class InstructionsActivity extends ActionBarActivity {

    //declare our View variables
    private TextView mWelcomeTextView;
    private TextView mInstructionsTextView;
    private Button mBackToFunFacts;
    Button btnToAdd;
    Button btnToView;
    Button btnToUpdate;
    Button btnToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        // assign the views from the layout file to the corresponding variables
        btnToAdd = (Button) findViewById(R.id.button_toAdd);
        btnToView = (Button) findViewById(R.id.button_toView);
        btnToUpdate = (Button) findViewById(R.id.button_toUpdate);
        btnToDelete = (Button) findViewById(R.id.button_toDelete);
        mBackToFunFacts = (Button) findViewById(R.id.BackToFunFacts);
        toAddMessage();
        toViewMessage();
        toUpdateMessage();
        toDeleteMessage();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InstructionsActivity.this, FunFactsActivity.class));
            }
        };
        mBackToFunFacts.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instructions, menu);
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

    public void toAddMessage() {
        btnToAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessage("To Add A Pickupline", "1. Enter your pickupline in the pickupline field.\n2. Enter your genre in the genre field.\n3. IGNORE id field. This is ONLY for UPDATING\n4. Click Add Data.\n5. To view the added pickupline, click on View All");
                    }
                }
        );
    }

    public void toViewMessage() {
        btnToView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessage("To View Pickuplines in the Database", "1. Click on View All. This will show all your added data.");
                    }
                }
        );
    }

    public void toUpdateMessage() {
        btnToUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessage("To Update An Existing Pickupline", "Note: Before updating an existing pickupline entry, take note of its ID number. To find the ID number, click View All and locate the ID number for your chosen pickupline entry.\n\n" +
                                "1. Enter the pickupline you want to update and make your changes.\nPlease Note: After hitting Update, any changes made will overwrite your existing data, and old data cannot be retrieved.\n2. Enter the pickupline\'s id number.\n3. Click Update.\n4.To view changes, click on View All.\n" +
                                "\nExample: User saved \n\"Is your name Daniel? Because damn\" \nand its genre \"Lame\", but wants to change \"damn\" to capital letters and add an exclamation mark.\nUser also wants to change genre to \"Funny\". User simply enters the desired pickupline with changes made,\n\"Is your name Daniel? Because DAMN\"!\ninto the pickupline field, and enters \"Funny\" into the genre field. \nUser enters the id number into id field, and clicks Update.");
                    }
                }
        );
    }

    public void toDeleteMessage() {
        btnToDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessage("To Delete A Pickupline", "Enter only the ID of the pickupline you want to delete, and Click Delete.");
                    }
                }
        );
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
