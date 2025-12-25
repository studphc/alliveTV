package p000;

import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class s50 implements Comparator {

    /* renamed from: a */
    public static final s50 f26247a;

    /* renamed from: b */
    public static final /* synthetic */ s50[] f26248b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, s50] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f26247a = r1;
        f26248b = new s50[]{r1};
    }

    public static s50 valueOf(String str) {
        return (s50) Enum.valueOf(s50.class, str);
    }

    public static s50[] values() {
        return (s50[]) f26248b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        double[] dArr = (double[]) obj;
        double[] dArr2 = (double[]) obj2;
        int min = Math.min(dArr.length, dArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Double.compare(dArr[i], dArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return dArr.length - dArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Doubles.lexicographicalComparator()";
    }
}
