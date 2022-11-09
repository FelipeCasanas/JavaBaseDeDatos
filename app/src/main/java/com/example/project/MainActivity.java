package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createProduct(View view) {
        Intent createProduct = new Intent(this, CreateProduct.class);
        startActivity(createProduct);
        onPause();
    }

    public void updateProduct(View view) {
        Intent updateProduct = new Intent(this, UpdateProduct.class);
        startActivity(updateProduct);
        onPause();
    }

    public void searchProduct(View view) {
        Intent searchProduct = new Intent(this, SearchProduct.class);
        startActivity(searchProduct);
        onPause();
    }

    public void deleteProduct(View view) {
        Intent createProduct = new Intent(this, DeleteProduct.class);
        startActivity(createProduct);
        onPause();
    }
}