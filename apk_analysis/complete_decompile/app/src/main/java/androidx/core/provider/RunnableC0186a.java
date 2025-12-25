package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.FontsContractCompat;

/* renamed from: androidx.core.provider.a */
/* loaded from: classes.dex */
public final class RunnableC0186a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ FontsContractCompat.FontRequestCallback f3740a;

    /* renamed from: b */
    public final /* synthetic */ Typeface f3741b;

    public RunnableC0186a(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
        this.f3740a = fontRequestCallback;
        this.f3741b = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3740a.onTypefaceRetrieved(this.f3741b);
    }
}
