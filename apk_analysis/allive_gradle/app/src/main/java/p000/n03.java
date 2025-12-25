package p000;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class n03 implements Comparator {

    /* renamed from: a */
    public static final n03 f23190a;

    /* renamed from: b */
    public static final /* synthetic */ n03[] f23191b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [n03, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f23190a = r1;
        f23191b = new n03[]{r1};
    }

    public static n03 valueOf(String str) {
        return (n03) Enum.valueOf(n03.class, str);
    }

    public static n03[] values() {
        return (n03[]) f23191b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            int compare = UnsignedBytes.compare(bArr[i], bArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return bArr.length - bArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
}
