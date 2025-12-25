package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import p000.k81;
import p000.l81;
import p000.m81;
import p000.o63;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class LinearTransformation {

    /* loaded from: classes2.dex */
    public static final class LinearTransformationBuilder {

        /* renamed from: a */
        public final double f15124a;

        /* renamed from: b */
        public final double f15125b;

        public LinearTransformationBuilder(double d, double d2) {
            this.f15124a = d;
            this.f15125b = d2;
        }

        public LinearTransformation and(double d, double d2) {
            boolean z;
            boolean z2 = false;
            if (o63.m6475t(d) && o63.m6475t(d2)) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            double d3 = this.f15124a;
            double d4 = this.f15125b;
            if (d == d3) {
                if (d2 != d4) {
                    z2 = true;
                }
                Preconditions.checkArgument(z2);
                return new m81(d3);
            }
            return withSlope((d2 - d4) / (d - d3));
        }

        public LinearTransformation withSlope(double d) {
            Preconditions.checkArgument(!Double.isNaN(d));
            boolean m6475t = o63.m6475t(d);
            double d2 = this.f15124a;
            if (m6475t) {
                return new l81(d, this.f15125b - (d2 * d));
            }
            return new m81(d2);
        }
    }

    public static LinearTransformation forNaN() {
        return k81.f20778a;
    }

    public static LinearTransformation horizontal(double d) {
        Preconditions.checkArgument(o63.m6475t(d));
        return new l81(0.0d, d);
    }

    public static LinearTransformationBuilder mapping(double d, double d2) {
        boolean z;
        if (o63.m6475t(d) && o63.m6475t(d2)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new LinearTransformationBuilder(d, d2);
    }

    public static LinearTransformation vertical(double d) {
        Preconditions.checkArgument(o63.m6475t(d));
        return new m81(d);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);
}
