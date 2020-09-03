package com.semantic.notesapp.Fragmetn;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.semantic.notesapp.DaoClasses.NoteDao;
import com.semantic.notesapp.R;
import com.semantic.notesapp.ViewModel.NoteDataVM;

public class FirstFragment extends Fragment {

    private NoteDataVM noteDataVM;
    private TextInputEditText textview_first;
    private AppCompatButton btn_done;
    private NoteDao noteDao = new NoteDao();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        noteDataVM = new ViewModelProvider(requireActivity()).get(NoteDataVM.class);

        textview_first = view.findViewById(R.id.textview_first);

        textview_first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                noteDao.setNote(charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        view.findViewById(R.id.btn_done).setOnClickListener(v1 -> {
            noteDataVM.insertData(noteDao);
            view.findViewById(R.id.button_first).performClick();
        });

        view.findViewById(R.id.button_first).setOnClickListener(view1 ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment));


    }
}