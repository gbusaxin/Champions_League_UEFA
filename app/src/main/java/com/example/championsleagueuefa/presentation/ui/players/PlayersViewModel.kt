package com.example.championsleagueuefa.presentation.ui.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.repository.StatisticRepositoryImpl
import com.example.championsleagueuefa.domain.use_cases.GetStatisticUseCase
import com.example.championsleagueuefa.domain.use_cases.LoadStatisticUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    repository:StatisticRepositoryImpl
) : ViewModel() {
    private val getStatisticUseCase = GetStatisticUseCase(repository)
    private val loadStatisticUseCase = LoadStatisticUseCase(repository)

    val getStatistic = getStatisticUseCase()

    init {
        viewModelScope.launch {
            loadStatisticUseCase()
        }
    }
}