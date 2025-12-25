package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class wp1 extends AbstractC1179f1 {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: h */
    public transient Supplier f28269h;

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f28269h = (Supplier) objectInputStream.readObject();
        m7963n((Map) objectInputStream.readObject());
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f28269h);
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
        return (List) this.f28269h.get();
    }
}
