package com.fanhl.dragbetweenrecyclerviewdemo;

import com.fanhl.dragbetweenrecyclerviewdemo.common.BaseContract;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

/**
 * Created by fanhl on 2017/4/10.
 */

public interface MainContract {
    interface View {

        void bindData(MainModel model);

        void setEditMode(boolean editMode);
    }

    interface Presenter extends BaseContract.Presenter{
        void changeEditMode();
    }
}
