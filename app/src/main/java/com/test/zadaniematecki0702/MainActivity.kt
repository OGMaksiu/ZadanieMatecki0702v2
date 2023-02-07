package com.test.zadaniematecki0702

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.ProgressBar
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var seekBarWidth1: SeekBar
    private lateinit var seekBarWidth2: SeekBar
    private lateinit var seekBarWidth3: SeekBar
    private lateinit var seekBarHeight1: SeekBar
    private lateinit var seekBarHeight2: SeekBar
    private lateinit var seekBarHeight3: SeekBar

    private lateinit var horizontalProgressBar: ProgressBar
    private lateinit var verticalProgressBar: ProgressBar
    private lateinit var resetButton: Button

    private var maxWidth = 300
    private var maxHeight = 300

    private var totalWidth = 0
    private var totalHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBarWidth1 = findViewById(R.id.seekBarWidth1)
        seekBarWidth2 = findViewById(R.id.seekBarWidth2)
        seekBarWidth3 = findViewById(R.id.seekBarWidth3)

        seekBarHeight1 = findViewById(R.id.seekBarHeight1)
        seekBarHeight2 = findViewById(R.id.seekBarHeight2)
        seekBarHeight3 = findViewById(R.id.seekBarHeight3)

        horizontalProgressBar = findViewById(R.id.horizontalProgressBar)
        verticalProgressBar = findViewById(R.id.verticalProgressBar)
        resetButton = findViewById(R.id.button)

        seekBarWidth1.max = maxWidth
        seekBarWidth2.max = maxWidth
        seekBarWidth3.max = maxWidth

        seekBarHeight1.max = maxHeight
        seekBarHeight2.max = maxHeight
        seekBarHeight3.max = maxHeight

        val maxWidth = seekBarWidth1.max + seekBarWidth2.max + seekBarWidth3.max
        val maxHeight = seekBarHeight1.max + seekBarHeight2.max + seekBarHeight3.max

        seekBarWidth1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                totalWidth =
                    seekBarWidth1.progress + seekBarWidth2.progress + seekBarWidth3.progress
                horizontalProgressBar.progress = (totalWidth * 100 / maxWidth).coerceAtMost(100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarWidth2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                totalWidth =
                    seekBarWidth1.progress + seekBarWidth2.progress + seekBarWidth3.progress
                horizontalProgressBar.progress = (totalWidth * 100 / maxWidth).coerceAtMost(100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}
