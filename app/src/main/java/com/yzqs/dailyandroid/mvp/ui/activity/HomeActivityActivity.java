package com.yzqs.dailyandroid.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.yzqs.dailyandroid.R;
import com.yzqs.dailyandroid.mvp.model.entity.TabEntity;
import com.yzqs.dailyandroid.mvp.ui.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import timber.log.Timber;


public class HomeActivityActivity extends BaseActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @BindView(R.id.tab_layout)
    CommonTabLayout mTabLayout;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;

    private String[] mTitles = {"每日精选", "发现", "热门", "我的"};
    // 未被选中的图标
    private int[] mIconUnSelectIds = {R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal};
    // 被选中的图标
    private int[] mIconSelectIds = {R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        for (String title : mTitles) {
            mFragments.add(HomeFragment.newInstance());
            mFragments.add(HomeFragment.newInstance());
            mFragments.add(HomeFragment.newInstance());
            mFragments.add(HomeFragment.newInstance());
        }
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mToolbarTitle.setText(mTitles[position]);
            }

            @Override
            public void onTabReselect(int position) {
                Timber.tag(TAG).w("onTabReselect position:"+ position);
            }
        });
        }
        //给tab设置数据和关联的fragment
        mTabLayout.setTabData(mTabEntities, this, R.id.home_fragment, mFragments);
        //设置红点
        mTabLayout.showDot(0);
        mToolbarTitle.setText(mTitles[0]);
    }


}
