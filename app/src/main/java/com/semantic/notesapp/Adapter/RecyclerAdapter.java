package com.semantic.notesapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.semantic.notesapp.DaoClasses.NoteDao;
import com.semantic.notesapp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<NoteDao> lstNotes;
    private Context context;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public List<NoteDao> getLstNotes() {
        return lstNotes;
    }

    public void setLstNotes(List<NoteDao> lstNotes) {
        this.lstNotes = lstNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.note_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_note.setText(lstNotes.get(position).getNote());
        holder.ll_notes.setOnClickListener(view -> Toast.makeText(context, "" + lstNotes.get(position).getNote(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return lstNotes == null ? 0 : lstNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView txt_note;
        public LinearLayout ll_notes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_note = itemView.findViewById(R.id.txt_note);
            ll_notes = itemView.findViewById(R.id.ll_notes);
        }
    }
}
