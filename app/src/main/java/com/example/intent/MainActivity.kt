package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.Model.User

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var btnGo: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textViewMain)
        btnGo = findViewById(R.id.btnGo)
        btnGo.setOnClickListener {
            openSecondActivity(User("Android","Kotlin",77))
        }

    }

    private val detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { res ->
        if (res.resultCode == Activity.RESULT_OK){
            val data = res.data
            val text = data?.getParcelableExtra<com.example.intent.Model.Number>("Number")
            textView.text = text.toString()
        }
    }

    private fun openSecondActivity(user: User) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        detailLauncher.launch(intent)
    }
}