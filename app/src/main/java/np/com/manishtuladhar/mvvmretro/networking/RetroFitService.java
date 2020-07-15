package np.com.manishtuladhar.mvvmretro.networking;

import retrofit2.Retrofit;

public class RetroFitService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .build();

    public static <S> S createService(Class<S> serviceClass)
    {
        return retrofit.create(serviceClass);
    }
}
