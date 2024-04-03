package edu.temple.funwithintents

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)

        // When the user clicks this button, share the text if not empty
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {
            val TextToShare = editText.toString()
            if (TextToShare.isNotEmpty()){
                val sentIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, TextToShare)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sentIntent, null)
                startActivity(shareIntent)
        }else{
            Toast.makeText(this, "It is empty",Toast.LENGTH_SHORT).show()
            }

        }
    }
}