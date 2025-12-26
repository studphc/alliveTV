package p000;

import com.google.common.primitives.Longs;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class fe1 implements Comparator {

    /* renamed from: a */
    public static final fe1 f17235a;

    /* renamed from: b */
    public static final /* synthetic */ fe1[] f17236b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [fe1, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f17235a = r1;
        f17236b = new fe1[]{r1};
    }

    public static fe1 valueOf(String str) {
        return (fe1) Enum.valueOf(fe1.class, str);
    }

    public static fe1[] values() {
        return (fe1[]) f17236b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        long[] jArr2 = (long[]) obj2;
        int min = Math.min(jArr.length, jArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = Longs.compare(jArr[i], jArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return jArr.length - jArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Longs.lexicographicalComparator()";
    }
}
