package com.fanhl.dragbetweenrecyclerviewdemo;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 2017/4/7.
 */

class FunctionDummy {
    private static FunctionItem item(final String key, final int key2) {
        return new FunctionItem(key + "-" + key2, 0, new FunctionItem.Action() {
            @Override
            public void action(Context context) {
                Toast.makeText(context, key + "-" + key2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static List<FunctionItem> list(String key) {
        List<FunctionItem> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(item(key, i));
        }
        return list;
    }
}
