package com.example.vol6;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class createURL {

    public static CalendarEntity get(String text) {
        CalendarEntity CalendarParam = new CalendarEntity();
        boolean debug = true;
        if(debug)System.out.println("createURLのtext : " + text + "\n");
        String yotei[] = text.split("\n", 0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date1 = new Date();
        Date date2 = new Date();
		try {
            date1 = sdf.parse(yotei[2]);
            date2 = sdf.parse(yotei[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(debug)System.out.println("date1.toString() : " + date1.toString() + "\n");
        CalendarParam.calendar1 = Calendar.getInstance();
        CalendarParam.calendar2 = Calendar.getInstance();
        CalendarParam.calendar1.setTime(date1);
        CalendarParam.calendar2.setTime(date2);
        CalendarParam.title = yotei[1];
        CalendarParam.location = yotei[4];
        CalendarParam.details = yotei[5];
        
        //URL生成
        String yotei_name = yotei[1];
        if(debug)System.out.println("yotei_name : " + yotei_name+"\n");
        String yotei_start_time = yotei[2].replaceAll("\\s", "T");
        if(debug)System.out.println("yotei_start_time : " + yotei_start_time + "\n");
        yotei_start_time = yotei_start_time.replaceAll("\\W", "");
        if(debug)System.out.println("yotei_start_time : " + yotei_start_time+"\n");
        String yotei_end_time = yotei[3].replaceAll("\\s", "T");
        if(debug)System.out.println("yotei_end_time : " + yotei_end_time+"\n");
        yotei_end_time = yotei_end_time.replaceAll("\\W", "");
        if(debug)System.out.println("yotei_end_time : " + yotei_end_time+"\n");
        String action = "TEMPLATE";
        CalendarParam.URL = "http://www.google.com/calendar/event?action=" + action + "&text=" + yotei_name + "&dates="
                + yotei_start_time + "00/" + yotei_end_time + "00"+"&location="+ CalendarParam.location+"&details="+ CalendarParam.details;
        

        if(debug)System.out.println("CalendarParam.calendar1.get(Calendar.YEAR) : " + CalendarParam.calendar1.get(Calendar.YEAR) + "\n");
        if(debug)System.out.println("CalendarParam.calendar1.get(Calendar.MONTH) : " + Integer.toString(CalendarParam.calendar1.get(Calendar.MONTH)+1) + "\n");
        if(debug)System.out.println("CalendarParam.calendar1.get(Calendar.DATE) : " + CalendarParam.calendar1.get(Calendar.DATE) + "\n");
        if(debug)System.out.println("CalendarParam.calendar1.get(Calendar.HOUR_OF_DAY) : " + CalendarParam.calendar1.get(Calendar.HOUR_OF_DAY) + "\n");
        if(debug)System.out.println("CalendarParam.calendar1.get(Calendar.MINUTE) : " + CalendarParam.calendar1.get(Calendar.MINUTE) + "\n");
        
        if(debug)System.out.println("CalendarParam.calendar2.get(Calendar.YEAR) : " + CalendarParam.calendar2.get(Calendar.YEAR) + "\n");
        if(debug)System.out.println("CalendarParam.calendar2.get(Calendar.MONTH) : " + Integer.toString(CalendarParam.calendar2.get(Calendar.MONTH)+1) + "\n");
        if(debug)System.out.println("CalendarParam.calendar2.get(Calendar.DATE) : " + CalendarParam.calendar2.get(Calendar.DATE) + "\n");
        if(debug)System.out.println("CalendarParam.calendar2.get(Calendar.HOUR_OF_DAY) : " + CalendarParam.calendar2.get(Calendar.HOUR_OF_DAY) + "\n");
        if(debug)System.out.println("CalendarParam.calendar2.get(Calendar.MINUTE) : " + CalendarParam.calendar2.get(Calendar.MINUTE) + "\n");
        
        if(debug)System.out.println("CalendarParam.Location : " + CalendarParam.location + "\n");
        if(debug)System.out.println("CalendarParam.Details : " + CalendarParam.details + "\n");
        if(debug)System.out.println("CalendarParam.URL : " + CalendarParam.URL+"\n");
        
		return CalendarParam;
    }
    
    
    public static void main(String[] args){
        get("予定追加\nオフ会\n2021/02/03 12:00:00\n2021/02/04 15:00:00\n大阪駅\n飯食ってカラオケ");
    }
}
