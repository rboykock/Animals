package rboyko.cherkassy.pro.animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import rboyko.cherkassy.pro.animals.manager.LoadManager;

public class SplashScreen extends AppCompatActivity {

    public static final int TIMESLEEP=5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        TextView app_title_view=(TextView) findViewById(R.id.app_title);
        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/9974.ttf");
        app_title_view.setTypeface(font);

        Thread trThread=new Thread() {
            public void run() {
                try {
                    sleep(SplashScreen.TIMESLEEP * 1000);

                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    LoadManager.loadSounds(getBaseContext());
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
