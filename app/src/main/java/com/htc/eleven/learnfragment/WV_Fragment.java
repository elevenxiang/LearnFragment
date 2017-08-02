package com.htc.eleven.learnfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by eleven on 17-8-2.
 */

public class WV_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.webview_fragment, container, false);

        WebView wv = rootView.findViewById(R.id.web_view);

        if(wv == null)
            System.out.println("we got null WebView !");
//        wv.loadUrl("http://www.jikexueyuan.com");

        wv.loadUrl("http://www.sina.com");




        return rootView;
    }
}
