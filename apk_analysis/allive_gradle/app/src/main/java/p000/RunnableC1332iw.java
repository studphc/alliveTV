package p000;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* renamed from: iw */
/* loaded from: classes.dex */
public final class RunnableC1332iw extends AtomicBoolean implements Runnable {

    /* renamed from: a */
    public final Continuation f20284a;

    public RunnableC1332iw(Continuation continuation) {
        super(false);
        this.f20284a = continuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (compareAndSet(false, true)) {
            Result.Companion companion = Result.INSTANCE;
            this.f20284a.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
