package p000;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum cz2 extends gz2 {
    public cz2() {
        super("JAVA7", 1);
    }

    @Override // p000.gz2
    /* renamed from: a */
    public final Type mo2179a(Type type) {
        if (type instanceof Class) {
            Joiner joiner = mz2.f23181a;
            return Array.newInstance((Class<?>) type, 0).getClass();
        }
        return new az2(type);
    }

    @Override // p000.gz2
    /* renamed from: d */
    public final Type mo2180d(Type type) {
        return (Type) Preconditions.checkNotNull(type);
    }
}
