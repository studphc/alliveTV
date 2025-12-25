package p000;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class e40 implements Executor {

    /* renamed from: a */
    public static final e40 f16668a;

    /* renamed from: b */
    public static final /* synthetic */ e40[] f16669b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [e40, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f16668a = r1;
        f16669b = new e40[]{r1};
    }

    public static e40 valueOf(String str) {
        return (e40) Enum.valueOf(e40.class, str);
    }

    public static e40[] values() {
        return (e40[]) f16669b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
