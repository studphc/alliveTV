package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import okhttp3.HttpUrl;

@GwtIncompatible
/* loaded from: classes2.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public transient AtomicLongArray f15280a;

    public AtomicDoubleArray(int i) {
        this.f15280a = new AtomicLongArray(i);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i = 0; i < readInt; i++) {
            builder.add(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.f15280a = new AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeDouble(get(i));
        }
    }

    @CanIgnoreReturnValue
    public double addAndGet(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f15280a.get(i);
            longBitsToDouble = Double.longBitsToDouble(j) + d;
        } while (!this.f15280a.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i, double d, double d2) {
        return this.f15280a.compareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final double get(int i) {
        return Double.longBitsToDouble(this.f15280a.get(i));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.f15280a.get(i);
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!this.f15280a.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble + d)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i, double d) {
        return Double.longBitsToDouble(this.f15280a.getAndSet(i, Double.doubleToRawLongBits(d)));
    }

    public final void lazySet(int i, double d) {
        this.f15280a.lazySet(i, Double.doubleToRawLongBits(d));
    }

    public final int length() {
        return this.f15280a.length();
    }

    public final void set(int i, double d) {
        this.f15280a.set(i, Double.doubleToRawLongBits(d));
    }

    public String toString() {
        int length = length();
        int i = length - 1;
        if (i == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length * 19);
        sb.append('[');
        int i2 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.f15280a.get(i2)));
            if (i2 == i) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            i2++;
        }
    }

    public final boolean weakCompareAndSet(int i, double d, double d2) {
        return this.f15280a.weakCompareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = Double.doubleToRawLongBits(dArr[i]);
        }
        this.f15280a = new AtomicLongArray(jArr);
    }
}
