package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class cw0 implements Funnel {

    /* renamed from: a */
    public static final cw0 f16146a;

    /* renamed from: b */
    public static final /* synthetic */ cw0[] f16147b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, cw0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f16146a = r1;
        f16147b = new cw0[]{r1};
    }

    public static cw0 valueOf(String str) {
        return (cw0) Enum.valueOf(cw0.class, str);
    }

    public static cw0[] values() {
        return (cw0[]) f16147b.clone();
    }

    @Override // com.google.common.hash.Funnel
    public final void funnel(Object obj, PrimitiveSink primitiveSink) {
        primitiveSink.putUnencodedChars((CharSequence) obj);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Funnels.unencodedCharsFunnel()";
    }
}
