package com.example.clipboardcopy

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Check if we were triggered by a Send Intent
        if (Intent.ACTION_SEND == intent.action && intent.type?.startsWith("image/") == true) {
            handleSendImage(intent)
        }

        // 2. Close the app immediately so it feels like a system function
        finish()
    }

    private fun handleSendImage(intent: Intent) {
        // Get the image URI (link) from the intent
        val imageUri: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)

        if (imageUri != null) {
            // 3. Copy to Clipboard
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newUri(contentResolver, "Image", imageUri)
            clipboard.setPrimaryClip(clip)

            // 4. Show a little popup
            Toast.makeText(this, "Image copied to clipboard", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Error copying image", Toast.LENGTH_SHORT).show()
        }
    }
}
