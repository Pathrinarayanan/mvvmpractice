package com.example.mvvmpractice;

// recylerFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerFragment extends Fragment {

    public widgetViewModel viewModel;
    RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        viewModel = new ViewModelProvider(this).get(widgetViewModel.class);

        observeViewModel();

        viewModel.fetchWidgets(); // Trigger data fetching

        return view;
    }

    private void observeViewModel() {
        viewModel.getWidgetItems().observe(getViewLifecycleOwner(), widgetItems -> {
            if (widgetItems != null) {
                adapter = new MyAdapter(widgetItems);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
