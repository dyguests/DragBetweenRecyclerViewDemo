package com.fanhl.dragbetweenrecyclerviewdemo;

import android.content.Context;
import android.support.annotation.DrawableRes;

/**
 * Created by fanhl on 2017/4/7.
 */
class FunctionItem {
    private String name;
    @DrawableRes
    private int iconResId;
    private Action action;

    public FunctionItem() {

    }

    public FunctionItem(String name, @DrawableRes int iconId, Action action) {
        this.name = name;
        this.iconResId = iconId;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DrawableRes
    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(@DrawableRes int iconResId) {
        this.iconResId = iconResId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public interface Action {
        void action(Context context);
    }

    private class DefaultAction implements Action {
        @Override
        public void action(Context context) {
            //donothing
        }
    }
}
