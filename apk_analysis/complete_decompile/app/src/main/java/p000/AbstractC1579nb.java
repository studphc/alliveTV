package p000;

import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Set;

/* renamed from: nb */
/* loaded from: classes.dex */
public abstract class AbstractC1579nb extends yg1 {

    /* renamed from: a */
    public final ImmutableMap f23316a;

    public AbstractC1579nb(ImmutableMap immutableMap) {
        this.f23316a = immutableMap;
    }

    @Override // p000.yg1
    /* renamed from: a */
    public final Iterator mo84a() {
        return new C1505lb(this.f23316a.size(), 1, this);
    }

    /* renamed from: c */
    public abstract String mo6330c();

    @Override // p000.yg1, java.util.AbstractMap, java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f23316a.containsKey(obj);
    }

    /* renamed from: e */
    public abstract Object mo6331e(int i);

    /* renamed from: f */
    public abstract Object mo6332f(int i, Object obj);

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Integer num = (Integer) this.f23316a.get(obj);
        if (num == null) {
            return null;
        }
        return mo6331e(num.intValue());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.f23316a.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f23316a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        ImmutableMap immutableMap = this.f23316a;
        Integer num = (Integer) immutableMap.get(obj);
        if (num != null) {
            return mo6332f(num.intValue(), obj2);
        }
        String mo6330c = mo6330c();
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(immutableMap.keySet());
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + mo6330c.length() + 9, mo6330c, " ", valueOf, " not in ");
        m7062r.append(valueOf2);
        throw new IllegalArgumentException(m7062r.toString());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f23316a.size();
    }
}
