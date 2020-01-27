package com.nextnepal.nextNepalPatro.calendar.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.annotation.IntRange;
import android.util.Log;

import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.calendar.contract.CalendarContract;
import com.nextnepal.nextNepalPatro.calendar.model.db.DatabaseHelperClass;
import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroEntity;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroEvent;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarModel extends CalendarBaseModel implements CalendarContract.Model {

    private final String CALENDAR_DATE_DATA = "data";
    private PatroEntity patroEntity;
    private DatabaseHelperClass databaseHelperClass;
    private Context context;


    public CalendarModel(Context context) {
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
        getDaysInMonthMap();
        getStartWeekDayMonthMap();
        SharedPreferences sharedPref = context.getSharedPreferences(CALENDAR_DATE_DATA, Context.MODE_PRIVATE);
        if (!sharedPref.getBoolean("dateSaved", false)) {
            new addDateToDatabse(context).execute("");
        }
        if (!sharedPref.getBoolean("eventSaved", false)) {
            new addEventToDatabase(context).execute("");
        }
    }

    private static boolean isEngDateInConversionRange(int yy, int mm, int dd) {
        return (yy >= 1913 && yy <= 2033) && (mm >= 1 && mm <= 12) && (dd >= 1 && dd <= 31);
    }

    @Override
    public List<PatroDto> getSelectedMonths(int selectedNepaliYear, int selectedNepaliMonth) {
        List<PatroDto> patroDtoList = new ArrayList<>();
        Cursor c = databaseHelperClass.loadMonth(selectedNepaliYear, selectedNepaliMonth);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                int nyear = c.getInt(c.getColumnIndex("nyear"));
                int nmonth = c.getInt(c.getColumnIndex("nmonth"));
                int nday = c.getInt(c.getColumnIndex("nday"));
                int eyear = c.getInt(c.getColumnIndex("eyear"));
                int emonth = c.getInt(c.getColumnIndex("emonth"));
                int eday = c.getInt(c.getColumnIndex("eday"));
                String id = c.getString(c.getColumnIndex("id"));
                int dayOfWeek = c.getInt(c.getColumnIndex("dayOfWeek"));
                int isHoliday = c.getInt(c.getColumnIndex("holiday"));
                PatroDto patroDto = new PatroDto(nyear, nmonth, nday, eyear, emonth, eday, id, dayOfWeek, isHoliday);
                patroDtoList.add(patroDto);
            }
        }
        return patroDtoList;
    }

    @Override
    public EventDto getEvent(String date) {
        return databaseHelperClass.loadPatroEvent(date);
    }


    private PatroEntity getNepaliDate(@IntRange(from = 1913 - 2033) int engYY,
                                      @IntRange(from = 1, to = 12) int engMM,
                                      @IntRange(from = 1, to = 31) int engDD) {

        if (isEngDateInConversionRange(engYY, engMM, engDD)) {

            int startingEngYear = 1913;
            int startingEngMonth = 4;
            int startingEngDay = 13;

            int startingDayOfWeek = Calendar.SUNDAY; // 1913/4/13 is a Sunday

            int startingNepYear = 1970;
            int startingNepMonth = 1;
            int startingNepDay = 1;

            int nepYY, nepMM, nepDD;
            int dayOfWeek = startingDayOfWeek;

            PatroEntity tempPatroEntity = new PatroEntity();

//
//            Calendar currentEngDate = new GregorianCalendar();
//            currentEngDate.set(engYY, engMM, engDD);
//            Calendar baseEngDate = new GregorianCalendar();
//            baseEngDate.set(startingEngYear, startingEngMonth, startingEngDay);
//            long totalEngDaysCount = daysBetween(baseEngDate, currentEngDate);
//
            /*calculate the days between two english date*/


            DateTime base = new DateTime(startingEngYear, startingEngMonth, startingEngDay, 0, 0); // June 20th, 2010
            DateTime newDate = new DateTime(engYY, engMM, engDD, 0, 0); // July 24th
            long totalEngDaysCount = Days.daysBetween(base, newDate).getDays();

            nepYY = startingNepYear;
            nepMM = startingNepMonth;
            nepDD = startingNepDay;

            while (totalEngDaysCount != 0) {
                int daysInMonth = daysInMonthMap.get(nepYY)[nepMM];
                nepDD++;
                if (nepDD > daysInMonth) {
                    nepMM++;
                    nepDD = 1;
                }
                if (nepMM > 12) {
                    nepYY++;
                    nepMM = 1;
                }
                dayOfWeek++;
                if (dayOfWeek > 7) {
                    dayOfWeek = 1;
                }
                totalEngDaysCount--;
            }
            tempPatroEntity.setYear(nepYY);
            tempPatroEntity.setMonth(nepMM - 1);
            tempPatroEntity.setDay(nepDD);
            tempPatroEntity.setDayOfWeek(dayOfWeek);

            return tempPatroEntity;
        } else
            throw new IllegalArgumentException("Out of Range: Date is out of range to Convert");
    }

    @Override
    public PatroEntity getCurrentDatesNep() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month++;
        int day = calendar.get(Calendar.DATE);
        return getNepaliDate(year, month, day);
    }

    @Override
    public String getStringDay(int i) {

        String dayname = "";
        switch (i) {
            case 1:
                dayname = "आइतबार";
                break;
            case 2:
                dayname = "सोमबार";
                break;
            case 3:
                dayname = "मंगलवार";
                break;
            case 4:
                dayname = "बुधबार ";
                break;
            case 5:
                dayname = "बिहीबार";
                break;
            case 6:
                dayname = "शुक्रबार";
                break;
            case 7:
                dayname = "शनिबार";
                break;
            default:
                break;
        }
        return dayname;
    }

    @Override
    public String getStringMonth(int i) {
        String monthofYear = "";
        switch (i) {
            case 1:
                monthofYear = "बैशाख";
                break;
            case 2:
                monthofYear = "जेष्ठ";
                break;
            case 3:
                monthofYear = "आषाढ";
                break;
            case 4:
                monthofYear = "श्रावण";
                break;
            case 5:
                monthofYear = "भाद्र";
                break;
            case 6:
                monthofYear = "आश्विन";
                break;
            case 7:
                monthofYear = "कार्तिक";
                break;
            case 8:
                monthofYear = "मंसिर";
                break;
            case 9:
                monthofYear = "पौष";
                break;
            case 10:
                monthofYear = "माघ";
                break;
            case 11:
                monthofYear = "फाल्गुन";
                break;
            case 12:
                monthofYear = "चैत";
                break;
        }
        return monthofYear;
    }

    @Override
    public List<PatroDto> getSelectedDate(int month, int year) {
        List<PatroDto> patroDtoList = new ArrayList<>();
        Cursor c = databaseHelperClass.loadMonth(year, month);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                int nyear = c.getInt(c.getColumnIndex("nyear"));
                int nmonth = c.getInt(c.getColumnIndex("nmonth"));
                int nday = c.getInt(c.getColumnIndex("nday"));
                int eyear = c.getInt(c.getColumnIndex("eyear"));
                int emonth = c.getInt(c.getColumnIndex("emonth"));
                int eday = c.getInt(c.getColumnIndex("eday"));
                String id = c.getString(c.getColumnIndex("id"));
                int dayOfWeek = c.getInt(c.getColumnIndex("dayOfWeek"));
                int isHoliday = c.getInt(c.getColumnIndex("holiday"));
                PatroDto patroDto = new PatroDto(nyear, nmonth, nday, eyear, emonth, eday, id, dayOfWeek, isHoliday);
                patroDtoList.add(patroDto);
            }
        }
        return patroDtoList;
    }

    @Override
    public List<EventDto> getListOfEvents(int currentDate, int currentMonth, int currentYear) {
        List<EventDto> eventDtos = new ArrayList<>();
        databaseHelperClass = new DatabaseHelperClass(context);
        Calendar c = Calendar.getInstance();
        Log.d("Patro Entiry", "" + c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH)
        );

        for (int i = 0; i < 10; i++) {

            c.add(Calendar.DATE, i);

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH) + 1;
            int day = c.get(Calendar.DATE);
            try {
                PatroEntity _patroEntity = getNepaliDate(year, month + 1, day);
                String days = _patroEntity.getYear() + "/" + _patroEntity.getMonth() + "/" + _patroEntity.getDay();
                EventDto eventDto = databaseHelperClass.loadWeek(days);
                if (eventDto != null) {
                    Log.d("TEST", "RUNNING");
                    eventDtos.add(eventDto);
                }
            } catch (Exception e) {
                Log.d("ERROR", "e");

            }
