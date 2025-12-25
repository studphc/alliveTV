package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.FontsContractCompat;
import p000.o63;

/* renamed from: androidx.core.provider.c */
/* loaded from: classes.dex */
public final class C0188c {

    /* renamed from: a */
    public final FontsContractCompat.FontRequestCallback f3744a;

    /* renamed from: b */
    public final Handler f3745b;

    public C0188c(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.f3744a = fontRequestCallback;
        this.f3745b = handler;
    }

    /* renamed from: a */
    public final void m881a(C0192g c0192g) {
        int i = c0192g.f3753b;
        Handler handler = this.f3745b;
        FontsContractCompat.FontRequestCallback fontRequestCallback = this.f3744a;
        if (i == 0) {
            handler.post(new RunnableC0186a(fontRequestCallback, c0192g.f3752a));
        } else {
            handler.post(new RunnableC0187b(fontRequestCallback, i));
        }
    }

    public C0188c(FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.f3744a = fontRequestCallback;
        this.f3745b = o63.m6466i();
    }
}
