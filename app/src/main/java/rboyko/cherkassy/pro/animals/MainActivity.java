package rboyko.cherkassy.pro.animals;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import rboyko.cherkassy.pro.animals.manager.LoadManager;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    protected ImageView[] imagesView=new ImageView[16];
    protected AudioManager audioManager;
    protected float curVolume, maxVolume, leftVolume, rightVolume;
    protected int priority = 1;
    protected int no_loop = 0;
    protected float normal_playback_rate = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesView[0]=(ImageView)findViewById(R.id.bear);
        imagesView[1]=(ImageView)findViewById(R.id.cat);
        imagesView[2]=(ImageView)findViewById(R.id.chiken);
        imagesView[3]=(ImageView)findViewById(R.id.cow);
        imagesView[4]=(ImageView)findViewById(R.id.dog);
        imagesView[5]=(ImageView)findViewById(R.id.elephant);
        imagesView[6]=(ImageView)findViewById(R.id.snake);
        imagesView[7]=(ImageView)findViewById(R.id.giraffe);
        imagesView[8]=(ImageView)findViewById(R.id.hippo);
        imagesView[9]=(ImageView)findViewById(R.id.monkey);
        imagesView[10]=(ImageView)findViewById(R.id.panda);
        imagesView[11]=(ImageView)findViewById(R.id.parrot);
        imagesView[12]=(ImageView)findViewById(R.id.penguin);
        imagesView[13]=(ImageView)findViewById(R.id.pig);
        imagesView[14]=(ImageView)findViewById(R.id.rabbit);
        imagesView[15]=(ImageView)findViewById(R.id.sheep);

        LoadManager.loadSounds(this);

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        leftVolume = curVolume / maxVolume;
        rightVolume = curVolume / maxVolume;

        for(ImageView view:imagesView){
            view.setOnClickListener(this);
        }

    }

    protected void onDestroy() {
        super.onDestroy();
        LoadManager.getSoundPool().release();
    }

    @Override
    public void onClick(View v) {
        int playSound=0;
        switch (v.getId()){
            case R.id.bear: Log.v("MyDEBUG","bear");
                            playSound=LoadManager.getClip(0);
                            break;
            case R.id.cat: Log.v("MyDEBUG","cat");
                            playSound=LoadManager.getClip(1);
                            break;
            case R.id.chiken: Log.v("MyDEBUG","chiken");
                                playSound=LoadManager.getClip(6);
                                break;
            case R.id.cow: Log.v("MyDEBUG","cow");
                            playSound=LoadManager.getClip(2);
                            break;
            case R.id.dog: Log.v("MyDEBUG","dog");
                            playSound=LoadManager.getClip(3);
                            break;
            case R.id.elephant: Log.v("MyDEBUG","elephant");
                                break;
            case R.id.snake: Log.v("MyDEBUG","snak");
                                break;
            case R.id.giraffe: Log.v("MyDEBUG","giraffe");
                                break;
            case R.id.hippo: Log.v("MyDEBUG","hippo");
                            break;
            case R.id.monkey: Log.v("MyDEBUG","monkey");
                             break;
            case R.id.panda: Log.v("MyDEBUG","panda");
                            break;
            case R.id.parrot: Log.v("MyDEBUG","parrot");
                            break;
            case R.id.penguin: Log.v("MyDEBUG","penguin");
                            break;
            case R.id.pig: Log.v("MyDEBUG","pig");
                            playSound=LoadManager.getClip(5);
                            break;
            case R.id.rabbit: Log.v("MyDEBUG","rabbit");
                            break;
            case R.id.sheep: Log.v("MyDEBUG","sheep");
                            playSound=LoadManager.getClip(7);
                            break;

        }
        SoundPool soundPool=LoadManager.getSoundPool();
        int mStreamId=soundPool.play(playSound, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
    }
}
