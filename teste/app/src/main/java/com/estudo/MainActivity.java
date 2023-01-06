package com.estudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class MainActivity extends AppCompatActivity {

    Button myButton, buttonSecondary;
    public FlutterEngine flutterEngine, flutterSecondary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flutterEngine = new FlutterEngine(getApplicationContext());
        flutterSecondary = new FlutterEngine(getApplicationContext());

        flutterEngine.getNavigationChannel().setInitialRoute("home");
        flutterSecondary.getNavigationChannel().setInitialRoute("secondary");

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.getDartExecutor().executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        );
        flutterSecondary.getDartExecutor().executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        );

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
                .getInstance()
                .put("my_engine_id", flutterEngine);

        FlutterEngineCache
                .getInstance()
                .put("secondary", flutterSecondary);

        myButton = findViewById(R.id.button);
        buttonSecondary = findViewById(R.id.button_secondary);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(
                            FlutterActivity.withCachedEngine("my_engine_id")
                        .build(getApplicationContext())
                );
            }
        });

        buttonSecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(
                        FlutterActivity.withCachedEngine("secondary")
                                .build(getApplicationContext())
                );
//                Intent intent = new Intent(getApplicationContext(),FlutterActivity.class);
//                intent.putExtra("route","secondary");
//                startActivity(intent);
            }
        });
    }
}