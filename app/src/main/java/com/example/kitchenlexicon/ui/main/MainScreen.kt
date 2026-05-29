package com.example.kitchenlexicon.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kitchenlexicon.data.DefaultDataRepository
import com.example.kitchenlexicon.data.Utensil
import com.example.kitchenlexicon.data.UtensilDb

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    speakUtensil: (String) -> Unit,
    playTone: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel { MainScreenViewModel(DefaultDataRepository()) }
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val activeTab = viewModel.activeTab
    
    // Core dark palette evoking Slate Charcoal and Copper Gold
    val copperGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFB923C), Color(0xFFC2410C))
    )
    val cardBackground = Color(0xFF1E293B)
    val accentColor = Color(0xFFF97316)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // App Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(999.dp))
                    .background(Color(0xFF292524))
                    .border(1.dp, accentColor.copy(alpha = 0.3f), RoundedCornerShape(999.dp))
                    .padding(horizontal = 14.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "KITCHEN VOCABULARY MASTERCLASS",
                    fontSize = 10.sp,
                    color = accentColor,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Culinary Lexicon",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "Master native terms for kitchen tools offline",
                fontSize = 12.sp,
                color = Color(0xFF94A3B8),
                textAlign = TextAlign.Center
            )
        }

        // Tab Navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF020617))
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val tabs = listOf(
                "dictionary" to "Visual Glossary",
                "anatomy" to "Anatomy Lab",
                "quiz" to "Interactive Quiz"
            )
            tabs.forEach { (tabId, label) ->
                val isActive = activeTab == tabId
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isActive) accentColor else Color.Transparent)
                        .clickable { viewModel.switchTab(tabId) }
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isActive) Color.White else Color(0xFF94A3B8)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tab Content
        Box(modifier = Modifier.weight(1f)) {
            when (state) {
                MainScreenUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = accentColor)
                    }
                }
                is MainScreenUiState.Success -> {
                    val list = (state as MainScreenUiState.Success).utensils
                    when (activeTab) {
                        "dictionary" -> GlossaryTab(
                            utensils = list,
                            viewModel = viewModel,
                            speakUtensil = speakUtensil,
                            cardBackground = cardBackground,
                            accentColor = accentColor
                        )
                        "anatomy" -> AnatomyTab(
                            utensils = list,
                            viewModel = viewModel,
                            cardBackground = cardBackground,
                            accentColor = accentColor
                        )
                        "quiz" -> QuizTab(
                            viewModel = viewModel,
                            playTone = playTone,
                            cardBackground = cardBackground,
                            accentColor = accentColor
                        )
                    }
                }
                is MainScreenUiState.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Error loading data: ${(state as MainScreenUiState.Error).throwable.message}",
                            color = Color.Red
                        )
                    }
                }
            }
        }
    }

    // UTENSIL DETAILS SHEET
    viewModel.selectedDetailUtensil?.let { utensil ->
        AlertDialog(
            onDismissRequest = { viewModel.showUtensilDetails(null) },
            confirmButton = {
                Button(
                    onClick = { viewModel.showUtensilDetails(null) },
                    colors = ButtonDefaults.buttonColors(containerColor = accentColor)
                ) {
                    Text("Close", color = Color.White)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { speakUtensil(utensil.name) },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = accentColor),
                    border = ButtonDefaults.outlinedButtonBorder.copy(brush = Brush.linearGradient(listOf(accentColor, accentColor)))
                ) {
                    Text("🔊 Listen")
                }
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF020617))
                            .padding(4.dp)
                    ) {
                        UtensilVectorIcon(
                            id = utensil.id,
                            category = utensil.category,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(utensil.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(utensil.phonetic, color = accentColor, fontSize = 12.sp, fontFamily = FontFamily.Monospace)
                    }
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Meta Details
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF020617))
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("CATEGORY", fontSize = 8.sp, color = Color(0xFF64748B), fontWeight = FontWeight.Bold)
                                Text(
                                    text = when (utensil.category) {
                                        "cutting" -> "Cutting/Prepping"
                                        "stirring" -> "Cooking/Stirring"
                                        "baking" -> "Baking/Pastry"
                                        "measuring" -> "Measuring"
                                        "straining" -> "Straining"
                                        "opening" -> "Opening/Grabbing"
                                        else -> "Cookware"
                                    },
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF020617))
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("MATERIALS", fontSize = 8.sp, color = Color(0xFF64748B), fontWeight = FontWeight.Bold)
                                Text(utensil.materials.joinToString(", "), fontSize = 11.sp, color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            }
                        }
                    }

                    // Alt Names
                    if (utensil.altNames.isNotEmpty()) {
                        Column {
                            Text("Alternative Names", color = accentColor, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            Text(utensil.altNames.joinToString(", "), color = Color.White, fontSize = 13.sp)
                        }
                    }

                    // Description
                    Column {
                        Text("Culinary Application", color = accentColor, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text(utensil.useCase, color = Color(0xFFE2E8F0), fontSize = 13.sp, lineHeight = 18.sp)
                    }

                    // Fun Fact
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(accentColor.copy(alpha = 0.08f))
                            .border(1.dp, accentColor.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                            .padding(12.dp)
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("💡", fontSize = 16.sp)
                            Text(
                                text = utensil.funFact,
                                color = Color.White,
                                fontSize = 12.sp,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            },
            containerColor = Color(0xFF1E293B),
            shape = RoundedCornerShape(16.dp)
        )
    }
}

