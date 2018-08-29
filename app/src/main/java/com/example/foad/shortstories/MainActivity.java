package com.example.foad.shortstories;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    String[] index;
    List<HashMap<String,String>> aList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        main();
    }
    public void init(){
        index = new String[]{"1- The Three Little Pigs", "2- How The Moon Became Beautiful"};
    }
    public void main(){
        array2listview(index);
    }
    public void array2listview(final String[] strArray){
        for (String aStrArray : strArray) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("name", aStrArray);
            aList.add(hm);
        }

        String[] from = {"name"};
        int[] to = {R.id.item};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list, from, to);
        ListView listView = findViewById(R.id.storyListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id1) {
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), PigsActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MoonActivity.class);
                        startActivity(intent);
                        break;
                        default:
                            Toast.makeText(MainActivity.this, "Not yet created.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}