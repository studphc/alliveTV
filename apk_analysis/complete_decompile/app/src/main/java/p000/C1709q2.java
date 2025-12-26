package p000;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.CancellationException;

/* renamed from: q2 */
/* loaded from: classes.dex */
public final class C1709q2 {

    /* renamed from: c */
    public static final C1709q2 f25409c;

    /* renamed from: d */
    public static final C1709q2 f25410d;

    /* renamed from: a */
    public final boolean f25411a;

    /* renamed from: b */
    public final CancellationException f25412b;

    static {
        if (AbstractResolvableFuture.f1804d) {
            f25410d = null;
            f25409c = null;
        } else {
            f25410d = new C1709q2(false, null);
            f25409c = new C1709q2(true, null);
        }
    }

    public C1709q2(boolean z, CancellationException cancellationException) {
        this.f25411a = z;
        this.f25412b = cancellationException;
    }
}
