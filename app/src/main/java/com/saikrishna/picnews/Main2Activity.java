package com.saikrishna.picnews;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    WebView webview;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webview = (WebView)findViewById(R.id.webView2);

        Intent intent = getIntent();
        value = intent.getStringExtra("key");

        webview.getSettings().setJavaScriptEnabled(true); // enable javascript
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        final Activity activity = this;

        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        webview.loadUrl(value.split("#")[2]);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onStop () {
        super.onStop();
        webview.loadUrl("");
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webview.loadUrl("");
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.loadUrl("");
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
//        if (value.split("#")[0].matches("1")) {
//            menu.findItem(R.id.action_share).setVisible(false);
//            menu.findItem(R.id.action_browser).setVisible(false);
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_refresh:
                webview.reload();
                return true;
            case R.id.action_browser:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(value.split("#")[2]));
                startActivity(browserIntent);
                return true;
            case R.id.action_share:
                Intent share1 = new Intent(android.content.Intent.ACTION_SEND);
                share1.setType("text/plain");
                share1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                share1.putExtra(Intent.EXTRA_TEXT, value.split("#")[0] + "\n\n" + value.split("#")[2] + "\n\n-via PICnews");

                startActivity(Intent.createChooser(share1, "Share link!"));
                return true;
            case R.id.action_close:
                finish();
                return true;
            case R.id.action_left:
                webview.goBack();
                return true;
            case R.id.action_right:
                webview.goForward();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
