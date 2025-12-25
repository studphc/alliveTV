package p000;

import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt;

/* renamed from: wu */
/* loaded from: classes2.dex */
public final class C1959wu implements Map.Entry, KMutableMap.Entry {

    /* renamed from: a */
    public final Object f28331a;

    /* renamed from: b */
    public final Object f28332b;

    public C1959wu(Object obj, Object obj2) {
        this.f28331a = obj;
        this.f28332b = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f28331a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f28332b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        ConcurrentWeakMapKt.access$noImpl();
        throw new KotlinNothingValueException();
    }
}
