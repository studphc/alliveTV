package p000;

import android.p001os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* renamed from: hw */
/* loaded from: classes.dex */
public final class C1284hw extends AtomicBoolean implements OutcomeReceiver {

    /* renamed from: a */
    public final Continuation f18203a;

    public C1284hw(Continuation continuation) {
        super(false);
        this.f18203a = continuation;
    }

    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            Continuation continuation = this.f18203a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f18203a.resumeWith(Result.m8512constructorimpl(obj));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
