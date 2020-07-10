package com.longjunhao.jetpackwanandroid.net;

import androidx.lifecycle.LiveData;
import com.longjunhao.jetpackwanandroid.model.WxArticleBean;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * .WanApi
 *
 * @author Admitor
 * @date 2020/07/03
 */
public interface ApiService {
    
    static ApiService get() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS);
        return new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(builder.build())
            .addCallAdapterFactory(new LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    }
    
    public final static String BASE_URL = "https://wanandroid.com";
    
    
    @GET("wxarticle/chapters/json")
    LiveData<ApiResponse<List<WxArticleBean>>> getWxActicle();
    
}
