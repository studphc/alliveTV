package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class PairedStatsAccumulator {

    /* renamed from: a */
    public final StatsAccumulator f15136a = new StatsAccumulator();

    /* renamed from: b */
    public final StatsAccumulator f15137b = new StatsAccumulator();

    /* renamed from: c */
    public double f15138c = 0.0d;

    public void add(double d, double d2) {
        StatsAccumulator statsAccumulator = this.f15136a;
        statsAccumulator.add(d);
        boolean isFinite = Doubles.isFinite(d);
        StatsAccumulator statsAccumulator2 = this.f15137b;
        if (isFinite && Doubles.isFinite(d2)) {
            if (statsAccumulator.count() > 1) {
                this.f15138c = ((d2 - statsAccumulator2.mean()) * (d - statsAccumulator.mean())) + this.f15138c;
            }
        } else {
            this.f15138c = Double.NaN;
        }
        statsAccumulator2.add(d2);
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        Stats xStats = pairedStats.xStats();
        StatsAccumulator statsAccumulator = this.f15136a;
        statsAccumulator.addAll(xStats);
        StatsAccumulator statsAccumulator2 = this.f15137b;
        long count = statsAccumulator2.count();
        double d = pairedStats.f15135c;
        if (count == 0) {
            this.f15138c = d;
        } else {
            this.f15138c = ((pairedStats.yStats().mean() - statsAccumulator2.mean()) * (pairedStats.xStats().mean() - statsAccumulator.mean()) * pairedStats.count()) + d + this.f15138c;
        }
        statsAccumulator2.addAll(pairedStats.yStats());
    }

    public long count() {
        return this.f15136a.count();
    }

    public final LinearTransformation leastSquaresFit() {
        boolean z;
        boolean z2 = false;
        if (count() > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (Double.isNaN(this.f15138c)) {
            return LinearTransformation.forNaN();
        }
        StatsAccumulator statsAccumulator = this.f15136a;
        double d = statsAccumulator.f15151c;
        StatsAccumulator statsAccumulator2 = this.f15137b;
        if (d > 0.0d) {
            if (statsAccumulator2.f15151c > 0.0d) {
                return LinearTransformation.mapping(statsAccumulator.mean(), statsAccumulator2.mean()).withSlope(this.f15138c / d);
            }
            return LinearTransformation.horizontal(statsAccumulator2.mean());
        }
        if (statsAccumulator2.f15151c > 0.0d) {
            z2 = true;
        }
        Preconditions.checkState(z2);
        return LinearTransformation.vertical(statsAccumulator.mean());
    }

    public final double pearsonsCorrelationCoefficient() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (count() > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (Double.isNaN(this.f15138c)) {
            return Double.NaN;
        }
        double d = this.f15136a.f15151c;
        double d2 = this.f15137b.f15151c;
        if (d > 0.0d) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        if (d2 > 0.0d) {
            z3 = true;
        }
        Preconditions.checkState(z3);
        double d3 = d * d2;
        if (d3 <= 0.0d) {
            d3 = Double.MIN_VALUE;
        }
        return Doubles.constrainToRange(this.f15138c / Math.sqrt(d3), -1.0d, 1.0d);
    }

    public double populationCovariance() {
        boolean z;
        if (count() != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15138c / count();
    }

    public final double sampleCovariance() {
        boolean z;
        if (count() > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.f15138c / (count() - 1);
    }

    public PairedStats snapshot() {
        return new PairedStats(this.f15136a.snapshot(), this.f15137b.snapshot(), this.f15138c);
    }

    public Stats xStats() {
        return this.f15136a.snapshot();
    }

    public Stats yStats() {
        return this.f15137b.snapshot();
    }
}
