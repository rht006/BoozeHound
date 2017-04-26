package com.boozehound.boozehound12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String[] venues = {"Venue1", "Venue2", "venue3", "venue4", "venue5", "venue6", "venue7",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, venues);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button btn = (Button)findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("maps", "button pressed");
                loadMapPage();
            }
        });
    }



    public void loadMapPage(){
        Intent MapIntent = new Intent(this, MapActivity.class);
        startActivity(MapIntent);
        // Intent MapIntent = new Intent(MainMenu.this, MapActivity.class);
        //MainMenu.this.startActivity(MapIntent);
    }
}

