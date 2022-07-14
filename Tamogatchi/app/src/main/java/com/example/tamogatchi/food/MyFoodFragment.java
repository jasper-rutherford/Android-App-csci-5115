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
import com.example.tamogatchi.food.MyFoodAdapter;
import com.example.tamogatchi.food.MyFoodItem;
import com.example.tamogatchi.food.PageViewModel;
//import com.example.tamogatchi.food.PageViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MyFoodFragment extends Fragment {

    //a list to store all the products
    static List<MyFoodItem> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private AddfoodFragmentBinding binding;
    public static MyFoodAdapter adapter;
    public static MyFoodFragment newInstance(int index) {
        MyFoodFragment fragment = new MyFoodFragment();
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
        // adding some food to our list
        productList.add(new MyFoodItem(1, "Apple", "Increases health by +25%", 25, R.drawable.apple));

        productList.add(
                new MyFoodItem(2, "Watermelon", "Increases health by +20%", 20, R.drawable.watermelon));

        productList.add(
                new MyFoodItem(3, "Pizza", "Increases health by +15%", 15,  R.drawable.pizza));

        productList.add(new MyFoodItem(1, "Cheeseburger", "Increases health by +10", 10, R.drawable.cheeseburger));
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = AddfoodFragmentBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.myfood_fragment, container, false);
        View root = binding.getRoot();
        recyclerView = (RecyclerView) root.findViewById(R.id.addfoodrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //creating recyclerview adapter
        adapter =new MyFoodAdapter(getContext(), productList);
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
    public void FoodUpdate(){
        this.productList = productList;
    }
}
