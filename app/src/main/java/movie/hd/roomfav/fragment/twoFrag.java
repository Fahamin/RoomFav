package movie.hd.roomfav.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import movie.hd.roomfav.MainActivity;
import movie.hd.roomfav.R;
import movie.hd.roomfav.adapter.FavAdapter;
import movie.hd.roomfav.database.FavDatabase;

import movie.hd.roomfav.model.FavModel;


public class twoFrag extends Fragment {

    List<FavModel> list;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recviewTwo);
        list = new ArrayList<>();

        list =  MainActivity.favDatabase.favoriteDao().getFavoriteData();
        FavAdapter adapter = new FavAdapter(getContext(), list);    //    MainAdapter adapter = new MainAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }
}
