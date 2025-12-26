package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {

    /* renamed from: f */
    public static final Integer f19993f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: a */
    public final int f19994a;

    /* renamed from: b */
    public final AtomicLong f19995b;

    /* renamed from: c */
    public long f19996c;

    /* renamed from: d */
    public final AtomicLong f19997d;

    /* renamed from: e */
    public final int f19998e;

    public SpscArrayQueue(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        this.f19994a = length() - 1;
        this.f19995b = new AtomicLong();
        this.f19997d = new AtomicLong();
        this.f19998e = Math.min(i / 4, f19993f.intValue());
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
        if (this.f19995b.get() == this.f19997d.get()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue, java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            AtomicLong atomicLong = this.f19995b;
            long j = atomicLong.get();
            int i = this.f19994a;
            int i2 = ((int) j) & i;
            if (j >= this.f19996c) {
                long j2 = this.f19998e + j;
                if (get(i & ((int) j2)) == null) {
                    this.f19996c = j2;
                } else if (get(i2) != null) {
                    return false;
                }
            }
            lazySet(i2, e);
            atomicLong.lazySet(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.rxjava3.operators.SimplePlainQueue, io.reactivex.rxjava3.operators.SimpleQueue
    @Nullable
    public E poll() {
        AtomicLong atomicLong = this.f19997d;
        long j = atomicLong.get();
        int i = ((int) j) & this.f19994a;
        E e = get(i);
        if (e == null) {
            return null;
        }
        atomicLong.lazySet(j + 1);
        lazySet(i, null);
        return e;
    }

    @Override // io.reactivex.rxjava3.operators.SimpleQueue
    public boolean offer(E e, E e2) {
        return offer(e) && offer(e2);
    }
}
