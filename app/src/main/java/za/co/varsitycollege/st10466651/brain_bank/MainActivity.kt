package za.co.varsitycollege.st10466651.brain_bank

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val start = findViewById<Button>(R.id.btnStart)

        start.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }

        val intent = Intent(this, Quiz::class.java).apply {
            putExtra("Questions_Array", arrQuestions) // Add data to pass
            putExtra("Answer_Array", arrAnswer) // Add data to pass
            putExtra("UserAnswer_Array", arrUserAnswer) // Add data to pass
        }
        startActivity(intent)
    }
}