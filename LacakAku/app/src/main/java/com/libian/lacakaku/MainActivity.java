package com.libian.lacakaku;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.squareup.otto.Bus;

public class MainActivity extends AppCompatActivity {

    private Communicator communicator;
    private final static String TAG = "MainActivity";
    public static Bus bus;
    int battery;
    String slsno, dist, la, lg;

    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            battery = level;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        communicator = new Communicator();
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        slsno = "10001";
        dist = "3015070009";
        final Button postData = (Button) findViewById(R.id.postData);

        postData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData.setEnabled(false);
                final Handler handler = new Handler();
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while (true){
                            try {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        CoordinateHelper.getCoordinate(MainActivity.this);
                                        la = Double.toString(CoordinateHelper.getLatitude());
                                        lg = Double.toString(CoordinateHelper.getLongitude());
                                        usePost(slsno, dist, battery, la, lg);
                                    }
                                });
                                Thread.sleep(30000); // 1000 = 1 seconds
                            }catch (Exception e){

                            }
                        }
                    }
                };
                thread.start();
            }
        });
    }

    private void usePost(String slsno, String dist, int battery, String la, String lg){
        communicator.locationPost(slsno, dist, battery, la, lg);
    }
}
