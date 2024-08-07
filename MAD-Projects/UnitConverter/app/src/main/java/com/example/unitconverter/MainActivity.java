package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView cv_tmp;
    CardView cv_weight;
    CardView cv_length;
    CardView cv_speed;
    CardView cv_volume;
    CardView cv_time;
    CardView cv_area;
    CardView cv_fuel;
    CardView cv_pressure;
    CardView cv_energy;
    CardView cv_storage;
    CardView cv_current;
    CardView cv_force;
    CardView cv_freq;
    CardView cv_resistance;
    CardView cv_power;
    CardView cv_torque;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        cv_tmp = findViewById(R.id.cv_tmp);
        cv_weight = findViewById(R.id.cv_weight);
        cv_length = findViewById(R.id.cv_length);
        cv_speed = findViewById(R.id.cv_speed);
        cv_volume = findViewById(R.id.cv_Volume);
        cv_time = findViewById(R.id.cv_time);
        cv_area = findViewById(R.id.cv_area);
        cv_fuel = findViewById(R.id.cv_fuel);
        cv_pressure = findViewById(R.id.cv_pressure);
        cv_energy = findViewById(R.id.cv_energy);
        cv_storage = findViewById(R.id.cv_storage);
        cv_current = findViewById(R.id.cv_current);
        cv_force = findViewById(R.id.cv_force);
        cv_freq = findViewById(R.id.cv_frequency);
        cv_resistance = findViewById(R.id.cv_resistence);
        cv_power = findViewById(R.id.cv_power);
        cv_torque = findViewById(R.id.cv_torque);


    cv_tmp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, TemperatureConversion.class));
        }
    });

    cv_weight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, WeightConversion.class));
        }
    });

    cv_length.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, LengthConversion.class));
        }
    });


        cv_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SpeedConversion.class));
            }
        });
        cv_volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VolumeConversion.class));
            }
        });
        cv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TimeConversion.class));
            }
        });
        cv_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AreaConversion.class));
            }
        });
        cv_fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FuelConversion.class));
            }
        });
        cv_pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PressureConversion.class));
            }
        });
        cv_energy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EnergyConversion.class));
            }
        });
        cv_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StorageConversion.class));
            }
        });
        cv_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CurrentConversion.class));
            }
        });
        cv_force.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForceConversion.class));
            }
        });
        cv_freq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FrequencyConversion.class));
            }
        });
        cv_resistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResistanceConversion.class));
            }
        });
        cv_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PowerConversion.class));
            }
        });
        cv_torque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TorqueConversion.class));
            }
        });



    }
}