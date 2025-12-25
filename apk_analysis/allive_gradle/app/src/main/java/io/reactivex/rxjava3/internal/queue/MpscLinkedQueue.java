package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;
import p000.np1;

/* loaded from: classes2.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: a */
    public final AtomicReference f19827a;

    /* renamed from: b */
    public final AtomicReference f19828b;

    public MpscLinkedQueue() {
        AtomicReference atomicReference = new AtomicReference();
        this.f19827a = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        this.f19828b = atomicReference2;
        AtomicReference atomicReference3 = new AtomicReference();
        atomicReference2.lazySet(atomicReference3);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean isEmpty() {
        if (((np1) this.f19828b.get()) == ((np1) this.f19827a.get())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.concurrent.atomic.AtomicReference, np1] */
    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public boolean offer(T t) {
        if (t != null) {
            ?? atomicReference = new AtomicReference();
            atomicReference.f23449a = t;
            ((np1) this.f19827a.getAndSet(atomicReference)).lazySet(atomicReference);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.rxjava3.operators.SimplePlainQueue, io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public T poll() {
        np1 np1Var;
        AtomicReference atomicReference = this.f19828b;
        np1 np1Var2 = (np1) atomicReference.get();
        np1 np1Var3 = (np1) np1Var2.get();
        if (np1Var3 != null) {
            T t = (T) np1Var3.f23449a;
            np1Var3.f23449a = null;
            atomicReference.lazySet(np1Var3);
            return t;
        }
        if (np1Var2 == ((np1) this.f19827a.get())) {
            return null;
        }
        do {
            np1Var = (np1) np1Var2.get();
        } while (np1Var == null);
        T t2 = (T) np1Var.f23449a;
        np1Var.f23449a = null;
        atomicReference.lazySet(np1Var);
        return t2;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }
}
