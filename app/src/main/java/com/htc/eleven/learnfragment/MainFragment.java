package com.htc.eleven.learnfragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.net.URL;

/**
 * Created by eleven on 17-8-2.
 */

public class MainFragment extends Fragment {
    public static final String TAG = "eleven-MainFragment";

    public static Button anotherFragmentButton = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: MainFragment !");
    }

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

        rootView.findViewById(R.id.btnStartSliderActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SliderActivity.class));
            }
        });

        rootView.findViewById(R.id.btnStartTabbedActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TabbedActivity.class));
            }
        });

        rootView.findViewById(R.id.btnPhoneCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:13917203200")));
            }
        });

        rootView.findViewById(R.id.btnOpenWebSite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sina.com.cn")));
            }
        });

        rootView.findViewById(R.id.btnSendMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:13917203200");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "今天加班,晚点回家 ~");
                startActivity(it);
            }
        });

        rootView.findViewById(R.id.btnPlayLocalVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_VIEW);
                String type = "video/mp4";
                Uri uri = Uri.parse("content:///sdcard/Movies/CtsTest720p.mp4");

                it.setDataAndType(uri,type);
                startActivity(it);
            }
        });

        rootView.findViewById(R.id.btnStartAnotherActivityWithArgs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AnotherActivity.class);

                i.putExtra("data", "这是来自前一个 Activity 的参数 !");

                startActivity(i);
            }
        });
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: MainFragment !");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: MainFragment !");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: MainFragment !");
    }
}
