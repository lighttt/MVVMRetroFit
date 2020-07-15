package np.com.manishtuladhar.mvvmretro.networking;

import np.com.manishtuladhar.mvvmretro.model.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsResponse> getNewsList(@Query("sources") String newSource, @Query("apiKey")String apiKey);

}
