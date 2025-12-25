package com.google.common.hash;

import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;
import p000.C1195fh;
import p000.C1269hh;
import p000.C1306ih;
import p000.EnumC1354jh;

@Beta
/* loaded from: classes2.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {

    /* renamed from: a */
    public final C1306ih f15053a;

    /* renamed from: b */
    public final int f15054b;

    /* renamed from: c */
    public final Funnel f15055c;

    /* renamed from: d */
    public final EnumC1354jh f15056d;

    public BloomFilter(C1306ih c1306ih, int i, Funnel funnel, EnumC1354jh enumC1354jh) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "numHashFunctions (%s) must be > 0", i);
        Preconditions.checkArgument(i <= 255, "numHashFunctions (%s) must be <= 255", i);
        this.f15053a = (C1306ih) Preconditions.checkNotNull(c1306ih);
        this.f15054b = i;
        this.f15055c = (Funnel) Preconditions.checkNotNull(funnel);
        this.f15056d = (EnumC1354jh) Preconditions.checkNotNull(enumC1354jh);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i, double d) {
        return create(funnel, i, d);
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) {
        int i;
        int i2;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        int i3 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i2 = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    i3 = dataInputStream.readInt();
                    EnumC1354jh enumC1354jh = EnumC1354jh.values()[readByte];
                    C1306ih c1306ih = new C1306ih(LongMath.checkedMultiply(i3, 64L));
                    for (int i4 = 0; i4 < i3; i4++) {
                        c1306ih.m5243c(i4, dataInputStream.readLong());
                    }
                    return new BloomFilter<>(c1306ih, i2, funnel, enumC1354jh);
                } catch (RuntimeException e) {
                    e = e;
                    int i5 = i3;
                    i3 = readByte;
                    i = i5;
                    StringBuilder sb = new StringBuilder(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO);
                    sb.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                    sb.append(i3);
                    sb.append(" numHashFunctions: ");
                    sb.append(i2);
                    sb.append(" dataLength: ");
                    sb.append(i);
                    throw new IOException(sb.toString(), e);
                }
            } catch (RuntimeException e2) {
                e = e2;
                i2 = -1;
                i3 = readByte;
                i = -1;
            }
        } catch (RuntimeException e3) {
            e = e3;
            i = -1;
            i2 = -1;
        }
    }

    private Object writeReplace() {
        return new C1195fh(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        C1306ih c1306ih = this.f15053a;
        long m5241a = c1306ih.m5241a();
        double mo7361b = c1306ih.f18408b.mo7361b();
        double d = m5241a;
        return DoubleMath.roundToLong(((-Math.log1p(-(mo7361b / d))) * d) / this.f15054b, RoundingMode.HALF_UP);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(new C1306ih(C1306ih.m5240e(this.f15053a.f18407a)), this.f15054b, this.f15055c, this.f15056d);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        if (this.f15054b == bloomFilter.f15054b && this.f15055c.equals(bloomFilter.f15055c) && this.f15053a.equals(bloomFilter.f15053a) && this.f15056d.equals(bloomFilter.f15056d)) {
            return true;
        }
        return false;
    }

    public double expectedFpp() {
        C1306ih c1306ih = this.f15053a;
        return Math.pow(c1306ih.f18408b.mo7361b() / c1306ih.m5241a(), this.f15054b);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f15054b), this.f15055c, this.f15056d, this.f15053a);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        if (this != bloomFilter) {
            if (this.f15054b == bloomFilter.f15054b && this.f15053a.m5241a() == bloomFilter.f15053a.m5241a() && this.f15056d.equals(bloomFilter.f15056d) && this.f15055c.equals(bloomFilter.f15055c)) {
                return true;
            }
        }
        return false;
    }

    public boolean mightContain(T t) {
        return this.f15056d.mo4952a(t, this.f15055c, this.f15054b, this.f15053a);
    }

    @CanIgnoreReturnValue
    public boolean put(T t) {
        return this.f15056d.mo4953b(t, this.f15055c, this.f15054b, this.f15053a);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        boolean z;
        boolean z2;
        boolean z3;
        Preconditions.checkNotNull(bloomFilter);
        boolean z4 = true;
        if (this != bloomFilter) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Cannot combine a BloomFilter with itself.");
        int i = bloomFilter.f15054b;
        int i2 = this.f15054b;
        if (i2 == i) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "BloomFilters must have the same number of hash functions (%s != %s)", i2, i);
        C1306ih c1306ih = this.f15053a;
        long m5241a = c1306ih.m5241a();
        C1306ih c1306ih2 = bloomFilter.f15053a;
        if (m5241a == c1306ih2.m5241a()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "BloomFilters must have the same size underlying bit arrays (%s != %s)", c1306ih.m5241a(), c1306ih2.m5241a());
        EnumC1354jh enumC1354jh = this.f15056d;
        EnumC1354jh enumC1354jh2 = bloomFilter.f15056d;
        Preconditions.checkArgument(enumC1354jh.equals(enumC1354jh2), "BloomFilters must have equal strategies (%s != %s)", enumC1354jh, enumC1354jh2);
        Funnel funnel = this.f15055c;
        Funnel funnel2 = bloomFilter.f15055c;
        Preconditions.checkArgument(funnel.equals(funnel2), "BloomFilters must have equal funnels (%s != %s)", funnel, funnel2);
        AtomicLongArray atomicLongArray = c1306ih.f18407a;
        if (atomicLongArray.length() != c1306ih2.f18407a.length()) {
            z4 = false;
        }
        int length = atomicLongArray.length();
        AtomicLongArray atomicLongArray2 = c1306ih2.f18407a;
        Preconditions.checkArgument(z4, "BitArrays must be of equal length (%s != %s)", length, atomicLongArray2.length());
        for (int i3 = 0; i3 < atomicLongArray.length(); i3++) {
            c1306ih.m5243c(i3, atomicLongArray2.get(i3));
        }
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.f15056d.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.f15054b));
        C1306ih c1306ih = this.f15053a;
        dataOutputStream.writeInt(c1306ih.f18407a.length());
        for (int i = 0; i < c1306ih.f18407a.length(); i++) {
            dataOutputStream.writeLong(c1306ih.f18407a.get(i));
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d) {
        C1269hh c1269hh = EnumC1354jh.f20499a;
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(j >= 0, "Expected insertions (%s) must be >= 0", j);
        Preconditions.checkArgument(d > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d));
        Preconditions.checkArgument(d < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d));
        Preconditions.checkNotNull(c1269hh);
        if (j == 0) {
            j = 1;
        }
        if (d == 0.0d) {
            d = Double.MIN_VALUE;
        }
        long log = (long) ((Math.log(d) * (-j)) / (Math.log(2.0d) * Math.log(2.0d)));
        try {
            return new BloomFilter<>(new C1306ih(log), Math.max(1, (int) Math.round(Math.log(2.0d) * (log / j))), funnel, c1269hh);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder(57);
            sb.append("Could not create BloomFilter of ");
            sb.append(log);
            sb.append(" bits");
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i) {
        return create(funnel, i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }
}
