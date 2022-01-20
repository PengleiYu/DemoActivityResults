package com.utopia.demoactivityresults

import android.media.RingtoneManager
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver(private val registry: ActivityResultRegistry) : DefaultLifecycleObserver {
  private lateinit var getContent: ActivityResultLauncher<String>
  private lateinit var pickRingtone: ActivityResultLauncher<Int>
  override fun onCreate(owner: LifecycleOwner) {
    getContent = registry.register("key", owner, ActivityResultContracts.GetContent()) {
      Log.d(TAG, "onCreate: $it")
    }

    pickRingtone = registry.register("ringtoneKey", owner, PickRingtone()) {
      Log.d(TAG, "onCreate: pickRingtone -> $it")
    }
  }

  fun pickRingtone() {
    pickRingtone.launch(RingtoneManager.TYPE_RINGTONE)
  }

  fun selectImage() {
    getContent.launch("image/*")
  }

  companion object {
    private const val TAG = "MyLifecycleObserver"
  }
}