package p000;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class lr2 extends pr2 implements Map {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient sr2 f22648c;

    /* renamed from: d */
    public transient gr2 f22649d;

    /* renamed from: e */
    public transient sr2 f22650e;

    @Override // java.util.Map
    public final void clear() {
        synchronized (this.f25273b) {
            mo4828e().clear();
        }
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f25273b) {
            containsKey = mo4828e().containsKey(obj);
        }
        return containsKey;
    }

    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f25273b) {
            containsValue = mo4828e().containsValue(obj);
        }
        return containsValue;
    }

    /* renamed from: e */
    public Map mo4828e() {
        return (Map) this.f25272a;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, sr2] */
    public Set entrySet() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f22650e == null) {
                    this.f22650e = new pr2(mo4828e().entrySet(), this.f25273b);
                }
                sr2Var = this.f22650e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f25273b) {
            equals = mo4828e().equals(obj);
        }
        return equals;
    }

    public Object get(Object obj) {
        Object obj2;
        synchronized (this.f25273b) {
            obj2 = mo4828e().get(obj);
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = mo4828e().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f25273b) {
            isEmpty = mo4828e().isEmpty();
        }
        return isEmpty;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, sr2] */
    @Override // java.util.Map
    public Set keySet() {
        sr2 sr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f22648c == null) {
                    this.f22648c = new pr2(mo4828e().keySet(), this.f25273b);
                }
                sr2Var = this.f22648c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sr2Var;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this.f25273b) {
            put = mo4828e().put(obj, obj2);
        }
        return put;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        synchronized (this.f25273b) {
            mo4828e().putAll(map);
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        Object remove;
        synchronized (this.f25273b) {
            remove = mo4828e().remove(obj);
        }
        return remove;
    }

    @Override // java.util.Map
    public final int size() {
        int size;
        synchronized (this.f25273b) {
            size = mo4828e().size();
        }
        return size;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [pr2, gr2] */
    public Collection values() {
        gr2 gr2Var;
        synchronized (this.f25273b) {
            try {
                if (this.f22649d == null) {
                    this.f22649d = new pr2(mo4828e().values(), this.f25273b);
                }
                gr2Var = this.f22649d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gr2Var;
    }
}
