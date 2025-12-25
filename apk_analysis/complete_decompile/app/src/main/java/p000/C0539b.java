package p000;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: b */
/* loaded from: classes2.dex */
public final class C0539b implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Type f7821a;

    /* renamed from: b */
    public final Type f7822b;

    /* renamed from: c */
    public final Type[] f7823c;

    public C0539b(Type type, Type type2, Type... typeArr) {
        Type canonicalize;
        boolean z;
        Objects.requireNonNull(type2);
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z2 = true;
            if (!Modifier.isStatic(cls.getModifiers()) && cls.getEnclosingClass() != null) {
                z = false;
            } else {
                z = true;
            }
            if (type == null && !z) {
                z2 = false;
            }
            C$Gson$Preconditions.checkArgument(z2);
        }
        if (type == null) {
            canonicalize = null;
        } else {
            canonicalize = C$Gson$Types.canonicalize(type);
        }
        this.f7821a = canonicalize;
        this.f7822b = C$Gson$Types.canonicalize(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f7823c = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Objects.requireNonNull(this.f7823c[i]);
            C$Gson$Types.m4414a(this.f7823c[i]);
            Type[] typeArr3 = this.f7823c;
            typeArr3[i] = C$Gson$Types.canonicalize(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f7823c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f7821a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f7822b;
    }

    public final int hashCode() {
        int i;
        int hashCode = Arrays.hashCode(this.f7823c) ^ this.f7822b.hashCode();
        Type type = this.f7821a;
        if (type != null) {
            i = type.hashCode();
        } else {
            i = 0;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        Type[] typeArr = this.f7823c;
        int length = typeArr.length;
        Type type = this.f7822b;
        if (length == 0) {
            return C$Gson$Types.typeToString(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(C$Gson$Types.typeToString(type));
        sb.append("<");
        sb.append(C$Gson$Types.typeToString(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(C$Gson$Types.typeToString(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
