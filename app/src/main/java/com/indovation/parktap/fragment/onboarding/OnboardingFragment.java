package com.indovation.parktap.fragment.onboarding;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indovation.parktap.R;
import com.indovation.parktap.util.PTTextView;

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

                PTTextView tvSignIn = (PTTextView)view.findViewById(R.id.tv_sign_in);
//                tvSignIn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        Toast.makeText(getActivity(), "You will be redirected to sign in page", Toast.LENGTH_SHORT).show();
//                        ViewPager vp = (ViewPager)getActivity().findViewById(R.id.vp_initial_onboarding_pager);
//                        vp.setCurrentItem(6,true);
//                    }
//                });
                setSkipButtonListener(tvSignIn);
                break;

            case 1:
                view = inflater.inflate(R.layout.fragment_onboarding_page2,null);

                PTTextView tvSkip1 = (PTTextView)view.findViewById(R.id.tv_skip);
                setSkipButtonListener(tvSkip1);
                break;

            case 2:
                view = inflater.inflate(R.layout.fragment_onboarding_page3,null);
                PTTextView tvSkip2 = (PTTextView)view.findViewById(R.id.tv_skip);
                setSkipButtonListener(tvSkip2);

            case 3:
                view = inflater.inflate(R.layout.fragment_onboarding_page4,null);
                PTTextView tvSkip3 = (PTTextView)view.findViewById(R.id.tv_skip);
                setSkipButtonListener(tvSkip3);
                break;

            case 4:
                view = inflater.inflate(R.layout.fragment_onboarding_page5,null);
                PTTextView tvSkip4 = (PTTextView)view.findViewById(R.id.tv_skip);
                setSkipButtonListener(tvSkip4);
                break;

            case 5:
//                FragmentTransaction fragmentTransaction = getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.rl_initial_onboarding_container,new LoginFragment());
//                fragmentTransaction.commit();
                view = inflater.inflate(R.layout.fragment_login,null);
                break;
        }
//TODO: remember to layout.addView();
        return view;
    }

    private void setSkipButtonListener(PTTextView theTV) {
        theTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                        Toast.makeText(getActivity(), "You will be redirected to sign in page", Toast.LENGTH_SHORT).show();
                //Log.i(OnboardingFragment.class.getSimpleName(),"SKIP BUTTON CLICKED");
                ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vp_initial_onboarding_pager);
                vp.setCurrentItem(6, true);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }

}
