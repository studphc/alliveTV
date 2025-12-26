package p000;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.WildcardTypeImpl$Companion;

/* loaded from: classes2.dex */
public final class l53 implements WildcardType, Type {

    /* renamed from: c */
    public static final WildcardTypeImpl$Companion f22350c = new WildcardTypeImpl$Companion(null);

    /* renamed from: d */
    public static final l53 f22351d = new l53(null, null);

    /* renamed from: a */
    public final Type f22352a;

    /* renamed from: b */
    public final Type f22353b;

    public l53(Type type, Type type2) {
        this.f22352a = type;
        this.f22353b = type2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f22353b;
        if (type == null) {
            return new Type[0];
        }
        return new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        Type type = this.f22353b;
        if (type != null) {
            return "? super " + TypesJVMKt.access$typeToString(type);
        }
        Type type2 = this.f22352a;
        if (type2 != null && !Intrinsics.areEqual(type2, Object.class)) {
            return "? extends " + TypesJVMKt.access$typeToString(type2);
        }
        return "?";
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        Type type = this.f22352a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public final int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public final String toString() {
        return getTypeName();
    }
}
