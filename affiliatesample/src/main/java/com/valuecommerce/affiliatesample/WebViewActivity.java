package com.valuecommerce.affiliatesample;

import android.app.Activity;
import android.os.Bundle;
import com.valuecommerce.android.ADVCWebView;

public class WebViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1.上記レイアウトファイルを設定してください。
        setContentView(R.layout.activity_webview);

        // 2.ADVCWebViewをインスタンス化します。
        ADVCWebView webView = (ADVCWebView) findViewById(R.id.web_view);

        // 3.setWebViewClientを呼び出します。
        webView.setWebViewClient();

        // 4.setTargetURLListを呼び出します。
        String[] targetUrlList = {"valuecommerce.ne.jp"};
        webView.setTargetURLList(targetUrlList);

        // 5.setLSParamを呼び出します。
        Integer vc_pid = getResources().getInteger(R.integer.vcpid);
        webView.setLSParam(vc_pid);

        webView.loadUrl("https://www.valuecommerce.ne.jp/");
    }
}