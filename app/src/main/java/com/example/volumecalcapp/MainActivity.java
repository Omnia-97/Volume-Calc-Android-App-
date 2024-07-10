package com.example.volumecalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Shape> shapeArrayList ;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();
        Shape shape1 = new Shape(R.drawable.sphere, "Cuboid");
        Shape shape2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape shape3 = new Shape(R.drawable.cube, "Cone");
        Shape shape4 = new Shape(R.drawable.prism, "Prism");
        shapeArrayList.add(shape1);
        shapeArrayList.add(shape2);
        shapeArrayList.add(shape3);
        customAdapter = new CustomAdapter( shapeArrayList, getApplicationContext());
        gridView.setAdapter(customAdapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext() , Sphere.class);
                startActivity(i);

            }
        });

    }
}