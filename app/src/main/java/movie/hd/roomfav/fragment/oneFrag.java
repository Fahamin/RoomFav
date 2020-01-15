package movie.hd.roomfav.fragment;

import android.content.Context;
import android.net.Uri;
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

import movie.hd.roomfav.R;
import movie.hd.roomfav.adapter.MainAdapter;
import movie.hd.roomfav.model.DataModel;


public class oneFrag extends Fragment {

    List<DataModel> list;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recviewONE);
        list = new ArrayList<>();

        list.add(new DataModel(1,"one","helo"));
        list.add(new DataModel(2,"jj","tfd"));
        list.add(new DataModel(3,"ff","edc"));
        list.add(new DataModel(4,"ee","bv"));
        list.add(new DataModel(5,"bb","qw"));
        list.add(new DataModel(6,"ww","bnm"));

        MainAdapter adapter = new MainAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }
}
