package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
import p000.o63;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class StatsAccumulator {

    /* renamed from: a */
    public long f15149a = 0;

    /* renamed from: b */
    public double f15150b = 0.0d;

    /* renamed from: c */
    public double f15151c = 0.0d;

    /* renamed from: d */
    public double f15152d = Double.NaN;

    /* renamed from: e */
    public double f15153e = Double.NaN;

    /* renamed from: a */
    public static double m4223a(double d, double d2) {
        if (Doubles.isFinite(d)) {
            return d2;
        }
        if (!Doubles.isFinite(d2) && d != d2) {
            return Double.NaN;
        }
        return d;
    }

    public void add(double d) {
        long j = this.f15149a;
        if (j == 0) {
            this.f15149a = 1L;
            this.f15150b = d;
            this.f15152d = d;
            this.f15153e = d;
            if (!Doubles.isFinite(d)) {
                this.f15151c = Double.NaN;
                return;
            }
            return;
        }
        this.f15149a = j + 1;
        if (Doubles.isFinite(d) && Doubles.isFinite(this.f15150b)) {
            double d2 = this.f15150b;
            double d3 = d - d2;
            double d4 = (d3 / this.f15149a) + d2;
            this.f15150b = d4;
            this.f15151c = ((d - d4) * d3) + this.f15151c;
        } else {
            this.f15150b = m4223a(this.f15150b, d);
            this.f15151c = Double.NaN;
        }
        this.f15152d = Math.min(this.f15152d, d);
        this.f15153e = Math.max(this.f15153e, d);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    /* renamed from: b */
    public final void m4224b(long j, double d, double d2, double d3, double d4) {
        long j2 = this.f15149a;
        if (j2 == 0) {
            this.f15149a = j;
            this.f15150b = d;
            this.f15151c = d2;
            this.f15152d = d3;
            this.f15153e = d4;
            return;
        }
        this.f15149a = j2 + j;
        if (Doubles.isFinite(this.f15150b) && Doubles.isFinite(d)) {
            double d5 = this.f15150b;
            double d6 = d - d5;
            double d7 = j;
            double d8 = ((d6 * d7) / this.f15149a) + d5;
            this.f15150b = d8;
            this.f15151c = ((d - d8) * d6 * d7) + d2 + this.f15151c;
        } else {
            this.f15150b = m4223a(this.f15150b, d);
            this.f15151c = Double.NaN;
        }
        this.f15152d = Math.min(this.f15152d, d3);
        this.f15153e = Math.max(this.f15153e, d4);
    }

    public long count() {
        return this.f15149a;
    }

    public double max() {
        boolean z;
        if (this.f15149a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15153e;
    }

    public double mean() {
        boolean z;
        if (this.f15149a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15150b;
    }

    public double min() {
        boolean z;
        if (this.f15149a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15152d;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        boolean z;
        if (this.f15149a != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (Double.isNaN(this.f15151c)) {
            return Double.NaN;
        }
        if (this.f15149a == 1) {
            return 0.0d;
        }
        return o63.m6469l(this.f15151c) / this.f15149a;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        boolean z;
        if (this.f15149a > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (Double.isNaN(this.f15151c)) {
            return Double.NaN;
        }
        return o63.m6469l(this.f15151c) / (this.f15149a - 1);
    }

    public Stats snapshot() {
        return new Stats(this.f15149a, this.f15150b, this.f15151c, this.f15152d, this.f15153e);
    }

    public final double sum() {
        return this.f15150b * this.f15149a;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d : dArr) {
            add(d);
        }
    }

    public void addAll(int... iArr) {
        for (int i : iArr) {
            add(i);
        }
    }

    public void addAll(long... jArr) {
        for (long j : jArr) {
            add(j);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        m4224b(stats.count(), stats.mean(), stats.f15146c, stats.min(), stats.max());
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() == 0) {
            return;
        }
        m4224b(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.f15151c, statsAccumulator.min(), statsAccumulator.max());
    }
}
