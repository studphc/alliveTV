package p000;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class zy2 {

    /* renamed from: a */
    public static final zy2 f29573a;

    /* renamed from: b */
    public static final /* synthetic */ zy2[] f29574b = {new zy2() { // from class: wy2
        @Override // p000.zy2
        /* renamed from: a */
        public final Class mo8083a(Class cls) {
            return cls.getEnclosingClass();
        }
    }, new zy2() { // from class: xy2
        @Override // p000.zy2
        /* renamed from: a */
        public final Class mo8083a(Class cls) {
            if (cls.isLocalClass()) {
                return null;
            }
            return cls.getEnclosingClass();
        }
    }};

    /* JADX INFO: Fake field, exist only in values array */
    zy2 EF4;

    static {
        ParameterizedType parameterizedType = (ParameterizedType) yy2.class.getGenericSuperclass();
        Objects.requireNonNull(parameterizedType);
        for (zy2 zy2Var : values()) {
            if (zy2Var.mo8083a(yy2.class) == parameterizedType.getOwnerType()) {
                f29573a = zy2Var;
                return;
            }
        }
        throw new AssertionError();
    }

    public static zy2 valueOf(String str) {
        return (zy2) Enum.valueOf(zy2.class, str);
    }

    public static zy2[] values() {
        return (zy2[]) f29574b.clone();
    }

    /* renamed from: a */
    public abstract Class mo8083a(Class cls);
}
