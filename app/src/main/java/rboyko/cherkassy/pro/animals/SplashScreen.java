package rboyko.cherkassy.pro.animals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    public static final int TIMESLEEP=14;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread trThread=new Thread() {
            public void run() {
                try {
                    sleep(SplashScreen.TIMESLEEP * 1000);

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);

                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        trThread.start();
    }
}
