package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class ir2 extends pr2 implements Map.Entry {
    private static final long serialVersionUID = 0;

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        synchronized (this.f25273b) {
            equals = ((Map.Entry) this.f25272a).equals(obj);
        }
        return equals;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        Object key;
        synchronized (this.f25273b) {
            key = ((Map.Entry) this.f25272a).getKey();
        }
        return key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object value;
        synchronized (this.f25273b) {
            value = ((Map.Entry) this.f25272a).getValue();
        }
        return value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        synchronized (this.f25273b) {
            hashCode = ((Map.Entry) this.f25272a).hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object value;
        synchronized (this.f25273b) {
            value = ((Map.Entry) this.f25272a).setValue(obj);
        }
        return value;
    }
}
