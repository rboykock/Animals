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
            case R.id.bear: playSound=LoadManager.getClip(0);
                            break;
            case R.id.cat:  playSound=LoadManager.getClip(1);
                            break;
            case R.id.chiken:   playSound=LoadManager.getClip(6);
                                break;
            case R.id.cow:  playSound=LoadManager.getClip(2);
                            break;
            case R.id.dog:  playSound=LoadManager.getClip(3);
                            break;
            case R.id.elephant: playSound=LoadManager.getClip(8);
                                break;
            case R.id.snake:    playSound=LoadManager.getClip(12);
                                break;
            case R.id.giraffe:  playSound=LoadManager.getClip(9);
                                break;
            case R.id.hippo: playSound=LoadManager.getClip(13);
                             break;
            case R.id.monkey: playSound=LoadManager.getClip(14);
                              break;
            case R.id.panda: playSound=LoadManager.getClip(15);
                             break;
            case R.id.parrot: playSound=LoadManager.getClip(10);
                              break;
            case R.id.penguin: playSound=LoadManager.getClip(11);
                              break;
            case R.id.pig: playSound=LoadManager.getClip(5);
                            break;
            case R.id.rabbit: Log.v("MyDEBUG","rabbit");
                            break;
            case R.id.sheep: playSound=LoadManager.getClip(7);
                            break;

        }
        SoundPool soundPool=LoadManager.getSoundPool();
        int mStreamId=soundPool.play(playSound, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
    }
}
