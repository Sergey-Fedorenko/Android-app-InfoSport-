package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

public class GenderMan extends AppCompatActivity implements  View.OnClickListener{

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_man);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layouts);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView1 = findViewById(R.id.imageViewMan);
        imageView2 = findViewById(R.id.imageVieManNutrition);
        imageView3 = findViewById(R.id.imageViewTime);
        imageView4 = findViewById(R.id.imageViewSportPit);
        imageView5 = findViewById(R.id.imageViewArticles);
        imageView6 = findViewById(R.id.imageViewProducts);


        imageView1.setOnClickListener((View.OnClickListener) this);
        imageView2.setOnClickListener((View.OnClickListener) this);
        imageView3.setOnClickListener((View.OnClickListener) this);
        imageView4.setOnClickListener((View.OnClickListener) this);
        imageView5.setOnClickListener((View.OnClickListener) this);
        imageView6.setOnClickListener((View.OnClickListener) this);

        //Проверка на первый вход в приложение
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            new TapTargetSequence(this)
                    .targets(
                            TapTarget.forView(imageView1,getString(R.string.plan_treni), getString(R.string.kos_icon))
                                    .outerCircleColor(R.color.defaultColor)
                                    .outerCircleAlpha(0.96f)
                                    .targetCircleColor(R.color.white)
                                    .titleTextSize(25)
                                    .titleTextColor(R.color.white)
                                    .descriptionTextSize(15)
                                    .descriptionTextColor(R.color.black)
                                    .textColor(R.color.black)
                                    .textTypeface(Typeface.SANS_SERIF)
                                    .dimColor(R.color.black)
                                    .drawShadow(true)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .transparentTarget(true)
                                    .targetRadius(70),
                            TapTarget.forView(imageView2,getString(R.string.nutri), getString(R.string.kos_icon))
                                    .outerCircleColor(R.color.defaultColor)
                                    .outerCircleAlpha(0.96f)
                                    .targetCircleColor(R.color.white)
                                    .titleTextSize(25)
                                    .titleTextColor(R.color.white)
                                    .descriptionTextSize(15)
                                    .descriptionTextColor(R.color.black)
                                    .textColor(R.color.black)
                                    .textTypeface(Typeface.SANS_SERIF)
                                    .dimColor(R.color.black)
                                    .drawShadow(true)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .transparentTarget(true)
                                    .targetRadius(70),
                            TapTarget.forView(imageView3,getString(R.string.sec), getString(R.string.kos_icon))
                                    .outerCircleColor(R.color.defaultColor)
                                    .outerCircleAlpha(0.96f)
                                    .targetCircleColor(R.color.white)
                                    .titleTextSize(25)
                                    .titleTextColor(R.color.white)
                                    .descriptionTextSize(15)
                                    .descriptionTextColor(R.color.black)
                                    .textColor(R.color.black)
                                    .textTypeface(Typeface.SANS_SERIF)
                                    .dimColor(R.color.black)
                                    .drawShadow(true)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .transparentTarget(true)
                                    .targetRadius(70),
                            TapTarget.forView(imageView4,getString(R.string.note), getString(R.string.kos_icon))
                                    .outerCircleColor(R.color.defaultColor)
                                    .outerCircleAlpha(0.96f)
                                    .targetCircleColor(R.color.white)
                                    .titleTextSize(25)
                                    .titleTextColor(R.color.white)
                                    .descriptionTextSize(15)
                                    .descriptionTextColor(R.color.black)
                                    .textColor(R.color.black)
                                    .textTypeface(Typeface.SANS_SERIF)
                                    .dimColor(R.color.black)
                                    .drawShadow(true)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .transparentTarget(true)
                                    .targetRadius(70),
                            TapTarget.forView(imageView5,getString(R.string.articl), getString(R.string.kos_icon))
                                    .outerCircleColor(R.color.defaultColor)
                                    .outerCircleAlpha(0.96f)
                                    .targetCircleColor(R.color.white)
                                    .titleTextSize(25)
                                    .titleTextColor(R.color.white)
                                    .descriptionTextSize(15)
                                    .descriptionTextColor(R.color.black)
                                    .textColor(R.color.black)
                                    .textTypeface(Typeface.SANS_SERIF)
                                    .dimColor(R.color.black)
                                    .drawShadow(true)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .transparentTarget(true)
                                    .targetRadius(70),
                            TapTarget.forView(imageView6,getString(R.string.idealweight), getString(R.string.kos_icon))
                                    .outerCircleColor(R.color.defaultColor)
                                    .outerCircleAlpha(0.96f)
                                    .targetCircleColor(R.color.white)
                                    .titleTextSize(25)
                                    .titleTextColor(R.color.white)
                                    .descriptionTextSize(15)
                                    .descriptionTextColor(R.color.black)
                                    .textColor(R.color.black)
                                    .textTypeface(Typeface.SANS_SERIF)
                                    .dimColor(R.color.black)
                                    .drawShadow(true)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .transparentTarget(true)
                                    .targetRadius(70)).listener(new TapTargetSequence.Listener() {
                @Override
                public void onSequenceFinish() {

                }

                @Override
                public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                }

                @Override
                public void onSequenceCanceled(TapTarget lastTarget) {

                }
            }).start();
        } else {

        }
        prefs.edit().putBoolean("isFirstRun",false).apply();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imageViewMan:
                Intent intent = new Intent(this, BodyTypeMan.class);
                startActivity(intent);
                break;
            case R.id.imageVieManNutrition:
                Intent intent1 = new Intent(this,Nutrition_man.class);
                startActivity(intent1);
                break;
            case R.id.imageViewTime:
                Intent intent2 = new Intent(this,TimerManAndGirl.class);
                startActivity(intent2);
                break;
            case R.id.imageViewSportPit:
                Intent intent3 = new Intent(this, NotePad.class);
                startActivity(intent3);
                break;
            case R.id.imageViewArticles:
                Intent intent4 = new Intent(this,Articles.class);
                startActivity(intent4);
                break;
            case R.id.imageViewProducts:
                Intent intent5 = new Intent(this, DetermineWeight.class);
                startActivity(intent5);
                break;
        }
    }
}