package p000;

import com.google.common.cache.ConcurrentMapC0840e;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class ib1 extends kz0 {

    /* renamed from: c */
    public final /* synthetic */ int f18355c;

    /* renamed from: d */
    public final /* synthetic */ ConcurrentMapC0840e f18356d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ib1(ConcurrentMapC0840e concurrentMapC0840e, int i) {
        super(concurrentMapC0840e);
        this.f18355c = i;
        this.f18356d = concurrentMapC0840e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        ConcurrentMapC0840e concurrentMapC0840e;
        Object obj2;
        switch (this.f18355c) {
            case 0:
                if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = (concurrentMapC0840e = this.f18356d).get(key)) == null || !concurrentMapC0840e.f14592f.equivalent(entry.getValue(), obj2)) {
                    return false;
                }
                return true;
            default:
                return this.f18356d.containsKey(obj);
        }
    }

    @Override // p000.kz0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f18355c) {
            case 0:
                return new hb1(this.f18356d, 0);
            default:
                return new hb1(this.f18356d, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.f18355c) {
            case 0:
                if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || !this.f18356d.remove(key, entry.getValue())) {
                    return false;
                }
                return true;
            default:
                if (this.f18356d.remove(obj) != null) {
                    return true;
                }
                return false;
        }
    }
}
