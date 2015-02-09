package com.apps4s.yiperu.tabbarcontroller_android;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayPaises = new String[]{"Brasil","Mexico","Colombia",
                "Argentina","Peru","Venezuela",
                "Chile","Ecuador","Guatemal","Cuba"};

        ArrayList<String> countries = new ArrayList<String>(Arrays.asList(arrayPaises));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                countries);
        ListView list = (ListView)findViewById(R.id.listView); // Aqui el id del List
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
        String country = adapterView.getItemAtPosition(position).toString();
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra(DetalleActivity.COUNTRY, country);
        startActivity(intent);
    }
}
