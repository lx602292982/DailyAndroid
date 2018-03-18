package com.yzqs.dailyandroid.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yzqs.dailyandroid.di.module.HomeActivityModule;

import dagger.Component;


@ActivityScope
@Component(modules = HomeActivityModule.class, dependencies = AppComponent.class)
public interface HomeActivityComponent {

//    void inject(HomeActivityActivity activity);

}