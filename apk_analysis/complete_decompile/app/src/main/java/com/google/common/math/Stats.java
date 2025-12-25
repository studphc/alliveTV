package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import p000.o63;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class Stats implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final long f15144a;

    /* renamed from: b */
    public final double f15145b;

    /* renamed from: c */
    public final double f15146c;

    /* renamed from: d */
    public final double f15147d;

    /* renamed from: e */
    public final double f15148e;

    public Stats(long j, double d, double d2, double d3, double d4) {
        this.f15144a = j;
        this.f15145b = d;
        this.f15146c = d2;
        this.f15147d = d3;
        this.f15148e = d4;
    }

    /* renamed from: a */
    public static Stats m4216a(ByteBuffer byteBuffer) {
        boolean z;
        Preconditions.checkNotNull(byteBuffer);
        if (byteBuffer.remaining() >= 40) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public static Stats fromByteArray(byte[] bArr) {
        boolean z;
        Preconditions.checkNotNull(bArr);
        if (bArr.length == 40) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return m4216a(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    /* renamed from: of */
    public static Stats m4217of(Iterable<? extends Number> iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    /* renamed from: b */
    public final void m4222b(ByteBuffer byteBuffer) {
        boolean z;
        Preconditions.checkNotNull(byteBuffer);
        if (byteBuffer.remaining() >= 40) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.f15144a).putDouble(this.f15145b).putDouble(this.f15146c).putDouble(this.f15147d).putDouble(this.f15148e);
    }

    public long count() {
        return this.f15144a;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        if (this.f15144a != stats.f15144a || Double.doubleToLongBits(this.f15145b) != Double.doubleToLongBits(stats.f15145b) || Double.doubleToLongBits(this.f15146c) != Double.doubleToLongBits(stats.f15146c) || Double.doubleToLongBits(this.f15147d) != Double.doubleToLongBits(stats.f15147d) || Double.doubleToLongBits(this.f15148e) != Double.doubleToLongBits(stats.f15148e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f15144a), Double.valueOf(this.f15145b), Double.valueOf(this.f15146c), Double.valueOf(this.f15147d), Double.valueOf(this.f15148e));
    }

    public double max() {
        boolean z;
        if (this.f15144a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15148e;
    }

    public double mean() {
        boolean z;
        if (this.f15144a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15145b;
    }

    public double min() {
        boolean z;
        if (this.f15144a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15147d;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        boolean z;
        long j = this.f15144a;
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        double d = this.f15146c;
        if (Double.isNaN(d)) {
            return Double.NaN;
        }
        if (j == 1) {
            return 0.0d;
        }
        return o63.m6469l(d) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        boolean z;
        if (this.f15144a > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        double d = this.f15146c;
        if (Double.isNaN(d)) {
            return Double.NaN;
        }
        return o63.m6469l(d) / (r0 - 1);
    }

    public double sum() {
        return this.f15145b * this.f15144a;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        m4222b(order);
        return order.array();
    }

    public String toString() {
        long count = count();
        long j = this.f15144a;
        if (count > 0) {
            return MoreObjects.toStringHelper(this).add("count", j).add("mean", this.f15145b).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.f15147d).add("max", this.f15148e).toString();
        }
        return MoreObjects.toStringHelper(this).add("count", j).toString();
    }

    public static double meanOf(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j++;
            doubleValue = (Doubles.isFinite(doubleValue2) && Doubles.isFinite(doubleValue)) ? ((doubleValue2 - doubleValue) / j) + doubleValue : StatsAccumulator.m4223a(doubleValue, doubleValue2);
        }
        return doubleValue;
    }

    /* renamed from: of */
    public static Stats m4218of(Iterator<? extends Number> it) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(it);
        return statsAccumulator.snapshot();
    }

    /* renamed from: of */
    public static Stats m4219of(double... dArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(dArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d2 = dArr[i];
            d = (Doubles.isFinite(d2) && Doubles.isFinite(d)) ? ((d2 - d) / (i + 1)) + d : StatsAccumulator.m4223a(d, d2);
        }
        return d;
    }

    /* renamed from: of */
    public static Stats m4220of(int... iArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iArr);
        return statsAccumulator.snapshot();
    }

    /* renamed from: of */
    public static Stats m4221of(long... jArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(jArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        double d = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d2 = iArr[i];
            d = (Doubles.isFinite(d2) && Doubles.isFinite(d)) ? ((d2 - d) / (i + 1)) + d : StatsAccumulator.m4223a(d, d2);
        }
        return d;
    }

    public static double meanOf(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        double d = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d2 = jArr[i];
            d = (Doubles.isFinite(d2) && Doubles.isFinite(d)) ? ((d2 - d) / (i + 1)) + d : StatsAccumulator.m4223a(d, d2);
        }
        return d;
    }
}
