package p000;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* renamed from: c */
/* loaded from: classes2.dex */
public final class C0575c implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Type f8210a;

    /* renamed from: b */
    public final Type f8211b;

    public C0575c(Type[] typeArr, Type[] typeArr2) {
        boolean z;
        boolean z2;
        if (typeArr2.length <= 1) {
            z = true;
        } else {
            z = false;
        }
        C$Gson$Preconditions.checkArgument(z);
        if (typeArr.length == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        C$Gson$Preconditions.checkArgument(z2);
        if (typeArr2.length == 1) {
            Objects.requireNonNull(typeArr2[0]);
            C$Gson$Types.m4414a(typeArr2[0]);
            C$Gson$Preconditions.checkArgument(typeArr[0] == Object.class);
            this.f8211b = C$Gson$Types.canonicalize(typeArr2[0]);
            this.f8210a = Object.class;
            return;
        }
        Objects.requireNonNull(typeArr[0]);
        C$Gson$Types.m4414a(typeArr[0]);
        this.f8211b = null;
        this.f8210a = C$Gson$Types.canonicalize(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f8211b;
        if (type != null) {
            return new Type[]{type};
        }
        return C$Gson$Types.f15716a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f8210a};
    }

    public final int hashCode() {
        int i;
        Type type = this.f8211b;
        if (type != null) {
            i = type.hashCode() + 31;
        } else {
            i = 1;
        }
        return i ^ (this.f8210a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f8211b;
        if (type != null) {
            return "? super " + C$Gson$Types.typeToString(type);
        }
        Type type2 = this.f8210a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + C$Gson$Types.typeToString(type2);
    }
}
