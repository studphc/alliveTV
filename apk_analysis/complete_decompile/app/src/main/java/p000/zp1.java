package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public final class zp1 extends AbstractC0543b3 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient Supplier f29460h;

    /* renamed from: i */
    public transient Comparator f29461i;

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Supplier supplier = (Supplier) objectInputStream.readObject();
        this.f29460h = supplier;
        this.f29461i = ((SortedSet) supplier.get()).comparator();
        m7963n((Map) objectInputStream.readObject());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f29460h);
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

    @Override // p000.AbstractC0543b3
    /* renamed from: t */
    public final SortedSet mo2006i() {
        return (SortedSet) this.f29460h.get();
    }

    @Override // com.google.common.collect.SortedSetMultimap
    public final Comparator valueComparator() {
        return this.f29461i;
    }
}
