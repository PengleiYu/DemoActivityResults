package com.utopia.demoactivityresults

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  private val startActivityForResult = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) { it ->
    Log.d(TAG, "null() called with: it = $it")
  }
  private val getContent = registerForActivityResult(
    ActivityResultContracts.GetContent()
  ) { it ->
    Log.d(TAG, "null() called with: it = $it")
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    findViewById<Button>(R.id.btn_next).setOnClickListener {
      nextPage()
    }
    findViewById<Button>(R.id.btn_get_content).setOnClickListener {
      getContent.launch("image/*")
    }
  }

  private fun nextPage() {
    val intent = Intent(this, SecondActivity::class.java)
    startActivityForResult.launch(intent)
  }

  companion object {
    private const val TAG = "MainActivity"
  }
}