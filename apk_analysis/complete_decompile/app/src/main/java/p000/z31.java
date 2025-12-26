package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class z31 extends ImmutableSet {

    /* renamed from: c */
    public final /* synthetic */ int f29234c = 0;

    /* renamed from: d */
    public final transient Object f29235d;

    public z31(ImmutableSetMultimap immutableSetMultimap) {
        this.f29235d = immutableSetMultimap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: a */
    public int mo3896a(Object[] objArr, int i) {
        switch (this.f29234c) {
            case 1:
                objArr[i] = this.f29235d;
                return i + 1;
            default:
                return super.mo3896a(objArr, i);
        }
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList asList() {
        switch (this.f29234c) {
            case 1:
                return ImmutableList.m3903of(this.f29235d);
            default:
                return super.asList();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f29234c) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return ((ImmutableSetMultimap) this.f29235d).containsEntry(entry.getKey(), entry.getValue());
                }
                return false;
            default:
                return this.f29235d.equals(obj);
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        switch (this.f29234c) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        switch (this.f29234c) {
            case 1:
                return this.f29235d.hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        switch (this.f29234c) {
            case 0:
                ImmutableSetMultimap immutableSetMultimap = (ImmutableSetMultimap) this.f29235d;
                immutableSetMultimap.getClass();
                return new g31(immutableSetMultimap);
            default:
                return Iterators.singletonIterator(this.f29235d);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f29234c) {
            case 0:
                return ((ImmutableSetMultimap) this.f29235d).size();
            default:
                return 1;
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        switch (this.f29234c) {
            case 1:
                String obj = this.f29235d.toString();
                StringBuilder sb = new StringBuilder(AbstractC1726qj.m7052h(2, obj));
                sb.append('[');
                sb.append(obj);
                sb.append(']');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public z31(Object obj) {
        this.f29235d = Preconditions.checkNotNull(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f29234c) {
            case 0:
                return iterator();
            default:
                return Iterators.singletonIterator(this.f29235d);
        }
    }
}
