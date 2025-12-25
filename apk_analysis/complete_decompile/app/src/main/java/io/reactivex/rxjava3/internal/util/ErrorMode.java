package io.reactivex.rxjava3.internal.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class ErrorMode {
    public static final ErrorMode BOUNDARY;
    public static final ErrorMode END;
    public static final ErrorMode IMMEDIATE;

    /* renamed from: a */
    public static final /* synthetic */ ErrorMode[] f19951a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, io.reactivex.rxjava3.internal.util.ErrorMode] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, io.reactivex.rxjava3.internal.util.ErrorMode] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, io.reactivex.rxjava3.internal.util.ErrorMode] */
    static {
        ?? r3 = new Enum("IMMEDIATE", 0);
        IMMEDIATE = r3;
        ?? r4 = new Enum("BOUNDARY", 1);
        BOUNDARY = r4;
        ?? r5 = new Enum("END", 2);
        END = r5;
        f19951a = new ErrorMode[]{r3, r4, r5};
    }

    public static ErrorMode valueOf(String str) {
        return (ErrorMode) Enum.valueOf(ErrorMode.class, str);
    }

    public static ErrorMode[] values() {
        return (ErrorMode[]) f19951a.clone();
    }
}
