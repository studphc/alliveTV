package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;
import p000.j21;

@Immutable
@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class ImmutableDoubleArray implements Serializable {

    /* renamed from: d */
    public static final ImmutableDoubleArray f15197d = new ImmutableDoubleArray(new double[0], 0, 0);

    /* renamed from: a */
    public final double[] f15198a;

    /* renamed from: b */
    public final transient int f15199b;

    /* renamed from: c */
    public final int f15200c;

    public ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    /* renamed from: a */
    public static boolean m4245a(double d, double d2) {
        if (Double.doubleToLongBits(d) == Double.doubleToLongBits(d2)) {
            return true;
        }
        return false;
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return f15197d;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4246of() {
        return f15197d;
    }

    public List<Double> asList() {
        return new j21(this);
    }

    public boolean contains(double d) {
        if (indexOf(d) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!m4245a(get(i), immutableDoubleArray.get(i))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.f15198a[this.f15199b + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.f15199b; i2 < this.f15200c; i2++) {
            i = (i * 31) + Doubles.hashCode(this.f15198a[i2]);
        }
        return i;
    }

    public int indexOf(double d) {
        int i = this.f15199b;
        for (int i2 = i; i2 < this.f15200c; i2++) {
            if (m4245a(this.f15198a[i2], d)) {
                return i2 - i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f15200c == this.f15199b) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(double d) {
        int i;
        int i2 = this.f15200c;
        do {
            i2--;
            i = this.f15199b;
            if (i2 < i) {
                return -1;
            }
        } while (!m4245a(this.f15198a[i2], d));
        return i2 - i;
    }

    public int length() {
        return this.f15200c - this.f15199b;
    }

    public Object readResolve() {
        if (isEmpty()) {
            return f15197d;
        }
        return this;
    }

    public ImmutableDoubleArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return f15197d;
        }
        int i3 = this.f15199b;
        return new ImmutableDoubleArray(this.f15198a, i + i3, i3 + i2);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.f15198a, this.f15199b, this.f15200c);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        double[] dArr = this.f15198a;
        int i = this.f15199b;
        sb.append(dArr[i]);
        while (true) {
            i++;
            if (i < this.f15200c) {
                sb.append(", ");
                sb.append(dArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableDoubleArray trimmed() {
        if (this.f15199b <= 0) {
            if (this.f15200c >= this.f15198a.length) {
                return this;
            }
        }
        return new ImmutableDoubleArray(toArray());
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.f15198a = dArr;
        this.f15199b = i;
        this.f15200c = i2;
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4247of(double d) {
        return new ImmutableDoubleArray(new double[]{d}, 0, 1);
    }

    @CanIgnoreReturnValue
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public double[] f15201a;

        /* renamed from: b */
        public int f15202b = 0;

        public Builder(int i) {
            this.f15201a = new double[i];
        }

        /* renamed from: a */
        public final void m4254a(int i) {
            int i2 = this.f15202b + i;
            double[] dArr = this.f15201a;
            if (i2 > dArr.length) {
                int length = dArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    this.f15201a = Arrays.copyOf(dArr, i3);
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public Builder add(double d) {
            m4254a(1);
            double[] dArr = this.f15201a;
            int i = this.f15202b;
            dArr[i] = d;
            this.f15202b = i + 1;
            return this;
        }

        public Builder addAll(double[] dArr) {
            m4254a(dArr.length);
            System.arraycopy(dArr, 0, this.f15201a, this.f15202b, dArr.length);
            this.f15202b += dArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableDoubleArray build() {
            int i = this.f15202b;
            if (i == 0) {
                return ImmutableDoubleArray.f15197d;
            }
            return new ImmutableDoubleArray(this.f15201a, 0, i);
        }

        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Double>) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().doubleValue());
            }
            return this;
        }

        public Builder addAll(Collection<Double> collection) {
            m4254a(collection.size());
            for (Double d : collection) {
                double[] dArr = this.f15201a;
                int i = this.f15202b;
                this.f15202b = i + 1;
                dArr[i] = d.doubleValue();
            }
            return this;
        }

        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            m4254a(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.f15198a, immutableDoubleArray.f15199b, this.f15201a, this.f15202b, immutableDoubleArray.length());
            this.f15202b = immutableDoubleArray.length() + this.f15202b;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? f15197d : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4248of(double d, double d2) {
        return new ImmutableDoubleArray(new double[]{d, d2}, 0, 2);
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4249of(double d, double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3}, 0, 3);
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4250of(double d, double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4}, 0, 4);
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4251of(double d, double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5}, 0, 5);
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4252of(double d, double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5, d6}, 0, 6);
    }

    /* renamed from: of */
    public static ImmutableDoubleArray m4253of(double d, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        int length = dArr.length + 1;
        double[] dArr2 = new double[length];
        dArr2[0] = d;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2, 0, length);
    }
}
