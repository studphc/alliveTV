package p000;

import java.util.Comparator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class qv0 implements Comparator {

    /* renamed from: a */
    public static final qv0 f25768a;

    /* renamed from: b */
    public static final /* synthetic */ qv0[] f25769b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, qv0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f25768a = r1;
        f25769b = new qv0[]{r1};
    }

    public static qv0 valueOf(String str) {
        return (qv0) Enum.valueOf(qv0.class, str);
    }

    public static qv0[] values() {
        return (qv0[]) f25769b.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2);
    }
}
