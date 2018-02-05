package com.valuecommerce.affiliatesample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.valuecommerce.android.ADVCURL;

public class LinkSwitchActivity extends Activity {
    private ADVCURL advcurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button button = (Button) findViewById(R.id.button);

        // 2.ADVCURLをインスタンス化します。
        advcurl = new ADVCURL(this);

        // 3.setLSParamを呼び出します。
        Integer vc_pid = getResources().getInteger(R.integer.vcpid);
        advcurl.setLSParams(vc_pid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.valuecommerce.ne.jp/");
                Uri result = advcurl.urlChanger(uri);
                Intent i = new Intent(Intent.ACTION_VIEW, result);
                startActivity(i);
            }
        });
    }
}