package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.intent.Model.Number
import com.example.intent.Model.User

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var btnBack:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
        loadData()
    }

    private fun loadData() {
      val user = intent.getParcelableExtra<User>("user")

        textView.text= user.toString()
    }

    private fun initViews() {
       textView = findViewById(R.id.textSecond)
        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener{
            backToMain(Number("Android",1500.0))
        }
    }
    private fun backToMain(Number: Number){
        val intent =Intent()
        intent.putExtra("member",Number)
        setResult(RESULT_OK,intent)
        finish()
    }
}