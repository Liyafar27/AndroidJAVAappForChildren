package ru.soundsforbaby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class PetsActivity extends AppCompatActivity {
    MediaPlayer mplayer;


    public void stopPlaying() {

        if (mplayer != null) {
            mplayer.stop();
        mplayer.release();
        mplayer=null;
      }
    }
       public void buttonTappedPets(View view) {

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

    public void buttonHomePets (View view) {

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
        setContentView(R.layout.activity_pets);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button cat=findViewById(R.id.cat);
        Button dog=findViewById(R.id.dog);
        Button guineapig=findViewById(R.id.guineapig);
        Button parrot=findViewById(R.id.parrot);
        Button hamster=findViewById(R.id.hamster);
        Button turtle=findViewById(R.id.turtle);

        Animation one =AnimationUtils.loadAnimation(this, R.anim.one);
        Animation two =AnimationUtils.loadAnimation(this, R.anim.two);
        Animation three =AnimationUtils.loadAnimation(this, R.anim.three);


        cat.startAnimation(one);
        dog.startAnimation(one);
        guineapig.startAnimation(two);
        parrot.startAnimation(two);
        turtle.startAnimation(three);
        hamster.startAnimation(three);
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

