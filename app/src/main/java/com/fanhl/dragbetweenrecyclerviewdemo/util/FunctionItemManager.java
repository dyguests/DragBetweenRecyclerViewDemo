package com.fanhl.dragbetweenrecyclerviewdemo.util;

import com.fanhl.dragbetweenrecyclerviewdemo.R;
import com.fanhl.dragbetweenrecyclerviewdemo.data.FunctionItem;
import com.fanhl.dragbetweenrecyclerviewdemo.dummy.FunctionDummy;
import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

import java.util.List;

/**
 * Created by fanhl on 2017/4/10.
 */

public class FunctionItemManager {
    private static final List<MainModel.FunctionItemWrap> serviceFunctions;
    private static final List<MainModel.FunctionItemWrap> securityFunctions;
    private static final List<MainModel.FunctionItemWrap> toolsFunctions;

//  fixme  id->action map

    static {
        serviceFunctions = CollectionUtil.parseList(FunctionDummy.list("服务", R.drawable.ic_function_2), new CollectionUtil.ParseListParser<FunctionItem, MainModel.FunctionItemWrap>() {
            @Override
            public MainModel.FunctionItemWrap parse(FunctionItem functionItem) {
                return new MainModel.FunctionItemWrap(MainModel.FunctionBarType.Service, functionItem);
            }
        });
        securityFunctions = CollectionUtil.parseList(FunctionDummy.list("安全", R.drawable.ic_function_4), new CollectionUtil.ParseListParser<FunctionItem, MainModel.FunctionItemWrap>() {
            @Override
            public MainModel.FunctionItemWrap parse(FunctionItem functionItem) {
                return new MainModel.FunctionItemWrap(MainModel.FunctionBarType.Service, functionItem);
            }
        });
        toolsFunctions = CollectionUtil.parseList(FunctionDummy.list("工具", R.drawable.ic_function_4), new CollectionUtil.ParseListParser<FunctionItem, MainModel.FunctionItemWrap>() {
            @Override
            public MainModel.FunctionItemWrap parse(FunctionItem functionItem) {
                return new MainModel.FunctionItemWrap(MainModel.FunctionBarType.Service, functionItem);
            }
        });
    }

    public static List<MainModel.FunctionItemWrap> getMyFunctions() {
        return null;
    }

    public static List<MainModel.FunctionItemWrap> getServiceFunctions() {
        return serviceFunctions;
    }

    public static List<MainModel.FunctionItemWrap> getSecurityFunctions() {
        return securityFunctions;
    }

    public static List<MainModel.FunctionItemWrap> getToolsFunctions() {
        return toolsFunctions;
    }
}
