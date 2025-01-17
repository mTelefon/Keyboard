package org.fossify.keyboard

import android.app.Application
import android.graphics.Color
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.emoji2.bundled.BundledEmojiCompatConfig
import androidx.emoji2.text.EmojiCompat
import androidx.emoji2.text.FontRequestEmojiCompatConfig
import org.fossify.commons.extensions.checkUseEnglish
import org.fossify.keyboard.extensions.isDeviceInDirectBootMode


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (!isDeviceInDirectBootMode) {
            checkUseEnglish()
        }
        setupEmojiCompat()
    }

    private fun setupEmojiCompat() {
        val config = BundledEmojiCompatConfig(applicationContext) // Uygulama bağlamını kullanarak konfigürasyon oluşturma
        EmojiCompat.init(config)
    }

}
