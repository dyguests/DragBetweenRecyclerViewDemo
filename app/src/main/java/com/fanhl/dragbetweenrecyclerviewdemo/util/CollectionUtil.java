package com.fanhl.dragbetweenrecyclerviewdemo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmy on 2015/10/30 0030.
 */
public class CollectionUtil {
    /**
     * 裁剪集合，返回被裁剪部分，同时从原集合中移除被裁剪的数据
     */
    public synchronized static <T> ArrayList<T> subList(ArrayList<T> arrayList, int start, int size) {
        int i = 0;
        int theSize = arrayList.size() > start + size ? size : arrayList.size() - start;
        ArrayList<T> subArrayList = new ArrayList<>(theSize);
        while (i < theSize) {
            T t = arrayList.get(i);
            arrayList.remove(i);
            subArrayList.add(t);
            i++;
        }

        return subArrayList;
    }

    public static <T> T getLast(List<T> list) {
        if (Util.isNullOrEmpty(list)) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    /**
     * 二分查找
     *
     * @param sortedList
     * @param key
     * @param comparator
     * @param <ITEM>
     * @param <KEY>
     * @return
     */
    public static <ITEM, KEY> ITEM binarySearch(List<ITEM> sortedList, KEY key, BinarySearchComparator<ITEM, KEY> comparator) {
        if (sortedList == null || sortedList.isEmpty()) {
            return null;
        }

        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            ITEM item = sortedList.get(middle);
            int compareResult = comparator.compare(item, key);

            if (compareResult == 0) {
                return item;
            } else if (compareResult < 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return null;
    }

    public static <S, T> List<T> parseList(List<S> list, ParseListParser<S, T> parser) {
        List<T> targetList = new ArrayList<>();
        if (list != null) {
            for (S s : list) {
                targetList.add(parser.parse(s));
            }
        }
        return targetList;
    }

    /**
     * see {@link CollectionUtil#binarySearch(List, Object, BinarySearchComparator)}.
     *
     * @param <ITEM>
     * @param <KEY>
     */
    public interface BinarySearchComparator<ITEM, KEY> {
        int compare(ITEM item, KEY key);
    }

    public interface ParseListParser<S, T> {
        T parse(S s);
    }
}
