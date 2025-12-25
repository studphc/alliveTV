package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;
import p000.z90;

@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
@GwtCompatible
/* loaded from: classes.dex */
public abstract class Escaper {

    /* renamed from: a */
    public final z90 f15012a = new z90(0, this);

    public final Function<String, String> asFunction() {
        return this.f15012a;
    }

    public abstract String escape(String str);
}
