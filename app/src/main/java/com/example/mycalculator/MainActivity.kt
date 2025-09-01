package com.example.mycalculator
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
private fun show() {
    TODO("Not yet implemented")
}

class MainActivity : AppCompatActivity() {


    private lateinit var button: Button
    private lateinit var second: Button
    private lateinit var third: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var alpha: Button
    private lateinit var symbol: Button
    private lateinit var percent: Button
    private lateinit var my: Button
    private lateinit var butn: Button
    private lateinit var buton: Button
    private lateinit var id: Button
    private lateinit var divide: Button

    private lateinit var text: TextView
    private lateinit var num: TextView


    private lateinit var imageView4: ImageView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.button)
        second = findViewById(R.id.second)
        third = findViewById(R.id.third)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        alpha = findViewById(R.id.alpha)
        symbol = findViewById(R.id.symbol)
        percent = findViewById(R.id.percent)
        my = findViewById(R.id.my)
        butn = findViewById(R.id.butn)
        buton = findViewById(R.id.buton)
        id = findViewById(R.id.id)
        divide = findViewById(R.id.divide)


        text = findViewById(R.id.text)
        num = findViewById(R.id.num)


        imageView4 = findViewById(R.id.imageView4)
        imageView = findViewById(R.id.imageView)


        one.setOnClickListener { text.text = text.text.toString() + "1" }
        two.setOnClickListener { text.text = text.text.toString() + "2" }
        three.setOnClickListener {text.text = text.text.toString() + "3" }
        four.setOnClickListener {text.text = text.text.toString() + "4" }
        five.setOnClickListener {text.text = text.text.toString() + "5" }
        six.setOnClickListener { text.text = text.text.toString() + "6" }
        seven.setOnClickListener { text.text = text.text.toString() + "7" }
        eight.setOnClickListener { text.text = text.text.toString() + "8" }
        nine.setOnClickListener { text.text = text.text.toString() + "9" }
        second.setOnClickListener { text.text = text.text.toString() + "0" }
        button.setOnClickListener { text.text = text.text.toString() + "." }


        butn.setOnClickListener { text.text = text.text.toString() + "+" }
        buton.setOnClickListener { text.text = text.text.toString() + "-" }
        id.setOnClickListener { text.text = text.text.toString() + "×" }
        divide.setOnClickListener { text.text = text.text.toString() + "÷" }
        percent.setOnClickListener { text.text = text.text.toString() + "%" }


        alpha.setOnClickListener { text.text = "" }


        third.setOnClickListener {
            val current = text.text.toString()
            if (current.isNotEmpty()) {
                text.text = current.substring(0, current.length - 1)
            }
        }


        my.setOnClickListener {
            val expression = text.text.toString()
            try {
                val numbers = mutableListOf<Double>()
                val operators = mutableListOf<Char>()

                var temp = ""
                for (char in expression) {
                    if (char in listOf('+', '-', '×', '÷','%')) {
                        numbers.add(temp.toDouble())
                        operators.add(char)
                        temp = ""
                    } else {
                        temp += char
                    }
                }
                numbers.add(temp.toDouble())


                var i = 0
                while (i < operators.size) {
                    when (operators[i]) {
                        '×' -> {
                            val result = numbers[i] * numbers[i + 1]
                            numbers[i] = result
                            numbers.removeAt(i + 1)
                            operators.removeAt(i)
                            i--
                        }
                        '÷' -> {
                            val result = numbers[i] / numbers[i + 1]
                            numbers[i] = result
                            numbers.removeAt(i + 1)
                            operators.removeAt(i)
                            i--
                        }
                    }
                    i++
                }

                i = 0
                while (i < operators.size) {
                    when (operators[i]) {
                        '+' -> {
                            val result = numbers[i] + numbers[i + 1]
                            numbers[i] = result
                            numbers.removeAt(i + 1)
                            operators.removeAt(i)
                            i--
                        }
                        '-' -> {
                            val result = numbers[i] - numbers[i + 1]
                            numbers[i] = result
                            numbers.removeAt(i + 1)
                            operators.removeAt(i)
                            i--
                        }
                    }
                    i++
                }

                num.text = numbers[0].toString()

            } catch (e: Exception){
                Toast.makeText(this,"Invalid Expression",Toast.LENGTH_SHORT).show()            }

        }
        text.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val expression = s.toString()
                if (expression.isEmpty()) {
                    num.text = ""
                    return
                }
              if (expression.last() in listOf('+','-','×','÷','%'))
                  {
                  num.text = ""
                    return
                }
                try {
                    val numbers = mutableListOf<Double>()
                    val operators = mutableListOf<Char>()
                    var temp = ""

                    for (char in expression) {
                        if (char in listOf('+', '-', '×', '÷','%')) {
                            numbers.add(temp.toDoubleOrNull() ?: 0.0)
                            operators.add(char)
                            temp = ""
                        } else {
                            temp += char
                        }
                    }
                    numbers.add(temp.toDoubleOrNull() ?: 0.0)

                     var i = 0
                    while (i < operators.size) {
                        when (operators[i]) {
                            '×' -> {
                                val result = numbers[i] * numbers[i + 1]
                                numbers[i] = result
                                numbers.removeAt(i + 1)
                                operators.removeAt(i)
                                i--
                            }
                            '÷' -> {
                                val result = numbers[i] / numbers[i + 1]
                                numbers[i] = result
                                numbers.removeAt(i + 1)
                                operators.removeAt(i)
                                i--
                            }
                        }
                        i++
                    }

                    i = 0
                    while (i < operators.size) {
                        when (operators[i]) {
                            '%' -> {
                                val result = numbers[i] % numbers[i + 1]
                                numbers[i] = result
                                numbers.removeAt(i + 1)
                                operators.removeAt(i)
                                i--
                            }
                        }
                        i++
                    }


                    i = 0
                    while (i < operators.size) {
                        when (operators[i]) {
                            '+' -> {
                                val result = numbers[i] + numbers[i + 1]
                                numbers[i] = result
                                numbers.removeAt(i + 1)
                                operators.removeAt(i)
                                i--
                            }
                            '-' -> {
                                val result = numbers[i] - numbers[i + 1]
                                numbers[i] = result
                                numbers.removeAt(i + 1)
                                operators.removeAt(i)
                                i--
                            }
                        }
                        i++
                    }

                    num.text = numbers[0].toString()
                } catch (e: Exception) {
                    num.text = ""
                }
            }

            override fun afterTextChanged(s: android.text.Editable?) {}
        })



    }
 }

