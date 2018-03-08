package com.mykeep.r3j3ct3d.mykeep;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mykeep.r3j3ct3d.mykeep.NoteCreation.SimpleNoteCreation;

public class SolventViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView    title;
    TextView    content;
    ImageView   image;

    SolventViewHolders(View itemView) {

        super(itemView);
        itemView.setOnClickListener(this);

        title = itemView.findViewById(R.id.note_title);
        content = itemView.findViewById(R.id.note_content);
        image = itemView.findViewById(R.id.note_image);
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();

        Intent simpleNoteIntent = new Intent(view.getContext(), SimpleNoteCreation.class);
        ((Activity) view.getContext()).startActivityForResult(simpleNoteIntent, 1);
    }
}
