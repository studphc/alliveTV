package p000;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class fe0 implements Executor {

    /* renamed from: a */
    public static final fe0 f17233a;

    /* renamed from: b */
    public static final /* synthetic */ fe0[] f17234b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [fe0, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f17233a = r1;
        f17234b = new fe0[]{r1};
    }

    public static fe0 valueOf(String str) {
        return (fe0) Enum.valueOf(fe0.class, str);
    }

    public static fe0[] values() {
        return (fe0[]) f17234b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
