package com.example.funfacts;

import android.content.Intent;
import android.database.Cursor;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddPickUpLineActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editPickupline, editGenre, editId;
    Button btnAddData;
    Button btnViewAll;
    Button btnViewUpdate;
    Button btnDelete;
    private Button mBackToMainActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pick_up_line);

        myDb = new DatabaseHelper(this);

        editPickupline = (EditText) findViewById(R.id.editText_pickupline);
        editGenre = (EditText) findViewById(R.id.editText_genre);
        editId = (EditText) findViewById(R.id.editText_id);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnViewAll = (Button) findViewById(R.id.button_view);
        btnViewUpdate = (Button) findViewById(R.id.button_id);
        btnDelete = (Button) findViewById(R.id.button_delete);

        AddData();
        viewAll();
        UpdateData();
        deleteData();

        mBackToMainActivityButton = (Button) findViewById(R.id.backToMainActivityButton);


        View.OnClickListener newPageBackToMain = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AddPickUpLineActivity.this, FunFactsActivity.class));
            }
        };
        mBackToMainActivityButton.setOnClickListener(newPageBackToMain);
    }

    public void deleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb.deleteData(editId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(AddPickUpLineActivity.this, "Data deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPickUpLineActivity.this, "Data not deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData() {
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdated = myDb.updateData(editId.getText().toString(),
                                editPickupline.getText().toString(),
                                editGenre.getText().toString());
                        if(isUpdated == true)
                            Toast.makeText(AddPickUpLineActivity.this, "Data updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPickUpLineActivity.this, "Data not updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       boolean isInserted = myDb.insertData(editPickupline.getText().toString(),
                                editGenre.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(AddPickUpLineActivity.this, "Data inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPickUpLineActivity.this, "Data not inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll(){
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

                        //Show all the data
                        showMessage("Data", buffer.toString());
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