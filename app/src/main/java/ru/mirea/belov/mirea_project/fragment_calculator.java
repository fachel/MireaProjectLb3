package ru.mirea.belov.mirea_project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_calculator.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_calculator extends Fragment {
    private View result;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fragment_calculator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_calculator.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_calculator newInstance(String param1, String param2) {
        fragment_calculator fragment = new fragment_calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        result = inflater.inflate(R.layout.fragment_calculator, container, false);
        return result;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button buttonPlus = result.findViewById(R.id.btnPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numFirst = result.findViewById(R.id.numFirst);
                EditText numSecond = result.findViewById(R.id.numSecond);
                TextView textResult = result.findViewById(R.id.textResult);

                String num1 = numFirst.getText().toString();
                String num2 = numSecond.getText().toString();

                int finalValue1=Integer.parseInt(num1);
                int finalValue2=Integer.parseInt(num2);
                textResult.setText(Integer.toString(finalValue1 + finalValue2));

            }
        });

        Button buttonMinus = result.findViewById(R.id.btnMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numFirst = result.findViewById(R.id.numFirst);
                EditText numSecond = result.findViewById(R.id.numSecond);
                TextView textResult = result.findViewById(R.id.textResult);

                String num1 = numFirst.getText().toString();
                String num2 = numSecond.getText().toString();

                int finalValue1=Integer.parseInt(num1);
                int finalValue2=Integer.parseInt(num2);
                textResult.setText(Integer.toString(finalValue1 - finalValue2));

            }
        });

        Button buttonMult = result.findViewById(R.id.btnMult);
        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numFirst = result.findViewById(R.id.numFirst);
                EditText numSecond = result.findViewById(R.id.numSecond);
                TextView textResult = result.findViewById(R.id.textResult);

                String num1 = numFirst.getText().toString();
                String num2 = numSecond.getText().toString();

                int finalValue1=Integer.parseInt(num1);
                int finalValue2=Integer.parseInt(num2);
                textResult.setText(Integer.toString(finalValue1 * finalValue2));

            }
        });

        Button buttonDev = result.findViewById(R.id.btnDev);
        buttonDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numFirst = result.findViewById(R.id.numFirst);
                EditText numSecond = result.findViewById(R.id.numSecond);
                TextView textResult = result.findViewById(R.id.textResult);

                String num1 = numFirst.getText().toString();
                String num2 = numSecond.getText().toString();
                double finalValue1=Double.parseDouble(num1);
                double finalValue2=Double.parseDouble(num2);
                textResult.setText(Double.toString(finalValue1 / finalValue2));
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