//            int TEST = _patroEntity.getMonth() + 1;

            c = Calendar.getInstance();
        }
        return eventDtos;
    }

    @SuppressLint("StaticFieldLeak")
    public class addDateToDatabse extends AsyncTask<String, Void, String> {
        private Context context;

        addDateToDatabse(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {
            for (int i = CONST.INITIAL_YEAR; i <= CONST.FINISH_YEAR; i++) {
                for (int j = CONST.INITIAL_MONTH; j <= CONST.FINISH_MONTH; j++) {
                    for (int k = CONST.INITIAL_DAY; k <= CONST.FINISH_DAY; k++) {
                        if (isEngDateInConversionRange(i, j, k)) {
                            try {
                                patroEntity = getNepaliDate(i, j, k);
                                int act_month = patroEntity.getMonth() + 1;
                                ContentValues contentValues = new ContentValues();
                                //nepali Day
                                contentValues.put("nyear", patroEntity.getYear());
                                contentValues.put("nmonth", act_month);
                                contentValues.put("nday", patroEntity.getDay());
//                                if (i == 2019 && j == 9 && k == 18) {
//                                    Log.d("E YEAR:", "" + i);
//                                    Log.d("E MONTH", "" + j);
//                                    Log.d("E DAY:", "" + i);
//                                    Log.d("N YEAR:", "" + patroEntity.getYear());
//                                    Log.d("N MONTH:", "" + act_month);
//                                    Log.d("N DAY:", "" + patroEntity.getDay());
//                                }
                                //English Month
                                contentValues.put("eyear", i);
                                contentValues.put("emonth", j);
                                contentValues.put("eday", k);
                                //id
                                String id = patroEntity.getYear() + "/" + act_month + "/" + patroEntity.getDay();
                                contentValues.put("id", id);
                                //day of the week(1=sun,2=mon..)
                                contentValues.put("dayOfWeek", patroEntity.getDayOfWeek());
                                databaseHelperClass.insertDate(contentValues);
                            } catch (IllegalArgumentException e) {
                                Log.e("Custom Error:", "IllegalArgumentException:-" + e.getMessage());
                            }
                        }

                    }
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("onPostExecuted", "" + result);
            SharedPreferences sharedPref = context.getSharedPreferences(
                    CALENDAR_DATE_DATA, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("dateSaved", true);
            editor.apply();
            // Toast.makeText(getActivity(), "Loading FriendListDataDto... Complete!!!", Toast.LENGTH_SHORT).show();
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
            //  Toast.makeText(getActivity(), "Loading FriendListDataDto...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class addEventToDatabase extends AsyncTask<String, Void, String> {
        private Context context;

        addEventToDatabase(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {
            Gson gson = new Gson();
            PatroEvent patroEvent;
            InputStream is = context.getResources().openRawResource(R.raw.patro_event);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                }
                int n;
                assert reader != null;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String jsonString = writer.toString();
            patroEvent = gson.fromJson(jsonString, PatroEvent.class);

            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < patroEvent.getEventDto().size(); i++) {
                contentValues.put("event_id", patroEvent.getEventDto().get(i).getEventId());
                contentValues.put("event_detail_np", patroEvent.getEventDto().get(i).getEventDetailNp());
                contentValues.put("event_detail_en", patroEvent.getEventDto().get(i).getEventDetailEn());
                contentValues.put("tithe", patroEvent.getEventDto().get(i).getTithe());
                contentValues.put("holiday", patroEvent.getEventDto().get(i).getHoliday());
                try {
                    databaseHelperClass.insertIvents(contentValues);
                } catch (Exception ignored) {

                }

            }
            return "executed";
        }

        @Override
        protected void onPostExecute(String s) {
            SharedPreferences sharedPref = context.getSharedPreferences(
                    CALENDAR_DATE_DATA, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("eventSaved", true);
            editor.apply();
        }
    }

}
