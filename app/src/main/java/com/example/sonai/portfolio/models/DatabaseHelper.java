package com.example.sonai.portfolio.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Sonai on 8/4/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Set Database Properties
    public static final String DATABASE_NAME = "MonsterDB";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Monster.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Monster.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addMonster(Monster monster) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Monster.COLUMN_NAME, monster.getM_sName());
        values.put(Monster.COLUMN_AGE, monster.getM_iAge());
        values.put(Monster.COLUMN_SPECIES, monster.getM_sSpecies());
        values.put(Monster.COLUMN_ATTACK_POWER, monster.getM_iAttackPower());
        values.put(Monster.COLUMN_HEALTH, monster.getM_fHealth());

        db.insert(Monster.TABLE_NAME, null, values);
        db.close();
    }

    public HashMap<Long, Monster> getAllMonsters() {
        HashMap<Long, Monster> people = new LinkedHashMap<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Monster.TABLE_NAME, null);
        // Add each Monster to hashmap (Each row has 1 Monster)
        if (cursor.moveToFirst()) {
            do {
                Monster Monster = new Monster(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getInt(4), cursor.getFloat(5));
                people.put(Monster.get_id(), Monster);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return people;
    }

    public void removeMonster(Monster monster) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Monster.TABLE_NAME, Monster.COLUMN_ID + "= ?", new String[]{String.valueOf(monster.get_id())});
    }

    public void updateMonster(Monster monster){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Monster.COLUMN_NAME,monster.getM_sName());
        cv.put(Monster.COLUMN_AGE,monster.getM_iAge());
        cv.put(Monster.COLUMN_SPECIES,monster.getM_sSpecies());
        cv.put(Monster.COLUMN_ATTACK_POWER,monster.getM_iAttackPower());
        cv.put(Monster.COLUMN_HEALTH,monster.getM_fHealth());


        db.update(Monster.TABLE_NAME,cv, Monster.COLUMN_ID + "= ?", new String[]{String.valueOf(monster.get_id())});

    }

    public void createDefaultMonsters(){
        addMonster(new Monster(0,"Groot",11,"Tree",80,900));
        addMonster(new Monster(1,"Grump",11,"Neverbeast",50,900));
        addMonster(new Monster(2,"Kumbhakarna",11,"Human",70,900));
        addMonster(new Monster(2,"Bombhodoitto",11,"Human",70,900));

    }

}
