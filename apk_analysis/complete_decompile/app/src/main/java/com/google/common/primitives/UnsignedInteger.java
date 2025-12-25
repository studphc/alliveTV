package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {

    /* renamed from: a */
    public final int f15217a;
    public static final UnsignedInteger ZERO = fromIntBits(0);
    public static final UnsignedInteger ONE = fromIntBits(1);
    public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);

    public UnsignedInteger(int i) {
        this.f15217a = i;
    }

    public static UnsignedInteger fromIntBits(int i) {
        return new UnsignedInteger(i);
    }

    public static UnsignedInteger valueOf(long j) {
        Preconditions.checkArgument((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.divide(this.f15217a, ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).f15217a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof UnsignedInteger) || this.f15217a != ((UnsignedInteger) obj).f15217a) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) longValue();
    }

    public int hashCode() {
        return this.f15217a;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f15217a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.toLong(this.f15217a);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.f15217a - ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).f15217a);
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.remainder(this.f15217a, ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).f15217a));
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.f15217a + ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).f15217a);
    }

    @GwtIncompatible
    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.f15217a * ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).f15217a);
    }

    public String toString() {
        return toString(10);
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.checkNotNull(unsignedInteger);
        return UnsignedInts.compare(this.f15217a, unsignedInteger.f15217a);
    }

    public String toString(int i) {
        return UnsignedInts.toString(this.f15217a, i);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return fromIntBits(bigInteger.intValue());
    }

    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedInteger valueOf(String str, int i) {
        return fromIntBits(UnsignedInts.parseUnsignedInt(str, i));
    }
}
