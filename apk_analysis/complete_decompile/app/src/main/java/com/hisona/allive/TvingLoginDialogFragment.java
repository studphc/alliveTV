package com.hisona.allive;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import p000.t30;
import p000.yk2;
import p000.zk2;

/* loaded from: classes2.dex */
public class TvingLoginDialogFragment extends DialogFragment {

    /* renamed from: u0 */
    public WebView f15957u0;

    /* renamed from: v0 */
    public OnResultListener f15958v0;

    /* loaded from: classes2.dex */
    public interface OnResultListener {
        void onResult(String str);
    }

    public static TvingLoginDialogFragment newInstance() {
        return new TvingLoginDialogFragment();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    @SuppressLint({"SetJavaScriptEnabled"})
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_snslogin, (ViewGroup) null);
        WebView webView = (WebView) inflate.findViewById(R.id.webview);
        this.f15957u0 = webView;
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(getResources().getString(R.string.USERAGENT));
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(0);
        this.f15957u0.setWebViewClient(new C1067b0(this));
        this.f15957u0.setWebChromeClient(new WebChromeClient());
        this.f15957u0.setNetworkAvailable(true);
        this.f15957u0.clearCache(true);
        this.f15957u0.clearHistory();
        CookieManager.getInstance().removeAllCookies(new yk2(1));
        CookieManager.getInstance().flush();
        this.f15957u0.requestFocus();
        this.f15957u0.setFocusable(true);
        this.f15957u0.setFocusableInTouchMode(true);
        this.f15957u0.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        this.f15957u0.loadUrl("https://www.tving.com/account/login?returnUrl=https://www.tving.com");
        AlertDialog create = new AlertDialog.Builder(getActivity(), 2131951929).setTitle(getResources().getString(R.string.tvinglogin_title)).setView(inflate).setNegativeButton(android.R.string.cancel, new zk2(this, 1)).create();
        create.setOnCancelListener(new t30(3, this));
        return create;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        getDialog().setOnDismissListener(onDismissListener);
    }

    public void setResultListener(OnResultListener onResultListener) {
        this.f15958v0 = onResultListener;
    }
}
