package com.example.memorylist1;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView Memorylist;
    String[] Title;
    String[] Date;
    String[] Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        Memorylist = (ListView) findViewById(R.id.Memorylist);
        Title = res.getStringArray(R.array.Title);
        Date = res.getStringArray(R.array.Date);
        Text = res.getStringArray(R.array.Text);

        item_adapter item_adapter = new item_adapter(this,Title,Date,Text);
        Memorylist.setAdapter(item_adapter);
        Memorylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showphotodetails = new Intent(getApplicationContext(),photodetails.class);
                showphotodetails.putExtra("com.example.Item_Position", position);
                startActivity(showphotodetails);


            }
        });
    }
}
