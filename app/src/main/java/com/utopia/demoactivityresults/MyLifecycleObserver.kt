package com.utopia.demoactivityresults

import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver(private val registry: ActivityResultRegistry) : DefaultLifecycleObserver {
  private lateinit var getContent: ActivityResultLauncher<String>
  override fun onCreate(owner: LifecycleOwner) {
    getContent = registry.register("key", owner, ActivityResultContracts.GetContent()) {
      Log.d(TAG, "onCreate: $it")
    }
  }

  fun selectImage() {
    getContent.launch("image/*")
  }

  companion object {
    private const val TAG = "MyLifecycleObserver"
  }
}