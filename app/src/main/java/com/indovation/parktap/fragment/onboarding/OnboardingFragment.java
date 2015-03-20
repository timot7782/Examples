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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.indovation.parktap.R;
import com.indovation.parktap.util.PTHelper;

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

        View view = inflater.inflate(R.layout.fragment_onboarding_page1,null);
        Bundle bundle = getArguments();
        int page = bundle.getInt(ONBOARDING_PAGE);

        Log.i(ONBOARDING_PAGE, String.format("page number = %d",page));
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.onboard_container);
        TextView tvSkip = (TextView)view.findViewById(R.id.tv_skip);
        TextView tvPhrase1 = (TextView) view.findViewById(R.id.tv_initial_onboarding_phrase1);
        TextView tvPhrase2 = (TextView) view.findViewById(R.id.tv_initial_onboarding_phrase2);
//        LinearLayout layout = new LinearLayout(getActivity());
//        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        layout.setGravity(Gravity.CENTER);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.setBackgroundColor(getResources().getColor(R.color.main));
        switch (page) {
            case 0:
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.main));

                //banner
                ImageView ivParkTapLogo = new ImageView(getActivity());
                ivParkTapLogo.setImageResource(R.drawable.parktap_logo);
                ivParkTapLogo.setId(arbID++);

                //phrase 1
                TextView tvPhrase = new TextView(getActivity());
                tvPhrase.setText(R.string.initial_onboarding_page_1_phrase);
                tvPhrase.setTypeface(PTHelper.getFontFaceFromAssets(getActivity(), PTHelper.OPENSANS_LIGHT));
                tvPhrase.setTextColor(getResources().getColor(android.R.color.white));
                tvPhrase.setGravity(Gravity.CENTER_HORIZONTAL);
                tvPhrase.setId(arbID++);

                linearLayout.addView(ivParkTapLogo);
                linearLayout.addView(tvPhrase);

                //phrase 2
                tvPhrase1.setText(R.string.initial_onboarding_page_1_already_a_member);
                tvPhrase1.setTypeface(PTHelper.getFontFaceFromAssets(getActivity(), PTHelper.OPENSANS_LIGHT));
                tvPhrase1.setTextColor(getResources().getColor(android.R.color.white));

                //phrase 3
                tvPhrase2.setText(R.string.sign_in);
                tvPhrase2.setTypeface(PTHelper.getFontFaceFromAssets(getActivity(), PTHelper.OPENSANS_SEMI_BOLD));
                tvPhrase2.setTextColor(getResources().getColor(android.R.color.white));
                tvPhrase2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity().getApplicationContext(), null));
                    }
                });

                //add the banner
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.ABOVE, tvPhrase1.getId());
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                params.bottomMargin = 600;  //in pixels
                layout.addView(linearLayout,params);
                break;

            case 1:
                LinearLayout linearLayoutPage2 = new LinearLayout(getActivity());
                linearLayoutPage2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                linearLayoutPage2.setGravity(Gravity.CENTER_HORIZONTAL);
                linearLayoutPage2.setOrientation(LinearLayout.VERTICAL);
                linearLayoutPage2.setBackgroundColor(getResources().getColor(R.color.main));


                tvSkip.setText(R.string.skip);
                tvSkip.setTypeface(PTHelper.getFontFaceFromAssets(getActivity(), PTHelper.OPENSANS_SEMI_BOLD));
                tvSkip.setTextColor(getResources().getColor(android.R.color.white));

                ImageView ivScreenShot = new ImageView(getActivity());
                ivScreenShot.setImageResource(R.drawable.onboarding_lockscreen);
                linearLayoutPage2.addView(ivScreenShot);

                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params2.addRule(RelativeLayout.ABOVE, tvPhrase1.getId());
                params2.addRule(RelativeLayout.CENTER_HORIZONTAL);
                params2.bottomMargin = 100;  //in pixels
                layout.removeView(linearLayout);
                layout.addView(ivScreenShot,params2);
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
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }
}
