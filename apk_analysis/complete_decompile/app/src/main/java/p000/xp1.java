package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class xp1 extends AbstractC1930w1 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient Supplier f28678h;

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f28678h = (Supplier) objectInputStream.readObject();
        m7963n((Map) objectInputStream.readObject());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f28678h);
        objectOutputStream.writeObject(this.f28031f);
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2
    /* renamed from: b */
    public final Map mo3947b() {
        return m7961k();
    }

    @Override // p000.AbstractC1930w1, p000.AbstractC1143e2
    /* renamed from: e */
    public final Set mo3949e() {
        return m7962l();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: i */
    public final Collection mo2006i() {
        return (Collection) this.f28678h.get();
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: o */
    public final Collection mo4o(Collection collection) {
        if (collection instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) collection);
        }
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    @Override // p000.AbstractC1930w1
    /* renamed from: q */
    public final Collection mo5q(Collection collection, Object obj) {
        if (collection instanceof List) {
            return m7964r(obj, (List) collection, null);
        }
        if (collection instanceof NavigableSet) {
            return new C1819t1(this, obj, (NavigableSet) collection, null);
        }
        if (collection instanceof SortedSet) {
            return new C1893v1(this, obj, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new C1856u1(this, obj, (Set) collection);
        }
        return new C1708q1(this, obj, collection, null);
    }
}
