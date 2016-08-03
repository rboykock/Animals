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
    static  int[] soundId=new int[16];
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
        soundId[8]=soundPool.load(c,R.raw.elephant,1);
        soundId[9]=soundPool.load(c,R.raw.giraffe,1);
        soundId[10]=soundPool.load(c,R.raw.parrot,1);
        soundId[11]=soundPool.load(c,R.raw.penguin,1);
        soundId[12]=soundPool.load(c,R.raw.snake,1);
        soundId[13]=soundPool.load(c,R.raw.hippo,1);
        soundId[14]=soundPool.load(c,R.raw.monkey,1);
        soundId[15]=soundPool.load(c,R.raw.panda,1);

    }

    public static int getClip(int i){
        return soundId[i];
    }

    public static SoundPool getSoundPool(){
        return soundPool;
    }

}
