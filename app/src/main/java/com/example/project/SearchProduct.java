package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.connection.AdminSQLiteOpenHelper;

public class SearchProduct extends AppCompatActivity {

    private TextView nameET, priceET;
    private EditText codeET;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        codeET = findViewById(R.id.codeET);
        nameET = findViewById(R.id.nameTV);
        priceET = findViewById(R.id.priceET);
    }

    public void searchProduct(View view) {
        String code = codeET.getText().toString();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        if(!code.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + code, null);

            if(fila.moveToFirst()){
                nameET.setText(fila.getString(0));
                priceET.setText(fila.getString(1));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearFields() {
        codeET.setText("");
        nameET.setText("");
        priceET.setText("");
    }

    public void goBack(View view) {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
        finish();
    }
}