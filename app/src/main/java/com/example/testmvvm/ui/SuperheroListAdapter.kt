package com.example.testmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testmvvm.R
import com.example.testmvvm.databinding.ItemSuperheroBinding
import com.example.testmvvm.models.Superheroe
import com.example.testmvvm.models.SuperheroesResponse


class SuperheroListAdapter : RecyclerView.Adapter<SuperheroListAdapter.ViewHolder>() {
    private lateinit var postList:SuperheroesResponse

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemSuperheroBinding  = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_superhero, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList.superheroes[position])
    }

    override fun getItemCount(): Int {
        return if(::postList.isInitialized) postList.superheroes.size else 0
    }

    fun updateSuperHeroList(superheroList:SuperheroesResponse){
        this.postList = superheroList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemSuperheroBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = SuperheroViewModel()
        fun bind(superheroList:Superheroe){
            viewModel.bind(superheroList)
            binding.viewModel = viewModel
        }
    }
}