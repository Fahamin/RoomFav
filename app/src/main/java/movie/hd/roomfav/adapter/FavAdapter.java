package movie.hd.roomfav.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import movie.hd.roomfav.MainActivity;
import movie.hd.roomfav.R;
import movie.hd.roomfav.model.FavModel;

public class FavAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    Context context;
    List<FavModel> list;

    public FavAdapter(Context context, List<FavModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MainAdapter.MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rowview, null, false);
        return new MainAdapter.MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainHolder holder, int position) {

       final FavModel favModel = list.get(position);

        holder.tv.setText(favModel.getName());
        holder.titletv.setText(favModel.getTitle());

        holder.fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.favDatabase.favoriteDao().delete(favModel);
                Toast.makeText(context, "remove", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainHolder extends RecyclerView.ViewHolder {
        ImageView img, fav_btn;
        TextView tv, titletv;

        public MainHolder(@NonNull View itemView) {
            super(itemView);

            titletv = itemView.findViewById(R.id.titleTV);
            tv = (TextView) itemView.findViewById(R.id.tv_name);
            fav_btn = (ImageView) itemView.findViewById(R.id.fav_btn);
        }
    }
}