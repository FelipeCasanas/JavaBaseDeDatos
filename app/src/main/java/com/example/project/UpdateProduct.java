package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateProduct extends AppCompatActivity {

    private EditText codeET, nameET, priceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        codeET = findViewById(R.id.productCodeUpdate);
        nameET = findViewById(R.id.productNameUpdate);
        priceET = findViewById(R.id.productPriceUpdate);

        nameET.setEnabled(false);
        priceET.setEnabled(false);
    }

    public void updateProduct(View view) {
        String code = String.valueOf(codeET.getText());
        String name = String.valueOf(codeET.getText());
        String price = String.valueOf(codeET.getText());
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