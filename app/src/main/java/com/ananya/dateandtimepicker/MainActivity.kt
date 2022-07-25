package com.ananya.dateandtimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Month
import java.time.MonthDay
import java.time.Year

class MainActivity : AppCompatActivity() , DatePickerDialog.OnDateSetListener , TimePickerDialog.OnTimeSetListener {
    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var min = 0
    var savedday = 0
    var savedmonth = 0
    var savedyear = 0
    var savedhour = 0
    var savedmin = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calendar = Calendar.getInstance()
        set.text = calendar.time.toString()
        reset.setOnClickListener {
            set.text = "0:0"
        }

        pickdate()


    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun pickdate(){
        setdateandtime.setOnClickListener {
            getdateandtime()
            DatePickerDialog(this, this , day , month , year).show()


        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun getdateandtime() {
        val calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
        hour = calendar.get(Calendar.HOUR)
        min = calendar.get(Calendar.MINUTE)
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayofmonth : Int) {
        savedday = dayofmonth
        savedmonth=month
        savedyear=year
        TimePickerDialog(this  , this,hour,min , true  ).show()
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        savedhour= hour
        savedmin = min
        set.text = "date is $savedday : $savedmonth : $savedyear \n  Time is $savedhour-$savedmin"
    }


}