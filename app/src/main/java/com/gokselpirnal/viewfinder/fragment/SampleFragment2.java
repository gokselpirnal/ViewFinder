package com.gokselpirnal.viewfinder.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gokselpirnal.viewfinder.R;
import com.gokselpirnal.viewfinder.viewfinder.FindView;
import com.gokselpirnal.viewfinder.viewfinder.FindViewGroup;
import com.gokselpirnal.viewfinder.viewfinder.ViewFinder;

/**
 * Created by gokselpirnal on 28/09/2016.
 */

@FindViewGroup(R.layout.fragment_2)
public class SampleFragment2 extends Fragment {

    @FindView(R.id.mesage_box)
    EditText messageBox;
    @FindView(R.id.btn_send)
    Button btnSend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = ViewFinder.bind(this, inflater, container);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), messageBox.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}