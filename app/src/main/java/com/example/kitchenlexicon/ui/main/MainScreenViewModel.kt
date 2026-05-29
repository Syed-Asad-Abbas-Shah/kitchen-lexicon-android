package com.example.kitchenlexicon.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchenlexicon.data.DataRepository
import com.example.kitchenlexicon.data.Utensil
import com.example.kitchenlexicon.data.UtensilDb
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

sealed interface MainScreenUiState {
    object Loading : MainScreenUiState
    data class Success(val utensils: List<Utensil>) : MainScreenUiState
    data class Error(val throwable: Throwable) : MainScreenUiState
}

class MainScreenViewModel(private val dataRepository: DataRepository) : ViewModel() {

    val uiState: StateFlow<MainScreenUiState> = flow {
        try {
            dataRepository.utensils.collect {
                emit(MainScreenUiState.Success(it))
            }
        } catch (e: Exception) {
            emit(MainScreenUiState.Error(e))
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MainScreenUiState.Loading)

    // UI tab state
    var activeTab by mutableStateOf("dictionary")
        private set

    fun switchTab(tab: String) {
        activeTab = tab
    }

    // Filters
    var searchQuery by mutableStateOf("")
        private set
    var selectedCategory by mutableStateOf("all")
        private set
    var selectedMaterial by mutableStateOf("all")
        private set

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun updateCategory(category: String) {
        selectedCategory = category
    }

    fun updateMaterial(material: String) {
        selectedMaterial = material
    }

    // Modal Details state
    var selectedDetailUtensil by mutableStateOf<Utensil?>(null)
        private set

    fun showUtensilDetails(utensil: Utensil?) {
        selectedDetailUtensil = utensil
    }

    // Anatomy Lab state
    var activeAnatomyToolId by mutableStateOf("chefs-knife")
        private set
    var hoveredAnatomyPartName by mutableStateOf("Hover over Hotspots")
        private set
    var hoveredAnatomyPartDesc by mutableStateOf("Glow circles point to key design components. Hover or tap them to explore what each structure does natively.")
        private set

    fun switchAnatomyTool(id: String) {
        activeAnatomyToolId = id
        resetAnatomyPart()
    }

    fun highlightAnatomyPart(name: String, desc: String) {
        hoveredAnatomyPartName = name
        hoveredAnatomyPartDesc = desc
    }

    fun resetAnatomyPart() {
        hoveredAnatomyPartName = "Hover over Hotspots"
        hoveredAnatomyPartDesc = "Glow circles point to key design components. Hover or tap them to explore what each structure does natively."
    }

    // Quiz Game States
    data class QuizQuestion(
        val type: String, // "visual" or "textual"
        val correctAnswer: String,
        val utensil: Utensil,
        val options: List<String>
    )

    var quizScore by mutableIntStateOf(0)
    var quizStreak by mutableIntStateOf(0)
    var currentQuizIndex by mutableIntStateOf(0)
    var selectedAnswer by mutableStateOf<String?>(null)
    var isQuizCompleted by mutableStateOf(false)
    val quizQuestions = mutableListOf<QuizQuestion>()

    fun startNewQuiz() {
        quizScore = 0
        quizStreak = 0
        currentQuizIndex = 0
        selectedAnswer = null
        isQuizCompleted = false
        generateQuizQuestions()
    }

    private fun generateQuizQuestions() {
        quizQuestions.clear()
        val list = UtensilDb.utensils
        for (i in 0 until 10) {
            val correctUtensil = list.random()
            val qType = if (Math.random() > 0.5) "visual" else "textual"
            
            val incorrect = list.filter { it.id != correctUtensil.id }
            val optionsSet = mutableSetOf(correctUtensil.name)
            while (optionsSet.size < 4 && incorrect.isNotEmpty()) {
                optionsSet.add(incorrect.random().name)
            }
            
            quizQuestions.add(
                QuizQuestion(
                    type = qType,
                    correctAnswer = correctUtensil.name,
                    utensil = correctUtensil,
                    options = optionsSet.toList().shuffled()
                )
            )
        }
    }

    fun answerQuestion(answer: String) {
        selectedAnswer = answer
        val currentQ = quizQuestions[currentQuizIndex]
        if (answer == currentQ.correctAnswer) {
            quizScore++
            quizStreak++
        } else {
            quizStreak = 0
        }
    }

    fun nextQuestion() {
        selectedAnswer = null
        if (currentQuizIndex < 9) {
            currentQuizIndex++
        } else {
            isQuizCompleted = true
        }
    }
}
