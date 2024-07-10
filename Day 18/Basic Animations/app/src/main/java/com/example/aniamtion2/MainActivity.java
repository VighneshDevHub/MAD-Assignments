package com.example.aniamtion2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button buttonTranslate,buttonRotate,buttonScale;
    private View animatingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTranslate = findViewById(R.id.buttonTranslate);
        buttonRotate = findViewById(R.id.buttonRotate);
        buttonScale = findViewById(R.id.buttonScale);
        animatingView = findViewById(R.id.animatingView);


        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.anim.translate);
            }
        });


        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.anim.rotate);
            }
        });

        buttonScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(R.anim.scale);
            }
        });











//
//        buttonTranslate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ObjectAnimator animator = ObjectAnimator.ofFloat(animatingView, "translationX", 0f, 200f);
//                animator.setDuration(1000);
//                animator.start();
//            }
//        });
//
//        buttonRotate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ObjectAnimator animator = ObjectAnimator.ofFloat(animatingView, "rotation", 0f, 360f);
//                animator.setDuration(1000);
//                animator.start();
//            }
//        });

    }



    private void startAnimation(int animatioResource){
        Animation animation = AnimationUtils.loadAnimation(this,animatioResource);
        animatingView.startAnimation(animation);
    }


}
