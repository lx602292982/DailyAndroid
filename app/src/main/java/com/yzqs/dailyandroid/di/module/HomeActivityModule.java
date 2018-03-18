package com.yzqs.dailyandroid.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yzqs.dailyandroid.mvp.contract.HomeActivityContract;
import com.yzqs.dailyandroid.mvp.model.HomeActivityModel;

import dagger.Module;
import dagger.Provides;


@Module
public class HomeActivityModule {
    private HomeActivityContract.View view;

    /**
     * 构建HomeActivityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public HomeActivityModule(HomeActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeActivityContract.View provideHomeActivityView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HomeActivityContract.Model provideHomeActivityModel(HomeActivityModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    RxPermissions provideRxPermissions(){
        return  new RxPermissions(view.getActivity());
    }
}