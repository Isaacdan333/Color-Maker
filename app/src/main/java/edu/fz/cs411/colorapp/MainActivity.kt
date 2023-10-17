// Name: Isaac Perez
// CWID: 887277002
// Email: isaacdan@csu.fullerton.edu
package edu.fz.cs411.colorapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var mainview: View
    private lateinit var button: Button
    private lateinit var redColor: SeekBar
    private lateinit var greenColor: SeekBar
    private lateinit var blueColor: SeekBar
    private lateinit var redText: EditText
    private lateinit var greenText: EditText
    private lateinit var blueText: EditText
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var redSwitch: Switch
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var greenSwitch: Switch
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var  blueSwitch: Switch
    private val zero:Float = 0.0f
    private var red:Float = zero
    private var green:Float = zero
    private var blue:Float = zero
    private var redcheck: Boolean = false
    private var greencheck: Boolean = false
    private var bluecheck: Boolean = false

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainview = findViewById(R.id.mainView)
        button = findViewById(R.id.button)
        redColor = findViewById(R.id.sRed)
        greenColor = findViewById(R.id.sGreen)
        blueColor = findViewById(R.id.sBlue)
        redText = findViewById(R.id.redText)
        greenText = findViewById(R.id.greenText)
        blueText = findViewById(R.id.blueText)
        redSwitch = findViewById(R.id.redSwitch)
        greenSwitch = findViewById(R.id.greenSwitch)
        blueSwitch = findViewById(R.id.blueSwitch)
        mainview.setBackgroundColor(Color.rgb(red, green, blue))

        button.setOnClickListener{
            red = zero
            green = zero
            blue = zero
            redColor.progress = 0
            greenColor.progress = 0
            blueColor.progress = 0
            redText.setText("0.00")
            greenText.setText("0.00")
            blueText.setText("0.00")
            redSwitch.isChecked = false
            redSwitch.text = "Off"
            redcheck = false
            greenSwitch.isChecked = false
            greenSwitch.text = "Off"
            greencheck = false
            blueSwitch.isChecked = false
            blueSwitch.text = "Off"
            bluecheck = false
            redColor.isEnabled = true
            redText.isEnabled = true
            greenColor.isEnabled = true
            greenText.isEnabled = true
            blueColor.isEnabled = true
            blueText.isEnabled = true
            mainview.setBackgroundColor(Color.rgb(red, green, blue))
        }

        redText.setOnClickListener{
            val inputText = redText.text.toString()
            try {
                val intValue = inputText.toFloat()
                redColor.progress = (intValue * 255).toInt()
            } catch (e: NumberFormatException) {
                println("Not a valid float")
            }
        }

        redSwitch.setOnClickListener{view: View ->
            val sw: Switch = (view as Switch)
            if (sw.isChecked) {
                redSwitch.text = "On"
                red = zero
                redcheck = true
                redColor.isEnabled = false
                redText.isEnabled = false
                mainview.setBackgroundColor(Color.rgb(red, green, blue))
            } else {
                redSwitch.text = "Off"
                redcheck = false
                val num = redColor.progress.toFloat() / 255
                val floatnum = String.format("%.2f", num)
                red = num
                redText.setText(floatnum)
                redColor.isEnabled = true
                redText.isEnabled = true
                mainview.setBackgroundColor(Color.rgb(red, green, blue))
            }
        }

        redColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                if (!redcheck) {
                    val num = progress.toFloat() / 255
                    val floatnum = String.format("%.2f", num)
                    redText.setText(floatnum)
                    red = num
                    mainview.setBackgroundColor(Color.rgb(red, green, blue))
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        greenText.setOnClickListener{
            val inputText = greenText.text.toString()
            try {
                val intValue = inputText.toFloat()
                greenColor.progress = (intValue * 255).toInt()
            } catch (e: NumberFormatException) {
                println("Not a valid float")
            }
        }

        greenSwitch.setOnClickListener{view: View ->
            val sw: Switch = (view as Switch)
            if (sw.isChecked) {
                greenSwitch.text = "On"
                green = zero
                greencheck = true
                greenColor.isEnabled = false
                greenText.isEnabled = false
                mainview.setBackgroundColor(Color.rgb(red, green, blue))
            } else {
                greenSwitch.text = "Off"
                greencheck = false
                val num = greenColor.progress.toFloat() / 255
                val floatnum = String.format("%.2f", num)
                green = num
                greenText.setText(floatnum)
                greenColor.isEnabled = true
                greenText.isEnabled = true
                mainview.setBackgroundColor(Color.rgb(red, green, blue))
            }
        }

        greenColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                if (!greencheck) {
                    val num = progress.toFloat() / 255
                    val floatnum = String.format("%.2f", num)
                    greenText.setText(floatnum)
                    green = num
                    mainview.setBackgroundColor(Color.rgb(red, green, blue))
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        blueText.setOnClickListener{
            val inputText = blueText.text.toString()
            try {
                val intValue = inputText.toFloat()
                blueColor.progress = (intValue * 255).toInt()
            } catch (e: NumberFormatException) {
                println("Not a valid float")
            }
        }

        blueSwitch.setOnClickListener{view: View ->
            val sw: Switch = (view as Switch)
            if (sw.isChecked) {
                blueSwitch.text = "On"
                blue = zero
                bluecheck = true
                blueColor.isEnabled = false
                blueText.isEnabled = false
                mainview.setBackgroundColor(Color.rgb(red, green, blue))
            } else {
                blueSwitch.text = "Off"
                bluecheck = false
                val num = blueColor.progress.toFloat() / 255
                val floatnum = String.format("%.2f", num)
                blue = num
                blueText.setText(floatnum)
                blueColor.isEnabled = true
                blueText.isEnabled = true
                mainview.setBackgroundColor(Color.rgb(red, green, blue))
            }
        }

        blueColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                if (!bluecheck) {
                    val num = progress.toFloat() / 255
                    val floatnum = String.format("%.2f", num)
                    blueText.setText(floatnum)
                    blue = num
                    mainview.setBackgroundColor(Color.rgb(red, green, blue))
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }
}