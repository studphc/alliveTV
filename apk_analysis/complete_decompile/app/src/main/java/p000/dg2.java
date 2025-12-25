package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class dg2 extends SequenceScope implements Iterator, Continuation, KMappedMarker {

    /* renamed from: a */
    public int f16370a;

    /* renamed from: b */
    public Object f16371b;

    /* renamed from: c */
    public Iterator f16372c;

    /* renamed from: d */
    public Continuation f16373d;

    /* renamed from: a */
    public final RuntimeException m4582a() {
        int i = this.f16370a;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f16370a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext getF20923a() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f16370a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw m4582a();
                }
                Iterator it = this.f16372c;
                Intrinsics.checkNotNull(it);
                if (it.hasNext()) {
                    this.f16370a = 2;
                    return true;
                }
                this.f16372c = null;
            }
            this.f16370a = 5;
            Continuation continuation = this.f16373d;
            Intrinsics.checkNotNull(continuation);
            this.f16373d = null;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f16370a;
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.f16370a = 0;
                    Object obj = this.f16371b;
                    this.f16371b = null;
                    return obj;
                }
                throw m4582a();
            }
            this.f16370a = 1;
            Iterator it = this.f16372c;
            Intrinsics.checkNotNull(it);
            return it.next();
        }
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ResultKt.throwOnFailure(obj);
        this.f16370a = 4;
    }

    @Override // kotlin.sequences.SequenceScope
    public final Object yield(Object obj, Continuation continuation) {
        this.f16371b = obj;
        this.f16370a = 3;
        this.f16373d = continuation;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (coroutine_suspended == b51.getCOROUTINE_SUSPENDED()) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.sequences.SequenceScope
    public final Object yieldAll(Iterator it, Continuation continuation) {
        if (!it.hasNext()) {
            return Unit.INSTANCE;
        }
        this.f16372c = it;
        this.f16370a = 2;
        this.f16373d = continuation;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == b51.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (coroutine_suspended == b51.getCOROUTINE_SUSPENDED()) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
