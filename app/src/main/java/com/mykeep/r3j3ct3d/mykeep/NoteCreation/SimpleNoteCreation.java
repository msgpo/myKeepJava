package com.mykeep.r3j3ct3d.mykeep.NoteCreation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.mykeep.r3j3ct3d.mykeep.R;

import eu.amirs.JSON;

public class SimpleNoteCreation extends AppCompatActivity {

    EditText    titleEditText;
    EditText    contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_note_creation);

        titleEditText = findViewById(R.id.title_edit_text);
        contentEditText = findViewById(R.id.content_edit_text);

        // Open keyboard and put focus on the content edit text
        contentEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.showSoftInput(contentEditText, InputMethodManager.SHOW_IMPLICIT);
    }

    // Save note content on back pressed
    @Override
    public void onBackPressed() {

        String titleText = titleEditText.getText().toString();
        String contentText = contentEditText.getText().toString();

        // Check if fields are not empty
        if (!TextUtils.isEmpty(titleText) || !TextUtils.isEmpty(contentText)) {

            String noteJSON;
            // Convert note to JSON
            noteJSON = noteToJSON();

            Log.d("JSON in Act 2", noteJSON);

            Toast.makeText(getApplicationContext(), "Not empty.", Toast.LENGTH_SHORT).show();

            // Return note JSON to MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("noteJSON", noteJSON);
            setResult(Activity.RESULT_OK, resultIntent);
        }
        Toast.makeText(getApplicationContext(), "Empty.", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    // Convert the note content to JSON
    public String noteToJSON() {

        JSON generatedJsonObject = JSON.create(
                JSON.dic(
                        "title", titleEditText.getText().toString(),
                        "content", contentEditText.getText().toString()
                )
        );

        return generatedJsonObject.toString();
    }
}
