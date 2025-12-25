package p000;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum dz2 extends gz2 {
    public dz2() {
        super("JAVA8", 2);
    }

    @Override // p000.gz2
    /* renamed from: a */
    public final Type mo2179a(Type type) {
        return gz2.f17891a.mo2179a(type);
    }

    @Override // p000.gz2
    /* renamed from: b */
    public final String mo4650b(Type type) {
        try {
            return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("Type.getTypeName should be available in Java 8");
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // p000.gz2
    /* renamed from: d */
    public final Type mo2180d(Type type) {
        return (Type) Preconditions.checkNotNull(type);
    }
}
