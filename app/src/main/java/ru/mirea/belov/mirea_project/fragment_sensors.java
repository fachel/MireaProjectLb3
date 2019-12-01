package ru.mirea.belov.mirea_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class fragment_sensors extends Fragment implements SensorEventListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView txtLight, txtPressure, txtX, txtY, txtZ;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor pressureSensor;
    private Sensor gyroscopeSensor;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public fragment_sensors() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_sensors.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_sensors newInstance(String param1, String param2) {
        fragment_sensors fragment = new fragment_sensors();
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
        View view = inflater.inflate(R.layout.fragment_sensors, container, false);
        txtLight = view.findViewById(R.id.valueLight);
        txtPressure = view.findViewById(R.id.valuePressure);
        txtX = view.findViewById(R.id.valueX);
        txtY = view.findViewById(R.id.valueY);
        txtZ = view.findViewById(R.id.valueZ);
        sensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_LIGHT);
        pressureSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_PRESSURE);
        gyroscopeSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        return view;
    }

    //отмена регистрации для освобождения ресурсов,
    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    //инициальизация датчика
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, pressureSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscopeSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }


    //отслеживаем изменения
    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float valueLight = event.values[0];
            txtLight.setText("Освещенность: " + valueLight);
        }

        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
            float valuePressure = event.values[0];
            txtPressure.setText("Давление: " + valuePressure);
        }

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float valueX = event.values[0];
            float valueY = event.values[1];
            float valueZ = event.values[2];
            txtX.setText("Значение х: " + valueX);
            txtY.setText("Значение у: " + valueY);
            txtZ.setText("Значение z: " + valueZ);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
