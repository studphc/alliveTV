package com.hisona.allive;

import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.hisona.allive.SnsLoginDialogFragment;

/* loaded from: classes2.dex */
public final class y extends WebViewClient {
    public final /* synthetic */ SnsLoginDialogFragment a;

    public y(SnsLoginDialogFragment snsLoginDialogFragment) {
        this.a = snsLoginDialogFragment;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        SnsLoginDialogFragment.OnResultListener onResultListener;
        String uri = webResourceRequest.getUrl().toString();
        if (uri.contains("https://www.tving.com")) {
            String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
            SnsLoginDialogFragment snsLoginDialogFragment = this.a;
            if (cookie != null && (onResultListener = snsLoginDialogFragment.v0) != null) {
                onResultListener.onResult(cookie);
            }
            if (snsLoginDialogFragment.getDialog() != null) {
                snsLoginDialogFragment.getDialog().dismiss();
                return false;
            }
        }
        webView.loadUrl(uri);
        return false;
    }
}
