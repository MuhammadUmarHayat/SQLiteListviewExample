package com.example.listviewsqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
TextView tvAddCustomer1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAddCustomer1=findViewById(R.id.tvAddCustomer);


        tvAddCustomer1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(MainActivity.this, AddCustomers.class);
                startActivity(page);



            }
        });

    }
}