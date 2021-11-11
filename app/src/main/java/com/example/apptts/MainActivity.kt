package com.example.apptts

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var tts: Button
    lateinit var stt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tts = findViewById(R.id.bt1)
        stt = findViewById(R.id.bt2)

        tts.setBackgroundColor(Color.MAGENTA)
        tts.setOnClickListener{
            startActivity(Intent(this, TTS::class.java))
        }
        stt.setBackgroundColor(Color.MAGENTA)
        stt.setOnClickListener {
            startActivity(Intent(this, STTActivity::class.java))
        }
    }
}