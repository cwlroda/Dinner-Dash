package com.example.someapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.someapp.ui.tabs.PageViewModel;
import com.example.someapp.ui.tabs.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Map;

public class InputActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        if (sectionsPagerAdapter == null) {
            sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        }
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton addBtn = findViewById(R.id.addBtn);
        FloatingActionButton procBtn = findViewById(R.id.proceedBtn);
        TextView tv = findViewById(R.id.textView);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: idk why but it still doesn't show up
//                ViewGroup vg = findViewById (R.id.view_pager);
//                vg.invalidate();
                openPopUp(sectionsPagerAdapter);
            }
        });

        procBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRecipeActivity();
            }
        });
    }

    private void openPopUp(final SectionsPagerAdapter sectionsPagerAdapter) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Adding Ingredients!");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alertDialogBuilder.setView(input);

        alertDialogBuilder.setPositiveButton("add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                String m_Text = input.getText().toString();
                // TODO: change this to have quantity too
                Toast.makeText(InputActivity.this,"added", Toast.LENGTH_LONG).show();
                sectionsPagerAdapter.getFragment(0).addItem(m_Text);
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
    }

    private void gotoRecipeActivity() {
        Intent intent = new Intent(this, OutputActivity.class);

        // for ingredients
        PageViewModel ingrdPVM = this.sectionsPagerAdapter.getFragment(0).getPageViewModel();
        Map<String, Double> ingrdItems = ingrdPVM.getItems();
        intent.putExtra("ingredients", ingrdPVM.ingredientsToString(ingrdItems));

        // for ingredients
        PageViewModel equipPVM = this.sectionsPagerAdapter.getFragment(1).getPageViewModel();
        Map<String, Double> equipItems = equipPVM.getItems();
        intent.putExtra("equipments", equipPVM.equipmentsToString(equipItems));

        // for ingredients
        PageViewModel factPVM = this.sectionsPagerAdapter.getFragment(2).getPageViewModel();
        Map<String, Double> factItems = factPVM.getItems();
        intent.putExtra("factors", ingrdPVM.factorsToString(factItems));

        startActivity(intent);
    }

}