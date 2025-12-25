package p000;

import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class o03 {

    /* renamed from: a */
    public static final Comparator f23560a;

    static {
        Comparator comparator;
        try {
            Object[] enumConstants = Class.forName(o03.class.getName().concat("$UnsafeComparator")).getEnumConstants();
            Objects.requireNonNull(enumConstants);
            comparator = (Comparator) enumConstants[0];
        } catch (Throwable unused) {
            comparator = n03.f23190a;
        }
        f23560a = comparator;
    }
}
