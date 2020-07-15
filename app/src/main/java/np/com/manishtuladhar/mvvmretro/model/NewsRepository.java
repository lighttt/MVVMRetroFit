package np.com.manishtuladhar.mvvmretro.model;

import np.com.manishtuladhar.mvvmretro.networking.NewsApi;

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
       // newsApi =
    }
}
