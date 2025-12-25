package p000;

import com.google.common.primitives.Booleans;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: mh */
/* loaded from: classes2.dex */
public final class EnumC1548mh implements Comparator {

    /* renamed from: a */
    public static final EnumC1548mh f22937a;

    /* renamed from: b */
    public static final /* synthetic */ EnumC1548mh[] f22938b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, mh] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f22937a = r1;
        f22938b = new EnumC1548mh[]{r1};
    }

    public static EnumC1548mh valueOf(String str) {
        return (EnumC1548mh) Enum.valueOf(EnumC1548mh.class, str);
    }

    public static EnumC1548mh[] values() {
        return (EnumC1548mh[]) f22938b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        boolean[] zArr = (boolean[]) obj;
        boolean[] zArr2 = (boolean[]) obj2;
        int min = Math.min(zArr.length, zArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Booleans.compare(zArr[i], zArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return zArr.length - zArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Booleans.lexicographicalComparator()";
    }
}
