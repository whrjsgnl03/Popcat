package com.example.calculater

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculater.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.click_sound2)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val button: ImageButton = findViewById(R.id.imageButton)
        val textView: TextView = findViewById(R.id.Text)

        var counter = 0

        button.setImageResource(R.drawable.mouse_close)
        @SuppressLint("ClickableViewAccessibility")
        button.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    button.setImageResource(R.drawable.mouse_open)
                    counter++
                    textView.text = "Clicks: $counter"
                    mediaPlayer?.start()
                }
                MotionEvent.ACTION_UP -> {
                    button.setImageResource(R.drawable.mouse_close)
                }
            }
            true
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}