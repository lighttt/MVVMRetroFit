package np.com.manishtuladhar.mvvmretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import np.com.manishtuladhar.mvvmretro.adapter.NewsItemAdapter;
import np.com.manishtuladhar.mvvmretro.model.NewsItem;
import np.com.manishtuladhar.mvvmretro.model.NewsResponse;

public class MainActivity extends AppCompatActivity {

    ArrayList<NewsItem> newsItemArrayList = new ArrayList<>();
    NewsItemAdapter newsItemAdapter;
    RecyclerView recyclerView;
    NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retrieving
        retrieveNews();
        setupRv();
    }

    private void setupRv()
    {
        if(newsItemAdapter == null)
        {
            //setup rv
            recyclerView = findViewById(R.id.rvNews);
            newsItemAdapter = new NewsItemAdapter(MainActivity.this,newsItemArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(newsItemAdapter);
        }
        else{
            newsItemAdapter.notifyDataSetChanged();
        }
    }


    private void retrieveNews()
    {
        //view model
        newsViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NewsViewModel.class);
        newsViewModel.init();
        newsViewModel.getNewsRepository().observe(this, new Observer<NewsResponse>() {
            @Override
            public void onChanged(NewsResponse newsResponse) {
                List<NewsItem> newsItems = newsResponse.getNewsItems();
                newsItemArrayList.addAll(newsItems);
                newsItemAdapter.notifyDataSetChanged();
            }
        });
    }
}