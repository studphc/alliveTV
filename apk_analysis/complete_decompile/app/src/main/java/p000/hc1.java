package p000;

import com.google.common.cache.ConcurrentMapC0840e;
import java.util.Map;

/* loaded from: classes.dex */
public final class hc1 implements Map.Entry {

    /* renamed from: a */
    public final Object f18017a;

    /* renamed from: b */
    public Object f18018b;

    /* renamed from: c */
    public final /* synthetic */ ConcurrentMapC0840e f18019c;

    public hc1(ConcurrentMapC0840e concurrentMapC0840e, Object obj, Object obj2) {
        this.f18019c = concurrentMapC0840e;
        this.f18017a = obj;
        this.f18018b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!this.f18017a.equals(entry.getKey()) || !this.f18018b.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f18017a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f18018b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f18017a.hashCode() ^ this.f18018b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object put = this.f18019c.put(this.f18017a, obj);
        this.f18018b = obj;
        return put;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f18017a);
        String valueOf2 = String.valueOf(this.f18018b);
        return AbstractC1726qj.m7059o(valueOf, "=", valueOf2, valueOf2.length() + valueOf.length() + 1);
    }
}
