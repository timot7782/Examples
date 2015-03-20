package com.indovation.parktap.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.indovation.parktap.R;
import com.indovation.parktap.util.PTTextView;

/**
 * Created by Timothy on 3/20/2015.
 */
public class OnboardingFragment extends Fragment {

    private static final String ONBOARDING_PAGE = "onboarding:page";

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

        Bundle bundle = getArguments();
        int page = bundle.getInt(ONBOARDING_PAGE);

        Log.i(ONBOARDING_PAGE, String.format("page number = %d",page));
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(getResources().getColor(R.color.main));
        switch (page) {
            case 0:
                ImageView ivParkTapLogo = new ImageView(getActivity());
                PTTextView tvPhrase1 = new PTTextView(getActivity());
                PTTextView tvPhrase2 = new PTTextView(getActivity());
                PTTextView tvPhrase3 = new PTTextView(getActivity());

                ivParkTapLogo.setImageResource(R.drawable.parktap_logo);
                tvPhrase1.setText(R.string.initial_onboarding_page_1_phrase);
                tvPhrase1.setGravity(Gravity.CENTER);
                tvPhrase2.setText(R.string.initial_onboarding_page_1_already_a_member);
                tvPhrase2.setGravity(Gravity.CENTER);
                tvPhrase3.setText(R.string.sign_in);
                tvPhrase3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(),null));
                    }
                });
                tvPhrase3.setGravity(Gravity.CENTER);
                layout.addView(ivParkTapLogo);
                layout.addView(tvPhrase1);
                layout.addView(tvPhrase2);
                layout.addView(tvPhrase3);
                break;

            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;
        }
//TODO: remember to layout.addView();
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }
}
