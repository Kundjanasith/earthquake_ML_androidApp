package com.example.exceed.earthquake;

import android.graphics.Color;
import android.os.Parcelable;
import java.util.Date;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;
    private CalendarView calendarView;
    private Spinner dropdown;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.single_list_item);
        calendarView = (CalendarView) findViewById(R.id.calendar);
        InputStream inputStream = getResources().openRawResource(R.raw.stats);
        CSVReader csv = new CSVReader(inputStream);
        List<String[]> scoreList = csv.read();
        System.out.println("XXXX"+scoreList.get(0));
        dropdown = (Spinner)findViewById(R.id.spinner1);
        but = (Button)findViewById(R.id.button);

        init();

//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, final int month, int dayOfMonth) {

                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Date d = new Date(calendarView.getDateTextAppearance());
                        Log.d("testX",d.getMonth()+"");
                        Log.d("testY",dropdown.getSelectedItemPosition()+"");

                    }
                });

//            }
//        });




//        String[] items = new String[]{"1", "2", "three"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
//        dropdown.setAdapter(adapter);

//        for(String[] scoreData:scoreList){
//            itemArrayAdapter.add(scoreData);
//        }

    }
    private Button leftz;
    private Button rightz;
    private Button moth;
    public void init(){
        leftz = (Button)findViewById(R.id.left);
        rightz = (Button)findViewById(R.id.right);
        moth = (Button)findViewById(R.id.month_year);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        final String[] m = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};

        moth.setText(m[month]+" / "+year);
        leftz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String h = moth.getText().toString().split(" / ")[0];
                int mm = 0;
                for(int i=0 ; i<12 ; i++){
                    if(h.equals(m[i])) mm = i-1;
                }
                int yy = Integer.parseInt(moth.getText().toString().split(" / ")[1]);
                if(mm==-1 && yy==2016){
                }
                else{
                    if(mm==-1){
                        mm=11;
                        yy=yy-1;
                    }
                    moth.setText(m[mm]+" / "+yy);
                }
            }
        });

        rightz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String h = moth.getText().toString().split(" / ")[0];
                int mm = 0;
                for(int i=0 ; i<12 ; i++){
                    if(h.equals(m[i])) mm = i+1;
                }
                int yy = Integer.parseInt(moth.getText().toString().split(" / ")[1]);
                if(mm==12 && yy==2026){
                }
                else{
                    if(mm==12){
                        mm=0;
                        yy=yy+1;
                    }
                    moth.setText(m[mm]+" / "+yy);
                }
            }
        });



    }
}
