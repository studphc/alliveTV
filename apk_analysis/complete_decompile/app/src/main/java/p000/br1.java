package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes2.dex */
public final class br1 implements CancellableContinuation, Waiter {

    /* renamed from: a */
    public final CancellableContinuationImpl f8142a;

    /* renamed from: b */
    public final Object f8143b;

    /* renamed from: c */
    public final /* synthetic */ MutexImpl f8144c;

    public br1(MutexImpl mutexImpl, CancellableContinuationImpl cancellableContinuationImpl, Object obj) {
        this.f8144c = mutexImpl;
        this.f8142a = cancellableContinuationImpl;
        this.f8143b = obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean cancel(Throwable th) {
        return this.f8142a.cancel(th);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void completeResume(Object obj) {
        this.f8142a.completeResume(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f8142a.getContext();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void initCancellability() {
        this.f8142a.initCancellability();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void invokeOnCancellation(Function1 function1) {
        this.f8142a.invokeOnCancellation(function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isActive() {
        return this.f8142a.isActive();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCancelled() {
        return this.f8142a.isCancelled();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final boolean isCompleted() {
        return this.f8142a.isCompleted();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resume(Object obj, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = MutexImpl.f22113i;
        Object obj2 = this.f8143b;
        MutexImpl mutexImpl = this.f8144c;
        atomicReferenceFieldUpdater.set(mutexImpl, obj2);
        ar1 ar1Var = new ar1(mutexImpl, this, 0);
        this.f8142a.resume((Unit) obj, ar1Var);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Object obj) {
        this.f8142a.resumeUndispatched(coroutineDispatcher, (Unit) obj);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable th) {
        this.f8142a.resumeUndispatchedWithException(coroutineDispatcher, th);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f8142a.resumeWith(obj);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResume(Object obj, Object obj2) {
        return this.f8142a.tryResume((Unit) obj, obj2);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResumeWithException(Throwable th) {
        return this.f8142a.tryResumeWithException(th);
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        this.f8142a.invokeOnCancellation(segment, i);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Object tryResume(Object obj, Object obj2, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        MutexImpl mutexImpl = this.f8144c;
        ar1 ar1Var = new ar1(mutexImpl, this, 1);
        Object tryResume = this.f8142a.tryResume((Unit) obj, obj2, ar1Var);
        if (tryResume != null) {
            atomicReferenceFieldUpdater = MutexImpl.f22113i;
            atomicReferenceFieldUpdater.set(mutexImpl, this.f8143b);
        }
        return tryResume;
    }
}
