package com.example.samplegetretrofitwithmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samplegetretrofitwithmvvm.R
import com.example.samplegetretrofitwithmvvm.module.ModuleRetro

class AdapterRetro: RecyclerView.Adapter<AdapterRetro.HolderRetro>()
{
    private var myList = emptyList<ModuleRetro>()

    inner class HolderRetro(view: View): RecyclerView.ViewHolder(view)
    {
        val userIdAdapter: TextView = view.findViewById(R.id.userId_text)
        val idAdapter: TextView = view.findViewById(R.id.id_text)
        val titleAdapter: TextView = view.findViewById(R.id.title_text)
        val bodyAdapter: TextView = view.findViewById(R.id.body_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRetro
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val inflaterView = layoutInflater.inflate(R.layout.item_list, parent, false)

        return HolderRetro(inflaterView)
    }

    override fun onBindViewHolder(holder: HolderRetro, position: Int)
    {
        val data = myList[position]

        //
        holder.userIdAdapter.text = data.userId.toString()
        holder.idAdapter.text = data.id.toString()
        holder.titleAdapter.text = data.title
        holder.bodyAdapter.text = data.body
    }

    override fun getItemCount(): Int
    {
        return myList.size
    }

    fun setData(newList: List<ModuleRetro>){
        myList = newList
        notifyDataSetChanged()
    }
}