package com.fanhl.dragbetweenrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;
import com.fanhl.dragbetweenrecyclerviewdemo.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MenuItem editMenu;

    private FunctionsViewHolder myServiceViewHolder;
    private FunctionsViewHolder serviceViewHolder;
    private FunctionsViewHolder securityViewHolder;
    private FunctionsViewHolder toolsViewHolder;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        editMenu = menu.findItem(R.id.action_edit);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                presenter.changeEditMode();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void assignViews() {
        this.myServiceViewHolder = new FunctionsViewHolder(findViewById(R.id.myServiceContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {

            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
//                if (!presenter.isEditMode()) {
//                    presenter.setEditMode(true);
//                }
                presenter.onMyItemLongClick();
            }
        });
        this.serviceViewHolder = new FunctionsViewHolder(findViewById(R.id.serviceContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.onOtherItemLongClick();
            }
        });
        this.securityViewHolder = new FunctionsViewHolder(findViewById(R.id.securityContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.onOtherItemLongClick();
            }
        });
        this.toolsViewHolder = new FunctionsViewHolder(findViewById(R.id.toolsContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.onOtherItemLongClick();
            }
        });
    }

    private void initData() {
        MainModel model = new MainModel();
        presenter = new MainPresenter(model, this);
        presenter.start();
    }

    @Override
    public void bindData(MainModel model) {
        bindFunctionDataToFunctionViewHolder(model.getMyFunctionBar(), myServiceViewHolder);
        bindFunctionDataToFunctionViewHolder(model.getServiceFunctionBar(), serviceViewHolder);
        bindFunctionDataToFunctionViewHolder(model.getSecurityFunctionBar(), securityViewHolder);
        bindFunctionDataToFunctionViewHolder(model.getToolsFunctionBar(), toolsViewHolder);
    }

    @Override
    public void setEditMode(boolean editMode) {
        editMenu.setTitle(editMode ? "完成" : "编辑");

        myServiceViewHolder.setEditMode(editMode);
        serviceViewHolder.setEditMode(editMode);
        securityViewHolder.setEditMode(editMode);
        toolsViewHolder.setEditMode(editMode);

        //// FIXME: 2017/4/10 editMode=false then save

    }

    private void bindFunctionDataToFunctionViewHolder(MainModel.FunctionBarData functionBarData, FunctionsViewHolder functionsViewHolder) {
        functionsViewHolder.bindData(functionBarData.getTitle(), functionBarData.getList());
    }

}
