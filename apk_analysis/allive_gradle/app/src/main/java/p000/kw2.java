package p000;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class kw2 extends ForwardingCollection implements Set {

    /* renamed from: a */
    public final Collection f22233a;

    public kw2(Collection collection) {
        this.f22233a = collection;
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f22233a;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return Sets.m4069a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return Sets.m4070b(this);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Collection delegate() {
        return this.f22233a;
    }
}
