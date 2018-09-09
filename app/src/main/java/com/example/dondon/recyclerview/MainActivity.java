package com.example.dondon.recyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String string = "string";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Button StartButton = new Button(this); //try to add new button view Java epic fail
        Button StartButton = findViewById(R.id.start_button);
        StartButton.setOnClickListener(fragmentClickListener);

        //




    }



    private View.OnClickListener fragmentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            //get an instance of fragment transaction



            FragmentPopup fragmentPopup = new FragmentPopup();
            // create an instance of the fragment first
            fragmentTransaction.add(R.id.fragment_container,fragmentPopup);
            //you can then add a fragment  by specifying the fragment and the view in which to insert it to.
            // first argument is the viewGroup in which the fragment will be placed , specified by the resource
            //second argument is the fragment to add.
            fragmentTransaction.commit();
            //must call commit for the fragment changes to take place


            // step 1: launch new activity with Intent
            // step 2: that activity has new xml layout containing fragment
            // step 3: FragmentPopup works as it does now
            //


        }
    };

}
