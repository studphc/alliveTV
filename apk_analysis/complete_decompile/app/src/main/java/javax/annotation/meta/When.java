package javax.annotation.meta;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class When {
    public static final When ALWAYS;
    public static final When MAYBE;
    public static final When NEVER;
    public static final When UNKNOWN;

    /* renamed from: a */
    public static final /* synthetic */ When[] f20440a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, javax.annotation.meta.When] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, javax.annotation.meta.When] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, javax.annotation.meta.When] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, javax.annotation.meta.When] */
    static {
        ?? r4 = new Enum("ALWAYS", 0);
        ALWAYS = r4;
        ?? r5 = new Enum("UNKNOWN", 1);
        UNKNOWN = r5;
        ?? r6 = new Enum("MAYBE", 2);
        MAYBE = r6;
        ?? r7 = new Enum("NEVER", 3);
        NEVER = r7;
        f20440a = new When[]{r4, r5, r6, r7};
    }

    public static When valueOf(String str) {
        return (When) Enum.valueOf(When.class, str);
    }

    public static When[] values() {
        return (When[]) f20440a.clone();
    }
}
