package p000;

import com.google.common.collect.Range;

/* loaded from: classes.dex */
public final class gw2 extends AbstractC2041z1 {

    /* renamed from: a */
    public final Range f17854a;

    /* renamed from: b */
    public final Object f17855b;

    public gw2(Range range, Object obj) {
        this.f17854a = range;
        this.f17855b = obj;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f17854a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f17855b;
    }
}
