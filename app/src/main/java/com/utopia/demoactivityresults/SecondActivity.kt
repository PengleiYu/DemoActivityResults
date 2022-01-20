package com.utopia.demoactivityresults

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    title = "SecondActivity"
    setContentView(R.layout.activity_second)

    findViewById<Button>(R.id.btn_finish).setOnClickListener {
      val intent = Intent().apply {
        putExtra("name", "age")
        putExtra("age", 111)
      }
      setResult(RESULT_OK, intent)
      finish()
    }
  }
}