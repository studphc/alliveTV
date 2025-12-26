package androidx.core.provider;

import androidx.core.provider.FontsContractCompat;

/* renamed from: androidx.core.provider.b */
/* loaded from: classes.dex */
public final class RunnableC0187b implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ FontsContractCompat.FontRequestCallback f3742a;

    /* renamed from: b */
    public final /* synthetic */ int f3743b;

    public RunnableC0187b(FontsContractCompat.FontRequestCallback fontRequestCallback, int i) {
        this.f3742a = fontRequestCallback;
        this.f3743b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3742a.onTypefaceRequestFailed(this.f3743b);
    }
}
