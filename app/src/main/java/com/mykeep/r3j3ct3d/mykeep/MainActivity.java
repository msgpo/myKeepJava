package com.mykeep.r3j3ct3d.mykeep;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mykeep.r3j3ct3d.mykeep.NoteCreation.SimpleNoteCreation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemObjects> staggeredList;
    SolventRecyclerViewAdapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check and get storage permissions
        if (Build.VERSION.SDK_INT >= 23) {
            if (!checkPermissionForReadExternalStorage())
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            if (!checkPermissionForWriteExternalStorage())
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // Check orientation to put the good amount of columns
        int column = 2;
        if (getResources().getConfiguration().orientation == 2)
            column = 3;

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(column, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        // Prevent the loss of items
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);

        // Load data
        staggeredList = getListItemData();

        rcAdapter = new SolventRecyclerViewAdapter(staggeredList);
        recyclerView.setAdapter(rcAdapter);

        // Drag and drop
        ItemTouchHelper ith = new ItemTouchHelper(_ithCallback);
        ith.attachToRecyclerView(recyclerView);

        // Create a simple note button click listener
        Button createSimpleNoteButton = findViewById(R.id.create_new_note);
        createSimpleNoteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent simpleNoteIntent = new Intent(getApplicationContext(), SimpleNoteCreation.class);
                startActivityForResult(simpleNoteIntent, 1);
            }
        });
    }

    // Drag and drop
    ItemTouchHelper.Callback _ithCallback = new ItemTouchHelper.Callback() {
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

            Collections.swap(staggeredList, viewHolder.getAdapterPosition(), target.getAdapterPosition());
            rcAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            //TODO
        }

        // Defines the enabled move directions in each state (idle, swiping, dragging).
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
        }
    };

    // Get the data from the note creation
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String noteJSON = data.getStringExtra("noteJSON");

            Log.d("JSON in Act 1", noteJSON);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    // Temporary solution to add notes
    private List<ItemObjects> getListItemData(){

        List<ItemObjects> listViewItems = new ArrayList<>();

        listViewItems.add(new ItemObjects("", "Lol mdr ptdr xptdr lmao test"));
        listViewItems.add(new ItemObjects("Lorem", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nullapariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        listViewItems.add(new ItemObjects("Alkane","Hello Markdown", R.drawable.one));
        listViewItems.add(new ItemObjects("Ethane", "Hello Markdown"));
        listViewItems.add(new ItemObjects("Alkyne", "Hello Markdown", R.drawable.three));
        listViewItems.add(new ItemObjects("Benzene", "Hello Markdown", R.drawable.four));
        listViewItems.add(new ItemObjects("Amide", "Hello Markdown", R.drawable.one));
        listViewItems.add(new ItemObjects("Amino Acid", "Hello Markdown", R.drawable.two));
        listViewItems.add(new ItemObjects("Phenol", "Hello Markdown"));
        listViewItems.add(new ItemObjects("Carbonxylic", "Hello Markdown", R.drawable.four));
        listViewItems.add(new ItemObjects("Nitril", "Hello Markdown", R.drawable.one));
        listViewItems.add(new ItemObjects("Ether", "Hello Markdown", R.drawable.two));
        listViewItems.add(new ItemObjects("Ester", "Hello Markdown", R.drawable.three));
        listViewItems.add(new ItemObjects("Alcohol", "Hello Markdown"));
        listViewItems.add(new ItemObjects("Title only", ""));
        listViewItems.add(new ItemObjects("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", ""));
        listViewItems.add(new ItemObjects("", "Content only"));
        listViewItems.add(new ItemObjects("", "Kkk"));
        listViewItems.add(new ItemObjects("", "Kkkkkk"));
        listViewItems.add(new ItemObjects("", "Kkkkkkkkkk"));
        listViewItems.add(new ItemObjects("", "Kkkkkkkkkkkkk"));
        listViewItems.add(new ItemObjects("", "Kkkkkkkkkkkkkkkkkkk"));
        listViewItems.add(new ItemObjects("", "Kkkkkkkkkkkkkkkkkkkkkkkk"));

        return listViewItems;
    }

    // Check for read in external storage
    public boolean checkPermissionForReadExternalStorage() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int result = getApplicationContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    // Check for write in external storage
    public boolean checkPermissionForWriteExternalStorage() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int result = getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }
}
