package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@GwtCompatible
/* loaded from: classes.dex */
public abstract class RemovalCause {
    public static final RemovalCause COLLECTED;
    public static final RemovalCause EXPIRED;
    public static final RemovalCause EXPLICIT;
    public static final RemovalCause REPLACED;
    public static final RemovalCause SIZE;

    /* renamed from: a */
    public static final /* synthetic */ RemovalCause[] f14567a;

    static {
        RemovalCause removalCause = new RemovalCause() { // from class: ia2
            @Override // com.google.common.cache.RemovalCause
            /* renamed from: a */
            public final boolean mo3792a() {
                return false;
            }
        };
        EXPLICIT = removalCause;
        RemovalCause removalCause2 = new RemovalCause() { // from class: ja2
            @Override // com.google.common.cache.RemovalCause
            /* renamed from: a */
            public final boolean mo3792a() {
                return false;
            }
        };
        REPLACED = removalCause2;
        RemovalCause removalCause3 = new RemovalCause() { // from class: ka2
            @Override // com.google.common.cache.RemovalCause
            /* renamed from: a */
            public final boolean mo3792a() {
                return true;
            }
        };
        COLLECTED = removalCause3;
        RemovalCause removalCause4 = new RemovalCause() { // from class: la2
            @Override // com.google.common.cache.RemovalCause
            /* renamed from: a */
            public final boolean mo3792a() {
                return true;
            }
        };
        EXPIRED = removalCause4;
        RemovalCause removalCause5 = new RemovalCause() { // from class: ma2
            @Override // com.google.common.cache.RemovalCause
            /* renamed from: a */
            public final boolean mo3792a() {
                return true;
            }
        };
        SIZE = removalCause5;
        f14567a = new RemovalCause[]{removalCause, removalCause2, removalCause3, removalCause4, removalCause5};
    }

    public static RemovalCause valueOf(String str) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, str);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) f14567a.clone();
    }

    /* renamed from: a */
    public abstract boolean mo3792a();
}
