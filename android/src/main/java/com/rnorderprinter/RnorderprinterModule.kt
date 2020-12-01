package com.rnorderprinter

import android.content.Intent
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

import android.net.Uri

class RnOrderPrinterModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "RnOrderPrinter"
    }

    // Example method
    // See https://facebook.github.io/react-native/docs/native-modules-android
    @ReactMethod
    fun printHtml(htmlData: String, promise: Promise) {
      val builder: Uri.Builder = Uri.Builder()
      builder.scheme("starpassprnt");
      builder.authority("v1");
      builder.path("/print/nopreview");
      builder.appendQueryParameter("port", "tcp:")
      builder.appendQueryParameter("settings", "portable")
      builder.appendQueryParameter("back", "startest://"))
      builder.appendQueryParameter("html", htmlData)

      var intent = Intent(Intent.ACTION_VIEW)
      intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
      intent.setData(builder.build())

      var activity = getCurrentActivity()
      activity?.startActivity(intent)

      promise.resolve(true)

    }

    
}
