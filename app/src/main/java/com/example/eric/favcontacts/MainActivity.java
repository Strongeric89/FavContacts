package com.example.eric.favcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView lv = null;
    private ListView favlv = null;


    public static ArrayList<String> favContacts = new ArrayList<String>();

    //assume these are pulled in from Database
    public static String contacts[] = {"eric strong","laura bermingham","dave bermo","tim berners lee","linus torvald","john lennon","david gilmore","margaret strong","bruce wayne", "steve jobs"};
    public static Integer images[] = {
            R.drawable.one,
            R.drawable.two
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.contacts);
        favlv = (ListView) findViewById(R.id.favourite);

        CustomAdapter adapter = new CustomAdapter(this, contacts, images);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"you selected: " + contacts[i], Toast.LENGTH_SHORT).show();

                favContacts.add(contacts[i]);

                CustomAdapter adapter2 = new CustomAdapter(MainActivity.this, favContacts, images);
                favlv.setAdapter(adapter2);

            }
        });
    }





    }

