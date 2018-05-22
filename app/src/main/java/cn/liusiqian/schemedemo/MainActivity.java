package cn.liusiqian.schemedemo;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends BaseSchemeAcitivity
{
    private WebView webview;
    private TextView tv;
    private WebView webview_second;

    @Override
    protected void loadData()
    {

    }

    @Override
    protected void initWidgets(Bundle savedInstanceState)
    {
        tv = (TextView) findViewById(R.id.txt);
        webview = (WebView) findViewById(R.id.web);
        tv.setText("schdemo://target/base?id=2&name=test");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManagerCompat manager = NotificationManagerCompat.from(MainActivity.this);
                boolean isOpened = manager.areNotificationsEnabled();
                if (isOpened){
                    Toast.makeText(MainActivity.this,"已经开启了通知",Toast.LENGTH_LONG).show();
                    return;
                }
                /**
                 * 跳到通知栏设置界面
                 * @param context
                 */
                Intent localIntent = new Intent();
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= 9) {
                    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    localIntent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    localIntent.setAction(Intent.ACTION_VIEW);

                    localIntent.setClassName("com.android.settings",
                            "com.android.settings.InstalledAppDetails");

                    localIntent.putExtra("com.android.settings.ApplicationPkgName",
                            MainActivity.this.getPackageName());
                }
                startActivity(localIntent);

            }
        });
        webview.loadUrl("file:///android_asset/index.html");
        webview_second= (WebView)findViewById(R.id.web_second);
        webview_second.loadUrl("file:///android_asset/index_second.html");
//        ArrayList arrayLists = new ArrayList<String >();
//        if (arrayLists.size()>0){
//            arrayLists.get(1);
//        }
    }

    @Override
    protected int setLayoutRes()
    {
        return R.layout.activity_main;
    }
}
