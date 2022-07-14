package com.example.tamogatchi.food;

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
import com.example.tamogatchi.databinding.AddfoodFragmentBinding;
import com.example.tamogatchi.food.AddFoodAdapter;
import com.example.tamogatchi.food.AddFoodItem;
import com.example.tamogatchi.food.FoodPageViewModel;
import com.example.tamogatchi.friends.main.PageViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class AddFoodFragment extends Fragment {

    //a list to store all the products
    static List<AddFoodItem> productList;
    public static AddFoodAdapter adapter;

    //the recyclerview
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private AddfoodFragmentBinding binding;

    public static AddFoodFragment newInstance(int index) {
        AddFoodFragment fragment = new AddFoodFragment();
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
        // adding some Food to our list
        productList.add(new AddFoodItem(1, "Apple", "Increases health by +25%", 54, 600, R.drawable.apple));

        productList.add(
                new AddFoodItem(1, "Watermelon", "Increases health by +20%", 76, 600, R.drawable.watermelon));


        productList.add(new AddFoodItem(1, "Pizza", "Increases health by +15%", 54, 600, R.drawable.pizza));

        productList.add(new AddFoodItem(1, "Cheeseburger", "Increases health by +10%", 54, 600, R.drawable.cheeseburger));
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = AddfoodFragmentBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.myFood_fragment, container, false);
        View root = binding.getRoot();
        recyclerView = (RecyclerView) root.findViewById(R.id.addfoodrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //creating recyclerview adapter
        adapter =  new AddFoodAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);

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
    private List<Food> newList() {
        //initializing the productlist
        productList = new ArrayList<>();
        // adding some Food to our list
        productList.add(
                new Food(
                        1,
                        "John",
                        "screentime up 3%",
                        54,
                        600,
                        R.drawable.caleb));

        productList.add(
                new Food(
                        1,
                        "Dennis",
                        "screentime down 26%",
                        76,
                        600,
                        R.drawable.dennis));

        productList.add(
                new Food(
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
