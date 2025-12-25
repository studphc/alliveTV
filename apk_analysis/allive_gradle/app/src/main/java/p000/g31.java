package p000;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class g31 extends UnmodifiableIterator {

    /* renamed from: a */
    public final UnmodifiableIterator f17538a;

    /* renamed from: b */
    public Object f17539b = null;

    /* renamed from: c */
    public UnmodifiableIterator f17540c = z51.f29250d;

    public g31(ImmutableMultimap immutableMultimap) {
        this.f17538a = immutableMultimap.f14675f.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f17540c.hasNext() && !this.f17538a.hasNext()) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f17540c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f17538a.next();
            this.f17539b = entry.getKey();
            this.f17540c = ((ImmutableCollection) entry.getValue()).iterator();
        }
        Object obj = this.f17539b;
        Objects.requireNonNull(obj);
        return Maps.immutableEntry(obj, this.f17540c.next());
    }
}
