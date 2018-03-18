package com.yzqs.dailyandroid.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.yzqs.dailyandroid.di.module.HomeFragmentModule;
import com.yzqs.dailyandroid.mvp.ui.fragment.HomeFragment;

import dagger.Component;


@ActivityScope
@Component(modules = HomeFragmentModule.class, dependencies = AppComponent.class)
public interface HomeFragmentComponent {

    void inject(HomeFragment fragment);


}