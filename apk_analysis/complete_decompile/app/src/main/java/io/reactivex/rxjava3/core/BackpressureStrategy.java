package io.reactivex.rxjava3.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class BackpressureStrategy {
    public static final BackpressureStrategy BUFFER;
    public static final BackpressureStrategy DROP;
    public static final BackpressureStrategy ERROR;
    public static final BackpressureStrategy LATEST;
    public static final BackpressureStrategy MISSING;

    /* renamed from: a */
    public static final /* synthetic */ BackpressureStrategy[] f18487a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureStrategy] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureStrategy] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureStrategy] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureStrategy] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, io.reactivex.rxjava3.core.BackpressureStrategy] */
    static {
        ?? r5 = new Enum("MISSING", 0);
        MISSING = r5;
        ?? r6 = new Enum("ERROR", 1);
        ERROR = r6;
        ?? r7 = new Enum("BUFFER", 2);
        BUFFER = r7;
        ?? r8 = new Enum("DROP", 3);
        DROP = r8;
        ?? r9 = new Enum("LATEST", 4);
        LATEST = r9;
        f18487a = new BackpressureStrategy[]{r5, r6, r7, r8, r9};
    }

    public static BackpressureStrategy valueOf(String str) {
        return (BackpressureStrategy) Enum.valueOf(BackpressureStrategy.class, str);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) f18487a.clone();
    }
}
