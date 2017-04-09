package com.example.sonai.portfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sonai.portfolio.models.Monster;

public class Monster_options extends AppCompatActivity implements View.OnClickListener {
    private Button m_ccreateBtn;
    private Button m_cViewBtn;
    private Button m_cSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_options);

        m_ccreateBtn = (Button) findViewById(R.id.createBtn);
        m_ccreateBtn.setOnClickListener(this);
        m_cViewBtn = (Button) findViewById(R.id.viewBtn);
        m_cViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMonsterView = new Intent(Monster_options.this,ViewAMonster.class);
                Monster aMonster = new Monster(0,"Groot",11,"Tree",80,900);
                showMonsterView.putExtra("Monster",aMonster);
                startActivity(showMonsterView);
            }
        });

        m_cSearchBtn = (Button) findViewById(R.id.searchBtn);
        m_cSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchMonsterView = new Intent(Monster_options.this,SearchMonsters.class);
                startActivity(searchMonsterView);
            }
        });



    }

    @Override
    public void onClick(View v) {
        Intent showCreateView = new Intent(this,MonsterUCActivity.class);
        startActivity(showCreateView);
    }



}
