package com.example.a1hw4monthlifetracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a1hw4monthlifetracker.databinding.ItemBoardBinding

class BoardAdapter(private val list : ArrayList<BoardModel>, private val listener : ItemOnClickListener):
    RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BoardViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(boardModel: BoardModel) {

            binding.imageView.setAnimation(boardModel.animation)
            binding.description.text = boardModel.description
            binding.nextBtn.text = boardModel.button
            binding.nextBtn.setOnClickListener{
                if (adapterPosition == list.size-1){
                    listener.itemClick()
                }else if(adapterPosition == list.size-3){
                    listener.btnClick1page()
                }else if(adapterPosition == list.size-2){
                    listener.btnClick2page()
                }
            }
        }

    }
}