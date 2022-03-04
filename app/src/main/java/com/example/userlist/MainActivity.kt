package com.example.userlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.userlist.UserData
import com.my.userlist.UserList
import com.my.userlist.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: UsersAdapter
    lateinit var userList: List<UserList>
    lateinit var recyclerview:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview=findViewById(R.id.recyclerview)
        getNews()
    }

    private fun getNews(){

        val list = UserService.userListInterface.getUserData(10)

        list.enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                val list=response.body()
                if (list!=null) {
                    Log.d("tag", list.toString())
                    adapter= UsersAdapter(this@MainActivity,list.data)
                    recyclerview.adapter=adapter
                    val layoutManager=LinearLayoutManager(this@MainActivity)
                    recyclerview.layoutManager = layoutManager
                }
            }
            override fun onFailure(call: Call<UserData>, t: Throwable) {
                Log.d("tag", "error",t )
            }
        })
    }
}
