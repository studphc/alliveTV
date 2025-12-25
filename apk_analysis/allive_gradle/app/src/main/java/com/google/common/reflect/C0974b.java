package com.google.common.reflect;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import java.util.Collection;
import java.util.Set;
import p000.dy2;
import p000.ey2;
import p000.hy2;

/* renamed from: com.google.common.reflect.b */
/* loaded from: classes2.dex */
public final class C0974b extends TypeToken.TypeSet {
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    public transient ImmutableSet f15244c;

    /* renamed from: d */
    public final /* synthetic */ TypeToken f15245d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0974b(TypeToken typeToken) {
        super();
        this.f15245d = typeToken;
    }

    private Object readResolve() {
        return this.f15245d.getTypes().classes();
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet
    public final TypeToken.TypeSet classes() {
        return this;
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet
    public final TypeToken.TypeSet interfaces() {
        throw new UnsupportedOperationException("classes().interfaces() not supported.");
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet
    public final Set rawTypes() {
        return ImmutableSet.copyOf((Collection) new dy2(ey2.f17041b).mo4506b(this.f15245d.m4297g()));
    }

    @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public final Set delegate() {
        ImmutableSet immutableSet = this.f15244c;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet set = FluentIterable.from(new dy2(ey2.f17040a).mo4506b(ImmutableList.m3903of(this.f15245d))).filter(hy2.f18217a).toSet();
        this.f15244c = set;
        return set;
    }
}
