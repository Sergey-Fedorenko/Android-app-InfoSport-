package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private long backPressedTime;
    private Toast backToast;

    private Button BtMan;
    private Button BtGirl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_gender);

        BtMan = findViewById(R.id.buttonMan);
        BtGirl = findViewById(R.id.buttonGirl);


        BtMan.setOnClickListener(this);
        BtGirl.setOnClickListener(this);


        //Проверка- Входит пользователь первый раз или нет
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {

            AlertDialog.Builder alert1 = new AlertDialog.Builder(MainActivity.this,R.style.fullscreenalert);
            View mView = getLayoutInflater().inflate(R.layout.fullalertdialog,null);
            alert1.setCancelable(true);
            alert1.setView(mView);
            AlertDialog dialog = alert1.create();

           Button dialogButton = (Button) mView.findViewById(R.id.close1);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();

                    //Если первый раз, то выполняется...
            new TapTargetSequence(this)
                    .targets(
                    TapTarget.forView(BtMan,getString(R.string.man1), getString(R.string.button1))
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
                            TapTarget.forView(BtGirl,getString(R.string.girl),getString(R.string.button1))
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
                    Intent i = new Intent(MainActivity.this,GenderMan.class);
                    startActivity(i);
                    finish();
                }

                @Override
                public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                }

                @Override
                public void onSequenceCanceled(TapTarget lastTarget) {

                }
            }).start();

        } else {
            //Если заходит второй раз выполняется...
        }
    prefs.edit().putBoolean("isFirstRun",false).apply();

    }

    //Переход Man and Girl
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonMan:
                Intent intent = new Intent(MainActivity.this, GenderMan.class);
                startActivity(intent);
                break;
            case R.id.buttonGirl:
                Intent intent2 = new Intent(MainActivity.this, GenderGirl.class);
                startActivity(intent2);
                break;
            case R.id.close1:
        }
    }

    //Выход из приложения нажатием кнопки назад 2 раза
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
           backToast = Toast.makeText(getBaseContext(), R.string.close1, Toast.LENGTH_SHORT);
           backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    //Добавление элементов в меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    //Обрабочик для  icon в ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item2:
                Intent intent3 = new Intent(MainActivity.this, Info.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
