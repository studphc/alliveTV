package p000;

import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

/* renamed from: o */
/* loaded from: classes.dex */
public final class C1604o extends AbstractC1706q {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f25353b = (AbstractC1706q) objectInputStream.readObject();
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f25353b);
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final /* bridge */ /* synthetic */ Object delegate() {
        return super.delegate();
    }

    @Override // p000.AbstractC1706q
    /* renamed from: e */
    public final Object mo3851e(Object obj) {
        return this.f25353b.mo3852f(obj);
    }

    @Override // p000.AbstractC1706q
    /* renamed from: f */
    public final Object mo3852f(Object obj) {
        return this.f25353b.mo3851e(obj);
    }

    @GwtIncompatible
    public Object readResolve() {
        return this.f25353b.inverse();
    }

    @Override // p000.AbstractC1706q, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public final /* bridge */ /* synthetic */ Collection values() {
        return values();
    }
}
