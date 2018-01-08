package com.example.eric.favcontacts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eric on 08/01/2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private String[] contacts;
    private final Integer[] images;
    private ArrayList<String> contacts2 = new ArrayList<String>();

    public int flag = 0;


    public CustomAdapter(Activity context, String [] contacts, Integer [] images){
        super(context, R.layout.row,contacts);
        this.context = context;
        this.contacts = contacts;
        this.images = images;


    }

    public CustomAdapter(Activity context, ArrayList<String> contacts2, Integer [] images){
        super(context, R.layout.row,contacts2);
        this.context = context;
        this.contacts2 = contacts2;
        this.images = images;

        flag = 1;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater(); // standard way to get the inflater
        View row = inflater.inflate(R.layout.row, null, true); // selecting the xml to inflate (Row.xml)

        TextView txt = (TextView) row.findViewById(R.id.contact);
        ImageView image = (ImageView) row.findViewById(R.id.image);


        if(flag == 1){
            image.setImageResource(images[1]);
            txt.setText(contacts2.get(position));
        }else{
            image.setImageResource(images[0]);
            txt.setText(contacts[position]);
        }

        return row;

    }

}
