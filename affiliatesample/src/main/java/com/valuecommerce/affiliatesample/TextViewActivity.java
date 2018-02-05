package com.valuecommerce.affiliatesample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;

import com.valuecommerce.android.ADVCTextView;

public class TextViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1.上記レイアウトファイルを設定してください。
        setContentView(R.layout.activity_textview);

        // 2.ADVCTextViewをインスタンス化します。
        ADVCTextView textView = (ADVCTextView)findViewById(R.id.text_view);
        String word = getString(R.string.text);
        CharSequence spanned = Html.fromHtml(word);
        textView.setText(spanned);

        // 3.setLSParamを呼び出します。
        Integer vc_pid = getResources().getInteger(R.integer.vcpid);
        textView.setLSParam(vc_pid);

        // 4.LinkSwitchを有効にします。
        textView.setMovementMethod();
    }
}