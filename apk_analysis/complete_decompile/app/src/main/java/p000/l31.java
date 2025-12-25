package p000;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public final class l31 extends ImmutableCollection {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final transient ImmutableMultimap f22313b;

    public l31(ImmutableMultimap immutableMultimap) {
        this.f22313b = immutableMultimap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public final int mo3896a(Object[] objArr, int i) {
        UnmodifiableIterator it = this.f22313b.f14675f.values().iterator();
        while (it.hasNext()) {
            i = ((ImmutableCollection) it.next()).mo3896a(objArr, i);
        }
        return i;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f22313b.containsValue(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f22313b.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        ImmutableMultimap immutableMultimap = this.f22313b;
        immutableMultimap.getClass();
        return new h31(immutableMultimap);
    }
}
