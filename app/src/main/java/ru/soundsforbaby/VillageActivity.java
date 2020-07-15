package ru.soundsforbaby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class VillageActivity extends AppCompatActivity {
    MediaPlayer mplayer;


    public void stopPlaying() {

        if (mplayer != null) {
            mplayer.stop();
            mplayer.release();
            mplayer=null;
        }
    }

    public void buttonTappedVillage(View view)  {

        int id = view.getId();
        String ourId = "";
        ourId = view.getResources().getResourceEntryName(id);

        int resourseId = getResources().getIdentifier(ourId, "raw", "ru.soundsforbaby");

        stopPlaying();
        mplayer = MediaPlayer.create(this, resourseId);
        mplayer.start();

        Animation anim = null;
        int a = (int) (Math.random() * 3);
        int animResourse;
        switch (a) {
            case 1:
                animResourse = R.anim.bounce;
                break;
            default:
                animResourse = R.anim.animpets;
        }
        anim = AnimationUtils.loadAnimation(this, animResourse);
        view.startAnimation(anim);
    }

    public void buttonHomeVillage (View view) {

        MediaPlayer mplayerHome = MediaPlayer.create(this,R.raw.pop);

        mplayerHome.start();

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.animmain);
        view.startAnimation(anim);


        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button cow=findViewById(R.id.cow);
        Button rooster=findViewById(R.id.rooster);
        Button pig=findViewById(R.id.pig);
        Button goat=findViewById(R.id.goat);
        Button horse=findViewById(R.id.horse);
        Button goose=findViewById(R.id.goose);


        Animation one =AnimationUtils.loadAnimation(this, R.anim.one);
        Animation two =AnimationUtils.loadAnimation(this, R.anim.two);
        Animation three =AnimationUtils.loadAnimation(this, R.anim.three);



        cow.startAnimation(one);
        pig.startAnimation(one);
        goat.startAnimation(two);
        rooster.startAnimation(two);
        horse.startAnimation(three);
        goose.startAnimation(three);
    }
    @Override
    public void onPause() {
        super.onPause();
        if(mplayer != null) {
            mplayer.release();
            mplayer=null;
        }

    }
}
