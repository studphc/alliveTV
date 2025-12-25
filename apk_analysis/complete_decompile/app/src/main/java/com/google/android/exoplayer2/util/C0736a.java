package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.FlagSet;

/* renamed from: com.google.android.exoplayer2.util.a */
/* loaded from: classes.dex */
public final class C0736a {

    /* renamed from: a */
    public final Object f12784a;

    /* renamed from: b */
    public FlagSet.Builder f12785b = new FlagSet.Builder();

    /* renamed from: c */
    public boolean f12786c;

    /* renamed from: d */
    public boolean f12787d;

    public C0736a(Object obj) {
        this.f12784a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0736a.class == obj.getClass()) {
            return this.f12784a.equals(((C0736a) obj).f12784a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12784a.hashCode();
    }
}
