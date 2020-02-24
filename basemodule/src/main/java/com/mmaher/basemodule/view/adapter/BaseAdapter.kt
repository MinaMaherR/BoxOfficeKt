package com.mmaher.basemodule.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmaher.basemodule.viewModel.BaseViewModel

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */



class BaseAdapter<Item> (var items: List<Item>, var layoutId: Int, var binder: Binder<Item>): RecyclerView.Adapter<BaseAdapter.BaseViewHolder<Item>>() {

    abstract class Binder<Item> {
        abstract fun bind(item: Item, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layoutId, parent, false)
        return BaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        holder.bind(items[position], binder)
    }

    class BaseViewHolder<Item>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, binder: Binder<Item>) {
            binder.bind(item, itemView)
        }
    }
}