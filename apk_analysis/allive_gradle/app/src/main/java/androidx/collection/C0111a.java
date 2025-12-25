package androidx.collection;

import androidx.collection.ScatterMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* renamed from: androidx.collection.a */
/* loaded from: classes.dex */
public final class C0111a extends ScatterMap.MapWrapper implements KMutableMap {

    /* renamed from: b */
    public final /* synthetic */ MutableScatterMap f1761b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0111a(MutableScatterMap mutableScatterMap) {
        super();
        this.f1761b = mutableScatterMap;
    }

    @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
    public final void clear() {
        this.f1761b.clear();
    }

    @Override // androidx.collection.ScatterMap.MapWrapper
    public final Set getEntries() {
        return new MutableScatterMap$MutableMapWrapper$entries$1(this.f1761b);
    }

    @Override // androidx.collection.ScatterMap.MapWrapper
    public final Set getKeys() {
        return new MutableScatterMap$MutableMapWrapper$keys$1(this.f1761b);
    }

    @Override // androidx.collection.ScatterMap.MapWrapper
    public final Collection getValues() {
        return new MutableScatterMap$MutableMapWrapper$values$1(this.f1761b);
    }

    @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f1761b.put(obj, obj2);
    }

    @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry entry : from.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.collection.ScatterMap.MapWrapper, java.util.Map
    public final Object remove(Object obj) {
        return this.f1761b.remove(obj);
    }
}
