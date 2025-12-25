package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;
import p000.px2;

/* loaded from: classes2.dex */
public abstract class TypeParameter<T> extends px2 {

    /* renamed from: a */
    public final TypeVariable f15235a;

    public TypeParameter() {
        Type m6934a = m6934a();
        Preconditions.checkArgument(m6934a instanceof TypeVariable, "%s should be a type variable.", m6934a);
        this.f15235a = (TypeVariable) m6934a;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeParameter) {
            return this.f15235a.equals(((TypeParameter) obj).f15235a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15235a.hashCode();
    }

    public String toString() {
        return this.f15235a.toString();
    }
}
