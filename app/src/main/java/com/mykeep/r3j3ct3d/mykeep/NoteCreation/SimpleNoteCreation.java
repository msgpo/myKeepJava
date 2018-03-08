package com.mykeep.r3j3ct3d.mykeep.NoteCreation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.mykeep.r3j3ct3d.mykeep.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleNoteCreation extends AppCompatActivity {
    
    String                  noteColor;

    EditText                titleEditText;
    EditText                contentEditText;
    TextView                lastUpdateDateTextView;
    RadioGroup              colorPickerRadioGroup;

    LinearLayout            noteLayout;
    HorizontalScrollView    colorScrollView;
    TableLayout             bottomToolbar;

    String                  lastUpdateDateString;
    String                  creationDateString;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_note_creation);

        titleEditText = findViewById(R.id.title_edit_text);
        contentEditText = findViewById(R.id.content_edit_text);
        colorPickerRadioGroup = findViewById(R.id.color_picker_radio_group);
        noteLayout = findViewById(R.id.simple_note_creation_linear_layout);
        colorScrollView = findViewById(R.id.color_scroll_view);
        bottomToolbar = findViewById(R.id.bottom_toolbar);
        lastUpdateDateTextView = findViewById(R.id.last_modification_date);

        noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteDefault));
        colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteDefault));
        bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteDefault));
        noteColor = getResources().getString(R.color.colorNoteDefault);

        creationDateString = new SimpleDateFormat("ddMMyyyyhhmmss", Locale.getDefault()).format(new Date());
        lastUpdateDateString = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

        lastUpdateDateTextView.setText("Last update : " + lastUpdateDateString);

        // Open keyboard and put focus on the content edit text
        contentEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.showSoftInput(contentEditText, InputMethodManager.SHOW_IMPLICIT);

        // Check the color picker
        colorPickerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.default_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteDefault));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteDefault));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteDefault));
                    noteColor = getResources().getString(R.color.colorNoteDefault);

                }
                else if (checkedId == R.id.red_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteRed));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteRed));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteRed));
                    noteColor = getResources().getString(R.color.colorNoteRed);
                }
                else if (checkedId == R.id.orange_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteOrange));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteOrange));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteOrange));
                    noteColor = getResources().getString(R.color.colorNoteOrange);
                }
                else if (checkedId == R.id.yellow_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteYellow));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteYellow));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteYellow));
                    noteColor = getResources().getString(R.color.colorNoteYellow);
                }
                else if (checkedId == R.id.green_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteGreen));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteGreen));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteGreen));
                    noteColor = getResources().getString(R.color.colorNoteGreen);
                }
                else if (checkedId == R.id.cyan_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteCyan));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteCyan));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteCyan));
                    noteColor = getResources().getString(R.color.colorNoteCyan);
                }
                else if (checkedId == R.id.light_blue_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteLightBlue));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteLightBlue));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteLightBlue));
                    noteColor = getResources().getString(R.color.colorNoteLightBlue);
                }
                else if (checkedId == R.id.dark_blue_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteDarkBlue));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteDarkBlue));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteDarkBlue));
                    noteColor = getResources().getString(R.color.colorNoteDarkBlue);
                }
                else if (checkedId == R.id.purple_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNotePurple));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNotePurple));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNotePurple));
                    noteColor = getResources().getString(R.color.colorNotePurple);
                }
                else if (checkedId == R.id.pink_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNotePink));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNotePink));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNotePink));
                    noteColor = getResources().getString(R.color.colorNotePink);
                }
                else if (checkedId == R.id.brown_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteBrow));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteBrow));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteBrow));
                    noteColor = getResources().getString(R.color.colorNoteBrow);
                }
                else if (checkedId == R.id.grey_color_checkbox) {

                    noteLayout.setBackgroundColor(getResources().getColor(R.color.colorNoteGrey));
                    colorScrollView.setBackgroundColor(getResources().getColor(R.color.colorNoteGrey));
                    bottomToolbar.setBackgroundColor(getResources().getColor(R.color.colorNoteGrey));
                    noteColor = getResources().getString(R.color.colorNoteGrey);
                }
            }
        });
    }

    // Save note content on back pressed
    @Override
    public void onBackPressed() {

        String titleText = titleEditText.getText().toString();
        String contentText = contentEditText.getText().toString();

        // Check if fields are not empty
        if (!TextUtils.isEmpty(titleText) || !TextUtils.isEmpty(contentText)) {


            JSONObject noteJSON = new JSONObject();
            try {
                noteJSON.put("noteTitle", titleEditText.getText().toString());
                noteJSON.put("noteContent", contentEditText.getText().toString());
                noteJSON.put("noteColor", noteColor);
                noteJSON.put("noteCreationDate", creationDateString);
                noteJSON.put("noteLastUpdateDate", lastUpdateDateString);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Return note JSON to MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("noteJSON", noteJSON.toString());
            setResult(Activity.RESULT_OK, resultIntent);
        }
        this.finish();
    }
}
