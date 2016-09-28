package com.gokselpirnal.viewfinder.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.gokselpirnal.viewfinder.R;
import com.gokselpirnal.viewfinder.viewfinder.FindView;
import com.gokselpirnal.viewfinder.viewfinder.FindLayout;
import com.gokselpirnal.viewfinder.viewfinder.ViewFinder;

/**
 * Created by gokselpirnal on 28/09/2016.
 */

@FindLayout(R.layout.fragment_1)
public class SampleFragment1 extends Fragment {

    @FindView(R.id.img_camera)
    ImageView imgCamera;
    @FindView(R.id.btn_photo)
    Button btnPhoto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = ViewFinder.bind(this, inflater, container);

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCamera.setImageResource(R.drawable.ic_menu_gallery);
            }
        });

        return view;
    }

}