package com.fanhl.dragbetweenrecyclerviewdemo.dummy;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.Toast;

import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 2017/4/7.
 */

public class FunctionDummy {
    private static FunctionItem item(final String title, @DrawableRes int iconResId) {
        return new FunctionItem(title, iconResId, new FunctionItem.Action() {
            @Override
            public void action(Context context) {
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static List<FunctionItem> list(String key, @DrawableRes int iconResId) {
        List<FunctionItem> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(item(key + "-" + i, iconResId));
        }
        return list;
    }
}
