package rayan.avik.autobackgroundchange;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout backgroundLayoutImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backgroundLayoutImage = (LinearLayout) findViewById(R.id.layout2);

        /////Make statusbar full screen /////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        final int drawablearray[] = {R.drawable.backgrnd,R.drawable.backgrnd1,R.drawable.backgrnd2,R.drawable.backgrnd3,R.drawable.backgrnd4};

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int randomAndroidColor = drawablearray[new Random().nextInt(drawablearray.length)];
                backgroundLayoutImage.setBackgroundResource(randomAndroidColor);
                handler.postDelayed(this,3000);
            }
        }, 3000);

    }
}
