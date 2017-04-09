package com.example.sonai.portfolio;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sonai.portfolio.models.DatabaseHelper;
import com.example.sonai.portfolio.models.Monster;

public class SearchMonsters extends AppCompatActivity implements
        AdapterView.OnItemLongClickListener , AdapterView.OnItemClickListener{

    // Unique Identifier for recieving activity result
    public static final int ADD_PERSON_REQUEST = 1;

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter adapter;

    private DatabaseHelper m_cDBHelper;


    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
    private ArrayList<Monster> m_cMonsterList;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_PERSON_REQUEST) {
            if(resultCode == RESULT_OK) {
                // Get the person object from the intent and add it to our list
                Monster newMonster = data.getParcelableExtra("result");
                m_cMonsterList.add(newMonster);
                adapter.notifyDataSetChanged();
                UpdateListCount();
            }
        }
    }

    private void UpdateListCount() {
        setTitle("All Monsters: " + m_cMonsterList.size());
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_monsters);



        // Listview Data
        /*String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
*/
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        m_cMonsterList = new ArrayList<>();
        //initializeDefaultList();

        // Create Adapter and associate it with our MonsterList
        //adapter = new MonsterAdapter(this, m_cMonsterList);
        //lv.setAdapter(adapter);


        // Get our database handler
        m_cDBHelper = new DatabaseHelper(getApplicationContext());
        // If there are no people in the db then add some defaults
        if(m_cDBHelper.getAllMonsters().size() == 0)
            m_cDBHelper.createDefaultMonsters();
        // Initialize the Monster List with the values from our database
        m_cMonsterList = new ArrayList<>(m_cDBHelper.getAllMonsters().values());

        //adapter = new ArrayAdapter<Monster>(this, R.layout.list_item, R.id.name, m_cMonsterList);
        adapter = new MonsterAdapter(this, R.layout.list_item, R.id.name, m_cMonsterList);

        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(this);
        lv.setOnItemClickListener(this);



        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                SearchMonsters.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });


    }


    // Function to initialize default values for the Monster list (Change this later)
    private void initializeDefaultList() {
        m_cMonsterList.add(new Monster(0,"Groot",11,"Tree",80,900));
        m_cMonsterList.add(new Monster(1,"Grump",11,"Neverbeast",50,900));
        m_cMonsterList.add(new Monster(2,"Kumbhakarna",11,"Human",70,900));
    }

    private void refreshListView() {
        adapter.notifyDataSetChanged();
        UpdateListCount();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(view.getContext());
        builder.setTitle("Remove Person?");
        builder.setMessage("Are you sure you wish to remove this person?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Remove person from list and database
                Monster m = m_cMonsterList.remove(position);
                m_cDBHelper.removeMonster(m);
                // Update ListView
                refreshListView();
                Toast.makeText(getBaseContext(), "Person has been deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.create().show();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent showMonsterView = new Intent(this,ViewAMonster.class);
        //Monster aMonster = new Monster(0,"Groot",11,"Tree",80,900);
        showMonsterView.putExtra("Monster",m_cMonsterList.get(position));
        startActivity(showMonsterView);
    }
}