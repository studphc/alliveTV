package p000;

import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.single.SingleToFlowable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class nj2 implements Function {

    /* renamed from: a */
    public static final nj2 f23383a;

    /* renamed from: b */
    public static final /* synthetic */ nj2[] f23384b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, nj2] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f23383a = r1;
        f23384b = new nj2[]{r1};
    }

    public static nj2 valueOf(String str) {
        return (nj2) Enum.valueOf(nj2.class, str);
    }

    public static nj2[] values() {
        return (nj2[]) f23384b.clone();
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        return new SingleToFlowable((SingleSource) obj);
    }
}
