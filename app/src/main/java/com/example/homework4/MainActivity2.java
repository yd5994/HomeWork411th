package com.example.homework4;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity{

    AlertDialog.Builder adb;
    LinearLayout mydialog;
    TextView Tposition, Tsum,Tdif;
    ListView listView;
    boolean type;
    String Fnumber,difference;
    Double[] numbers = new Double[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * @author: Jonathan David  yd5994@bs.amalnet.k12.il
         * @since: September 16, 2023
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent gi = getIntent();

        type = gi.getBooleanExtra("type",false);
        Fnumber = gi.getStringExtra("Fnumber");
        difference = gi.getStringExtra("difference");

        listView = findViewById(R.id.listview);

        Toast.makeText(this, String.valueOf(type), Toast.LENGTH_SHORT).show();
        numbers[0]=Double.valueOf(Fnumber);
        if(type){//Arithmetic progression
            for(int i=1;i<numbers.length;i++){
                numbers[i]=numbers[i-1]*Double.valueOf(difference);
            }
        }
        else{//Geometric series

            for(int i=1;i<numbers.length;i++){
                numbers[i]=numbers[i-1]+Double.valueOf(difference);
            }
        }

        ArrayAdapter<Double> adplist = new ArrayAdapter<Double>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,numbers);
        listView.setAdapter(adplist);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                start(position);

                return false;
            }
        });
    }





    DialogInterface.OnClickListener myclick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which==DialogInterface.BUTTON_POSITIVE){
            }
            if (which==DialogInterface.BUTTON_NEGATIVE){
                dialog.cancel();
            }
        }

    };
    public void start(int position){
        /**
         * @param: The function creates a "Custom Alert Dialog" with the values of the index that is clicked
         * @return: The function does not return
         */
        mydialog=(LinearLayout) getLayoutInflater().inflate(R.layout.my_dialog,null);
        Tposition=(TextView) mydialog.findViewById(R.id.textView);
        Tsum=(TextView) mydialog.findViewById(R.id.textView3);
        adb=new AlertDialog.Builder(this);
        if(type){
            double Math1= Double.valueOf(Double.valueOf(Fnumber)+(Double.valueOf(numbers[position])));
            double a1= parseDouble(String.valueOf(position+1))/2;
            Tsum.setText(String.valueOf(Math1*a1));
        }
        else{
            double Math2 = parseDouble(Fnumber)*(parseDouble(String.valueOf(Math.pow(parseDouble(difference),position+1)))-1);
            Tsum.setText(String.valueOf(Math2));
        }
        position+=1;
        Tposition.setText("position: "+position);

        adb.setView(mydialog);
        mydialog.setBackgroundColor(Color.GRAY);
        adb.setTitle("information");
        adb.setPositiveButton("Enter",myclick);
        adb.setNegativeButton("Cancel",myclick);
        adb.show();
    }


}