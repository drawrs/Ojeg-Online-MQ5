package id.co.imastudio.OjekuOnlinee.InitRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 9/12/17.
 */

public class InitLibrary {
    public static Retrofit setInit(){
        // api.khilman.net/ojeg_server/api/
        return new Retrofit.Builder()
                .baseUrl("http://192.168.61.1/ojeg_server/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiServices getInstance(){
        return setInit().create(ApiServices.class);
    }

}
