package com.fanhl.dragbetweenrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FunctionsViewHolder myServiceContainer;
    private FunctionsViewHolder serviceContainer;
    private FunctionsViewHolder securityContainer;
    private FunctionsViewHolder toolsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.toolsContainer = new FunctionsViewHolder(findViewById(R.id.toolsContainer));
        this.securityContainer = new FunctionsViewHolder(findViewById(R.id.securityContainer));
        this.serviceContainer = new FunctionsViewHolder(findViewById(R.id.serviceContainer));
        this.myServiceContainer = new FunctionsViewHolder(findViewById(R.id.myServiceContainer));
    }
}
