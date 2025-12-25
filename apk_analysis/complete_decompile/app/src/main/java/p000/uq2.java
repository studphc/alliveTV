package p000;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class uq2 implements Function {

    /* renamed from: a */
    public static final uq2 f27411a;

    /* renamed from: b */
    public static final /* synthetic */ uq2[] f27412b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, uq2] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f27411a = r1;
        f27412b = new uq2[]{r1};
    }

    public static uq2 valueOf(String str) {
        return (uq2) Enum.valueOf(uq2.class, str);
    }

    public static uq2[] values() {
        return (uq2[]) f27412b.clone();
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ((Supplier) obj).get();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Suppliers.supplierFunction()";
    }
}
