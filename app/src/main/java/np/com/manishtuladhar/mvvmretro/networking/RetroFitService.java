package np.com.manishtuladhar.mvvmretro.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //service generator : helps us to use our api interface by getting that class in return
    public static <S> S createService(Class<S> serviceClass)
    {
        return retrofit.create(serviceClass);
    }
}
