package com.example.tamogatchi.friends.main;

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
import com.example.tamogatchi.databinding.AddfriendsFragmentBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class AddFriendsFragment extends Fragment {

    //a list to store all the products
    static List<AddFriendsItem> productList;
    public static AddFriendsAdapter adapter;

    //the recyclerview
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private AddfriendsFragmentBinding binding;

    public static AddFriendsFragment newInstance(int index) {
        AddFriendsFragment fragment = new AddFriendsFragment();
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
        // adding some friends to our list
        productList.add(new AddFriendsItem(1, "Mickey", "Chelsea is friends with", 54, 600, R.drawable.avatar3));

        productList.add(
                new AddFriendsItem(1, "Nicky", "John & Dennis are friends with", 76, 600, R.drawable.avatar3));

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = AddfriendsFragmentBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.myfriends_fragment, container, false);
        View root = binding.getRoot();
        recyclerView = (RecyclerView) root.findViewById(R.id.addfriendsrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //creating recyclerview adapter
        adapter =  new AddFriendsAdapter(getContext(), productList);
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
    private List<Friends> newList() {
        //initializing the productlist
        productList = new ArrayList<>();
        // adding some friends to our list
        productList.add(
                new Friends(
                        1,
                        "John",
                        "screentime up 3%",
                        54,
                        600,
                        R.drawable.caleb));

        productList.add(
                new Friends(
                        1,
                        "Dennis",
                        "screentime down 26%",
                        76,
                        600,
                        R.drawable.dennis));

        productList.add(
                new Friends(
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
