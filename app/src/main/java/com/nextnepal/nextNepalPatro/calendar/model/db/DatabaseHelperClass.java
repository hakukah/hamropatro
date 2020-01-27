package com.nextnepal.nextNepalPatro.calendar.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;

public class DatabaseHelperClass extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper.Sqlite";
    private static String dbNAME = "HamroPatro";
    private static String patroDateTable = "NepPatro";
    private static String patroEventTable = "NepPatroEvent";
    private static int VERSION = 1;

    public DatabaseHelperClass(Context context) {
        super(context, dbNAME, null, VERSION);
    }

    public Cursor loadMonth(int year, int month) {
        return getReadableDatabase().rawQuery("Select d.nyear , d.nmonth , d.nday , d.eyear , d.emonth , d.eday , d.dayOfWeek ,  d.id , e.holiday"
                + " from " + patroDateTable + " d "
                + "LEFT OUTER JOIN " + patroEventTable + " e "
                + " ON d.id = e.event_id "
                + " Where nyear = " + year + " and nmonth = " + month, null);
    }

    public EventDto loadPatroEvent(String id) {
        EventDto eventDto = null;
        String sql = "SELECT * FROM " + patroEventTable + " WHERE event_id =" + " '" + id + "' ";
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            String event_id = c.getString(c.getColumnIndex("event_id"));
            String event_detail_np = c.getString(c.getColumnIndex("event_detail_np"));
            String event_detail_en = c.getString(c.getColumnIndex("event_detail_en"));
            String tithe = c.getString(c.getColumnIndex("tithe"));
            int holiday = c.getInt(c.getColumnIndex("holiday"));
            eventDto = new EventDto(event_id, event_detail_np, event_detail_en, tithe, holiday);
        }
        if (c.getCount() != 0) {
            c.close();
            return eventDto;
        } else return null;
    }

    public EventDto loadWeek(String patroEntity) {
        EventDto eventDto = null;
        String sql = "SELECT * FROM " + patroEventTable + " WHERE event_id =" + " '" + patroEntity + "' ";
        Cursor c = getReadableDatabase().rawQuery(sql, null);
        while (c.moveToNext()) {
            String event_id = c.getString(c.getColumnIndex("event_id"));
            String event_detail_np = c.getString(c.getColumnIndex("event_detail_np"));
            String event_detail_en = c.getString(c.getColumnIndex("event_detail_en"));
            String tithe = c.getString(c.getColumnIndex("tithe"));
            int holiday = c.getInt(c.getColumnIndex("holiday"));
            eventDto = new EventDto(event_id, event_detail_np, event_detail_en, tithe, holiday);
        }

        if (c.getCount() != 0) {
            c.close();
            return eventDto;
        } else {
            c.close();
            return null;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTablePatro = "CREATE TABLE IF NOT EXISTS `NepPatro` (\n" +
                "\t`nyear`\tINTEGER,\n" +
                "\t`nmonth`\tINTEGER,\n" +
                "\t`nday`\tINTEGER,\n" +
                "\t`eyear`\tINTEGER,\n" +
                "\t`emonth`\tINTEGER,\n" +
                "\t`eday`\tINTEGER,\n" +
                "\t`dayOfWeek`\tINTEGER,\n" +
                "\t`id`\tTEXT,\n" +
                "\tPRIMARY KEY(`id`)\n" +
                ")";
        db.execSQL(createTablePatro);
        String createTableEvent = "CREATE TABLE IF NOT EXISTS `NepPatroEvent` (\n" +
                "\t`event_detail_np`\tTEXT,\n" +
                "\t`event_detail_en`\tTEXT,\n" +
                "\t`tithe`\tTEXT,\n" +
                "\t`holiday`\tINTEGER,\n" +
                "\t`event_id`\tTEXT,\n" +
                "\tPRIMARY KEY(`event_id`)\n" +
                ")";
        db.execSQL(createTableEvent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + patroDateTable);
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + patroEventTable);
        onCreate(db);
    }

    public void insertDate(ContentValues cv) {
        getWritableDatabase().insert(patroDateTable, "", cv);
    }


    public void insertIvents(ContentValues contentValues) {
        getWritableDatabase().insert(patroEventTable, "", contentValues);
    }


}
