package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import p000.AbstractC1726qj;
import p000.p63;
import p000.q50;
import p000.r50;
import p000.s50;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Doubles extends p63 {
    public static final int BYTES = 8;

    /* renamed from: f */
    public static final Pattern f15196f;

    static {
        String concat = "(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)".concat("(?:[eE][+-]?\\d+#)?[fFdD]?");
        StringBuilder sb = new StringBuilder(78);
        sb.append("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?");
        String sb2 = sb.toString();
        StringBuilder m7062r = AbstractC1726qj.m7062r(AbstractC1726qj.m7052h(AbstractC1726qj.m7052h(23, concat), sb2), "[+-]?(?:NaN|Infinity|", concat, "|", sb2);
        m7062r.append(")");
        f15196f = Pattern.compile(m7062r.toString().replace("#", "+"));
    }

    /* renamed from: S */
    public static int m4243S(double[] dArr, double d, int i, int i2) {
        while (i < i2) {
            if (dArr[i] == d) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static List<Double> asList(double... dArr) {
        if (dArr.length == 0) {
            return Collections.emptyList();
        }
        return new q50(dArr, 0, dArr.length);
    }

    public static int compare(double d, double d2) {
        return Double.compare(d, d2);
    }

    public static double[] concat(double[]... dArr) {
        int i = 0;
        for (double[] dArr2 : dArr) {
            i += dArr2.length;
        }
        double[] dArr3 = new double[i];
        int i2 = 0;
        for (double[] dArr4 : dArr) {
            System.arraycopy(dArr4, 0, dArr3, i2, dArr4.length);
            i2 += dArr4.length;
        }
        return dArr3;
    }

    @Beta
    public static double constrainToRange(double d, double d2, double d3) {
        if (d2 <= d3) {
            return Math.min(Math.max(d, d2), d3);
        }
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", Double.valueOf(d2), Double.valueOf(d3)));
    }

    public static boolean contains(double[] dArr, double d) {
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static double[] ensureCapacity(double[] dArr, int i, int i2) {
        boolean z;
        boolean z2 = false;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid minLength: %s", i);
        if (i2 >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Invalid padding: %s", i2);
        if (dArr.length < i) {
            return Arrays.copyOf(dArr, i + i2);
        }
        return dArr;
    }

    public static int hashCode(double d) {
        return Double.valueOf(d).hashCode();
    }

    public static int indexOf(double[] dArr, double d) {
        return m4243S(dArr, d, 0, dArr.length);
    }

    public static boolean isFinite(double d) {
        return Double.NEGATIVE_INFINITY < d && d < Double.POSITIVE_INFINITY;
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i = 1; i < dArr.length; i++) {
            sb.append(str);
            sb.append(dArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(double[] dArr, double d) {
        for (int length = dArr.length - 1; length >= 0; length--) {
            if (dArr[length] == d) {
                return length;
            }
        }
        return -1;
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return s50.f26247a;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double max(double... dArr) {
        boolean z;
        if (dArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Math.max(d, dArr[i]);
        }
        return d;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double min(double... dArr) {
        boolean z;
        if (dArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Math.min(d, dArr[i]);
        }
        return d;
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    @Beta
    public static Converter<String, Double> stringConverter() {
        return r50.f25871b;
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof q50) {
            q50 q50Var = (q50) collection;
            return Arrays.copyOfRange(q50Var.f25453a, q50Var.f25454b, q50Var.f25455c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = ((Number) Preconditions.checkNotNull(array[i])).doubleValue();
        }
        return dArr;
    }

    @Beta
    @CheckForNull
    @GwtIncompatible
    public static Double tryParse(String str) {
        if (f15196f.matcher(str).matches()) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(double[] dArr, double[] dArr2) {
        Preconditions.checkNotNull(dArr, "array");
        Preconditions.checkNotNull(dArr2, TypedValues.AttributesType.S_TARGET);
        if (dArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (dArr.length - dArr2.length) + 1) {
            for (int i2 = 0; i2 < dArr2.length; i2++) {
                if (dArr[i + i2] != dArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static void reverse(double[] dArr, int i, int i2) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i, i2, dArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            double d = dArr[i];
            dArr[i] = dArr[i3];
            dArr[i3] = d;
            i++;
        }
    }

    public static void sortDescending(double[] dArr, int i, int i2) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i, i2, dArr.length);
        Arrays.sort(dArr, i, i2);
        reverse(dArr, i, i2);
    }
}
