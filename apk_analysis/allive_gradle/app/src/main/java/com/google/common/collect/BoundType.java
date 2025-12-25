package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@GwtCompatible
/* loaded from: classes.dex */
public final class BoundType {
    public static final BoundType CLOSED;
    public static final BoundType OPEN;

    /* renamed from: a */
    public static final /* synthetic */ BoundType[] f14620a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, com.google.common.collect.BoundType] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, com.google.common.collect.BoundType] */
    static {
        ?? r2 = new Enum("OPEN", 0);
        OPEN = r2;
        ?? r3 = new Enum("CLOSED", 1);
        CLOSED = r3;
        f14620a = new BoundType[]{r2, r3};
    }

    /* renamed from: a */
    public static BoundType m3833a(boolean z) {
        if (z) {
            return CLOSED;
        }
        return OPEN;
    }

    public static BoundType valueOf(String str) {
        return (BoundType) Enum.valueOf(BoundType.class, str);
    }

    public static BoundType[] values() {
        return (BoundType[]) f14620a.clone();
    }
}
