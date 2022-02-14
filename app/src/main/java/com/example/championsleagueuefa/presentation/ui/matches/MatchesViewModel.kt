package com.example.championsleagueuefa.presentation.ui.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.championsleagueuefa.data.repository.MatchRepositoryImpl
import com.example.championsleagueuefa.domain.use_cases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
    private val deleteAllFixturesUseCase = DeleteAllFixturesUseCase(repository)

    val getResult = getResultUseCase()
    val getFixtures = getFixturesUseCase()

    private fun deleteAllFixtures() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllFixturesUseCase()
        }
    }

    init {
        viewModelScope.launch {
            deleteAllFixtures()
            loadResultUseCase()
            loadFixturesUseCase()
        }
    }

}