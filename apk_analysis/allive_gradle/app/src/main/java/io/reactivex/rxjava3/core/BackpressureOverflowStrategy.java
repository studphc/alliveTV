package io.reactivex.rxjava3.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class BackpressureOverflowStrategy {
    public static final BackpressureOverflowStrategy DROP_LATEST;
    public static final BackpressureOverflowStrategy DROP_OLDEST;
    public static final BackpressureOverflowStrategy ERROR;

    /* renamed from: a */
    public static final /* synthetic */ BackpressureOverflowStrategy[] f18486a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureOverflowStrategy] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureOverflowStrategy] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureOverflowStrategy] */
    static {
        ?? r3 = new Enum("ERROR", 0);
        ERROR = r3;
        ?? r4 = new Enum("DROP_OLDEST", 1);
        DROP_OLDEST = r4;
        ?? r5 = new Enum("DROP_LATEST", 2);
        DROP_LATEST = r5;
        f18486a = new BackpressureOverflowStrategy[]{r3, r4, r5};
    }

    public static BackpressureOverflowStrategy valueOf(String str) {
        return (BackpressureOverflowStrategy) Enum.valueOf(BackpressureOverflowStrategy.class, str);
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[]) f18486a.clone();
    }
}
