package com.fanhl.dragbetweenrecyclerviewdemo.common;

import java.util.List;

/**
 * 增删改的通用接口
 * Created by fanhl on 2016/5/30.
 */
public interface Listable<ITEM> {
    //----------------数据增删-------------------
    void addItem(ITEM item);

    void addItems(List<ITEM> items);

    void clear();

    void replaceItems(List<ITEM> items);

    /**
     * 将item插入到最前面
     *
     * @param item
     */
    void addFirstItem(ITEM item);

    /**
     * 将items插入到最前面
     *
     * @param items
     */
    void addFirstItems(List<ITEM> items);
}
