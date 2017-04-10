package com.fanhl.dragbetweenrecyclerviewdemo.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.fanhl.dragbetweenrecyclerviewdemo.FunctionDummy;
import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;

import java.util.List;

/**
 * Created by fanhl on 2017/4/10.
 */

public class MainModel {
    private final FunctionBarData myFunctionBar;
    private final FunctionBarData serviceFunctionBar;
    private final FunctionBarData securityFunctionBar;
    private final FunctionBarData toolsFunctionBar;
    /** 当前页面是不是编辑模式 */
    private boolean editMode;

    public FunctionBarData getMyFunctionBar() {
        return myFunctionBar;
    }

    public FunctionBarData getServiceFunctionBar() {
        return serviceFunctionBar;
    }

    public FunctionBarData getSecurityFunctionBar() {
        return securityFunctionBar;
    }

    public FunctionBarData getToolsFunctionBar() {
        return toolsFunctionBar;
    }

    public MainModel() {
        myFunctionBar = createFunctionBar("我的", R.drawable.ic_function_1);
        serviceFunctionBar = createFunctionBar("服务", R.drawable.ic_function_2);
        securityFunctionBar = createFunctionBar("安全", R.drawable.ic_function_3);
        toolsFunctionBar = createFunctionBar("工具", R.drawable.ic_function_4);
    }

    @NonNull
    private FunctionBarData createFunctionBar(String title, @DrawableRes int iconResId) {
        return new FunctionBarData(title, FunctionDummy.list(title, iconResId));
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }


    public class FunctionBarData {
        private String title;
        private List<FunctionItem> list;

        public FunctionBarData() {

        }

        public FunctionBarData(String title, List<FunctionItem> list) {
            this.title = title;
            this.list = list;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<FunctionItem> getList() {
            return list;
        }

        public void setList(List<FunctionItem> list) {
            this.list = list;
        }
    }
}
