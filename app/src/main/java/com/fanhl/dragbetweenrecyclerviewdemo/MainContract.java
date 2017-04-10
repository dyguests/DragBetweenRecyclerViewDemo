package com.fanhl.dragbetweenrecyclerviewdemo;

import com.fanhl.dragbetweenrecyclerviewdemo.common.BaseContract;
import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

/**
 * Created by fanhl on 2017/4/10.
 */

public interface MainContract {
    interface View {

        void bindData(MainModel model);

        void setEditMode(boolean editMode);

        void addFunctionItemToMy(MainModel.FunctionBarType functionBarType, int position);
    }

    interface Presenter extends BaseContract.Presenter {
        boolean isEditMode();

        void changeEditMode();

        void clickFunctionItem(MainModel.FunctionBarType functionBarType, int position, ClickableAdapter.ViewHolder holder);

        @Deprecated
        void onOtherItemClick();

        void onMyItemLongClick();

        void onOtherItemLongClick();
    }
}
