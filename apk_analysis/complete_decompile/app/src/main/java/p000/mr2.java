package p000;

import com.google.common.collect.C0860d3;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class mr2 extends pr2 implements Multimap {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient sr2 f23084c;

    /* renamed from: d */
    public transient gr2 f23085d;

    /* renamed from: e */
    public transient gr2 f23086e;

    /* renamed from: f */
    public transient cr2 f23087f;

    /* renamed from: g */
    public transient Multiset f23088g;

    /* JADX WARN: Type inference failed for: r1v3, types: [pr2, cr2] */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final Map asMap() {
        cr2 cr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f23087f == null) {
                    this.f23087f = new pr2(mo5783e().asMap(), this.f25273b);
                }
                cr2Var = this.f23087f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cr2Var;
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        synchronized (this.f25273b) {
            mo5783e().clear();
        }
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsEntry(Object obj, Object obj2) {
        boolean containsEntry;
        synchronized (this.f25273b) {
            containsEntry = mo5783e().containsEntry(obj, obj2);
        }
        return containsEntry;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f25273b) {
            containsKey = mo5783e().containsKey(obj);
        }
        return containsKey;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f25273b) {
            containsValue = mo5783e().containsValue(obj);
        }
        return containsValue;
    }

    /* renamed from: e */
    public Multimap mo5783e() {
        return (Multimap) this.f25272a;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
    public Collection entries() {
        gr2 gr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f23086e == null) {
                    this.f23086e = yy2.m8356d(mo5783e().entries(), this.f25273b);
                }
                gr2Var = this.f23086e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gr2Var;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f25273b) {
            equals = mo5783e().equals(obj);
        }
        return equals;
    }

    public Collection get(Object obj) {
        gr2 m8356d;
        synchronized (this.f25273b) {
            m8356d = yy2.m8356d(mo5783e().get(obj), this.f25273b);
        }
        return m8356d;
    }

    @Override // com.google.common.collect.Multimap
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = mo5783e().hashCode();
        }
        return hashCode;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f25273b) {
            isEmpty = mo5783e().isEmpty();
        }
        return isEmpty;
    }

    @Override // com.google.common.collect.Multimap
    public final Set keySet() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f23084c == null) {
                    this.f23084c = yy2.m8354c(mo5783e().keySet(), this.f25273b);
                }
                sr2Var = this.f23084c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [pr2] */
    @Override // com.google.common.collect.Multimap
    public final Multiset keys() {
        Multiset multiset;
        synchronized (this.f25273b) {
            try {
                if (this.f23088g == null) {
                    Multiset keys = mo5783e().keys();
                    Object obj = this.f25273b;
                    if (!(keys instanceof C0860d3) && !(keys instanceof ImmutableMultiset)) {
                        keys = new pr2(keys, obj);
                    }
                    this.f23088g = keys;
                }
                multiset = this.f23088g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return multiset;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean put(Object obj, Object obj2) {
        boolean put;
        synchronized (this.f25273b) {
            put = mo5783e().put(obj, obj2);
        }
        return put;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean putAll(Object obj, Iterable iterable) {
        boolean putAll;
        synchronized (this.f25273b) {
            putAll = mo5783e().putAll(obj, iterable);
        }
        return putAll;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.f25273b) {
            remove = mo5783e().remove(obj, obj2);
        }
        return remove;
    }

    public Collection removeAll(Object obj) {
        Collection removeAll;
        synchronized (this.f25273b) {
            removeAll = mo5783e().removeAll(obj);
        }
        return removeAll;
    }

    public Collection replaceValues(Object obj, Iterable iterable) {
        Collection replaceValues;
        synchronized (this.f25273b) {
            replaceValues = mo5783e().replaceValues(obj, iterable);
        }
        return replaceValues;
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        int size;
        synchronized (this.f25273b) {
            size = mo5783e().size();
        }
        return size;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, gr2] */
    @Override // com.google.common.collect.Multimap
    public final Collection values() {
        gr2 gr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f23085d == null) {
                    this.f23085d = new pr2(mo5783e().values(), this.f25273b);
                }
                gr2Var = this.f23085d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gr2Var;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean putAll(Multimap multimap) {
        boolean putAll;
        synchronized (this.f25273b) {
            putAll = mo5783e().putAll(multimap);
        }
        return putAll;
    }
}
