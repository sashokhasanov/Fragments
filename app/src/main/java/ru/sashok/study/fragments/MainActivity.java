package ru.sashok.study.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Main application activity class.
 *
 * @author Aleksandr Khasanov
 */
public class MainActivity extends AppCompatActivity
        implements Fragment0.Fragment0Listener, Fragment1.Fragment1Listener, Fragment2.Fragment2Listener {

    // first entered value, as a string
    private String value1;

    // second entered value, as a string
    private String value2;

    // operation
    private String operation;

    // fragment id, possible values [0, 3]
    private int currentFragmentId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Application start
            getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment0()).commit();
        }

        ImageButton buttonNext = findViewById(R.id.button_next);
        if (buttonNext != null) {
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentFragmentId < 3) {
                        currentFragmentId++;
                        replaceFragment(currentFragmentId);
                    }


                }
            });
        }

        ImageButton buttonPrevious = findViewById(R.id.button_prev);
        if (buttonPrevious != null) {
            buttonPrevious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentFragmentId > 0) {
                        currentFragmentId--;
                        replaceFragment(currentFragmentId);
                    }
                }
            });
        }
    }

    @Override
    public void onFirstNumber(String value) {

        value1 = value;
        currentFragmentId++;
        replaceFragment(currentFragmentId);
    }

    @Override
    public void onSecondNumber(String value) {

        value2 = value;
        currentFragmentId++;
        replaceFragment(currentFragmentId);
    }

    @Override
    public void onOperation(String operation) {

        this.operation = operation;
        currentFragmentId++;
        replaceFragment(currentFragmentId);
    }

    /*
     * Replace current fragment with fragment that has passed id.
     */
    private void replaceFragment(int id) {
        Fragment fragment = getFragmentById(id);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    /*
     * Get fragment by id.
     */
    private Fragment getFragmentById(int id) {
        switch (id) {
            case 0:
                return Fragment0.newInstance(value1);
            case 1:
                return Fragment1.newInstance(value2);
            case 2:
                return Fragment2.newInsatnce();
            case 3:
                return Fragment3.newInstance(value1, value2, operation);
            default:
                return null;
        }
    }
}
