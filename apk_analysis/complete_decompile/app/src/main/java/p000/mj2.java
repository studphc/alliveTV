package p000;

import io.reactivex.rxjava3.functions.Supplier;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class mj2 implements Supplier {

    /* renamed from: a */
    public static final mj2 f22961a;

    /* renamed from: b */
    public static final /* synthetic */ mj2[] f22962b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, mj2] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f22961a = r1;
        f22962b = new mj2[]{r1};
    }

    public static mj2 valueOf(String str) {
        return (mj2) Enum.valueOf(mj2.class, str);
    }

    public static mj2[] values() {
        return (mj2[]) f22962b.clone();
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final Object get() {
        return new NoSuchElementException();
    }
}
