package p000;

import com.google.common.util.concurrent.AbstractFuture;

/* renamed from: h0 */
/* loaded from: classes2.dex */
public final class C1252h0 {

    /* renamed from: c */
    public static final C1252h0 f17897c;

    /* renamed from: d */
    public static final C1252h0 f17898d;

    /* renamed from: a */
    public final boolean f17899a;

    /* renamed from: b */
    public final RuntimeException f17900b;

    static {
        if (AbstractFuture.f15251d) {
            f17898d = null;
            f17897c = null;
        } else {
            f17898d = new C1252h0(false, null);
            f17897c = new C1252h0(true, null);
        }
    }

    public C1252h0(boolean z, RuntimeException runtimeException) {
        this.f17899a = z;
        this.f17900b = runtimeException;
    }
}
