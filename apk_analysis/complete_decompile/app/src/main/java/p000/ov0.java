package p000;

import com.google.common.base.Function;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ov0 implements Function {

    /* renamed from: a */
    public static final ov0 f24920a;

    /* renamed from: b */
    public static final /* synthetic */ ov0[] f24921b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, ov0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f24920a = r1;
        f24921b = new ov0[]{r1};
    }

    public static ov0 valueOf(String str) {
        return (ov0) Enum.valueOf(ov0.class, str);
    }

    public static ov0[] values() {
        return (ov0[]) f24921b.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Functions.identity()";
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return obj;
    }
}
