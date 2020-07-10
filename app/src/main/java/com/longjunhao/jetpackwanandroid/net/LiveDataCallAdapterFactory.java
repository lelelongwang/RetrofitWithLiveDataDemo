package com.longjunhao.jetpackwanandroid.net;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * .LiveDataCallAdapterFactory
 *
 * @author Admitor
 * @date 2020/07/06
 */
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    
    private static final String TAG = LiveDataCallAdapterFactory.class.getSimpleName();
    
    @SuppressWarnings("ClassGetClass")
    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class) {
            return null;
        }
        //获取第一个泛型类型
        Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class<?> rawType = getRawType(observableType);
        Log.d(TAG, "rawType = " + rawType.getClass().getSimpleName());
        boolean isApiResponse = true;
        if (rawType != ApiResponse.class) {
            //不是返回ApiResponse类型的返回值
            isApiResponse = false;
        }
        if (!(observableType instanceof ParameterizedType)) {
            throw new IllegalArgumentException("resource must be parameterized");
        }
        return new LiveDataCallAdapter<>(observableType, isApiResponse);
    }
}
