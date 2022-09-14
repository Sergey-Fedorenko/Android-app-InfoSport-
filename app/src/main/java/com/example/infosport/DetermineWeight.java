package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetermineWeight extends AppCompatActivity {

    public int resultWeight; //переменная для подсчёта процента жира в организме
    public Double obD,weight1; //переменная для подсчёта процента жира в организме

    public int resultPulse; // переменная для подсчёта пульса
    public Double agePulse; // переменная для подсчёта пульса

    public Double ageCalories,weightCalories,heightCalories,resultCalories; //Перевенные для подсчёта ккал

    public int resultWater; //переменные для подсчёта кол-во воды в сутки
    public Double weightWater,timeWater; //переменные для подсчёта кол-во воды в сутки

    public Double weight; // переменные для подсчёта иедеального веса
    int weightresult;// переменные для подсчёта иедеального веса

    TextView textViewMas, textViewWater,textViewCalories,textViewPulse, textViewWeight;

    BottomSheetDialog dialog; //переменная для всплывающего окна (идеальный вес)
    BottomSheetDialog dialog2; //переменная для всплывающего окна (подсчёт кол-во воды)
    BottomSheetDialog dialog3; //переменная для всплывающего окна (подсчёт кол-во калорий)
    BottomSheetDialog dialog4; //переменная для всплывающего окна (подсчёт макс. значения пульса)
    BottomSheetDialog dialog5; //переменная для всплывающего окна (подсчёт процента жира в организме)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determine_weight);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_calculator);
        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewMas = findViewById(R.id.textView8);
        textViewWater = findViewById(R.id.textView88);
        textViewCalories = findViewById(R.id.textView99);
        textViewPulse = findViewById(R.id.textView9);
        textViewWeight = findViewById(R.id.textView95);

        dialog = new BottomSheetDialog(this);
        dialog2 = new BottomSheetDialog(this);
        dialog3 = new BottomSheetDialog(this);
        dialog4 = new BottomSheetDialog(this);
        dialog5 = new BottomSheetDialog(this);

        createDialogWeight(); //Ваш идеальный вес
        createDialogWater(); //Кол-во воды в день
        createDialogCalories(); //Кол-во ккал в сутки
        createDialogPulse(); //Максимальный пульс при нагрузках
        createDialogMass(); //Процент жира в организме


        //Обработчик нажатия для "Идеальный вес"
        textViewMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAGS_CHANGED);

        //Обработчик для расчёта суточной нормы воды
        textViewWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });
        dialog2.getWindow().clearFlags(WindowManager.LayoutParams.FLAGS_CHANGED);

        //Обработчик для расчёта ккал в сутки
        textViewCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3.show();
            }
        });
        dialog3.getWindow().clearFlags(WindowManager.LayoutParams.FLAGS_CHANGED);

        //Обработчик для расчёта макс. пульса
        textViewPulse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4.show();
            }
        });
        dialog4.getWindow().clearFlags(WindowManager.LayoutParams.FLAGS_CHANGED);

        //Обработчик для расчёта процента жира
        textViewWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.show();
            }
        });
        dialog5.getWindow().clearFlags(WindowManager.LayoutParams.FLAGS_CHANGED);
    }


    //Метод для расчёта процента жира в организме
    private void createDialogMass() {

        View view = getLayoutInflater().inflate(R.layout.button_dialog_weight,null,false);

        Button startP = view.findViewById(R.id.button1);
        EditText ob = view.findViewById(R.id.obx);
        EditText mass = view.findViewById(R.id.weight);

        startP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean wantToCloseDialog = false;

                if (wantToCloseDialog)
                    dialog5.dismiss();

                if (!ob.getText().toString().equals("") && (!mass.getText().toString().equals("") )) {
                    obD = Double.parseDouble(ob.getText().toString());
                    weight1 = Double.parseDouble(mass.getText().toString());

                    resultWeight = (int) ((0.31457 * obD) - (0.10969 * weight1) + 10.834);

                    AlertDialog.Builder alert = new AlertDialog.Builder(DetermineWeight.this);
                    alert.setTitle(R.string.result);
                    alert.setMessage(getString(R.string.gir) + " " + resultWeight + "%");
                    alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           if (resultWeight <= 10) {
                               Toast.makeText(DetermineWeight.this, R.string.nise, Toast.LENGTH_SHORT).show();
                           } else {
                               Toast.makeText(DetermineWeight.this, R.string.vrema, Toast.LENGTH_SHORT).show();

                           }
                        }
                    });
                    alert.create().show();
                    dialog5.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.pola,Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog5.setContentView(view);
    }


    //Метод для расчёта макс. пульса при нагрузках
    private void createDialogPulse() {
        View view = getLayoutInflater().inflate(R.layout.button_dialog_pulse,null,false);

        Button startP = view.findViewById(R.id.button);
        EditText ageP = view.findViewById(R.id.age);

        startP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean wantToCloseDialog = false;

                if (wantToCloseDialog)
                    dialog3.dismiss();

                if (!ageP.getText().toString().equals("")) {
                    agePulse = Double.parseDouble(ageP.getText().toString());

                    resultPulse = (int) (220 - agePulse);

                    AlertDialog.Builder alert = new AlertDialog.Builder(DetermineWeight.this);
                    alert.setTitle(R.string.result);
                    alert.setMessage(getString(R.string.maxresult) + resultPulse);
                    alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DetermineWeight.this, R.string.nice, Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.create().show();
                    dialog4.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.age,Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog4.setContentView(view);
    }

    // Метод для расчёта ккал в сутки
    private void createDialogCalories() {
        View view = getLayoutInflater().inflate(R.layout.button_dialog_calories,null,false);

        Button start = view.findViewById(R.id.button);
        EditText weightC = view.findViewById(R.id.weight);
        EditText heightC = view.findViewById(R.id.height);
        EditText ageC = view.findViewById(R.id.age);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean wantToCloseDialog = false;

                if (wantToCloseDialog)
                    dialog3.dismiss();

                if (!weightC.getText().toString().equals("") && !heightC.getText().toString().equals("") && !ageC.getText().toString().equals("")) {
                    weightCalories = Double.parseDouble(weightC.getText().toString());
                    heightCalories = Double.parseDouble(heightC.getText().toString());
                    ageCalories = Double.parseDouble(ageC.getText().toString());

                    resultCalories = (10 * weightCalories) + (6.25 * heightCalories) - (5 * ageCalories) + 5;

                    AlertDialog.Builder alert = new AlertDialog.Builder(DetermineWeight.this);
                    alert.setTitle(R.string.result_kkal);
                    alert.setMessage(getString(R.string.neobhodimo) +  " " + resultCalories + " " + getString(R.string.kkal));
                    alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DetermineWeight.this, R.string.nice, Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.create().show();
                    dialog3.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.pola,Toast.LENGTH_SHORT).show();
                }

            }
        });
        dialog3.setContentView(view);
    }

    //Метод для расчёта суточной нормы воды
    private void createDialogWater() {

        View view = getLayoutInflater().inflate(R.layout.button_dialog_water,null,false);

        Button start = view.findViewById(R.id.button);
        EditText growthNumberWeight = view.findViewById(R.id.number);
        EditText growthNumberTime = view.findViewById(R.id.time);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean wantToCloseDialog = false;

                if (wantToCloseDialog)
                    dialog2.dismiss();

                if (!growthNumberWeight.getText().toString().equals("") && !growthNumberTime.getText().toString().equals("")) {

                    weightWater = Double.parseDouble(growthNumberWeight.getText().toString());
                    timeWater = Double.parseDouble(growthNumberTime.getText().toString());
                   resultWater = (int) ((weightWater * 0.04) + (timeWater * 0.6));

                    AlertDialog.Builder alert = new AlertDialog.Builder(DetermineWeight.this);
                    alert.setTitle(R.string.water);

                    if (resultWater >= 5 ){
                        alert.setMessage(getString(R.string.drink) + "\n" + resultWater + "  " + getString(R.string.day));
                        alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DetermineWeight.this, R.string.nice, Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert.create().show();
                        dialog2.dismiss();
                    }

                    if (resultWater >=2 && resultWater == 4)
                    {
                        alert.setMessage(getString(R.string.drink1) + "\n" + resultWater + "  " + getString(R.string.litr));
                        alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DetermineWeight.this, R.string.nice, Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert.create().show();
                        dialog2.dismiss();
                    }

                    if (resultWater == 1) {
                        alert.setMessage(getString(R.string.drink1) + "\n" + resultWater + "  " + getString(R.string.litr));
                        alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(DetermineWeight.this, R.string.nice, Toast.LENGTH_SHORT).show();
                            }
                        });
                        alert.create().show();
                        dialog2.dismiss();
                    }
                     } else {
                    Toast.makeText(getApplicationContext(), R.string.neobh,Toast.LENGTH_SHORT).show();
                    }


            }
        });
        dialog2.setContentView(view);
    }

    //Метод для расчёта идеального веса человека
    private void createDialogWeight() {

        View view = getLayoutInflater().inflate(R.layout.bottom_dialog,null,false);

        Button start = view.findViewById(R.id.button);
        EditText growthNumber = view.findViewById(R.id.number);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean wantToCloseDialog = false;

                if (wantToCloseDialog)
                    dialog.dismiss();

                if (!growthNumber.getText().toString().equals("")) {
                    weight = Double.parseDouble(growthNumber.getText().toString());
                    weightresult = (int) ((4 * weight / 2.54 - 128) * 0.453);
                    AlertDialog.Builder alert = new AlertDialog.Builder(DetermineWeight.this);
                    alert.setTitle(R.string.weight);
                    alert.setMessage(getString(R.string.niceweight) + " " + weightresult + getString(R.string.kg));
                    alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(DetermineWeight.this, R.string.nice, Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.create().show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.nugno,Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.setContentView(view);
    }
}