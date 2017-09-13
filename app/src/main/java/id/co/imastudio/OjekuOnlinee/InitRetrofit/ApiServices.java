package id.co.imastudio.OjekuOnlinee.InitRetrofit;

import id.co.imastudio.OjekuOnlinee.Response.ResponseDaftar;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by root on 9/12/17.
 */

public interface ApiServices {
    @FormUrlEncoded
    @POST("daftar")
    Call<ResponseDaftar> request_daftar (
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone
    );
}
