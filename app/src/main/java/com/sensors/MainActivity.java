package com.sensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView tvSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sensor List");
        setContentView(R.layout.activity_main);

        tvSensors = findViewById(R.id.tvSensors);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i =0; i <  sensorList.size();  i++){
            String sensors ="";
            sensors += sensorList.get(i).getName() + "\n";
            tvSensors.append(sensors);
        }





    }
}
