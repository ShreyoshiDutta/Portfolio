package com.example.sonai.portfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sonai.portfolio.models.Monster;

public class Monster_options extends AppCompatActivity {
    private Button m_cCreateBtn;
    private Button m_cViewBtn;
    private Button m_cSearchBtn;

    //Sets up listeners for all 3 buttons on home page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_options);

        // for create button
        m_cCreateBtn = (Button) findViewById(R.id.createBtn);
        m_cCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showCreateView = new Intent(Monster_options.this,MonsterUCActivity.class);
                startActivity(showCreateView);
            }
        });


        // for view button
        m_cViewBtn = (Button) findViewById(R.id.viewBtn);
        // The 0 id is dummy because its auto assigned by SQLLite on insertion.
        m_cViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMonsterView = new Intent(Monster_options.this,MonsterUCActivity.class);
                Monster aMonster = new Monster(0,"Groot",11,"Tree",80,900);
                showMonsterView.putExtra("Monster",aMonster);
                startActivity(showMonsterView);
            }
        });

        // for search Button
        m_cSearchBtn = (Button) findViewById(R.id.searchBtn);
        m_cSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchMonsterView = new Intent(Monster_options.this,SearchMonsters.class);
                startActivity(searchMonsterView);
            }
        });



    }





}
