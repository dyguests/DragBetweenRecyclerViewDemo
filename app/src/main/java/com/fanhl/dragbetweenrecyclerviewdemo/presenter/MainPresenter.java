package com.fanhl.dragbetweenrecyclerviewdemo.presenter;

import com.fanhl.dragbetweenrecyclerviewdemo.MainContract;
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
    public void changeEditMode() {
        boolean newEditMode = !model.isEditMode();
        setEditMode(newEditMode);
    }

    public void setEditMode(boolean editMode) {
        model.setEditMode(editMode);
        view.setEditMode(editMode);
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
