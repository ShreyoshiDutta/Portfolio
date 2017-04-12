package com.example.sonai.portfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sonai.portfolio.models.Monster;

/**
 * Created by Sonai on 8/4/17.
 * This class serves as the controller for acitivty_view_amonster which is a display only screen.
 * However, in the final version of the app I have not used this display screen.
 * Rather I am displaying the monster in the update-create screen itself.
 */

public class ViewAMonster extends AppCompatActivity {

    private TextView name;
    private TextView age;
    private TextView species;
    private TextView attackPower;
    private TextView health;

    private Monster m_cCurrent_Monster;

    /*
    Simply gets the monster passed in from the caller of this intent.
    Displays each attribute of that monster.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_amonster);

        Intent monster = getIntent();
        m_cCurrent_Monster = (Monster) monster.getParcelableExtra("Monster");

        name = (TextView) findViewById(R.id.textView);
        name.setText(m_cCurrent_Monster.getM_sName());

        age = (TextView) findViewById(R.id.textView2);
        age.setText(String.valueOf(m_cCurrent_Monster.getM_iAge()));

        species = (TextView) findViewById(R.id.textView3);
        species.setText(m_cCurrent_Monster.getM_sSpecies());

        attackPower = (TextView) findViewById(R.id.textView4);
        attackPower.setText(String.valueOf(m_cCurrent_Monster.getM_iAttackPower()));

        health = (TextView) findViewById(R.id.textView5);
        health.setText(String.valueOf(m_cCurrent_Monster.getM_fHealth()));



    }
}
