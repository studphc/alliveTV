package p000;

import com.google.common.primitives.UnsignedLongs;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class q03 implements Comparator {

    /* renamed from: a */
    public static final q03 f25398a;

    /* renamed from: b */
    public static final /* synthetic */ q03[] f25399b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, q03] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f25398a = r1;
        f25399b = new q03[]{r1};
    }

    public static q03 valueOf(String str) {
        return (q03) Enum.valueOf(q03.class, str);
    }

    public static q03[] values() {
        return (q03[]) f25399b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        long[] jArr2 = (long[]) obj2;
        int min = Math.min(jArr.length, jArr2.length);
        for (int i = 0; i < min; i++) {
            long j = jArr[i];
            long j2 = jArr2[i];
            if (j != j2) {
                return UnsignedLongs.compare(j, j2);
            }
        }
        return jArr.length - jArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UnsignedLongs.lexicographicalComparator()";
    }
}
