package com.ourteam.covid_19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class VaccineAdapter extends ArrayAdapter<Vaccine> {
    private Activity context;
    private List<Vaccine> vaccineList;

    public VaccineAdapter( Activity context, List<Vaccine> vaccineList) {
        super(context, R.layout.vaccine_center_layout, vaccineList);
        this.context=context;
        this.vaccineList =vaccineList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.vaccine_center_layout,null,true);
        Vaccine vaccine=vaccineList.get(position);
        TextView itemName=view.findViewById(R.id.itemName);
        TextView itemAddress=view.findViewById(R.id.itemAddress);
        TextView itemPhone=view.findViewById(R.id.itemPhone);
        itemName.setText(vaccine.getName());
        itemAddress.setText(vaccine.getCountry());
        itemPhone.setText(vaccine.getDetails());
        return view;
    }
}
