package com.nextnepal.nextNepalPatro.activityNews.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.nextnepal.nextNepalPatro.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This class opens the news url provided by newsportaladapter
 */
public class NewsExploreActivity extends AppCompatActivity {

    @BindView(R.id.webview_news)
    WebView webView_v;

    @BindView(R.id.relative_news_explore)
    RelativeLayout relativeLayout;

    @BindView(R.id.progressBar)
    ProgressBar progressBar_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_explore);
        ButterKnife.bind(this);
        progressBar_v.setVisibility(View.VISIBLE);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            webView_v.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView webView, int progress) {
                    if (progress == 100) {
                        progressBar_v.setVisibility(View.GONE);
                    }
                }
            });
            webView_v.loadUrl(bundle.get("url").toString());
            webView_v.getSettings().setJavaScriptEnabled(true);
        } else {
            Snackbar.make(relativeLayout, "Internal Error", Snackbar.LENGTH_SHORT).show();
        }
    }
}
