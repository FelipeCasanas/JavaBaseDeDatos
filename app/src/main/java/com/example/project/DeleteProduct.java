package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.connection.AdminSQLiteOpenHelper;

public class DeleteProduct extends AppCompatActivity {

    private EditText codeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        codeET = findViewById(R.id.productCodeDelete);
    }

    public void searchProduct(View view) {
        String code = codeET.getText().toString();

        if(!code.isEmpty()) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "product", null, 1);
            SQLiteDatabase database = admin.getWritableDatabase();
            String sentence = "select * from product where productID = " + code;
            Cursor row = database.rawQuery(sentence, null);

            if(row.moveToFirst()) {
                database.delete("product", "productID = " + code, null);
            } else {
                Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show();
            }
            database.close();
        } else {
            Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearFields() {
        codeET.setText("");
    }

    public void goBack(View view) {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
        finish();
    }
}