package p000;

import com.google.common.primitives.UnsignedInts;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class p03 implements Comparator {

    /* renamed from: a */
    public static final p03 f24996a;

    /* renamed from: b */
    public static final /* synthetic */ p03[] f24997b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [p03, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f24996a = r1;
        f24997b = new p03[]{r1};
    }

    public static p03 valueOf(String str) {
        return (p03) Enum.valueOf(p03.class, str);
    }

    public static p03[] values() {
        return (p03[]) f24997b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int[] iArr = (int[]) obj;
        int[] iArr2 = (int[]) obj2;
        int min = Math.min(iArr.length, iArr2.length);
        for (int i = 0; i < min; i++) {
            int i2 = iArr[i];
            int i3 = iArr2[i];
            if (i2 != i3) {
                return UnsignedInts.compare(i2, i3);
            }
        }
        return iArr.length - iArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UnsignedInts.lexicographicalComparator()";
    }
}
