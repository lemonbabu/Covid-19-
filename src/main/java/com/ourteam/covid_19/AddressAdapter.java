package com.ourteam.covid_19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AddressAdapter extends ArrayAdapter<Hospital> {
    private Activity context;
    private List<Hospital> hospitalList;

    public AddressAdapter( Activity context, List<Hospital> hospitalList) {
        super(context, R.layout.vaccine_center_layout, hospitalList);
        this.context=context;
        this.hospitalList =hospitalList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.vaccine_center_layout,null,true);
        Hospital hospital=hospitalList.get(position);
        TextView itemName=view.findViewById(R.id.itemName);
        TextView itemAddress=view.findViewById(R.id.itemAddress);
        TextView itemPhone=view.findViewById(R.id.itemPhone);
        itemName.setText(hospital.getName());
        itemAddress.setText(hospital.getAddress());
        itemPhone.setText(hospital.getPhone());
        return view;
    }
}
