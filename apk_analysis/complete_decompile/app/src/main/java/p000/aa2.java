package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class aa2 extends ImmutableList {

    /* renamed from: c */
    public final transient Object[] f100c;

    /* renamed from: d */
    public final transient int f101d;

    /* renamed from: e */
    public final transient int f102e;

    public aa2(int i, int i2, Object[] objArr) {
        this.f100c = objArr;
        this.f101d = i;
        this.f102e = i2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: e */
    public final boolean mo7e() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, this.f102e);
        Object obj = this.f100c[(i * 2) + this.f101d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f102e;
    }
}
