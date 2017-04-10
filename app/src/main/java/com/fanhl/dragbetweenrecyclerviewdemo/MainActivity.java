package com.fanhl.dragbetweenrecyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
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
        assginViews();
        initData();
    }

    private void assginViews() {
        this.myServiceContainer = new FunctionsViewHolder(findViewById(R.id.myServiceContainer));
        this.serviceContainer = new FunctionsViewHolder(findViewById(R.id.serviceContainer));
        this.securityContainer = new FunctionsViewHolder(findViewById(R.id.securityContainer));
        this.toolsContainer = new FunctionsViewHolder(findViewById(R.id.toolsContainer));
    }

    private void initData() {
        bindDataToContainer();
    }

    private void bindDataToContainer() {
        bindDataToFunctionViewHolder("我的", R.drawable.ic_function_1, myServiceContainer);
        bindDataToFunctionViewHolder("服务", R.drawable.ic_function_2, serviceContainer);
        bindDataToFunctionViewHolder("安全", R.drawable.ic_function_3, securityContainer);
        bindDataToFunctionViewHolder("工具", R.drawable.ic_function_4, toolsContainer);
    }

    private void bindDataToFunctionViewHolder(String title, @DrawableRes int iconResId, FunctionsViewHolder functionsViewHolder) {
        functionsViewHolder.bindData(title, FunctionDummy.list(title, iconResId));
    }
}
