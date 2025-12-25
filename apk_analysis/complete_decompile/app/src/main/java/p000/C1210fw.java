package p000;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* renamed from: fw */
/* loaded from: classes.dex */
public final class C1210fw extends AtomicBoolean implements Consumer {

    /* renamed from: a */
    public final Continuation f17414a;

    public C1210fw(Continuation continuation) {
        super(false);
        this.f17414a = continuation;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (compareAndSet(false, true)) {
            this.f17414a.resumeWith(Result.m8512constructorimpl(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
