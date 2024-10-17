package com.doinglab.foodlens.sample

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)

        // WebView를 초기화
        val webView: WebView = findViewById(R.id.webview)

        webView.apply {
            webView.settings.javaScriptEnabled = true  // JavaScript 활성화
            webView.webViewClient = WebViewClient()    // 외부 브라우저가 아닌 WebView에서 열리도록 설정
        }
        webView.loadUrl("http://snapdiet.myoung.my:8080/articles")
    }
}