package p000;

import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class bf0 implements Comparator {

    /* renamed from: a */
    public static final bf0 f7991a;

    /* renamed from: b */
    public static final /* synthetic */ bf0[] f7992b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, bf0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f7991a = r1;
        f7992b = new bf0[]{r1};
    }

    public static bf0 valueOf(String str) {
        return (bf0) Enum.valueOf(bf0.class, str);
    }

    public static bf0[] values() {
        return (bf0[]) f7992b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        int min = Math.min(fArr.length, fArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Float.compare(fArr[i], fArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return fArr.length - fArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Floats.lexicographicalComparator()";
    }
}
