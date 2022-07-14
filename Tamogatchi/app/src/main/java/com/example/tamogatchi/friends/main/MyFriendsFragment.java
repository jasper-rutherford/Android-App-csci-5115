package com.example.tamogatchi.friends.main;

import com.example.tamogatchi.R;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.tamogatchi.databinding.MyfriendsFragmentBinding;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MyFriendsFragment extends Fragment {

    //a list to store all the products
    static List<MyFriendsItem> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private MyfriendsFragmentBinding binding;
    public static MyFriendsAdapter adapter;
    public static MyFriendsFragment newInstance(int index) {
        MyFriendsFragment fragment = new MyFriendsFragment();
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
        productList.add(new MyFriendsItem(1, "John", "screentime up 3%", 54, R.drawable.avatar2));

        productList.add(
                new MyFriendsItem(2, "Dennis", "screentime down 26%", 76, R.drawable.avatar2));

        productList.add(
                new MyFriendsItem(3, "Chelsea", "screentime up 10%", 25,  R.drawable.avatar1));
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = MyfriendsFragmentBinding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.myfriends_fragment, container, false);
        View root = binding.getRoot();
        recyclerView = (RecyclerView) root.findViewById(R.id.addfriendsrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //creating recyclerview adapter
        adapter =new MyFriendsAdapter(getContext(), productList);
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
    public void FriendsUpdate(){
        this.productList = productList;
    }
}
