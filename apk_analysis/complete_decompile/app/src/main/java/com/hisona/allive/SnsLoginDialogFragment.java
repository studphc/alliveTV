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
public class SnsLoginDialogFragment extends DialogFragment {

    /* renamed from: u0 */
    public WebView f15950u0;

    /* renamed from: v0 */
    public OnResultListener f15951v0;

    /* loaded from: classes2.dex */
    public interface OnResultListener {
        void onResult(String str);
    }

    public static SnsLoginDialogFragment newInstance() {
        return new SnsLoginDialogFragment();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    @SuppressLint({"SetJavaScriptEnabled"})
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_snslogin, (ViewGroup) null);
        WebView webView = (WebView) inflate.findViewById(R.id.webview);
        this.f15950u0 = webView;
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(getResources().getString(R.string.USERAGENT));
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        this.f15950u0.setWebViewClient(new C1091y(this));
        this.f15950u0.setWebChromeClient(new WebChromeClient());
        this.f15950u0.setNetworkAvailable(true);
        this.f15950u0.clearCache(true);
        this.f15950u0.clearHistory();
        CookieManager.getInstance().removeAllCookies(new yk2(0));
        CookieManager.getInstance().flush();
        this.f15950u0.requestFocus();
        this.f15950u0.setFocusable(true);
        this.f15950u0.setFocusableInTouchMode(true);
        this.f15950u0.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        this.f15950u0.loadUrl("https://www.wavve.com/member/login");
        AlertDialog create = new AlertDialog.Builder(getActivity(), 2131951929).setTitle(getResources().getString(R.string.snslogin_title)).setView(inflate).setNegativeButton(android.R.string.cancel, new zk2(this, 0)).create();
        create.setOnCancelListener(new t30(2, this));
        return create;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        getDialog().setOnDismissListener(onDismissListener);
    }

    public void setResultListener(OnResultListener onResultListener) {
        this.f15951v0 = onResultListener;
    }
}
