package com.fanhl.dragbetweenrecyclerviewdemo.util;

import com.fanhl.dragbetweenrecyclerviewdemo.model.MainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhl on 2017/4/10.
 */

public class FunctionFactory {
    private static final List<MainModel.FunctionItemWrap> serviceFunctions;
    private static final List<MainModel.FunctionItemWrap> securityFunctions;
    private static final List<MainModel.FunctionItemWrap> toolsFunctions;

    static {
        serviceFunctions = new ArrayList<>();
        securityFunctions = new ArrayList<>();
        toolsFunctions = new ArrayList<>();
    }


}
