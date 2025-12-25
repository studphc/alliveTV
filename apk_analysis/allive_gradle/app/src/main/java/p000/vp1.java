package p000;

import com.google.common.base.Supplier;
import java.util.LinkedList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class vp1 implements Supplier {

    /* renamed from: a */
    public static final vp1 f27911a;

    /* renamed from: b */
    public static final /* synthetic */ vp1[] f27912b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, vp1] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f27911a = r1;
        f27912b = new vp1[]{r1};
    }

    public static vp1 valueOf(String str) {
        return (vp1) Enum.valueOf(vp1.class, str);
    }

    public static vp1[] values() {
        return (vp1[]) f27912b.clone();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return new LinkedList();
    }
}
