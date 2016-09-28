package com.gokselpirnal.viewfinder.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gokselpirnal.viewfinder.R;
import com.gokselpirnal.viewfinder.fragment.SampleFragment1;
import com.gokselpirnal.viewfinder.fragment.SampleFragment2;
import com.gokselpirnal.viewfinder.viewfinder.FindView;
import com.gokselpirnal.viewfinder.viewfinder.ViewFinder;

public class MainActivity extends AppCompatActivity {

    @FindView(R.id.btn_fragment_1)
    Button btnFragment1;
    @FindView(R.id.btn_fragment_2)
    Button btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFinder.bind(this);

        btnFragment1.setOnClickListener(onClickListener);
        btnFragment2.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            if(v.getId() == btnFragment1.getId()){
                fragment = new SampleFragment1();
            }else if(v.getId() == btnFragment2.getId()){
                fragment = new SampleFragment2();
            }

            if(fragment == null) {
                return;
            }

            Bundle args = new Bundle();
            args.putString("activityName", getClass().getSimpleName());
            fragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    };
}
