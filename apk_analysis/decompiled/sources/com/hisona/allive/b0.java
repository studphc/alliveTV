package com.hisona.allive;

import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.hisona.allive.TvingLoginDialogFragment;

/* loaded from: classes2.dex */
public final class b0 extends WebViewClient {
    public final /* synthetic */ TvingLoginDialogFragment a;

    public b0(TvingLoginDialogFragment tvingLoginDialogFragment) {
        this.a = tvingLoginDialogFragment;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        TvingLoginDialogFragment.OnResultListener onResultListener;
        if (webResourceRequest.getUrl().toString().contains("https://www.tving.com")) {
            String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
            TvingLoginDialogFragment tvingLoginDialogFragment = this.a;
            if (cookie != null && (onResultListener = tvingLoginDialogFragment.v0) != null) {
                onResultListener.onResult(cookie);
            }
            if (tvingLoginDialogFragment.getDialog() != null) {
                tvingLoginDialogFragment.getDialog().dismiss();
                return false;
            }
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
