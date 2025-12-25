package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class gz2 {

    /* renamed from: a */
    public static final cz2 f17891a;

    /* renamed from: b */
    public static final dz2 f17892b;

    /* renamed from: c */
    public static final gz2 f17893c;

    /* renamed from: d */
    public static final /* synthetic */ gz2[] f17894d;

    static {
        gz2 gz2Var = new gz2() { // from class: bz2
            @Override // p000.gz2
            /* renamed from: a */
            public final Type mo2179a(Type type) {
                return new az2(type);
            }

            @Override // p000.gz2
            /* renamed from: d */
            public final Type mo2180d(Type type) {
                Preconditions.checkNotNull(type);
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (cls.isArray()) {
                        return new az2(cls.getComponentType());
                    }
                    return type;
                }
                return type;
            }
        };
        cz2 cz2Var = new cz2();
        f17891a = cz2Var;
        dz2 dz2Var = new dz2();
        f17892b = dz2Var;
        ez2 ez2Var = new ez2();
        f17894d = new gz2[]{gz2Var, cz2Var, dz2Var, ez2Var};
        if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
            if (new px2().m6934a().toString().contains("java.util.Map.java.util.Map")) {
                f17893c = dz2Var;
                return;
            } else {
                f17893c = ez2Var;
                return;
            }
        }
        if (new px2().m6934a() instanceof Class) {
            f17893c = cz2Var;
        } else {
            f17893c = gz2Var;
        }
    }

    public static gz2 valueOf(String str) {
        return (gz2) Enum.valueOf(gz2.class, str);
    }

    public static gz2[] values() {
        return (gz2[]) f17894d.clone();
    }

    /* renamed from: a */
    public abstract Type mo2179a(Type type);

    /* renamed from: b */
    public String mo4650b(Type type) {
        Joiner joiner = mz2.f23181a;
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    /* renamed from: c */
    public final ImmutableList m5028c(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            builder.add((ImmutableList.Builder) mo2180d(type));
        }
        return builder.build();
    }

    /* renamed from: d */
    public abstract Type mo2180d(Type type);
}
