package com.htc.eleven.learnfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by eleven on 17-8-2.
 */

public class MainFragment extends Fragment {
    public static final String TAG = "eleven-MainFragment";

    public static Button anotherFragmentButton = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        /* obtain its own layout view, and get Button from it. !!!!! Cannot call findViewById() directly */
        anotherFragmentButton = rootView.findViewById(R.id.btnShowAnotherFragment);

        if(anotherFragmentButton == null) {
            Log.d(TAG, "onCreateView: rootView().findViewById get null anotherFragmentButton");
        }

        anotherFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getFragmentManager().beginTransaction().replace(R.id.main_context, new AnotherFragment()).commit();
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null) // 把自己添加到后退stack之中,防止下一个Fragment back的时候,整个 activity 也同时退出.
                        .replace(R.id.main_context, new AnotherFragment())
                        .commit();
            }
        });

        return rootView;
    }
}
