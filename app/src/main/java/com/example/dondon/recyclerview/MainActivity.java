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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button StartButton = new Button(this); //try to add new button view Java epic fail
        Button StartButton = findViewById(R.id.start_button);
        StartButton.setText(" java created button");
       // setContentView();


        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentPopup fragmentPopup = new FragmentPopup();
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction transaction= fragmentManager.beginTransaction();

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragmentPopup).commit();


                //fragmentPopup();// call fragment class

            }
        });



    }
}
