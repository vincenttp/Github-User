package id.vincenttp.ajaibtest.data.network

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import id.vincenttp.ajaibtest.data.response.RepositoriesResponse

class ArrayListMoshiAdapter {
    @ToJson
    fun arrayListToJson(list: ArrayList<RepositoriesResponse>): List<RepositoriesResponse> = list

    @FromJson
    fun arrayListFromJson(list: List<RepositoriesResponse>): ArrayList<RepositoriesResponse> = ArrayList(list)
}