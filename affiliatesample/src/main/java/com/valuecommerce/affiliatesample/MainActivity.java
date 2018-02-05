package com.valuecommerce.affiliatesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String VIEW_TYPE_WEBVIEW = "WebView";
    private final static String VIEW_TYPE_TEXTVIEW = "TextView";
    private final static String VIEW_TYPE_BUTTON = "Button";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupListView();
    }

    private void setupListView(){
        ListView listView = (ListView) findViewById(R.id.listView);

        String[] values = new String[] {
                VIEW_TYPE_WEBVIEW,
                VIEW_TYPE_TEXTVIEW,
                VIEW_TYPE_BUTTON
        };

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                if (item == VIEW_TYPE_WEBVIEW) {
                    showWebView();
                } else if (item == VIEW_TYPE_TEXTVIEW) {
                    showTextView();
                } else if (item == VIEW_TYPE_BUTTON) {
                    showButton();
                }
            }
        });
    }

    private void showWebView() {
        Intent intent = new Intent(this, WebViewActivity.class);
        this.startActivity(intent);
    }
    private void showTextView() {
        Intent intent = new Intent(this, TextViewActivity.class);
        this.startActivity(intent);
    }
    private void showButton() {
        Intent intent = new Intent(this, LinkSwitchActivity.class);
        this.startActivity(intent);
    }
}
