package p000;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes.dex */
public final class rq1 implements Map.Entry, KMutableMap.Entry {

    /* renamed from: a */
    public final Object[] f26111a;

    /* renamed from: b */
    public final Object[] f26112b;

    /* renamed from: c */
    public final int f26113c;

    public rq1(Object[] keys, Object[] values, int i) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f26111a = keys;
        this.f26112b = values;
        this.f26113c = i;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f26111a[this.f26113c];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f26112b[this.f26113c];
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object[] objArr = this.f26112b;
        int i = this.f26113c;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }
}
