package com.indovation.parktap.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.indovation.parktap.fragment.onboarding.OnboardingFragment;


/**
 * Created by Timothy on 3/20/2015.
 */
public class OnboardingFragmentAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public OnboardingFragmentAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int page) {
        return OnboardingFragment.newInstance(page);
    }


    @Override
    public int getCount() {
        return 6;
    }
}
