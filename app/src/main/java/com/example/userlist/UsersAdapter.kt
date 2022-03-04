package com.example.userlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.my.userlist.UserList

class UsersAdapter(val context: Context, val userLists:List<UserList>): RecyclerView.Adapter<UsersAdapter.userViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return userViewHolder(view)
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val user=userLists[position]
        holder.userId.text="ID: "+user.id
        holder.userName.text=user.title+"."+user.firstName+" "+user.lastName
        Glide.with(context).load(user.picture).into(holder.userImage)

    }

    override fun getItemCount(): Int {
        return userLists.size
    }

    class userViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var userImage=itemView.findViewById<ImageView>(R.id.image)
        var userId=itemView.findViewById<TextView>(R.id.txtId)
        var userName=itemView.findViewById<TextView>(R.id.txtName)

    }

}