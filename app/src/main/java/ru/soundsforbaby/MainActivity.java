package ru.soundsforbaby;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView8;
    private Animation anim8;
    private Animation four;
    ImageView bublemain;
    ImageView exitMain;
    MediaPlayer mplayer1;
    MediaPlayer mplayer2;

public void policy (View view) {
    Button buttonPolicy = (Button) findViewById(R.id.buttonPolicy);

    Intent intent = new Intent(MainActivity.this, Policy.class);
    startActivity(intent);

}

public void firstView(View view) {

        bublemain = (ImageView) findViewById(R.id.bublemain);

        Animation anim = null;
        anim = AnimationUtils.loadAnimation(this, R.anim.animmain);
        bublemain.startAnimation(anim);

       mplayer1.stop();
       mplayer2 = MediaPlayer.create(this, R.raw.pops);
       mplayer2.start();


        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

    public void shortClick() {
        Toast.makeText(this, "Для выхода удерживать 2 секунды", Toast.LENGTH_LONG).show();

    }
    public  void longClick(){
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(1);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mplayer1 = MediaPlayer.create(this, R.raw.mainsong);
        mplayer1.setLooping(false);
        mplayer1.start();


        imageView8 = findViewById(R.id.imageView8);
        bublemain = findViewById(R.id.bublemain);

        anim8 = null;
        four = null;

        anim8 = AnimationUtils.loadAnimation(this, R.anim.forclick);
        four = AnimationUtils.loadAnimation(this, R.anim.four);
        imageView8.startAnimation(anim8);
        bublemain.startAnimation(four);


        exitMain = (ImageView) findViewById(R.id.exitMain);
        exitMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortClick();
            }
        });
        exitMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClick();
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mplayer1.stop();
    }

    @Override
    protected void onStop() {
         super.onStop();
        mplayer1.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mplayer1.stop();
    }
}










