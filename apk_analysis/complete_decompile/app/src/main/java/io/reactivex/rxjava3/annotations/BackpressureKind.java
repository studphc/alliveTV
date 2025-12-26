package io.reactivex.rxjava3.annotations;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class BackpressureKind {
    public static final BackpressureKind ERROR;
    public static final BackpressureKind FULL;
    public static final BackpressureKind NONE;
    public static final BackpressureKind PASS_THROUGH;
    public static final BackpressureKind SPECIAL;
    public static final BackpressureKind UNBOUNDED_IN;

    /* renamed from: a */
    public static final /* synthetic */ BackpressureKind[] f18484a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, io.reactivex.rxjava3.annotations.BackpressureKind] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, io.reactivex.rxjava3.annotations.BackpressureKind] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Enum, io.reactivex.rxjava3.annotations.BackpressureKind] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, io.reactivex.rxjava3.annotations.BackpressureKind] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, io.reactivex.rxjava3.annotations.BackpressureKind] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, io.reactivex.rxjava3.annotations.BackpressureKind] */
    static {
        ?? r6 = new Enum("PASS_THROUGH", 0);
        PASS_THROUGH = r6;
        ?? r7 = new Enum("FULL", 1);
        FULL = r7;
        ?? r8 = new Enum("SPECIAL", 2);
        SPECIAL = r8;
        ?? r9 = new Enum("UNBOUNDED_IN", 3);
        UNBOUNDED_IN = r9;
        ?? r10 = new Enum("ERROR", 4);
        ERROR = r10;
        ?? r11 = new Enum("NONE", 5);
        NONE = r11;
        f18484a = new BackpressureKind[]{r6, r7, r8, r9, r10, r11};
    }

    public static BackpressureKind valueOf(String str) {
        return (BackpressureKind) Enum.valueOf(BackpressureKind.class, str);
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[]) f18484a.clone();
    }
}
