package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class wv0 implements Funnel {

    /* renamed from: a */
    public static final wv0 f28344a;

    /* renamed from: b */
    public static final /* synthetic */ wv0[] f28345b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [wv0, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f28344a = r1;
        f28345b = new wv0[]{r1};
    }

    public static wv0 valueOf(String str) {
        return (wv0) Enum.valueOf(wv0.class, str);
    }

    public static wv0[] values() {
        return (wv0[]) f28345b.clone();
    }

    @Override // com.google.common.hash.Funnel
    public final void funnel(Object obj, PrimitiveSink primitiveSink) {
        primitiveSink.putInt(((Integer) obj).intValue());
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Funnels.integerFunnel()";
    }
}
