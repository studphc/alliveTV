package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {

    /* renamed from: a */
    public final long f15218a;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    public UnsignedLong(long j) {
        this.f15218a = j;
    }

    public static UnsignedLong fromLongBits(long j) {
        return new UnsignedLong(j);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long j) {
        Preconditions.checkArgument(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
        return fromLongBits(j);
    }

    public BigInteger bigIntegerValue() {
        long j = this.f15218a;
        BigInteger valueOf = BigInteger.valueOf(Long.MAX_VALUE & j);
        if (j < 0) {
            return valueOf.setBit(63);
        }
        return valueOf;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.f15218a, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).f15218a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j = this.f15218a;
        if (j >= 0) {
            return j;
        }
        return ((j >>> 1) | (j & 1)) * 2.0d;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof UnsignedLong) || this.f15218a != ((UnsignedLong) obj).f15218a) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j = this.f15218a;
        if (j >= 0) {
            return (float) j;
        }
        return ((float) ((j >>> 1) | (j & 1))) * 2.0f;
    }

    public int hashCode() {
        return Longs.hashCode(this.f15218a);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.f15218a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f15218a;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.f15218a - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).f15218a);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.f15218a, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).f15218a));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.f15218a + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).f15218a);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.f15218a * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).f15218a);
    }

    public String toString() {
        return UnsignedLongs.toString(this.f15218a);
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.f15218a, unsignedLong.f15218a);
    }

    public String toString(int i) {
        return UnsignedLongs.toString(this.f15218a, i);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str, int i) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i));
    }
}
