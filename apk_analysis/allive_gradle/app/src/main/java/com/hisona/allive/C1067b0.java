package com.hisona.allive;

import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.hisona.allive.TvingLoginDialogFragment;

/* renamed from: com.hisona.allive.b0 */
/* loaded from: classes2.dex */
public final class C1067b0 extends WebViewClient {

    /* renamed from: a */
    public final /* synthetic */ TvingLoginDialogFragment f15974a;

    public C1067b0(TvingLoginDialogFragment tvingLoginDialogFragment) {
        this.f15974a = tvingLoginDialogFragment;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        TvingLoginDialogFragment.OnResultListener onResultListener;
        if (webResourceRequest.getUrl().toString().contains("https://www.tving.com")) {
            String cookie = CookieManager.getInstance().getCookie("https://www.tving.com/");
            TvingLoginDialogFragment tvingLoginDialogFragment = this.f15974a;
            if (cookie != null && (onResultListener = tvingLoginDialogFragment.f15958v0) != null) {
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
