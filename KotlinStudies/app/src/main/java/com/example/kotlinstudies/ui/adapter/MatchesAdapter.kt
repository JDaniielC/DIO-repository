package com.example.kotlinstudies.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinstudies.databinding.MatchItemBinding
import com.example.kotlinstudies.domain.Match

class MatchesAdapter(matchesList: List<Match>): RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    private var matches: List<Match>
    // Isso é tipo um constructor
    init {
        this.matches = matchesList
    }

    public fun getMatch(position: Int): Match {
        return matches.get(position);
    }

    class ViewHolder(binding: MatchItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: MatchItemBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MatchItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Glide pede um context
        val context: Context = holder.itemView.context
        val match: Match = matches.get(position)

        // Adapter toma os dados da partida para o layout
        holder.binding.tvHomeTeamName.text = match.homeTeam.name
        Glide.with(context).load(match.homeTeam.image).into(holder.binding.ivHomeTeam)
        // Glide pode modificar a imagem colocando match.homeTeam.image.circleCrop
        if (match.homeTeam.score != null)
            holder.binding.tvHomeTeamScore.text = match.homeTeam.score.toString()

        holder.binding.tvAwayTeamName.text = match.awayTeam.name
        Glide.with(context).load(match.awayTeam.image).into(holder.binding.ivAwayTeam)
        if (match.awayTeam.score != null)
            holder.binding.tvAwayTeamScore.text = match.awayTeam.score.toString()
    }

    override fun getItemCount(): Int {
        return matches.size
    }
}