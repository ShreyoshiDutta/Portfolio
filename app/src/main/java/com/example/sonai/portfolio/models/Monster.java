package com.example.sonai.portfolio.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sonai on 13/03/2017.
 */

public class Monster implements Parcelable {

    public static final String TABLE_NAME = "people";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_SPECIES = "species";
    public static final String COLUMN_ATTACK_POWER = "attack_power";
    public static final String COLUMN_HEALTH = "health";


    // Table create statement
    public static final String CREATE_STATEMENT = "CREATE TABLE "
            + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_AGE + " NUMBER NOT NULL, " +
            COLUMN_SPECIES + " TEXT NOT NULL, " +
            COLUMN_ATTACK_POWER + " NUMBER NOT NULL, " +
            COLUMN_HEALTH + " NUMBER NOT NULL" +
            ")";


    private long _id;

    private String m_sName;
    private int m_iAge;
    private String m_sSpecies;
    private int m_iAttackPower;
    private float m_fHealth;

    public Monster() {
        this(0,"Dummy",1,"Hamba",1,10);
    }


    public Monster(long id, String m_sName, int m_iAge, String m_sSpecies, int m_iAttackPower, float m_fHealth) {
        this._id = id;
        this.m_sName = m_sName;
        this.m_iAge = m_iAge;
        this.m_sSpecies = m_sSpecies;
        this.m_iAttackPower = m_iAttackPower;
        this.m_fHealth = m_fHealth;
    }

    public String summary(){
        return this.toString();
    }

    public String toString(){
        //return String.format("name: %s, age: %d, species: %s, ap: %d, health: %f",m_sName,m_iAge,m_sSpecies,m_iAttackPower,m_fHealth);
        return String.format("name: %s, species: %s",m_sName,m_sSpecies);
    }

    public String getM_sName() {
        return m_sName;
    }

    public void setM_sName(String m_sName) {
        this.m_sName = m_sName;
    }

    public int getM_iAge() {
        return m_iAge;
    }

    public void setM_iAge(int m_iAge) {
        this.m_iAge = m_iAge;
    }

    public String getM_sSpecies() {
        return m_sSpecies;
    }

    public void setM_sSpecies(String m_sSpecies) {
        this.m_sSpecies = m_sSpecies;
    }

    public int getM_iAttackPower() {
        return m_iAttackPower;
    }

    public void setM_iAttackPower(int m_iAttackPower) {
        this.m_iAttackPower = m_iAttackPower;
    }

    public float getM_fHealth() {
        return m_fHealth;
    }

    public void setM_fHealth(float m_fHealth) {
        this.m_fHealth = m_fHealth;
    }

    public long get_id() { return _id; }
    public void set_id(long _id) { this._id = _id; }


    protected Monster(Parcel in) {
        _id = in.readLong();
        m_sName = in.readString();
        m_iAge = in.readInt();
        m_sSpecies = in.readString();
        m_iAttackPower = in.readInt();
        m_fHealth = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(_id);
        dest.writeString(m_sName);
        dest.writeInt(m_iAge);
        dest.writeString(m_sSpecies);
        dest.writeInt(m_iAttackPower);
        dest.writeFloat(m_fHealth);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Monster> CREATOR = new Parcelable.Creator<Monster>() {
        @Override
        public Monster createFromParcel(Parcel in) {
            return new Monster(in);
        }

        @Override
        public Monster[] newArray(int size) {
            return new Monster[size];
        }
    };
}