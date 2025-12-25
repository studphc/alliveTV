package p000;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class bf1 extends AbstractSet {

    /* renamed from: a */
    public final /* synthetic */ int f7993a;

    /* renamed from: b */
    public final /* synthetic */ zf1 f7994b;

    public /* synthetic */ bf1(zf1 zf1Var, int i) {
        this.f7993a = i;
        this.f7994b = zf1Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f7993a) {
            case 0:
                this.f7994b.clear();
                return;
            default:
                this.f7994b.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        zf1 zf1Var;
        Object obj2;
        switch (this.f7993a) {
            case 0:
                if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = (zf1Var = this.f7994b).get(key)) == null || !zf1Var.f29355f.mo4575d().mo4950a().equivalent(entry.getValue(), obj2)) {
                    return false;
                }
                return true;
            default:
                return this.f7994b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f7993a) {
            case 0:
                return this.f7994b.isEmpty();
            default:
                return this.f7994b.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f7993a) {
            case 0:
                return new af1(this.f7994b, 0);
            default:
                return new af1(this.f7994b, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.f7993a) {
            case 0:
                if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !this.f7994b.remove(key, entry.getValue())) {
                    return false;
                }
                return true;
            default:
                if (this.f7994b.remove(obj) != null) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f7993a) {
            case 0:
                return this.f7994b.size();
            default:
                return this.f7994b.size();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return zf1.m8413a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return zf1.m8413a(this).toArray(objArr);
    }
}
