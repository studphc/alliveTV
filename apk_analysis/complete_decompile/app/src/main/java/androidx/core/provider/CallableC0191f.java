package androidx.core.provider;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: androidx.core.provider.f */
/* loaded from: classes.dex */
public final class CallableC0191f implements Callable {

    /* renamed from: a */
    public final /* synthetic */ String f3748a;

    /* renamed from: b */
    public final /* synthetic */ Context f3749b;

    /* renamed from: c */
    public final /* synthetic */ FontRequest f3750c;

    /* renamed from: d */
    public final /* synthetic */ int f3751d;

    public CallableC0191f(String str, Context context, FontRequest fontRequest, int i) {
        this.f3748a = str;
        this.f3749b = context;
        this.f3750c = fontRequest;
        this.f3751d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        try {
            return AbstractC0193h.m884a(this.f3748a, this.f3749b, this.f3750c, this.f3751d);
        } catch (Throwable unused) {
            return new C0192g(-3);
        }
    }
}
