package com.example.homework4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    boolean type= true;
    Switch tg;
    EditText et,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tg=(Switch)findViewById(R.id.switch2);
        et = findViewById(R.id.editTextNumber2);
        et2 = findViewById(R.id.editTextNumber4);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * The function creates the Menu Option in MainActivity
         * @return: return true
         */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        /**
         * The function starts when you click a item in OptionMenu
         * @param: the function get the item that pressed
         * @return: the function should return true
         */
        String st = item.getTitle().toString();
        if (st.equals("credits")) {
            Intent si = new Intent(this,credits.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onswitch(View view) {
        if(tg.isChecked()){
            type=true;
        }
        else{
            type=false;
        }
    }

    public void nextpage(View view) {
        Intent si = new Intent(this,MainActivity2.class);
        si.putExtra("type",type);
        si.putExtra("Fnumber",et.getText().toString());
        si.putExtra("difference",et2.getText().toString());
        startActivity(si);

    }


}