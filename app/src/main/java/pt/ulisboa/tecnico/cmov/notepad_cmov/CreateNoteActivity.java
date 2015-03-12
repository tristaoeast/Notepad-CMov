package pt.ulisboa.tecnico.cmov.notepad_cmov;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by TMC on 12/03/2015.
 */
public class CreateNoteActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
    }

    public void createNote(View view) {
        Intent data = new Intent();
        final EditText ed_noteTitle = (EditText) findViewById(R.id.et_noteTitle);
        final EditText ed_noteText = (EditText) findViewById(R.id.et_noteText);
        String noteTitle = ed_noteTitle.getText().toString();
        String noteText = ed_noteText.getText().toString();
        data.putExtra("noteTitle", noteTitle);
        data.putExtra("noteText", noteText);
        Log.d("CreateNoteActivity", "BEFORE RESULT_OK");
        // Activity finished ok, return the data
        setResult(RESULT_OK, data);
        Log.d("CreateNoteActivity", "AFTER RESULT_OK");
        finish();
        Log.d("CreateNoteActivity", "AFTER FINISH");
    }

    public void cancelNote(View view) {
        Intent data = new Intent();
        setResult(RESULT_CANCELED, data);
        finish();
    }
}
