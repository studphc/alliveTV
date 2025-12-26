package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class PairedStats implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Stats f15133a;

    /* renamed from: b */
    public final Stats f15134b;

    /* renamed from: c */
    public final double f15135c;

    public PairedStats(Stats stats, Stats stats2, double d) {
        this.f15133a = stats;
        this.f15134b = stats2;
        this.f15135c = d;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        boolean z;
        Preconditions.checkNotNull(bArr);
        if (bArr.length == 88) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.m4216a(order), Stats.m4216a(order), order.getDouble());
    }

    public long count() {
        return this.f15133a.count();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        if (!this.f15133a.equals(pairedStats.f15133a) || !this.f15134b.equals(pairedStats.f15134b) || Double.doubleToLongBits(this.f15135c) != Double.doubleToLongBits(pairedStats.f15135c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f15133a, this.f15134b, Double.valueOf(this.f15135c));
    }

    public LinearTransformation leastSquaresFit() {
        boolean z;
        boolean z2 = false;
        if (count() > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        double d = this.f15135c;
        if (Double.isNaN(d)) {
            return LinearTransformation.forNaN();
        }
        Stats stats = this.f15133a;
        double d2 = stats.f15146c;
        Stats stats2 = this.f15134b;
        if (d2 > 0.0d) {
            if (stats2.f15146c > 0.0d) {
                return LinearTransformation.mapping(stats.mean(), stats2.mean()).withSlope(d / d2);
            }
            return LinearTransformation.horizontal(stats2.mean());
        }
        if (stats2.f15146c > 0.0d) {
            z2 = true;
        }
        Preconditions.checkState(z2);
        return LinearTransformation.vertical(stats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (count() > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        double d = this.f15135c;
        if (Double.isNaN(d)) {
            return Double.NaN;
        }
        double d2 = xStats().f15146c;
        double d3 = yStats().f15146c;
        if (d2 > 0.0d) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        if (d3 > 0.0d) {
            z3 = true;
        }
        Preconditions.checkState(z3);
        double d4 = d2 * d3;
        if (d4 <= 0.0d) {
            d4 = Double.MIN_VALUE;
        }
        double sqrt = d / Math.sqrt(d4);
        double d5 = 1.0d;
        if (sqrt < 1.0d) {
            d5 = -1.0d;
            if (sqrt > -1.0d) {
                return sqrt;
            }
        }
        return d5;
    }

    public double populationCovariance() {
        boolean z;
        if (count() != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15135c / count();
    }

    public double sampleCovariance() {
        boolean z;
        if (count() > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15135c / (count() - 1);
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.f15133a.m4222b(order);
        this.f15134b.m4222b(order);
        order.putDouble(this.f15135c);
        return order.array();
    }

    public String toString() {
        long count = count();
        Stats stats = this.f15134b;
        Stats stats2 = this.f15133a;
        if (count > 0) {
            return MoreObjects.toStringHelper(this).add("xStats", stats2).add("yStats", stats).add("populationCovariance", populationCovariance()).toString();
        }
        return MoreObjects.toStringHelper(this).add("xStats", stats2).add("yStats", stats).toString();
    }

    public Stats xStats() {
        return this.f15133a;
    }

    public Stats yStats() {
        return this.f15134b;
    }
}
