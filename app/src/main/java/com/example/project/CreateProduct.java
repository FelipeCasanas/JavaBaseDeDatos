package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.connection.AdminSQLiteOpenHelper;

public class CreateProduct extends AppCompatActivity {

    private EditText codeET, nameET, priceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        codeET = findViewById(R.id.productCode);
        nameET = findViewById(R.id.productName);
        priceET = findViewById(R.id.productPrice);
    }

    public void setProduct(View view) {
        String code = codeET.getText().toString();
        String name = nameET.getText().toString();
        String price = priceET.getText().toString();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!code.isEmpty() && !name.isEmpty() && !price.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", code);
            registro.put("descripcion", name);
            registro.put("precio", price);

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();
            clearFields();

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
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