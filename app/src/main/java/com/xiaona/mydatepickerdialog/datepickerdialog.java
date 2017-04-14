package com.xiaona.mydatepickerdialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.DateKeyListener;
import android.widget.TextView;
import android.view.View;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.View.OnClickListener;
import android.app.DatePickerDialog;
import android.widget.Toast;

public class datepickerdialog extends Activity {

    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        showdate=(TextView) this.findViewById(R.id.showdate);
        setdate=(Button) this.findViewById(R.id.setdate);
        Calendar c=Calendar.getInstance(Locale.CHINA);//初始化Calendar的日历对象
        Date mydate =new Date();//获取当前日期的Date对象
        c.setTime(mydate);      //为Calendar对象设置时间为当前日期

        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        showdate.setText("当前时间："+year+"-"+(month+1)+"-"+day);

        //添加单击事件--设置日期
        setdate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建DatePickerDialog对象
                DatePickerDialog myDatePickerDialog=new DatePickerDialog(datepickerdialog.this, DateListener,year,month,day);
                myDatePickerDialog.show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener DateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker v, int y, int m, int d) {

            //修改year,month,day值
            if(y>year){
                updateDate();
                Toast.makeText(getApplicationContext(),"设置日期无效",Toast.LENGTH_SHORT).show();
            }else if(m>month){
                updateDate();
                Toast.makeText(getApplicationContext(),"设置日期无效",Toast.LENGTH_SHORT).show();
            }else if(d>day){
                updateDate();
                Toast.makeText(getApplicationContext(),"设置日期无效",Toast.LENGTH_SHORT).show();
            }else {
                year=y;
                month=m;
                day=d;
                updateDate();//更新日期；
            }

        }
        private void updateDate(){
            showdate.setText("当前时间："+year+"-"+(month+1)+"-"+day);
        }
    };
}
