package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.Sets;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class yp1 extends AbstractC0004a3 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient Supplier f29058h;

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f29058h = (Supplier) objectInputStream.readObject();
        m7963n((Map) objectInputStream.readObject());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f29058h);
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
        return (Set) this.f29058h.get();
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1
    /* renamed from: o */
    public final Collection mo4o(Collection collection) {
        if (collection instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) collection);
        }
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // p000.AbstractC0004a3, p000.AbstractC1930w1
    /* renamed from: q */
    public final Collection mo5q(Collection collection, Object obj) {
        if (collection instanceof NavigableSet) {
            return new C1819t1(this, obj, (NavigableSet) collection, null);
        }
        if (collection instanceof SortedSet) {
            return new C1893v1(this, obj, (SortedSet) collection, null);
        }
        return new C1856u1(this, obj, (Set) collection);
    }
}
