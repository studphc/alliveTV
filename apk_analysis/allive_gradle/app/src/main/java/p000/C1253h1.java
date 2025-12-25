package p000;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: h1 */
/* loaded from: classes.dex */
public final class C1253h1 implements Iterator {

    /* renamed from: a */
    public final Iterator f17908a;

    /* renamed from: b */
    public Object f17909b = null;

    /* renamed from: c */
    public Collection f17910c = null;

    /* renamed from: d */
    public Iterator f17911d = b61.f7906a;

    /* renamed from: e */
    public final /* synthetic */ AbstractC1930w1 f17912e;

    /* renamed from: f */
    public final /* synthetic */ int f17913f;

    public C1253h1(AbstractC1930w1 abstractC1930w1, int i) {
        this.f17913f = i;
        this.f17912e = abstractC1930w1;
        this.f17908a = abstractC1930w1.f28031f.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f17908a.hasNext() && !this.f17911d.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f17911d.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f17908a.next();
            this.f17909b = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f17910c = collection;
            this.f17911d = collection.iterator();
        }
        Object obj = this.f17909b;
        Object next = this.f17911d.next();
        switch (this.f17913f) {
            case 0:
                return next;
            default:
                return Maps.immutableEntry(obj, next);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f17911d.remove();
        Collection collection = this.f17910c;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f17908a.remove();
        }
        AbstractC1930w1 abstractC1930w1 = this.f17912e;
        abstractC1930w1.f28032g--;
    }
}
