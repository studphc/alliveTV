package p000;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import java.util.Collection;
import java.util.Map;

/* renamed from: m */
/* loaded from: classes.dex */
public final class C1530m extends ForwardingMapEntry {

    /* renamed from: a */
    public final /* synthetic */ int f22733a;

    /* renamed from: b */
    public final Map.Entry f22734b;

    /* renamed from: c */
    public final /* synthetic */ Object f22735c;

    public /* synthetic */ C1530m(rv2 rv2Var, Map.Entry entry, int i) {
        this.f22733a = i;
        this.f22735c = rv2Var;
        this.f22734b = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        switch (this.f22733a) {
            case 0:
                return this.f22734b;
            case 1:
                return this.f22734b;
            default:
                return this.f22734b;
        }
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public Object getValue() {
        switch (this.f22733a) {
            case 2:
                return yy2.m8356d((Collection) this.f22734b.getValue(), ((dr2) ((rg1) this.f22735c).f25960c).f25273b);
            default:
                return super.getValue();
        }
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public Object setValue(Object obj) {
        switch (this.f22733a) {
            case 0:
                AbstractC1706q abstractC1706q = (AbstractC1706q) this.f22735c;
                abstractC1706q.mo3852f(obj);
                Preconditions.checkState(abstractC1706q.entrySet().contains(this), "entry no longer in map");
                if (!Objects.equal(obj, getValue())) {
                    Preconditions.checkArgument(!abstractC1706q.containsValue(obj), "value already present: %s", obj);
                    Object value = this.f22734b.setValue(obj);
                    Preconditions.checkState(Objects.equal(obj, abstractC1706q.get(getKey())), "entry no longer in map");
                    Object key = getKey();
                    abstractC1706q.f25353b.f25352a.remove(value);
                    abstractC1706q.f25353b.f25352a.put(obj, key);
                    return value;
                }
                return obj;
            case 1:
                Preconditions.checkArgument(((sg1) ((C1669p) ((rg1) this.f22735c).f25960c).f24969b).m7372f(getKey(), obj));
                return super.setValue(obj);
            default:
                return super.setValue(obj);
        }
    }

    public C1530m(AbstractC1706q abstractC1706q, Map.Entry entry) {
        this.f22733a = 0;
        this.f22735c = abstractC1706q;
        this.f22734b = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    public final Map.Entry delegate() {
        switch (this.f22733a) {
            case 0:
                return this.f22734b;
            case 1:
                return this.f22734b;
            default:
                return this.f22734b;
        }
    }
}
