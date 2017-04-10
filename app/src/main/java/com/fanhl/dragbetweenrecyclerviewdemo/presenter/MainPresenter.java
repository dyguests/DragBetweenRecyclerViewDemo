package com.fanhl.dragbetweenrecyclerviewdemo.presenter;

import com.fanhl.dragbetweenrecyclerviewdemo.MainContract;
import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

/**
 * Created by fanhl on 2017/4/10.
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainModel model;
    private final MainContract.View view;

    public MainPresenter(MainModel model, MainContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void start() {
        view.bindData(model);
    }

    @Override
    public boolean isEditMode() {
        return model.isEditMode();
    }

    @Override
    public void changeEditMode() {
        boolean newEditMode = !isEditMode();
        setEditMode(newEditMode);
    }

    /**
     * 当某个functionBar中某一项被点击时的处理
     *
     * @param functionBarType
     * @param position
     * @param holder
     */
    @Override
    public void clickFunctionItem(MainModel.FunctionBarType functionBarType, int position, @Deprecated/*??*/ ClickableAdapter.ViewHolder holder) {
        if (!isEditMode()) {
            return;
        }

        MainModel.FunctionItemWrap functionBarItem = view.getFunctionBarItem(functionBarType, position);

        if (functionBarType != MainModel.FunctionBarType.My) {
            if (!functionBarItem.isAdded()) {
                view.addFunctionItemToMy(functionBarType, position);
            }
        } else {
            view.removeFunctionItemFromMy(position);
        }
    }

    public void setEditMode(boolean editMode) {
        model.setEditMode(editMode);
        view.setEditMode(editMode);
    }

    @Override
    public void onOtherItemClick() {
        if (isEditMode()) {
            // FIXME: 2017/4/10
        }
    }

    @Override
    public void onMyItemLongClick() {
        if (model.isEditMode()) {
            // FIXME: 2017/4/10
        } else {
            setEditMode(true);
        }
    }

    @Override
    public void onOtherItemLongClick() {
        if (!model.isEditMode()) {
            setEditMode(true);
        }
    }
}
