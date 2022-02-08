package com.example.championsleagueuefa.presentation.ui.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.repository.MatchRepositoryImpl
import com.example.championsleagueuefa.domain.use_cases.GetFixturesUseCase
import com.example.championsleagueuefa.domain.use_cases.GetResultUseCase
import com.example.championsleagueuefa.domain.use_cases.LoadFixturesUseCase
import com.example.championsleagueuefa.domain.use_cases.LoadResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    repository: MatchRepositoryImpl
) : ViewModel() {

    private val getResultUseCase = GetResultUseCase(repository)
    private val getFixturesUseCase = GetFixturesUseCase(repository)
    private val loadResultUseCase = LoadResultUseCase(repository)
    private val loadFixturesUseCase = LoadFixturesUseCase(repository)

    val getResult = getResultUseCase()
    val getFixtures = getFixturesUseCase()

    init {
        viewModelScope.launch {
            loadResultUseCase()
            loadFixturesUseCase()
        }
    }
}