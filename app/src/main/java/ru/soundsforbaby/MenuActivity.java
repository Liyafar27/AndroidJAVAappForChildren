package ru.soundsforbaby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
        Button buttonExit;


    public void buttonPets ( View view) {
       // view.setHapticFeedbackEnabled(true);
        //view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);

        MediaPlayer mplayer = MediaPlayer.create(this,R.raw.petspops);

        mplayer.start();

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.animmain);
        view.startAnimation(anim);

        Intent intent = new Intent(getApplicationContext(), PetsActivity.class);
        startActivity(intent);

    }

    public void buttonVillage ( View view) {
        MediaPlayer mplayer = MediaPlayer.create(this,R.raw.villagepops);

        mplayer.start();

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.animmain);
        view.startAnimation(anim);

        Intent intent = new Intent(getApplicationContext(), VillageActivity.class);
        startActivity(intent);

    }
    public void buttonForest( View view) {
        MediaPlayer mplayer = MediaPlayer.create(this,R.raw.forestpops);

        mplayer.start();

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.animmain);
        view.startAnimation(anim);

        Intent intent = new Intent(getApplicationContext(), ForestActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        Button pets = findViewById(R.id.pets);
        Button village = findViewById(R.id.village);
        Button forest = findViewById(R.id.forest);

        Animation one = AnimationUtils.loadAnimation(this, R.anim.one);
        Animation two = AnimationUtils.loadAnimation(this, R.anim.two);
        Animation three = AnimationUtils.loadAnimation(this, R.anim.three);

        pets.startAnimation(one);
        village.startAnimation(two);
        forest.startAnimation(three);


        buttonExit = (Button) findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortClick();
            }
        });
        buttonExit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClick();
                return false;
            }
        });
    }
        public void shortClick() {
            Toast.makeText(this, "Для выхода  в главное меню нажимайте 2 секунды", Toast.LENGTH_LONG).show();

        }
        public  void longClick(){
       // android.os.Process.killProcess(android.os.Process.myPid());
       // System.exit(1);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            }
        }



