package p000;

import com.google.common.primitives.Ints;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class e51 implements Comparator {

    /* renamed from: a */
    public static final e51 f16673a;

    /* renamed from: b */
    public static final /* synthetic */ e51[] f16674b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [e51, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f16673a = r1;
        f16674b = new e51[]{r1};
    }

    public static e51 valueOf(String str) {
        return (e51) Enum.valueOf(e51.class, str);
    }

    public static e51[] values() {
        return (e51[]) f16674b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int[] iArr = (int[]) obj;
        int[] iArr2 = (int[]) obj2;
        int min = Math.min(iArr.length, iArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Ints.compare(iArr[i], iArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return iArr.length - iArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Ints.lexicographicalComparator()";
    }
}
