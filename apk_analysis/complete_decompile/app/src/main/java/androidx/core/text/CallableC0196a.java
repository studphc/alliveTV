package androidx.core.text;

import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.Callable;

/* renamed from: androidx.core.text.a */
/* loaded from: classes.dex */
public final class CallableC0196a implements Callable {

    /* renamed from: a */
    public PrecomputedTextCompat.Params f3799a;

    /* renamed from: b */
    public CharSequence f3800b;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return PrecomputedTextCompat.create(this.f3800b, this.f3799a);
    }
}
