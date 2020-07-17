package np.com.manishtuladhar.mvvmretro.networking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import np.com.manishtuladhar.mvvmretro.model.NewsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository newsRepository;

    public static NewsRepository getInstance()
    {
        if(newsRepository == null)
        {
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private NewsApi newsApi;

    public NewsRepository()
    {
       newsApi = RetroFitService.createService(NewsApi.class);
    }

    /**
     * Helps to get our news response as mutable live data so that we can set or post values to our ui
     * @param source : news source
     * @param apiKey :
     * @return : gets mutable data
     */
    public MutableLiveData<NewsResponse> getNews(String source, String apiKey)
    {
        //initialize
        final MutableLiveData<NewsResponse> newsData = new MutableLiveData<>();

        //api call get news list
        newsApi.getNewsList(source,apiKey).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful())
                {
                    //setting our response directly as it get automatically
                    Log.e("NEWS REPO",response.body().getNewsItems().toString());
                    newsData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
