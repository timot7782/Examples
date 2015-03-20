package com.indovation.parktap.fragment.onboarding;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.indovation.parktap.R;

/**
 * Created by Timothy on 3/20/2015.
 */
public class OnboardingFragment extends Fragment {

    private static final String ONBOARDING_PAGE = "onboarding:page";
    int arbID = 1;
    public OnboardingFragment() {
    }

    public static OnboardingFragment newInstance(int page) {
        OnboardingFragment frag = new OnboardingFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ONBOARDING_PAGE, page);
        frag.setArguments(bundle);

        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;
        Bundle bundle = getArguments();
        int page = bundle.getInt(ONBOARDING_PAGE);
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        layout.setGravity(Gravity.CENTER);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.setBackgroundColor(getResources().getColor(R.color.main));
        switch (page) {
            case 0:
                view = inflater.inflate(R.layout.fragment_onboarding_page1,null);
                TextView tvSignIn = (TextView)view.findViewById(R.id.tv_sign_in);
                tvSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(), null));
                    }
                });
                break;

            case 1:
                view = inflater.inflate(R.layout.fragment_onboarding_page2,null);
                break;

            case 2:
                view = inflater.inflate(R.layout.fragment_onboarding_page3,null);
                break;

            case 3:
                view = inflater.inflate(R.layout.fragment_onboarding_page4,null);
                break;

            case 4:
                view = inflater.inflate(R.layout.fragment_onboarding_page5,null);
                break;

            case 5:
                view = inflater.inflate(R.layout.fragment_onboarding_page5,null);
                break;
        }
//TODO: remember to layout.addView();
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }
}
