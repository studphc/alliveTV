package p000;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.TypesJVMKt;

/* loaded from: classes2.dex */
public final class iy2 implements TypeVariable, Type {

    /* renamed from: a */
    public final KTypeParameter f20308a;

    public iy2(KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.f20308a = typeParameter;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof TypeVariable) && Intrinsics.areEqual(this.f20308a.getName(), ((TypeVariable) obj).getName())) {
            getGenericDeclaration();
            throw null;
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        Type m5627a;
        List<KType> upperBounds = this.f20308a.getUpperBounds();
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            m5627a = TypesJVMKt.m5627a((KType) it.next(), true);
            arrayList.add(m5627a);
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError(AbstractC1726qj.m7038C("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f20308a));
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        return this.f20308a.getName();
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return this.f20308a.getName();
    }

    public final int hashCode() {
        this.f20308a.getName().hashCode();
        getGenericDeclaration();
        throw null;
    }

    public final String toString() {
        return this.f20308a.getName();
    }
}
