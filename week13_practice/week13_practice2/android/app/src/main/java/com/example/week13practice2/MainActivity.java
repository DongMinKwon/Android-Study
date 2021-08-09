package com.example.week13practice2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.BatteryManager;
import android.os.Build;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        
        new EventChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), eventChannel)
                .setStreamHandler(
                        new RotationStreamHandler()
                );
    }

    private static final String eventChannel = "com.example.flutter/Rotate";

    class RotationStreamHandler implements EventChannel.StreamHandler {

        private SensorEventListener sensorEventListener;
        private SensorManager sManager;
        private Sensor sensor;

        RotationStreamHandler(){
            this.sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            this.sensor = sManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        }

        @Override
        public void onListen(Object arguments, EventChannel.EventSink events) {
            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    double[] sensorValues = new double[event.values.length];
                    for(int i = 0; i<event.values.length; i++){
                        sensorValues[i] = event.values[i];
                    }
                    events.success(sensorValues);
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };
            sManager.registerListener(sensorEventListener, sensor, sManager.SENSOR_DELAY_NORMAL);
        }

        @Override
        public void onCancel(Object arguments) {
            sManager.unregisterListener(sensorEventListener);
        }
    }
}
