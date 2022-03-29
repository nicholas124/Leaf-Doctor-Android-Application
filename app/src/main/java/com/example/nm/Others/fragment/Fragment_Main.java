package com.example.nm.Others.fragment;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nm.Others.Information;
import com.example.nm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Main extends Fragment {



    private CardView corn_btn;
    private CardView potato_btn;
    private CardView tomato_btn;
    private TextView cropType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment__main, container, false);


        //initialization of the buttons
        corn_btn = (CardView) view.findViewById(R.id.corn_btn);
        potato_btn = (CardView) view.findViewById(R.id.potato_btn);
        tomato_btn = (CardView) view.findViewById(R.id.tomato_btn);
        cropType = (TextView) getActivity().findViewById(R.id.crop_type);

        corn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "this is a test", Toast.LENGTH_SHORT).show();
                cropType.setText("corn");
                ((Information)getActivity()).setViewPager(2);
            }
        });

        potato_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cropType.setText("potato");
                (( Information)getActivity()).setViewPager(2);
            }
        });

        tomato_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cropType.setText("tomato");
                ((Information)getActivity()).setViewPager(2);
            }
        });

        return view;
    }

}
