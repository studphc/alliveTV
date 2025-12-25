package p000;

import com.google.common.primitives.Chars;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: hp */
/* loaded from: classes2.dex */
public final class EnumC1277hp implements Comparator {

    /* renamed from: a */
    public static final EnumC1277hp f18120a;

    /* renamed from: b */
    public static final /* synthetic */ EnumC1277hp[] f18121b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, hp] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f18120a = r1;
        f18121b = new EnumC1277hp[]{r1};
    }

    public static EnumC1277hp valueOf(String str) {
        return (EnumC1277hp) Enum.valueOf(EnumC1277hp.class, str);
    }

    public static EnumC1277hp[] values() {
        return (EnumC1277hp[]) f18121b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        char[] cArr = (char[]) obj;
        char[] cArr2 = (char[]) obj2;
        int min = Math.min(cArr.length, cArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Chars.compare(cArr[i], cArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return cArr.length - cArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Chars.lexicographicalComparator()";
    }
}
