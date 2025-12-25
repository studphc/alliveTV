package p000;

import androidx.core.util.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* renamed from: x7 */
/* loaded from: classes.dex */
public final class C1973x7 extends AtomicBoolean implements Consumer {

    /* renamed from: a */
    public final Continuation f28451a;

    public C1973x7(Continuation continuation) {
        super(false);
        this.f28451a = continuation;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        if (compareAndSet(false, true)) {
            this.f28451a.resumeWith(Result.m8512constructorimpl(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
