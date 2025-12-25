package p000;

import com.google.common.cache.Weigher;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: xj */
/* loaded from: classes.dex */
public final class EnumC1985xj implements Weigher {

    /* renamed from: a */
    public static final EnumC1985xj f28583a;

    /* renamed from: b */
    public static final /* synthetic */ EnumC1985xj[] f28584b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [xj, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f28583a = r1;
        f28584b = new EnumC1985xj[]{r1};
    }

    public static EnumC1985xj valueOf(String str) {
        return (EnumC1985xj) Enum.valueOf(EnumC1985xj.class, str);
    }

    public static EnumC1985xj[] values() {
        return (EnumC1985xj[]) f28584b.clone();
    }

    @Override // com.google.common.cache.Weigher
    public final int weigh(Object obj, Object obj2) {
        return 1;
    }
}
