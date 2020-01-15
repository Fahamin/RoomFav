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
import movie.hd.roomfav.model.DataModel;
import movie.hd.roomfav.model.FavModel;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    Context context;
    List<DataModel> list;

    public MainAdapter(Context context, List<DataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rowview, null, false);
        return new MainHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MainHolder holder, int position) {

        final DataModel dataModel = list.get(position);
        holder.tv.setText(dataModel.getName());
        holder.titletv.setText(dataModel.getTitle());

        if (MainActivity.favDatabase.favoriteDao().isFavorite(dataModel.getId()) == 1) {
            holder.fav_btn.setImageResource(R.drawable.greedn);
        } else {
            holder.fav_btn.setImageResource(R.drawable.ic_favorite_border_black_24dp);

        }


        holder.fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavModel favModel = new FavModel();

                int id = dataModel.getId();
                String name = dataModel.getName();
                String title = dataModel.getTitle();

                favModel.setId(id);
                favModel.setTitle(title);
                favModel.setName(name);

                if (MainActivity.favDatabase.favoriteDao().isFavorite(id) != 1) {
                    holder.fav_btn.setImageResource(R.drawable.greedn);
                    MainActivity.favDatabase.favoriteDao().addData(favModel);
                    Toast.makeText(context, "added", Toast.LENGTH_SHORT).show();
                } else {
                    holder.fav_btn.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    MainActivity.favDatabase.favoriteDao().delete(favModel);
                    Toast.makeText(context, "remove", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
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
