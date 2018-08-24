package com.example.dondon.recyclerview;

import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private String string = "stgring";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button StartButton = new Button(this); //try to add new button view Java epic fail
        Button StartButton = findViewById(R.id.start_button);

       // setContentView();

        StartButton.setOnClickListener(fragmentClickListener);
    }



    private View.OnClickListener fragmentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            //get an instance of fragment transaction

           // getSupportFragmentManager().beginTransaction().add(R.id.layout_main,fragmentPopup).commit();
            // this line was my earlier mistake, i was not using the fragment transaction even though I created an instance before

            FragmentPopup fragmentPopup = new FragmentPopup();
            // create an instance of the fragment first
            fragmentTransaction.add(R.id.fragment_container,fragmentPopup);
            //you can then add a fragment  by specifying the fragment and the view in which to insert it to.
            // first argument is the viewGroup in which the fragment will be placed , specified by the resource
            //second argument is the fragment to add.
            fragmentTransaction.commit();
            //must call commit for the fragment changes to take


        }
    };

}
