package com.example.tamogatchi.goals.main;

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
import com.example.tamogatchi.databinding.AddgoalsFragmentBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class AddGoalsFragment extends Fragment {

    //a list to store all the products
    List<AddGoalsItem> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private AddgoalsFragmentBinding binding;

    public static AddGoalsFragment newInstance(int index) {
        AddGoalsFragment fragment = new AddGoalsFragment();
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
        productList.add(new AddGoalsItem(1, "Mickey", "Chelsea is goals with", 54, 600, R.drawable.caleb));

        productList.add(
                new AddGoalsItem(1, "Nicky", "John & Dennis are goals with", 76, 600, R.drawable.dennis));

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = AddgoalsFragmentBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.mygoals_fragment, container, false);
        View root = binding.getRoot();

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
/*
    private List<Goals> newList() {
        //initializing the productlist
        productList = new ArrayList<>();
        // adding some goals to our list
        productList.add(
                new Goals(
                        1,
                        "John",
                        "screentime up 3%",
                        54,
                        600,
                        R.drawable.caleb));

        productList.add(
                new Goals(
                        1,
                        "Dennis",
                        "screentime down 26%",
                        76,
                        600,
                        R.drawable.dennis));

        productList.add(
                new Goals(
                        1,
                        "Chelsea",
                        "screentime up 10%",
                        25,
                        600,
                        R.drawable.chelsea));
        return productList;
    }
*/
}
