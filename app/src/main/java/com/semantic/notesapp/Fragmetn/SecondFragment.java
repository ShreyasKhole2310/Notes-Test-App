package com.semantic.notesapp.Fragmetn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.semantic.notesapp.Adapter.GridItemDecoration;
import com.semantic.notesapp.Adapter.RecyclerAdapter;
import com.semantic.notesapp.R;
import com.semantic.notesapp.ViewModel.NoteDataVM;

public class SecondFragment extends Fragment {

    private RecyclerAdapter rv_Adapter;
    private Context mContext;
    private RecyclerView rv_notes_view;
    private NoteDataVM note_data_vm;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_Adapter = new RecyclerAdapter(mContext);

        rv_notes_view = view.findViewById(R.id.rv_notes_view);
        rv_notes_view.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));

        rv_notes_view.setAdapter(rv_Adapter);
//        rv_notes_view.addItemDecoration(new GridItemDecoration(10,3));

        view.findViewById(R.id.button_second).setOnClickListener(view1 ->
                NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));

        note_data_vm = new ViewModelProvider(requireActivity()).get(NoteDataVM.class);

        note_data_vm.getData().observe(getViewLifecycleOwner(), lstData -> {
            rv_Adapter.setLstNotes(lstData);
            rv_notes_view.setAdapter(rv_Adapter);
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }
}