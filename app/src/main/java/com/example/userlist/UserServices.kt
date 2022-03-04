package com.my.userlist

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//https://dummyapi.io/data/v1/user?limit=10

const val BASE_URL="https://dummyapi.io/data/v1/"
interface UserListInterface {
    @Headers("app-id:621f39de82636f256783d6f5")
    @GET("user?")
    // fun getHeadlines( @Query("page")page:Int): Call<List<Details>>
    fun getUserData(@Query("limit")limit:Int): Call<UserData>
}
object UserService{
    val userListInterface: UserListInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        userListInterface=retrofit.create(UserListInterface::class.java)
    }
}