// TAB 1: VISUAL GLOSSARY TAB
@Composable
fun GlossaryTab(
    utensils: List<Utensil>,
    viewModel: MainScreenViewModel,
    speakUtensil: (String) -> Unit,
    cardBackground: Color,
    accentColor: Color
) {
    val search = viewModel.searchQuery
    val category = viewModel.selectedCategory
    val material = viewModel.selectedMaterial

    // Filter logic
    val filtered = utensils.filter { u ->
        val matchesSearch = u.name.contains(search, ignoreCase = true) || u.useCase.contains(search, ignoreCase = true)
        val matchesCategory = category == "all" || u.category == category
        val matchesMaterial = material == "all" || u.materials.any { m -> m.contains(material, ignoreCase = true) }
        matchesSearch && matchesCategory && matchesMaterial
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search and Filters
        OutlinedTextField(
            value = search,
            onValueChange = { viewModel.updateSearchQuery(it) },
            placeholder = { Text("Search utensil name or application...", color = Color(0xFF64748B)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color(0xFF020617),
                unfocusedContainerColor = Color(0xFF020617),
                focusedBorderColor = accentColor,
                unfocusedBorderColor = Color(0xFF334155)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Categories list horizontal scrollbar
        val categories = listOf("all" to "All", "cutting" to "Cutting", "stirring" to "Cooking", "baking" to "Baking", "measuring" to "Measuring", "straining" to "Straining", "opening" to "Opening", "vessels" to "Cookware")
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { (catId, label) ->
                val isActive = category == catId
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(999.dp))
                        .background(if (isActive) accentColor.copy(alpha = 0.15f) else Color.Transparent)
                        .border(1.dp, if (isActive) accentColor else Color(0xFF334155), RoundedCornerShape(999.dp))
                        .clickable { viewModel.updateCategory(catId) }
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = label,
                        fontSize = 11.sp,
                        color = if (isActive) accentColor else Color(0xFF94A3B8),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Cards Grid view
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filtered) { utensil ->
                Card(
                    modifier = Modifier
                        .height(210.dp)
                        .clickable { viewModel.showUtensilDetails(utensil) },
                    colors = CardDefaults.cardColors(containerColor = cardBackground),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        // Vector SVG Icon Canvas Box
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF020617))
                                .padding(8.dp)
                        ) {
                            UtensilVectorIcon(
                                id = utensil.id,
                                category = utensil.category,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        // Text details
                        Text(
                            text = utensil.name,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = utensil.phonetic,
                            fontSize = 9.sp,
                            color = accentColor,
                            fontFamily = FontFamily.Monospace
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        // Speak Action button
                        Button(
                            onClick = { speakUtensil(utensil.name) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(28.dp),
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF334155))
                        ) {
                            Text("🔊 Pronounce", fontSize = 10.sp, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

// TAB 2: INTERACTIVE ANATOMY TAB
@Composable
fun AnatomyTab(
    utensils: List<Utensil>,
    viewModel: MainScreenViewModel,
    cardBackground: Color,
    accentColor: Color
) {
    val activeToolId = viewModel.activeAnatomyToolId
    val partName = viewModel.hoveredAnatomyPartName
    val partDesc = viewModel.hoveredAnatomyPartDesc

    val tool = utensils.firstOrNull { it.id == activeToolId } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {
        Text("Interactive Anatomy Lab", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Text("Select a tool below and inspect its parts", fontSize = 11.sp, color = Color(0xFF94A3B8), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        
        Spacer(modifier = Modifier.height(14.dp))
        
        // Tool Switcher buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("chefs-knife" to "Chef's Knife", "whisk" to "Wire Whisk").forEach { (id, label) ->
                val isActive = activeToolId == id
                Button(
                    onClick = { viewModel.switchAnatomyTool(id) },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = if (isActive) accentColor else cardBackground)
                ) {
                    Text(label, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Visual Canvas with relative hotspots
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF020617))
                .border(1.dp, Color(0xFF334155), RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            // Render tool illustration centered
            UtensilVectorIcon(
                id = tool.id,
                category = tool.category,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            )

            // Render glowing hotspot dots
            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                val boxWidth = maxWidth
                val boxHeight = maxHeight
                tool.anatomy.forEach { part ->
                    val xPx = boxWidth * (part.x / 100f)
                    val yPx = boxHeight * (part.y / 100f)
                    Box(
                        modifier = Modifier
                            .offset(x = xPx - 8.dp, y = yPx - 8.dp)
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(accentColor)
                            .border(2.dp, Color.White, CircleShape)
                            .clickable { viewModel.highlightAnatomyPart(part.name, part.description) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Explanatory description card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackground)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = partName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = accentColor
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = partDesc,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color(0xFFCBD5E1)
                )
            }
        }
    }
}

// TAB 3: QUIZ TAB
@Composable
fun QuizTab(
    viewModel: MainScreenViewModel,
    playTone: (Boolean) -> Unit,
    cardBackground: Color,
    accentColor: Color
) {
    val questions = viewModel.quizQuestions
    val currentIndex = viewModel.currentQuizIndex
    val score = viewModel.quizScore
    val streak = viewModel.quizStreak
    val selected = viewModel.selectedAnswer
    val completed = viewModel.isQuizCompleted

    // Auto-init quiz if empty
    LaunchedEffect(key1 = questions.size) {
        if (questions.isEmpty()) {
            viewModel.startNewQuiz()
        }
    }

    if (questions.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        if (!completed) {
            val q = questions[currentIndex]

            // Stats row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Score: $score/10", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text("Streak: $streak 🔥", color = accentColor, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text("Q: ${currentIndex + 1}/10", color = Color(0xFF94A3B8), fontSize = 12.sp)
            }
            
            Spacer(modifier = Modifier.height(10.dp))
            
            // Linear Progress Bar
            LinearProgressIndicator(
                progress = { (currentIndex.toFloat() / 10f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(999.dp)),
                color = accentColor,
                trackColor = Color(0xFF334155)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Question Card box
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = cardBackground)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (q.type == "visual") "VISUAL IDENTIFICATION" else "CULINARY APPLICATION",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = if (q.type == "visual") "Which English kitchen utensil does this shape represent?" else "Identify the utensil matching this application:",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(14.dp))

                    if (q.type == "visual") {
                        Box(
                            modifier = Modifier
                                .size(140.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF020617))
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            UtensilVectorIcon(id = q.utensil.id, category = q.utensil.category, modifier = Modifier.fillMaxSize())
                        }
                    } else {
                        Text(
                            text = "\"${q.utensil.useCase}\"",
                            fontSize = 12.sp,
                            color = Color(0xFFCBD5E1),
                            fontFamily = FontFamily.Serif,
                            textAlign = TextAlign.Center,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Multiple choice grid
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                q.options.chunked(2).forEach { pair ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        pair.forEach { option ->
                            val isChosen = selected == option
                            val isCorrect = option == q.correctAnswer
                            val isWrong = isChosen && !isCorrect
                            
                            val btnColor = when {
                                selected == null -> cardBackground
                                isCorrect -> Color(0xFF065F46) // Correct green
                                isWrong -> Color(0xFF991B1B)   // Wrong red
                                else -> cardBackground.copy(alpha = 0.5f)
                            }
                            
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(btnColor)
                                    .clickable(enabled = selected == null) {
                                        viewModel.answerQuestion(option)
                                        playTone(option == q.correctAnswer)
                                    }
                                    .padding(vertical = 14.dp, horizontal = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = option,
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Next question button
            if (selected != null) {
                Button(
                    onClick = { viewModel.nextQuestion() },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(bottom = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = accentColor)
                ) {
                    Text("Next Question →", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }

        } else {
            // Victory Results Screen
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBackground)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("🏆", fontSize = 64.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = if (score >= 8) "Excellent Work!" else if (score >= 5) "Good Effort!" else "Keep Training!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "You scored $score out of 10 points on the kitchen utensil visual exam.",
                        fontSize = 13.sp,
                        color = Color(0xFFCBD5E1),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { viewModel.startNewQuiz() },
                        colors = ButtonDefaults.buttonColors(containerColor = accentColor)
                    ) {
                        Text("Train Again", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
