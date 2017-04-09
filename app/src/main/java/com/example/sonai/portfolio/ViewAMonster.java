package com.example.sonai.portfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sonai.portfolio.models.Monster;

public class ViewAMonster extends AppCompatActivity {

    private TextView name;
    private TextView age;
    private TextView species;
    private TextView attackPower;
    private TextView health;

    private Monster m_cCurrent_Monster;

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





        //name.setText("haha");

    }
}
