package io.reactivex.rxjava3.parallel;

import io.reactivex.rxjava3.functions.BiFunction;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    public static final ParallelFailureHandling ERROR;
    public static final ParallelFailureHandling RETRY;
    public static final ParallelFailureHandling SKIP;
    public static final ParallelFailureHandling STOP;

    /* renamed from: a */
    public static final /* synthetic */ ParallelFailureHandling[] f20009a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.reactivex.rxjava3.parallel.ParallelFailureHandling, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v1, types: [io.reactivex.rxjava3.parallel.ParallelFailureHandling, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r6v1, types: [io.reactivex.rxjava3.parallel.ParallelFailureHandling, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.reactivex.rxjava3.parallel.ParallelFailureHandling, java.lang.Enum] */
    static {
        ?? r4 = new Enum("STOP", 0);
        STOP = r4;
        ?? r5 = new Enum("ERROR", 1);
        ERROR = r5;
        ?? r6 = new Enum("SKIP", 2);
        SKIP = r6;
        ?? r7 = new Enum("RETRY", 3);
        RETRY = r7;
        f20009a = new ParallelFailureHandling[]{r4, r5, r6, r7};
    }

    public static ParallelFailureHandling valueOf(String str) {
        return (ParallelFailureHandling) Enum.valueOf(ParallelFailureHandling.class, str);
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[]) f20009a.clone();
    }

    @Override // io.reactivex.rxjava3.functions.BiFunction
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
