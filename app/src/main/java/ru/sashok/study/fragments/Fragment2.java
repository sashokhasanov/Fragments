package ru.sashok.study.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment2 extends Fragment {

    private Fragment2Listener listener;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInsatnce() {
        return new Fragment2();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Fragment2Listener) {
            listener = (Fragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement Fragment2Listener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        Button buttonPlus = view.findViewById(R.id.button_plus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOperation("+");
            }
        });

        Button buttonMinus = view.findViewById(R.id.button_minus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOperation("-");
            }
        });

        Button buttonMul = view.findViewById(R.id.button_multiply);
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOperation("*");
            }
        });

        Button buttonDiv = view.findViewById(R.id.button_divide);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOperation("/");
            }
        });

        return view;
    }

    public interface Fragment2Listener {
        void onOperation(String operation);
    }
}
