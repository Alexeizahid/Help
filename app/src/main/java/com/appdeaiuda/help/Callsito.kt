package com.appdeaiuda.help

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_callsito.*

class Callsito : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_callsito)
        imageButton.setOnClickListener {
            var mediaPlayer : MediaPlayer? = MediaPlayer.create(this, R.raw.sonidoalarma)
            mediaPlayer?.start()

            imageButton.setOnClickListener {
                mediaPlayer?.release()
                mediaPlayer = null
            }
           }


        }
}
