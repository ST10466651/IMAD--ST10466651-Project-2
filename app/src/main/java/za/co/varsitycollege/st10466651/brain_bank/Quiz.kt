package za.co.varsitycollege.st10466651.brain_bank

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class Quiz : AppCompatActivity() {
    val arrQuestions = arrayOf("A basketball game consists of four quarters of 12 minutes each in the NBA.",
        "Cristiano Ronaldo has only played for clubs in Spain during his professional career.",
        "In tennis, a score of zero is called 'love.'",
        "The Olympic Games are held every 3 years.",
        "South Africa won the Rugby World Cup in both 1995 and 2019.")

    val arrAnswer = arrayOf(true,
        false,
        true,
        false,
        true)

    val arrUserAnswer = BooleanArray(5)

    var counter = 0
    var trueFalse = false
    var falseTrue = false
    var score = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val questions = findViewById<TextView>(R.id.txtQuestions)
        val right = findViewById<Button>(R.id.btnTrue)
        val wrong = findViewById<Button>(R.id.btnFalse)
        val next = findViewById<Button>(R.id.btnEnd)
        val done = findViewById<Button>(R.id.btnDone)
        var counter = 0
        var score = 0

        questions.text = arrQuestions[counter]
        done.visibility = View.GONE

        next.setOnClickListener {
            counter++
            questions.text = arrQuestions[counter]
            wrong.isEnabled = true
            right.isEnabled = true
            if(counter == 4)
                done.visibility = View.VISIBLE
            next.isEnabled = false
        }

        right.setOnClickListener {
            wrong.isEnabled = false
//            arrUserAnswer.add(true)
            if(arrUserAnswer == arrAnswer) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                score++
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }
        wrong.setOnClickListener {
            right.isEnabled = false
//            arrUserAnswer.add(false)
            if(arrUserAnswer == arrAnswer) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                score++
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        done.setOnClickListener {
            val intent = Intent (this, Results::class.java)
            startActivity(intent)
            counter++
            //attempt.text = "Attempts: ${counter}/5"
            //scores.text = "Score: ${score}/5"
        }

        val intent = Intent(this, Results::class.java).apply {
            putExtra("Questions_Array", arrQuestions) // Add data to pass
            putExtra("Answer_Array", arrAnswer) // Add data to pass
            putExtra("UserAnswer_Array", arrUserAnswer) // Add data to pass
            }
        startActivity(intent)
    }
}