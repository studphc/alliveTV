package com.google.common.collect;

import com.google.common.collect.ImmutableRangeMap;
import java.io.Serializable;
import java.util.Map;

/* renamed from: com.google.common.collect.f0 */
/* loaded from: classes.dex */
public final class C0867f0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final ImmutableMap f14816a;

    public C0867f0(ImmutableMap immutableMap) {
        this.f14816a = immutableMap;
    }

    public Object readResolve() {
        ImmutableMap immutableMap = this.f14816a;
        if (immutableMap.isEmpty()) {
            return ImmutableRangeMap.m3964of();
        }
        ImmutableRangeMap.Builder builder = new ImmutableRangeMap.Builder();
        UnmodifiableIterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.put((Range) entry.getKey(), entry.getValue());
        }
        return builder.build();
    }
}
