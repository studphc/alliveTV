package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class lz2 implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final ImmutableList f22731a;

    /* renamed from: b */
    public final ImmutableList f22732b;

    public lz2(Type[] typeArr, Type[] typeArr2) {
        mz2.m6265b(typeArr, "lower bound for wildcard");
        mz2.m6265b(typeArr2, "upper bound for wildcard");
        gz2 gz2Var = gz2.f17893c;
        this.f22731a = gz2Var.m5028c(typeArr);
        this.f22732b = gz2Var.m5028c(typeArr2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) obj;
        if (!this.f22731a.equals(Arrays.asList(wildcardType.getLowerBounds()))) {
            return false;
        }
        if (!this.f22732b.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
            return false;
        }
        return true;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        return mz2.m6266c(this.f22731a);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return mz2.m6266c(this.f22732b);
    }

    public final int hashCode() {
        return this.f22731a.hashCode() ^ this.f22732b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("?");
        UnmodifiableIterator it = this.f22731a.iterator();
        while (it.hasNext()) {
            Type type = (Type) it.next();
            sb.append(" super ");
            sb.append(gz2.f17893c.mo4650b(type));
        }
        Joiner joiner = mz2.f23181a;
        for (Type type2 : Iterables.filter(this.f22732b, Predicates.not(Predicates.equalTo(Object.class)))) {
            sb.append(" extends ");
            sb.append(gz2.f17893c.mo4650b(type2));
        }
        return sb.toString();
    }
}
