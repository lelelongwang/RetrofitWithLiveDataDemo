package com.longjunhao.jetpackwanandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.longjunhao.jetpackwanandroid.model.WxArticleBean;
import com.longjunhao.jetpackwanandroid.net.ApiResponse;
import com.longjunhao.jetpackwanandroid.net.ApiService;
import java.util.List;

/**
 * @author Admitor
 * MVVM之Retrofit与LiveData的集成:
 * https://www.jianshu.com/p/34fb6ffaa684
 * https://www.jianshu.com/p/eaf294738dca
 * https://github.com/iamyours/Wandroid
 */
public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveDataRetrofit();
            }
        });
        
    }
    
    private void liveDataRetrofit(){
        LiveData<ApiResponse<List<WxArticleBean>>> wxActicle = ApiService.get().getWxActicle();
        wxActicle.observe(this, new Observer<ApiResponse<List<WxArticleBean>>>() {
            @Override
            public void onChanged(ApiResponse<List<WxArticleBean>> listApiResponse) {
                List<WxArticleBean> data = listApiResponse.data;
                Log.d(TAG, "onChanged: ljh");
            }
        });
    }
}