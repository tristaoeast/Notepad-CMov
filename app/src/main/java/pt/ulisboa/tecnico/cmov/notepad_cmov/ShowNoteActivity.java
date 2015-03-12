package pt.ulisboa.tecnico.cmov.notepad_cmov;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

/**
 * Created by TMC on 12/03/2015.
 */
public class ShowNoteActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String noteTitle = intent.getExtras().getString("NOTE_TITLE");
        String noteText = intent.getExtras().getString("NOTE_TEXT");
        Toast.makeText(this, "Title: " + noteTitle + "\nText: " + noteText, Toast.LENGTH_LONG).show();

    }
}
