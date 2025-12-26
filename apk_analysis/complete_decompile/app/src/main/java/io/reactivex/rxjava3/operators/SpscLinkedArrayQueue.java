package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: i */
    public static final int f19999i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    public static final Object f20000j = new Object();

    /* renamed from: a */
    public final AtomicLong f20001a;

    /* renamed from: b */
    public final int f20002b;

    /* renamed from: c */
    public long f20003c;

    /* renamed from: d */
    public final int f20004d;

    /* renamed from: e */
    public AtomicReferenceArray f20005e;

    /* renamed from: f */
    public final int f20006f;

    /* renamed from: g */
    public AtomicReferenceArray f20007g;

    /* renamed from: h */
    public final AtomicLong f20008h;

    public SpscLinkedArrayQueue(int i) {
        AtomicLong atomicLong = new AtomicLong();
        this.f20001a = atomicLong;
        this.f20008h = new AtomicLong();
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i));
        int i2 = roundToPowerOfTwo - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(roundToPowerOfTwo + 1);
        this.f20005e = atomicReferenceArray;
        this.f20004d = i2;
        this.f20002b = Math.min(roundToPowerOfTwo / 4, f19999i);
        this.f20007g = atomicReferenceArray;
        this.f20006f = i2;
        this.f20003c = roundToPowerOfTwo - 2;
        atomicLong.lazySet(0L);
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean isEmpty() {
        if (this.f20001a.get() == this.f20008h.get()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray atomicReferenceArray = this.f20005e;
            AtomicLong atomicLong = this.f20001a;
            long j = atomicLong.get();
            int i = this.f20004d;
            int i2 = ((int) j) & i;
            if (j < this.f20003c) {
                atomicReferenceArray.lazySet(i2, t);
                atomicLong.lazySet(j + 1);
                return true;
            }
            long j2 = this.f20002b + j;
            if (atomicReferenceArray.get(((int) j2) & i) == null) {
                this.f20003c = j2 - 1;
                atomicReferenceArray.lazySet(i2, t);
                atomicLong.lazySet(j + 1);
                return true;
            }
            long j3 = j + 1;
            if (atomicReferenceArray.get(((int) j3) & i) == null) {
                atomicReferenceArray.lazySet(i2, t);
                atomicLong.lazySet(j3);
                return true;
            }
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.f20005e = atomicReferenceArray2;
            this.f20003c = (j + i) - 1;
            atomicReferenceArray2.lazySet(i2, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i2, f20000j);
            atomicLong.lazySet(j3);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public T peek() {
        AtomicReferenceArray atomicReferenceArray = this.f20007g;
        int i = (int) this.f20008h.get();
        int i2 = this.f20006f;
        int i3 = i & i2;
        T t = (T) atomicReferenceArray.get(i3);
        if (t == f20000j) {
            int i4 = i2 + 1;
            AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i4);
            atomicReferenceArray.lazySet(i4, null);
            this.f20007g = atomicReferenceArray2;
            return (T) atomicReferenceArray2.get(i3);
        }
        return t;
    }

    @Override // io.reactivex.rxjava3.operators.SimplePlainQueue, io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public T poll() {
        boolean z;
        AtomicReferenceArray atomicReferenceArray = this.f20007g;
        AtomicLong atomicLong = this.f20008h;
        long j = atomicLong.get();
        int i = this.f20006f;
        int i2 = ((int) j) & i;
        T t = (T) atomicReferenceArray.get(i2);
        if (t == f20000j) {
            z = true;
        } else {
            z = false;
        }
        if (t != null && !z) {
            atomicReferenceArray.lazySet(i2, null);
            atomicLong.lazySet(j + 1);
            return t;
        }
        if (!z) {
            return null;
        }
        int i3 = i + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i3);
        atomicReferenceArray.lazySet(i3, null);
        this.f20007g = atomicReferenceArray2;
        T t2 = (T) atomicReferenceArray2.get(i2);
        if (t2 != null) {
            atomicReferenceArray2.lazySet(i2, null);
            atomicLong.lazySet(j + 1);
        }
        return t2;
    }

    public int size() {
        AtomicLong atomicLong = this.f20008h;
        long j = atomicLong.get();
        while (true) {
            long j2 = this.f20001a.get();
            long j3 = atomicLong.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean offer(T t, T t2) {
        AtomicReferenceArray atomicReferenceArray = this.f20005e;
        AtomicLong atomicLong = this.f20001a;
        long j = atomicLong.get();
        long j2 = 2 + j;
        int i = this.f20004d;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            int i2 = ((int) j) & i;
            atomicReferenceArray.lazySet(i2 + 1, t2);
            atomicReferenceArray.lazySet(i2, t);
            atomicLong.lazySet(j2);
        } else {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.f20005e = atomicReferenceArray2;
            int i3 = ((int) j) & i;
            atomicReferenceArray2.lazySet(i3 + 1, t2);
            atomicReferenceArray2.lazySet(i3, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i3, f20000j);
            atomicLong.lazySet(j2);
        }
        return true;
    }
}
