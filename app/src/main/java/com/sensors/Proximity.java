package com.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Proximity extends AppCompatActivity {

    private TextView tvProximity;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Proximity");
        setContentView(R.layout.activity_proximity);

        tvProximity = findViewById(R.id.tvProximity);
        proximity();
    }

    private void proximity() {
        sensorManager    = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        SensorEventListener proxilistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0] <= 4) {
                    tvProximity.setText("Object is near");
                }else {
                    tvProximity.setText("Object is far");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener( proxilistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
