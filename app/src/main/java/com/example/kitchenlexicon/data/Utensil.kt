package com.example.kitchenlexicon.data

data class AnatomyPart(
    val name: String,
    val description: String,
    val x: Float, // Relative X coordinate (0f to 100f)
    val y: Float  // Relative Y coordinate (0f to 100f)
)

data class Utensil(
    val id: String,
    val name: String,
    val phonetic: String,
    val category: String,
    val materials: List<String>,
    val altNames: List<String>,
    val useCase: String,
    val funFact: String,
    val anatomy: List<AnatomyPart> = emptyList()
)
