package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class vv0 implements Funnel {

    /* renamed from: a */
    public static final vv0 f27976a;

    /* renamed from: b */
    public static final /* synthetic */ vv0[] f27977b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [vv0, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f27976a = r1;
        f27977b = new vv0[]{r1};
    }

    public static vv0 valueOf(String str) {
        return (vv0) Enum.valueOf(vv0.class, str);
    }

    public static vv0[] values() {
        return (vv0[]) f27977b.clone();
    }

    @Override // com.google.common.hash.Funnel
    public final void funnel(Object obj, PrimitiveSink primitiveSink) {
        primitiveSink.putBytes((byte[]) obj);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Funnels.byteArrayFunnel()";
    }
}
