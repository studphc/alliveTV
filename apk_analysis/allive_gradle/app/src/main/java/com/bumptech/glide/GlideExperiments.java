package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000.C1785s4;

/* loaded from: classes.dex */
public class GlideExperiments {

    /* renamed from: a */
    public final Map f8492a;

    public GlideExperiments(C1785s4 c1785s4) {
        this.f8492a = Collections.unmodifiableMap(new HashMap(c1785s4.f26232a));
    }

    public boolean isEnabled(Class<Object> cls) {
        return this.f8492a.containsKey(cls);
    }
}
