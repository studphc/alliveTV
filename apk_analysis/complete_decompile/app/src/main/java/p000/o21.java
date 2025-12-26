package p000;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.EnumSet;

/* loaded from: classes.dex */
public final class o21 extends ImmutableSet {

    /* renamed from: c */
    public final transient EnumSet f23574c;

    /* renamed from: d */
    public transient int f23575d;

    public o21(EnumSet enumSet) {
        this.f23574c = enumSet;
    }

    /* renamed from: j */
    public static ImmutableSet m6407j(EnumSet enumSet) {
        int size = enumSet.size();
        if (size != 0) {
            if (size != 1) {
                return new o21(enumSet);
            }
            return ImmutableSet.m3972of(Iterables.getOnlyElement(enumSet));
        }
        return ImmutableSet.m3971of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f23574c.contains(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof o21) {
            collection = ((o21) collection).f23574c;
        }
        return this.f23574c.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o21) {
            obj = ((o21) obj).f23574c;
        }
        return this.f23574c.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.f23575d;
        if (i == 0) {
            int hashCode = this.f23574c.hashCode();
            this.f23575d = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: i */
    public final boolean mo8i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f23574c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f23574c.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return this.f23574c.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new n21(this.f23574c);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        return Iterators.unmodifiableIterator(this.f23574c.iterator());
    }
}
