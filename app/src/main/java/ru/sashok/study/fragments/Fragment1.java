package ru.sashok.study.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

public class Fragment1 extends Fragment {

    private Fragment1Listener listener;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance(String arg) {
        Bundle args = new Bundle();
        args.putString("value", arg);

        Fragment1 result = new Fragment1();
        result.setArguments(args);

        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Fragment1Listener) {
            listener = (Fragment1Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement Fragment1Listener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        final EditText editText = view.findViewById(R.id.edit_text);
        if (editText != null) {
            if (getArguments() != null) {
                String text = getArguments().getString("value");
                if (text != null) {
                    editText.setText(text);
                }
            }
        }

        ImageButton button = view.findViewById(R.id.enter_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editText != null) {

                        listener.onSecondNumber(editText.getText().toString());
                    }
                }
            });
        }

        return view;
    }

    public interface Fragment1Listener {
        void onSecondNumber(String value);
    }
}
