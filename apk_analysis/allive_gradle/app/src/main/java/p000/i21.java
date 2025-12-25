package p000;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes.dex */
public abstract class i21 extends ImmutableList {
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return ((u92) this).f27157c.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        ((u92) this).f27157c.getClass();
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        ((u92) this).f27157c.getClass();
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return ((u92) this).f27157c.size();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new h21(((u92) this).f27157c);
    }
}
