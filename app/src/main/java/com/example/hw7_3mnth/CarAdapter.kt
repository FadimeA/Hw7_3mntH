package com.example.hw7_3mnth

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw7_3mnth.databinding.ItemCarBinding

class CarAdapter(private val cars: List<Car>) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.binding.textViewBrand.text = car.name
        holder.binding.textViewNumber.text = car.phoneNumber

        Glide.with(holder.itemView.context).load(car.imageUrl).into(holder.binding.imageView)

        holder.binding.buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${car.phoneNumber}")
            }
            holder.itemView.context.startActivity(intent)
        }


        holder.binding.buttonWhatsApp.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=${car.phoneNumber}"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}