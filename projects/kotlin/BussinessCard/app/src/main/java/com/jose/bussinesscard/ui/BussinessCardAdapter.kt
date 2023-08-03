package com.jose.bussinesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jose.bussinesscard.data.BussinessCard
import com.jose.bussinesscard.databinding.ItemBussinessCardBinding

class BussinessCardAdapter:
    ListAdapter<BussinessCard, BussinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listernerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBussinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBussinessCardBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BussinessCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersinalizado))
            binding.mcvContent.setOnClickListener { listernerShare(it) }
        }
    }

}

class DiffCallback: DiffUtil.ItemCallback<BussinessCard>() {
    override fun areItemsTheSame(oldItem: BussinessCard, newItem: BussinessCard): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: BussinessCard, newItem: BussinessCard): Boolean =
        oldItem.id == newItem.id
}