package com.example.apptts

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import java.util.*

class TTS : AppCompatActivity() {
    lateinit var bt: Button
    lateinit var tvOutput: TextView
    lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tts)
        init()
    }

    private fun init(){
        tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                status ->
            if (status != TextToSpeech.ERROR){
                tts.language = Locale.FRANCE
            }
        })

        bt = findViewById(R.id.bt)
        bt.setBackgroundColor(Color.MAGENTA)
        tvOutput = findViewById(R.id.tvOutput)
        tvOutput.movementMethod = ScrollingMovementMethod()
        tvOutput.setText("Victor Hugo est né à Besançon le 26 février 1802. Pendant son adolescence, il a habité à Paris avec sa mère dans le quartier du Val de Grâce.\n" +
                "En 1817, à l’âge de 15 ans, il a gagné deux prix littéraires.\n" +
                "\n" +
                "Après, il a continué à écrire et il a eu beaucoup de succès.\n" +
                "\n" +
                "Il a écrit des romans comme « Notre Dame de Paris », des pièces de théâtre, des poèmes, il a aussi écrit pour un journal.\n" +
                "\n" +
                "Sa vie a changé après un échec littéraire et la mort de sa fille Léopoldine.\n" +
                "\n" +
                "Il a décidé de faire de la politique. Il est devenu député en 1848, mais il a dû fuir la France en 1851.\n" +
                "\n" +
                "Il est parti sur l’île de Jersey, ensuite il est allé à Guernesey (Jersey et Guernesey sont deux îles britanniques. Elles sont situées près des côtes françaises).\n" +
                "\n" +
                "Il a écrit des livres contre le gouvernement de Napoléon III, c’est aussi à ce moment qu’il a écrit « les Misérables ».\n" +
                "\n" +
                "Napoléon III a perdu la guerre contre la Prusse et Victor Hugo est revenu en France. (Il est rentré en 1870). Il a continué la politique. Il est mort en 1885.")
        bt.setOnClickListener {
            textToSpeech(tvOutput)
        }
    }

    private fun textToSpeech(tvOutput: TextView) {
        val toSpeak = tvOutput.text.toString()
        tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
    }

    //override method of back buttton
    override fun onBackPressed() {
        super.onBackPressed()
        tts.stop()
    }
}