package com.google.common.reflect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import java.util.Set;
import p000.C1593np;
import p000.ey2;
import p000.hy2;

/* renamed from: com.google.common.reflect.c */
/* loaded from: classes2.dex */
public final class C0975c extends TypeToken.TypeSet {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public final transient TypeToken.TypeSet f15246c;

    /* renamed from: d */
    public transient ImmutableSet f15247d;

    /* renamed from: e */
    public final /* synthetic */ TypeToken f15248e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0975c(TypeToken typeToken, TypeToken.TypeSet typeSet) {
        super();
        this.f15248e = typeToken;
        this.f15246c = typeSet;
    }

    private Object readResolve() {
        return this.f15248e.getTypes().interfaces();
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet
    public final TypeToken.TypeSet classes() {
        throw new UnsupportedOperationException("interfaces().classes() not supported.");
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet
    public final TypeToken.TypeSet interfaces() {
        return this;
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet
    public final Set rawTypes() {
        return FluentIterable.from(ey2.f17041b.mo4506b(this.f15248e.m4297g())).filter(new C1593np(4)).toSet();
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        ImmutableSet immutableSet = this.f15247d;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet set = FluentIterable.from(this.f15246c).filter(hy2.f18218b).toSet();
        this.f15247d = set;
        return set;
    }
}
