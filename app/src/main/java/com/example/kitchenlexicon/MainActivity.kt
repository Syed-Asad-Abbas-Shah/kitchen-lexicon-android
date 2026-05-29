package com.example.kitchenlexicon

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kitchenlexicon.theme.KitchenLexiconTheme
import com.example.kitchenlexicon.ui.main.MainScreen
import java.util.Locale

class MainActivity : ComponentActivity(), TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var toneGenerator: ToneGenerator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Text To Speech
        tts = TextToSpeech(this, this)

        // Initialize Tone Generator for Quiz Sound Synthesis
        try {
            toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
        } catch (e: Exception) {
            Log.e("KitchenLexicon", "Failed to create ToneGenerator", e)
        }

        enableEdgeToEdge()
        setContent {
            KitchenLexiconTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        speakUtensil = { text -> speak(text) },
                        playTone = { isCorrect -> playQuizTone(isCorrect) },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "US Locale is not supported or missing data.")
            }
        } else {
            Log.e("TTS", "Initialization failed.")
        }
    }

    private fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    private fun playQuizTone(isCorrect: Boolean) {
        try {
            if (isCorrect) {
                // Ascending chime: TONE_CDMA_PIP
                toneGenerator?.startTone(ToneGenerator.TONE_CDMA_PIP, 150)
            } else {
                // Buzz beep: TONE_SUP_ERROR
                toneGenerator?.startTone(ToneGenerator.TONE_SUP_ERROR, 250)
            }
        } catch (e: Exception) {
            Log.e("Tone", "Failed to play tone", e)
        }
    }

    override fun onDestroy() {
        // Shutdown TTS to prevent memory leaks
        tts?.stop()
        tts?.shutdown()
        // Release tone generator resources
        toneGenerator?.release()
        super.onDestroy()
    }
}
