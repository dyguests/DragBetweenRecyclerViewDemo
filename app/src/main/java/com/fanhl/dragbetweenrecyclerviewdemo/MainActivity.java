package com.fanhl.dragbetweenrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.fanhl.dragbetweenrecyclerviewdemo.viewHolder.MyFunctionsViewHolder;
import com.fanhl.dragbetweenrecyclerviewdemo.common.ClickableAdapter;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;
import com.fanhl.dragbetweenrecyclerviewdemo.presenter.MainPresenter;
import com.fanhl.dragbetweenrecyclerviewdemo.viewHolder.FunctionsViewHolder;
import com.fanhl.dragbetweenrecyclerviewdemo.viewHolder.OtherFunctionsViewHolder;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MenuItem editMenu;

    private MyFunctionsViewHolder myServiceViewHolder;
    private OtherFunctionsViewHolder serviceViewHolder;
    private OtherFunctionsViewHolder securityViewHolder;
    private OtherFunctionsViewHolder toolsViewHolder;

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
        this.myServiceViewHolder = new MyFunctionsViewHolder(findViewById(R.id.myServiceContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.clickFunctionItem(MainModel.FunctionBarType.My, position, holder);
            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.onMyItemLongClick();
            }
        });
        this.serviceViewHolder = new OtherFunctionsViewHolder(findViewById(R.id.serviceContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.clickFunctionItem(MainModel.FunctionBarType.Service, position, holder);
            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.onOtherItemLongClick();
            }
        });
        this.securityViewHolder = new OtherFunctionsViewHolder(findViewById(R.id.securityContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.clickFunctionItem(MainModel.FunctionBarType.Security, position, holder);
            }

            @Override
            public void onItemLongClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.onOtherItemLongClick();
            }
        });
        this.toolsViewHolder = new OtherFunctionsViewHolder(findViewById(R.id.toolsContainer), new FunctionsViewHolder.Callback() {
            @Override
            public void onItemClick(int position, ClickableAdapter.ViewHolder holder) {
                presenter.clickFunctionItem(MainModel.FunctionBarType.Tools, position, holder);
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

    @Override
    public void addFunctionItemToMy(MainModel.FunctionBarType functionBarType, int position) {
        MainModel.FunctionItemWrap functionItemWrap = null;
        switch (functionBarType) {
            case Service:
                functionItemWrap = serviceViewHolder.setFunctionItemStatusAdded(position, true);
                break;
            case Security:
                functionItemWrap = securityViewHolder.setFunctionItemStatusAdded(position, true);
                break;
            case Tools:
                functionItemWrap = toolsViewHolder.setFunctionItemStatusAdded(position, true);
                break;

        }
        assert functionItemWrap != null;
        myServiceViewHolder.addFunctionItem(functionItemWrap);
    }

    @Override
    public void removeFunctionItemFromMy(int position) {
        MainModel.FunctionItemWrap functionItemWrap = myServiceViewHolder.removeFunctionItem(position);
        switch (functionItemWrap.getFunctionBarType()) {
            case Service:
                serviceViewHolder.setFunctionItemStatusAdded(functionItemWrap, false);
                break;
            case Security:
                securityViewHolder.setFunctionItemStatusAdded(position, false);
                break;
            case Tools:
                toolsViewHolder.setFunctionItemStatusAdded(position, false);
                break;
        }
    }

    @Override
    public MainModel.FunctionItemWrap getFunctionBarItem(MainModel.FunctionBarType functionBarType, int position) {
        switch (functionBarType) {
            case My:
                return myServiceViewHolder.getFunctionBarItem(position);
            case Service:
                return serviceViewHolder.getFunctionBarItem(position);
            case Security:
                return securityViewHolder.getFunctionBarItem(position);
            case Tools:
                return toolsViewHolder.getFunctionBarItem(position);
        }
        return null;
    }

    private void bindFunctionDataToFunctionViewHolder(MainModel.FunctionBarData functionBarData, FunctionsViewHolder functionsViewHolder) {
        functionsViewHolder.bindData(functionBarData.getTitle(), functionBarData.getList());
    }

}
