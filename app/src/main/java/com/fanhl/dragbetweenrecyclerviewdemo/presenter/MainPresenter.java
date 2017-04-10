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
        model.setEditMode(newEditMode);
        view.setEditMode(newEditMode);
    }
}
