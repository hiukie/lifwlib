package com.example.fengwei.selector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SelectorView selectorView;
    List<String> list;
    private TextView show;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView) findViewById(R.id.select_year);

        selectorView = (SelectorView) findViewById(R.id.selector);

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"月");
        }

        selectorView.setAdapter(adapter);

        selectorView.setOnItemCheckListener(new SelectorView.OnItemCheckListener() {
            @Override
            public void onItemChecked(int position) {
                Log.i(TAG, "onItemChecked: "+position);
                show.setText(list.get(position));
            }

            @Override
            public void onScrolled(int position) {
                Log.i(TAG, "onScrolled: "+position);
            }
        });
    }

    public void left(View view){
        selectorView.left();
    }

    public void right(View view){
        selectorView.right();
    }

    SelectorView.SeletcorAdapter adapter = new SelectorView.SeletcorAdapter(){
        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public void setView(View view, int position) {
            ((TextView)view).setText(list.get(position));
        }


    };
}
