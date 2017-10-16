package ru.sashok.study.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {

    public Fragment3() {
        // Required empty public constructor
    }

    public static Fragment3 newInstance(String value1, String value2, String operation) {
        Bundle arguments = new Bundle();
        arguments.putString("value1", value1);
        arguments.putString("value2", value2);
        arguments.putString("operation", operation);

        Fragment3 result = new Fragment3();
        result.setArguments(arguments);

        return result;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

        TextView textView = view.findViewById(R.id.text_view);

        if (getArguments() != null) {
            String value1 = getArguments().getString("value1");

            String value2 = getArguments().getString("value2");

            String operation = getArguments().getString("operation");

            if ((value1 != null && !value1.isEmpty())
                    && (value2 != null && !value2.isEmpty())
                    && (operation != null && !operation.isEmpty())) {
                String result = value1 + " " + operation + " " + value2 + " = ";

                Double dv1 = Double.valueOf(value1);
                Double dv2 = Double.valueOf(value2);

                switch (operation) {
                    case "+":

                        result += Double.valueOf(dv1 + dv2).toString();
                        break;

                    case "-":
                        result += Double.valueOf(dv1 - dv2).toString();
                        break;

                    case "*":
                        result += Double.valueOf(dv1 * dv2).toString();
                        break;


                    case "/":
                        result += Double.valueOf(dv1 / dv2).toString();
                        break;

                    default:
                        break;
                }

                textView.setText(result);
            }
        }

        return view;
    }

}
