package p000;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public final class te1 implements Map.Entry, KMappedMarker {

    /* renamed from: a */
    public final Object f26785a;

    /* renamed from: b */
    public final Object f26786b;

    public te1(Object obj, Object obj2) {
        this.f26785a = obj;
        this.f26786b = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f26785a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f26786b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
