package p000;

import com.google.common.primitives.Shorts;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ei2 implements Comparator {

    /* renamed from: a */
    public static final ei2 f16838a;

    /* renamed from: b */
    public static final /* synthetic */ ei2[] f16839b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, ei2] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f16838a = r1;
        f16839b = new ei2[]{r1};
    }

    public static ei2 valueOf(String str) {
        return (ei2) Enum.valueOf(ei2.class, str);
    }

    public static ei2[] values() {
        return (ei2[]) f16839b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        short[] sArr = (short[]) obj;
        short[] sArr2 = (short[]) obj2;
        int min = Math.min(sArr.length, sArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Shorts.compare(sArr[i], sArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return sArr.length - sArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Shorts.lexicographicalComparator()";
    }
}
