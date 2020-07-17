package np.com.manishtuladhar.mvvmretro.networking;

import np.com.manishtuladhar.mvvmretro.model.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("everything")
    Call<NewsResponse> getNewsList(@Query("q") String searchBy, @Query("apiKey")String apiKey);

}
