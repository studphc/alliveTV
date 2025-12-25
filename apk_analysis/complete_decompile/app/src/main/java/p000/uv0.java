package p000;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class uv0 implements Function {

    /* renamed from: a */
    public static final uv0 f27465a;

    /* renamed from: b */
    public static final /* synthetic */ uv0[] f27466b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, uv0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f27465a = r1;
        f27466b = new uv0[]{r1};
    }

    public static uv0 valueOf(String str) {
        return (uv0) Enum.valueOf(uv0.class, str);
    }

    public static uv0[] values() {
        return (uv0[]) f27466b.clone();
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj.toString();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Functions.toStringFunction()";
    }
}
