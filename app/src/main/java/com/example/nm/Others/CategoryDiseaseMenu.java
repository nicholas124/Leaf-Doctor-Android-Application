package com.example.nm.Others;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.nm.Camera2BasicFragment;
import com.example.nm.CameraActivity;
import com.example.nm.ImageClassifier;
import com.example.nm.ImageClassifierFloatMobileNet;
import com.example.nm.MainActivity;
import com.example.nm.R;
import com.example.nm.kotlin.SelectImage;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryDiseaseMenu extends AppCompatActivity {

    private ListView mListCategory;
    private MaterialSearchBar searchBar;
    Dialog dialog;

    private Button realTime;
    private Button imageSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_disease_menu);

        mListCategory = (ListView) findViewById(R.id.mListView);
        searchBar = (MaterialSearchBar) findViewById(R.id.search_bar);

        //.............................Dialog componentss......................
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.options);
        dialog.setTitle("Search Type");

        realTime = (Button) dialog.findViewById(R.id.realTime);
        imageSelect = (Button) dialog.findViewById(R.id.imageSelect);

        searchBar.setHint("Search...");
        searchBar.setSpeechMode(true);

        ArrayList<String> searchItems = new ArrayList<String>();
        searchItems.add("Corn maize");
        searchItems.add("Potato");
        searchItems.add("Tomato");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchItems);

        mListCategory.setAdapter(itemsAdapter);

        //searchBar.addTextChangeListener();

        //.......................................


        mListCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (itemsAdapter.getItem(i).toString().equals("Apple")) {
                    //Toast.makeText(CategoryDiseaseMenu.this, "clicked", Toast.LENGTH_SHORT).show();
                    dialog.show();
                    realTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (itemsAdapter.getItem(i).toString().equals("Apple")){
                                dialog.dismiss();

                                Intent toRealTime = new Intent(CategoryDiseaseMenu.this, CameraActivity.class);
                                toRealTime.putExtra("realtime", itemsAdapter.getItem(i).toString());
                                startActivity(toRealTime);
                                Animatoo.animateCard(CategoryDiseaseMenu.this);

                            }
                        }
                    });

                    imageSelect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent imageSelect = new Intent(CategoryDiseaseMenu.this, SelectImage.class);
                            imageSelect.putExtra("imageSelect", itemsAdapter.getItem(i).toString());
                            startActivity(imageSelect);
                            Animatoo.animateCard(CategoryDiseaseMenu.this);
                        }
                    });

                }else if (itemsAdapter.getItem(i).toString().equals("Corn maize")){

                    dialog.show();
                    realTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (itemsAdapter.getItem(i).toString().equals("Corn maize")){
                                dialog.dismiss();

                                Intent toRealTime = new Intent(CategoryDiseaseMenu.this, CameraActivity.class);
                                toRealTime.putExtra("realtime", itemsAdapter.getItem(i).toString());
                                startActivity(toRealTime);
                                //toRealTime.putExtra("realtime", itemsAdapter.getItem(i).toString());
                                Toast.makeText(CategoryDiseaseMenu.this, "i have click" + itemsAdapter.getItem(i).toString(), Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(CategoryDiseaseMenu.this, CameraActivity.class));
                                //Animatoo.animateCard(CategoryDiseaseMenu.this);

                            }
                        }
                    });

                    imageSelect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent imageSelect = new Intent(CategoryDiseaseMenu.this, SelectImage.class);
                            imageSelect.putExtra("imageSelect", itemsAdapter.getItem(i).toString());
                            startActivity(imageSelect);
                            Animatoo.animateCard(CategoryDiseaseMenu.this);
                        }
                    });
                }else if (itemsAdapter.getItem(i).toString().equals("Potato")) {
                    Toast.makeText(CategoryDiseaseMenu.this, "" + itemsAdapter.getItem(i).toString(), Toast.LENGTH_SHORT).show();
                    dialog.show();
                    realTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (itemsAdapter.getItem(i).toString().equals("Potato")){
                                dialog.dismiss();

                                Intent toRealTime = new Intent(CategoryDiseaseMenu.this, CameraActivity.class);
                                toRealTime.putExtra("realtime", itemsAdapter.getItem(i).toString());
                                startActivity(toRealTime);
                                Animatoo.animateCard(CategoryDiseaseMenu.this);

                            }
                        }
                    });

                    imageSelect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent imageSelect = new Intent(CategoryDiseaseMenu.this, SelectImage.class);
                            imageSelect.putExtra("imageSelect", itemsAdapter.getItem(i).toString());
                            startActivity(imageSelect);
                            Animatoo.animateCard(CategoryDiseaseMenu.this);
                        }
                    });

                }else if (itemsAdapter.getItem(i).toString().equals("Tomato")) {
                    Toast.makeText(CategoryDiseaseMenu.this, "" + itemsAdapter.getItem(i).toString(), Toast.LENGTH_SHORT).show();

                    //Toast.makeText(CategoryDiseaseMenu.this, "clicked", Toast.LENGTH_SHORT).show();
                    dialog.show();
                    realTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (itemsAdapter.getItem(i).toString().equals("Tomato")){
                                dialog.dismiss();

                                Intent toRealTime = new Intent(CategoryDiseaseMenu.this, CameraActivity.class);
                                toRealTime.putExtra("realtime", itemsAdapter.getItem(i).toString());
                                startActivity(toRealTime);
                                Animatoo.animateCard(CategoryDiseaseMenu.this);

                            }
                        }
                    });

                    imageSelect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent imageSelect = new Intent(CategoryDiseaseMenu.this, SelectImage.class);
                            imageSelect.putExtra("imageSelect", itemsAdapter.getItem(i).toString());
                            startActivity(imageSelect);
                            Animatoo.animateCard(CategoryDiseaseMenu.this);
                        }
                    });
                }


            }
        });
    }
    /** when Back button is pressed*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateCard(this); //fire the Card animation
    }
}
