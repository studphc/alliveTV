package p000;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class rw0 implements GenericArrayType, Type {

    /* renamed from: a */
    public final Type f26167a;

    public rw0(Type elementType) {
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        this.f26167a = elementType;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            if (Intrinsics.areEqual(this.f26167a, ((GenericArrayType) obj).getGenericComponentType())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f26167a;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return TypesJVMKt.access$typeToString(this.f26167a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public final int hashCode() {
        return this.f26167a.hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
