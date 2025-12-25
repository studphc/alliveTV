package p000;

import io.reactivex.rxjava3.functions.Supplier;
import java.util.HashSet;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class mv0 implements Supplier {

    /* renamed from: a */
    public static final mv0 f23135a;

    /* renamed from: b */
    public static final /* synthetic */ mv0[] f23136b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, mv0] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f23135a = r1;
        f23136b = new mv0[]{r1};
    }

    public static mv0 valueOf(String str) {
        return (mv0) Enum.valueOf(mv0.class, str);
    }

    public static mv0[] values() {
        return (mv0[]) f23136b.clone();
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        return new HashSet();
    }
}
