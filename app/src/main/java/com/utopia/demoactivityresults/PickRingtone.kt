package com.utopia.demoactivityresults

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract

class PickRingtone : ActivityResultContract<Int, Uri?>() {
  override fun createIntent(context: Context, ringtonType: Int): Intent {
    return Intent(RingtoneManager.ACTION_RINGTONE_PICKER).apply {
      putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, ringtonType)
    }
  }

  override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
    if (resultCode != Activity.RESULT_OK) return null
    return intent?.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
  }
}