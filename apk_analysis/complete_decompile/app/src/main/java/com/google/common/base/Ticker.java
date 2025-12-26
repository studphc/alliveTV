package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import p000.nt2;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class Ticker {

    /* renamed from: a */
    public static final nt2 f14503a = new Ticker();

    public static Ticker systemTicker() {
        return f14503a;
    }

    public abstract long read();
}
