package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class xv0 implements Funnel {

    /* renamed from: a */
    public static final xv0 f28742a;

    /* renamed from: b */
    public static final /* synthetic */ xv0[] f28743b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [xv0, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f28742a = r1;
        f28743b = new xv0[]{r1};
    }

    public static xv0 valueOf(String str) {
        return (xv0) Enum.valueOf(xv0.class, str);
    }

    public static xv0[] values() {
        return (xv0[]) f28743b.clone();
    }

    @Override // com.google.common.hash.Funnel
    public final void funnel(Object obj, PrimitiveSink primitiveSink) {
        primitiveSink.putLong(((Long) obj).longValue());
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Funnels.longFunnel()";
    }
}
