package p000;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* loaded from: classes2.dex */
public final class qm2 implements Continuation, CoroutineStackFrame {

    /* renamed from: a */
    public final Continuation f25687a;

    /* renamed from: b */
    public final CoroutineContext f25688b;

    public qm2(Continuation continuation, CoroutineContext coroutineContext) {
        this.f25687a = continuation;
        this.f25688b = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f25687a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f25688b;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f25687a.resumeWith(obj);
    }
}
