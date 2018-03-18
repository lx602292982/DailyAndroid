package com.yzqs.dailyandroid.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.yzqs.dailyandroid.mvp.contract.HomeActivityContract;

import javax.inject.Inject;


@ActivityScope
public class HomeActivityModel extends BaseModel implements HomeActivityContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HomeActivityModel(IRepositoryManager repositoryManager)
    {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}