package com.example.nm.Others.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nm.Others.DiseaseInformation;
import com.example.nm.R;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Disease extends Fragment {


    TextView cropType;
    TextView cropDiseaseName;
    ListView listView;
    Button back_btn;
    //Initialize preference

    SharedPreferences preference;
    //Initialize preference

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment__disease, container, false);

        cropType = (TextView) getActivity().findViewById(R.id.crop_type);
        listView = (ListView) view.findViewById(R.id.disease_list);


        //....................................................................................................................



        preference = getActivity().getSharedPreferences("STATE",MODE_PRIVATE);
        // it uses key-value pairs
        // put string data to preference

        preference.edit().putString("Your_String_Data","hhhhh").commit();

        //.........................................................................................................................


        final String checkCropType = cropType.getText().toString();

        if(checkCropType.equals("corn")){

            //create arraylist to hold the diseases of the plant
            final ArrayList<String> cornList = new ArrayList<>();
            cornList.add("corn maize cercospora leaf spot gray leaf spot");
            cornList.add("corn maize common rust");
            cornList.add("corn maize northern leaf blight");
            cornList.add("corn maize healthy");

            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,cornList);

            listView.setAdapter(arrayAdapter);

            //clicked button
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getContext(), "Clicked item : " + i+" = " + cornList.get(i).toString(), Toast.LENGTH_SHORT).show();

                    Intent diseaseInformationIntent = new Intent(getActivity(), DiseaseInformation.class).putExtra("TEXT", cornList.get(i).toString());
                    startActivity(diseaseInformationIntent);

                }
            });

        }else if (checkCropType.equals("tomato")){

            //create arraylist to hold the diseases of the plant
            final ArrayList<String> tomatoList = new ArrayList<>();
            tomatoList.add("tomato bacterial spot");
            tomatoList.add("tomato early blight");
            tomatoList.add("tomato late blight");
            tomatoList.add("tomato leaf mold");
            tomatoList.add("tomato septoria leaf spot");
            tomatoList.add("tomato spider mites two spotted spider mite");
            tomatoList.add("tomato target spot");
            tomatoList.add("tomato tomato yellow leaf curl virus");
            tomatoList.add("tomato tomato mosaic virus");
            tomatoList.add("tomato healthy");

            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,tomatoList);

            listView.setAdapter(arrayAdapter);

            //clicked button
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getContext(), "Clicked item : " + i+" = " + tomatoList.get(i).toString(), Toast.LENGTH_SHORT).show();
                    Intent diseaseInformationIntent = new Intent(getActivity(), DiseaseInformation.class).putExtra("TEXT", tomatoList.get(i).toString());
                    startActivity(diseaseInformationIntent);
                }
            });

        }else if (checkCropType.equals("potato")){
            //create arraylist to hold the diseases of the plant
            final ArrayList<String> potatoList = new ArrayList<>();
            potatoList.add("potato early blight");
            potatoList.add("potato late blight");
            potatoList.add("potato healthy");

            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,potatoList);

            listView.setAdapter(arrayAdapter);

            //clicked button
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getContext(), "Clicked item : " + i+" = " + potatoList.get(i).toString(), Toast.LENGTH_SHORT).show();
                    Intent diseaseInformationIntent = new Intent(getActivity(), DiseaseInformation.class).putExtra("TEXT", potatoList.get(i).toString());
                    startActivity(diseaseInformationIntent);
                }
            });
        }

        return view;
    }
}
