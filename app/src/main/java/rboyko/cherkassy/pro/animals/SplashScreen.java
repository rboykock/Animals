package rboyko.cherkassy.pro.animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import rboyko.cherkassy.pro.animals.manager.LoadManager;

import static java.security.AccessController.getContext;

public class SplashScreen extends AppCompatActivity {

    public static final int TIMESLEEP=6;
    private ProgressBar progressBar;
    protected Thread trThread;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT>=14) {

            getWindow().getDecorView().setSystemUiVisibility(android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
                    | android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | android.view.View.SYSTEM_UI_FLAG_IMMERSIVE);
        }

        setContentView(R.layout.splash_screen);


        TextView app_title_view=(TextView) findViewById(R.id.app_title);
        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/9974.ttf");
        app_title_view.setTypeface(font);

        progressBar=(ProgressBar)findViewById(R.id.splashScreenProgressBar);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();


        trThread=new Thread() {
            public void run() {
                    runProgress();
                    LoadManager.loadSounds(getBaseContext());
                    runMainActivity();
                    finish();
            }
        };

        mAdView.setAdListener(new AdListener() {

            public void onAdLoaded(){
                trThread.start();
            }


            public void onAdFailedToLoad(int i) {
                trThread.start();
            }
        });

        mAdView.loadAd(adRequest);
    }

    protected void runProgress(){
        for(int progress=0;progress<=100;progress+=10){
            try {
                progressBar.setProgress(progress);
                Thread.sleep(SplashScreen.TIMESLEEP * 100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    protected void runMainActivity(){
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
    }
}
