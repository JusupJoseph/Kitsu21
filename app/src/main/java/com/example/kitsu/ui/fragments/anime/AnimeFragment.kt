package com.example.kitsu.ui.fragments.anime

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.databinding.FragmentAnimeBinding
import com.example.kitsu.databinding.FragmentMangaBinding
import com.example.kitsu.ui.adapters.anime.AnimeAdapter
import com.example.kitsu.ui.adapters.manga.MangaAdapter
import com.example.kitsu.ui.fragments.manga.MangaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<MangaViewModel, FragmentAnimeBinding>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.rvAnime.adapter = mangaAdapter
    }

    override fun setupSubscribe() {
        viewModel.fetchManga().observe(viewLifecycleOwner){
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

}