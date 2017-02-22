package com.example.funfacts;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.widget.ThemeUtils;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity implements OnClickListener{
    public static final String TAG = FunFactsActivity.class.getSimpleName(); //TAG for log message
    //declare our View variables

    private Button mGoToAddPickUpLineButton;
    private Button mButtonInstructionPage;
    private Button mButtonReadMePage;
    Button btnViewAll;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_fun_facts);

        myDb = new DatabaseHelper(this);

        // assign the views from the layout file to the corresponding variables
        findViewById(R.id.button_changeTheme).setOnClickListener(this);
        findViewById(R.id.button_changeTheme2).setOnClickListener(this);
        findViewById(R.id.button_changeTheme3).setOnClickListener(this);


        mGoToAddPickUpLineButton = (Button) findViewById(R.id.goToAddPickUpLineButton);
        mButtonInstructionPage = (Button) findViewById(R.id.button_instructions);
        mButtonReadMePage = (Button) findViewById(R.id.button_readme);
        btnViewAll = (Button) findViewById(R.id.button_viewFromMainActivity);
        viewAll();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunFactsActivity.this, AddPickUpLineActivity.class));
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
        mGoToAddPickUpLineButton.setOnClickListener(listener);
        mButtonInstructionPage.setOnClickListener(newPageInstruct);
        mButtonReadMePage.setOnClickListener(newPageReadme);

        Toast.makeText(FunFactsActivity.this, "Yay! Our Activity was created!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We're logging from the onCreate() method!");
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.button_changeTheme:
                Utils.changeToTheme(this, Utils.THEME_DEFAULT);
                break;
            case R.id.button_changeTheme2:
                Utils.changeToTheme(this, Utils.THEME_ONE);
                break;
            case R.id.button_changeTheme3:
                Utils.changeToTheme(this, Utils.THEME_TWO);
                break;
        }
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0)+"\n");
                            buffer.append("Pickupline :" + res.getString(1)+"\n");
                            buffer.append("Genre :" + res.getString(2)+"\n\n");
                        }

                        //show all data
                        showMessage("Pickuplines", buffer.toString());
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

