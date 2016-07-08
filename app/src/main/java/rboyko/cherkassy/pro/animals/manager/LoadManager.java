package rboyko.cherkassy.pro.animals.manager;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.provider.ContactsContract;

import rboyko.cherkassy.pro.animals.R;

/**
 * Created by rost on 08.07.2016.
 */
public class LoadManager {
    static  int[] soundId=new int[8];
    static SoundPool soundPool=null;

    public static void loadSounds(Context c){
        soundPool=new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundId[0]=soundPool.load(c,R.raw.bear,1);
        soundId[1]=soundPool.load(c,R.raw.cat,1);
        soundId[2]=soundPool.load(c,R.raw.cow,1);
        soundId[3]=soundPool.load(c,R.raw.dog,1);
        soundId[4]=soundPool.load(c,R.raw.duck,1);
        soundId[5]=soundPool.load(c,R.raw.pigs,1);
        soundId[6]=soundPool.load(c,R.raw.rooster,1);
        soundId[7]=soundPool.load(c,R.raw.sheep,1);

    }

    public static int getClip(int i){
        return soundId[i];
    }

    public static SoundPool getSoundPool(){
        return soundPool;
    }

}
