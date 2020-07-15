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

public class ForestActivity extends AppCompatActivity {

    MediaPlayer mplayer;

    public void stopPlaying() {

        if (mplayer != null) {
            mplayer.stop();
            mplayer.release();
            mplayer=null;
        }
    }


    public void buttonTappedForest(View view)  {

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

    public void buttonHomeForest (View view) {

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
        setContentView(R.layout.activity_forest);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button bear = findViewById(R.id.bear);
        Button wolf = findViewById(R.id.wolf);
        Button fox = findViewById(R.id.fox);
        Button snake = findViewById(R.id.snake);
        Button frog = findViewById(R.id.frog);
        Button hedgehog = findViewById(R.id.hedgehog);

        Animation one = AnimationUtils.loadAnimation(this, R.anim.one);
        Animation two = AnimationUtils.loadAnimation(this, R.anim.two);
        Animation three = AnimationUtils.loadAnimation(this, R.anim.three);


        bear.startAnimation(one);
        wolf.startAnimation(one);
        fox.startAnimation(two);
        snake.startAnimation(two);
        frog.startAnimation(three);
        hedgehog.startAnimation(three);
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
