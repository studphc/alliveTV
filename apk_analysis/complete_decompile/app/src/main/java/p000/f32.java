package p000;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;

/* loaded from: classes2.dex */
public final class f32 implements ParameterizedType, Type {

    /* renamed from: a */
    public final Class f17116a;

    /* renamed from: b */
    public final Type f17117b;

    /* renamed from: c */
    public final Type[] f17118c;

    public f32(Class rawType, Type type, ArrayList typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.f17116a = rawType;
        this.f17117b = type;
        this.f17118c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics.areEqual(this.f17116a, parameterizedType.getRawType()) && Intrinsics.areEqual(this.f17117b, parameterizedType.getOwnerType())) {
                if (Arrays.equals(this.f17118c, parameterizedType.getActualTypeArguments())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.f17118c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f17117b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f17116a;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Class cls = this.f17116a;
        Type type = this.f17117b;
        if (type != null) {
            sb.append(TypesJVMKt.access$typeToString(type));
            sb.append("$");
            sb.append(cls.getSimpleName());
        } else {
            sb.append(TypesJVMKt.access$typeToString(cls));
        }
        Type[] typeArr = this.f17118c;
        if (typeArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ArraysKt___ArraysKt.joinTo(typeArr, sb, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : "<", (r14 & 8) == 0 ? ">" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : e32.f16664h);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f17116a.hashCode();
        Type type = this.f17117b;
        if (type != null) {
            i = type.hashCode();
        } else {
            i = 0;
        }
        return (hashCode ^ i) ^ Arrays.hashCode(this.f17118c);
    }

    public final String toString() {
        return getTypeName();
    }
}
