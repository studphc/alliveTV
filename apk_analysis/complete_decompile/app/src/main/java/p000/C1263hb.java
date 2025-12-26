package p000;

import androidx.collection.ArrayMap;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: hb */
/* loaded from: classes.dex */
public final class C1263hb implements Iterator, Map.Entry {

    /* renamed from: a */
    public int f17997a;

    /* renamed from: b */
    public int f17998b = -1;

    /* renamed from: c */
    public boolean f17999c;

    /* renamed from: d */
    public final /* synthetic */ ArrayMap f18000d;

    public C1263hb(ArrayMap arrayMap) {
        this.f18000d = arrayMap;
        this.f17997a = arrayMap.getF1755c() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this.f17999c) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i = this.f17998b;
            ArrayMap arrayMap = this.f18000d;
            if (!ContainerHelpersKt.equal(key, arrayMap.keyAt(i)) || !ContainerHelpersKt.equal(entry.getValue(), arrayMap.valueAt(this.f17998b))) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f17999c) {
            return this.f18000d.keyAt(this.f17998b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f17999c) {
            return this.f18000d.valueAt(this.f17998b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f17998b < this.f17997a) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        if (this.f17999c) {
            int i = this.f17998b;
            ArrayMap arrayMap = this.f18000d;
            K keyAt = arrayMap.keyAt(i);
            V valueAt = arrayMap.valueAt(this.f17998b);
            int i2 = 0;
            if (keyAt == 0) {
                hashCode = 0;
            } else {
                hashCode = keyAt.hashCode();
            }
            if (valueAt != 0) {
                i2 = valueAt.hashCode();
            }
            return hashCode ^ i2;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f17998b++;
            this.f17999c = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f17999c) {
            this.f18000d.removeAt(this.f17998b);
            this.f17998b--;
            this.f17997a--;
            this.f17999c = false;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f17999c) {
            return this.f18000d.setValueAt(this.f17998b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
