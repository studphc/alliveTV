package kotlin.io;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, m5569d2 = {"Lkotlin/io/OnErrorAction;", "", "SKIP", "TERMINATE", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class OnErrorAction {
    public static final OnErrorAction SKIP;
    public static final OnErrorAction TERMINATE;

    /* renamed from: a */
    public static final /* synthetic */ OnErrorAction[] f21129a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, kotlin.io.OnErrorAction] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, kotlin.io.OnErrorAction] */
    static {
        ?? r2 = new Enum("SKIP", 0);
        SKIP = r2;
        ?? r3 = new Enum("TERMINATE", 1);
        TERMINATE = r3;
        f21129a = new OnErrorAction[]{r2, r3};
    }

    public static OnErrorAction valueOf(String str) {
        return (OnErrorAction) Enum.valueOf(OnErrorAction.class, str);
    }

    public static OnErrorAction[] values() {
        return (OnErrorAction[]) f21129a.clone();
    }
}
