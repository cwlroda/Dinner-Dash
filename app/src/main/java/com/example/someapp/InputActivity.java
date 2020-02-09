package com.example.someapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.someapp.ui.tabs.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        final SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton addBtn = findViewById(R.id.addBtn);
        FloatingActionButton procBtn = findViewById(R.id.proceedBtn);

        final String[] input = new String[1];

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input[0] = openPopUp();
                sectionsPagerAdapter.getFragment(0).addItem(input[0]);
            }
        });

        procBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRecipeActivity();
            }
        });
    }

    private String openPopUp() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Adding Ingredients!");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alertDialogBuilder.setView(input);
        final String[] m_Text = new String[1];

        alertDialogBuilder.setPositiveButton("add", new DialogInterface.OnClickListener() {
            // TODO: put m_Text into interface
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                m_Text[0] = input.getText().toString();
                // TODO: change this to have quantity too
                Toast.makeText(InputActivity.this,"added ingredient", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        return m_Text[0];
    }

    private void gotoRecipeActivity() {
        Intent intent = new Intent(this, OutputActivity.class);
        startActivity(intent);
    }

}