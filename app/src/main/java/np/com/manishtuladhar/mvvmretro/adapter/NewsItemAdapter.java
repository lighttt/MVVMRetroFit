package np.com.manishtuladhar.mvvmretro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import np.com.manishtuladhar.mvvmretro.R;
import np.com.manishtuladhar.mvvmretro.model.NewsItem;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.NewsViewHolder> {

    Context mContext;
    ArrayList<NewsItem> newsItemArrayList;

    public NewsItemAdapter(Context context, ArrayList<NewsItem> arrayList)
    {
        this.mContext = context;
        this.newsItemArrayList = arrayList;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.news_item,parent,false);
       return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.tvName.setText(newsItemArrayList.get(position).getTitle());
        holder.tvDescription.setText(newsItemArrayList.get(position).getDescription());
        Picasso.get().load(newsItemArrayList.get(position).getUrlToImage()).into(holder.ivNews);
    }

    @Override
    public int getItemCount() {
        return newsItemArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;
        ImageView ivNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivNews = itemView.findViewById(R.id.ivNews);
        }
    }
}
