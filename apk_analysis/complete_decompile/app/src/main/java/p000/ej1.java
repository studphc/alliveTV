package p000;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ej1 extends AtomicReferenceArray implements fj1 {
    private static final long serialVersionUID = -7969063454040569579L;

    /* renamed from: a */
    public final AtomicInteger f16849a;

    /* renamed from: b */
    public int f16850b;

    public ej1(int i) {
        super(i);
        this.f16849a = new AtomicInteger();
    }

    @Override // p000.fj1
    /* renamed from: b */
    public final int mo2257b() {
        return this.f16849a.get();
    }

    @Override // p000.fj1
    /* renamed from: c */
    public final void mo2258c() {
        int i = this.f16850b;
        lazySet(i, null);
        this.f16850b = i + 1;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // p000.fj1
    /* renamed from: d */
    public final int mo2259d() {
        return this.f16850b;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean isEmpty() {
        if (this.f16850b == this.f16849a.get()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public final boolean offer(Object obj) {
        Objects.requireNonNull(obj, "value is null");
        int andIncrement = this.f16849a.getAndIncrement();
        if (andIncrement >= length()) {
            return false;
        }
        lazySet(andIncrement, obj);
        return true;
    }

    @Override // p000.fj1
    public final Object peek() {
        int i = this.f16850b;
        if (i == length()) {
            return null;
        }
        return get(i);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final Object poll() {
        int i = this.f16850b;
        if (i == length()) {
            return null;
        }
        AtomicInteger atomicInteger = this.f16849a;
        do {
            Object obj = get(i);
            if (obj != null) {
                this.f16850b = i + 1;
                lazySet(i, null);
                return obj;
            }
        } while (atomicInteger.get() != i);
        return null;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
