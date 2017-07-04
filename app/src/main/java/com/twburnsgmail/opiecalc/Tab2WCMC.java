package com.twburnsgmail.opiecalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by PunyHuman on 5/11/2017.
 */

public class Tab2WCMC extends Fragment {

   private Button btnTest;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_wcmc, container, false);
        return rootView;
    }

}
