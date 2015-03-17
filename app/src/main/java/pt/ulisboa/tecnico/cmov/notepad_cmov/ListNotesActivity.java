package pt.ulisboa.tecnico.cmov.notepad_cmov;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListNotesActivity extends ActionBarActivity {

    static final int NEW_NOTE_REQUEST = 1;
    private ArrayList<String> notesTitlesList;
    private ArrayList<String> notesTextList;
    private ArrayAdapter<String> noteTitlesAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);


        notesTitlesList = new ArrayList<String>();
        notesTextList = new ArrayList<String>();
        noteTitlesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, notesTitlesList);
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.lv_listItems);
        listView.setAdapter(noteTitlesAdapter);
//        notesTextList.add(0, "First text...");
//        notesTitlesList.add(0, "First title...");
//        notesTextList.add(0, "Second text...");
//        notesTitlesList.add(0, "Second title...");
        noteTitlesAdapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String noteTitle = notesTitlesList.get(position);
                String noteText = notesTextList.get(position);
                //Toast.makeText(ListNotesActivity.this, "Title: " + noteTitle + "\nText: " + noteText, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListNotesActivity.this, ShowNoteActivity.class);
                intent.putExtra("NOTE_TITLE", noteTitle);
                intent.putExtra("NOTE_TEXT", noteText);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void newNote(View view) {
        Intent intent = new Intent(this, CreateNoteActivity.class);
        startActivityForResult(intent, NEW_NOTE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("CreateNoteActivity", "ON ACtIViTY RESULT");
        if (resultCode == RESULT_OK) {
            Log.d("CreateNoteActivity", "ENTREI1");
            if (data.hasExtra("noteTitle") && data.hasExtra("noteText")) {
                Log.d("CreateNoteActivity", "ENTREI2");
                String noteTitle = data.getExtras().getString("noteTitle");
                String noteText = data.getExtras().getString("noteText");
                notesTitlesList.add(0, noteTitle);
                notesTextList.add(0, noteText);
                noteTitlesAdapter.notifyDataSetChanged();
            } else
                Toast.makeText(this, "Something went wrong, it should have those two fields",
                        Toast.LENGTH_LONG).show();
        } else if (resultCode == RESULT_CANCELED)
            Toast.makeText(this, "Note creation cancelled",
                    Toast.LENGTH_LONG).show();
    }


}
