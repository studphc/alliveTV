package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.Arrays;
import java.util.Collection;
import p000.p63;

/* renamed from: com.google.common.collect.z */
/* loaded from: classes.dex */
public abstract class AbstractC0957z extends ImmutableCollection.Builder {

    /* renamed from: a */
    public Object[] f14993a;

    /* renamed from: b */
    public int f14994b;

    /* renamed from: c */
    public boolean f14995c;

    public AbstractC0957z(int i) {
        p63.m6869m(i, "initialCapacity");
        this.f14993a = new Object[i];
        this.f14994b = 0;
    }

    @Override // com.google.common.collect.ImmutableCollection.Builder
    public AbstractC0957z add(Object obj) {
        Preconditions.checkNotNull(obj);
        m4169b(this.f14994b + 1);
        Object[] objArr = this.f14993a;
        int i = this.f14994b;
        this.f14994b = i + 1;
        objArr[i] = obj;
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection.Builder
    public ImmutableCollection.Builder addAll(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            m4169b(collection.size() + this.f14994b);
            if (collection instanceof ImmutableCollection) {
                this.f14994b = ((ImmutableCollection) collection).mo3896a(this.f14993a, this.f14994b);
                return this;
            }
        }
        super.addAll(iterable);
        return this;
    }

    /* renamed from: b */
    public final void m4169b(int i) {
        Object[] objArr = this.f14993a;
        if (objArr.length < i) {
            this.f14993a = Arrays.copyOf(objArr, ImmutableCollection.Builder.m3900a(objArr.length, i));
            this.f14995c = false;
        } else if (this.f14995c) {
            this.f14993a = (Object[]) objArr.clone();
            this.f14995c = false;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection.Builder
    public ImmutableCollection.Builder add(Object... objArr) {
        int length = objArr.length;
        ObjectArrays.m4065a(length, objArr);
        m4169b(this.f14994b + length);
        System.arraycopy(objArr, 0, this.f14993a, this.f14994b, length);
        this.f14994b += length;
        return this;
    }
}
