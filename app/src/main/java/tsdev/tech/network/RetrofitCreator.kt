package tsdev.tech.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun <T> createRetrofit(cls: Class<T>, baseUrl: String): T {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory( GsonConverterFactory.create() )
            //body에 있는 로그를 출력 하도록 만들어 준것
        .client( createOkHttpClient() )
        .build()
        .create(cls)
}

/**
 * TODO Http 로그가 궁금하면 다음을 확인
 * OkHttp에 HttpLoggingInterceptor을 추가하여 Log를 출력
 *
        **/

private fun createOkHttpClient(): OkHttpClient {
    val builder: OkHttpClient.Builder = OkHttpClient.Builder()

    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    builder.addInterceptor(interceptor)
    return builder.build()
}