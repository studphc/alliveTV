package p000;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class i31 extends ImmutableCollection {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final ImmutableMultimap f18280b;

    public i31(ImmutableMultimap immutableMultimap) {
        this.f18280b = immutableMultimap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return this.f18280b.containsEntry(entry.getKey(), entry.getValue());
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f18280b.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        ImmutableMultimap immutableMultimap = this.f18280b;
        immutableMultimap.getClass();
        return new g31(immutableMultimap);
    }
}
