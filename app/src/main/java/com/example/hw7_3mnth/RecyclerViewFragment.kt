package com.example.hw7_3mnth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw7_3mnth.databinding.FragmentRecyclerViewBinding
import com.google.android.material.carousel.CarouselLayoutManager


    class RecyclerViewFragment : Fragment() {
        private lateinit var binding: FragmentRecyclerViewBinding
        private lateinit var adapter: CarAdapter
        private var carList = arrayListOf<Car>()

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            initAdapter()
            loadData()

            binding.buttonToNewFragment.setOnClickListener {
                val action = RecyclerViewFragmentDirections.actionRecyclerViewFragmentToNewFragment()
                findNavController().navigate(action)
            }

        }

        private fun loadData() {
            val cars = listOf(
                Car("Linkoln", "https://autokadabra.ru/system/uploads/photos/Shout/112/112862/big/0_DSC07948_-_Copy.JPG", "0500990"),
                Car("Porsche", "https://lh6.googleusercontent.com/proxy/20NCLP-7-PzeGjcGlhYmk8Y8VqFOWV4C62C_7dxNiq5bsEzloQZPR_48oKFK6X3zaB77BzVCj5t3vcky0HJTJL-BFB3MfkDOCzBqyEjAJS-vNmsU3bt4626-Dt1az3U", "8080000"),
                Car("Chevrolet", "https://img.freepik.com/premium-photo/classic-car-pink-color-with-giant-fins-this-vintage-car-ai-generated-image_377307-1857.jpg", "0999007")

            )
            carList.addAll(cars)
            adapter.notifyDataSetChanged()
        }

        private fun initAdapter() {
            adapter = CarAdapter(carList)
            binding.recyclerView.layoutManager = CarouselLayoutManager()
            binding.recyclerView.adapter = adapter
        }
    }
