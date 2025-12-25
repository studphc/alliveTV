package com.hisona.allive;

import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.hisona.allive.SnsLoginDialogFragment;

/* renamed from: com.hisona.allive.y */
/* loaded from: classes2.dex */
public final class C1091y extends WebViewClient {

    /* renamed from: a */
    public final /* synthetic */ SnsLoginDialogFragment f16021a;

    public C1091y(SnsLoginDialogFragment snsLoginDialogFragment) {
        this.f16021a = snsLoginDialogFragment;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        SnsLoginDialogFragment.OnResultListener onResultListener;
        String uri = webResourceRequest.getUrl().toString();
        if (uri.contains("https://www.tving.com")) {
            String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
            SnsLoginDialogFragment snsLoginDialogFragment = this.f16021a;
            if (cookie != null && (onResultListener = snsLoginDialogFragment.f15951v0) != null) {
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
