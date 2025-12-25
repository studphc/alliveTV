package p000;

import com.google.common.primitives.SignedBytes;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class hi2 implements Comparator {

    /* renamed from: a */
    public static final hi2 f18069a;

    /* renamed from: b */
    public static final /* synthetic */ hi2[] f18070b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [hi2, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f18069a = r1;
        f18070b = new hi2[]{r1};
    }

    public static hi2 valueOf(String str) {
        return (hi2) Enum.valueOf(hi2.class, str);
    }

    public static hi2[] values() {
        return (hi2[]) f18070b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = SignedBytes.compare(bArr[i], bArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return bArr.length - bArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "SignedBytes.lexicographicalComparator()";
    }
}
