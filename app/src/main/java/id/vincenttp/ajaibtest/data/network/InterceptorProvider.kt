package id.vincenttp.ajaibtest.data.network

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorProvider() : Interceptor {
    companion object {
        const val EXPIRED_TOKEN = "EXPIRED_TOKEN"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header("Accept", "application/vnd.github+json")
            //.header("Authorization", "token ")
            .build()
        val response: Response = chain.proceed(request)
        if (response.code !in 200..299) {
            if (response.code == 401) {
                Throwable(EXPIRED_TOKEN)
            }
        }
        return response
    }
}