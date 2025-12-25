package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.primitives.Primitives;
import java.util.Map;

/* loaded from: classes.dex */
public final class pq1 extends ForwardingMapEntry {

    /* renamed from: a */
    public final /* synthetic */ int f25262a;

    /* renamed from: b */
    public final Map.Entry f25263b;

    public /* synthetic */ pq1(Map.Entry entry, int i) {
        this.f25262a = i;
        this.f25263b = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        switch (this.f25262a) {
            case 0:
                return this.f25263b;
            case 1:
                return this.f25263b;
            default:
                return this.f25263b;
        }
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public boolean equals(Object obj) {
        switch (this.f25262a) {
            case 2:
                return standardEquals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public final Object setValue(Object obj) {
        switch (this.f25262a) {
            case 0:
                return super.setValue(Primitives.wrap((Class) getKey()).cast(obj));
            case 1:
                throw new UnsupportedOperationException();
            default:
                return super.setValue(Preconditions.checkNotNull(obj));
        }
    }

    public pq1(Map.Entry entry) {
        this.f25262a = 1;
        this.f25263b = (Map.Entry) Preconditions.checkNotNull(entry);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    public final Map.Entry delegate() {
        switch (this.f25262a) {
            case 0:
                return this.f25263b;
            case 1:
                return this.f25263b;
            default:
                return this.f25263b;
        }
    }
}
