package com.example.tamogatchi.dressingroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tamogatchi.R;
import com.example.tamogatchi.databinding.ClosetFragmentBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ClosetFragment extends Fragment {

    //a list to store all the products
    List<ClothingItem> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private ClosetFragmentBinding binding;

    public static ClosetFragment newInstance(int index) {
        ClosetFragment fragment = new ClosetFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

        productList = new ArrayList<>();
        // adding some goals to our list
        productList.add(new ClothingItem(1, "Jeans", "Classic blue denim", R.drawable.jeans));

        productList.add(
                new ClothingItem(1, "Shorts", "For nice weather", R.drawable.shorts));

        productList.add(
                new ClothingItem(1, "Sweatpants", "Casual, comfy, and cozy",  R.drawable.sweats));

        productList.add(
                new ClothingItem(1, "Button down shirt", "A little dressy",  R.drawable.buttondown));
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = ClosetFragmentBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.mygoals_fragment, container, false);
        View root = binding.getRoot();
        recyclerView = (RecyclerView) root.findViewById(R.id.closetrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //creating recyclerview adapter
        recyclerView.setAdapter(new ClosetAdapter(getContext(), productList));

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
