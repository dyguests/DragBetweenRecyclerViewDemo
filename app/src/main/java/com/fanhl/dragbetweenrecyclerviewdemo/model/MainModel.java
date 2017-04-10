package com.fanhl.dragbetweenrecyclerviewdemo.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;
import com.fanhl.dragbetweenrecyclerviewdemo.dummy.FunctionDummy;
import com.fanhl.dragbetweenrecyclerviewdemo.util.CollectionUtil;

import java.util.ArrayList;
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
        myFunctionBar = createFunctionBar("我的", FunctionBarType.My, R.drawable.ic_function_1);
        serviceFunctionBar = createFunctionBar("服务", FunctionBarType.Service, R.drawable.ic_function_2);
        securityFunctionBar = createFunctionBar("安全", FunctionBarType.Security, R.drawable.ic_function_3);
        toolsFunctionBar = createFunctionBar("工具", FunctionBarType.Tools, R.drawable.ic_function_4);
    }

    @NonNull
    private FunctionBarData createFunctionBar(String title, FunctionBarType functionBarType, @DrawableRes int iconResId) {
        return new FunctionBarData(title, functionBarType, FunctionDummy.list(title, iconResId));
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        if (this.editMode == editMode) {
            return;
        }
        this.editMode = editMode;
    }

    public FunctionItemWrap getFunctionBarItem(FunctionBarType functionBarType, int position) {
        switch (functionBarType) {
            case My:
                return myFunctionBar.getList().get(position);
            case Service:
                return serviceFunctionBar.getList().get(position);
            case Security:
                return securityFunctionBar.getList().get(position);
            case Tools:
                return toolsFunctionBar.getList().get(position);
        }
        return null;
    }


    public class FunctionBarData {
        private String title;
        private List<FunctionItemWrap> list;

        public FunctionBarData() {
            list = new ArrayList<>();
        }

        public FunctionBarData(String title, final FunctionBarType functionBarType, @NonNull List<FunctionItem> list) {
            this.title = title;
            this.list = CollectionUtil.parseList(list, new CollectionUtil.ParseListParser<FunctionItem, FunctionItemWrap>() {
                @Override
                public FunctionItemWrap parse(FunctionItem functionItem) {
                    return new FunctionItemWrap(functionBarType, functionItem);
                }
            });
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<FunctionItemWrap> getList() {
            return list;
        }

        public void setList(List<FunctionItemWrap> list) {
            this.list = list;
        }

    }

    public static class FunctionItemWrap {
        /** 来源(服务、安全、工具) */
        private FunctionBarType functionBarType;
        private FunctionItem functionItem;
        /** 是否已添加到my */
        private boolean isAdded;

        public FunctionItemWrap(FunctionBarType functionBarType, FunctionItem functionItem) {
            this.functionBarType = functionBarType;
            this.functionItem = functionItem;
        }

        public String getName() {
            return functionItem.getName();
        }

        public void setName(String name) {
            functionItem.setName(name);
        }

        @DrawableRes
        public int getIconResId() {
            return functionItem.getIconResId();
        }

        public void setIconResId(@DrawableRes int iconResId) {
            functionItem.setIconResId(iconResId);
        }

        public FunctionItem.Action getAction() {
            return functionItem.getAction();
        }

        public void setAction(FunctionItem.Action action) {
            functionItem.setAction(action);
        }

        public FunctionBarType getFunctionBarType() {
            return functionBarType;
        }

        public void setFunctionBarType(FunctionBarType functionBarType) {
            this.functionBarType = functionBarType;
        }

        public boolean isAdded() {
            return isAdded;
        }

        public void setAdded(boolean added) {
            isAdded = added;
        }
    }

    public enum FunctionBarType {
        My, Service, Security, Tools
    }
}
