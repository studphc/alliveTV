package p000;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum ez2 extends gz2 {
    public ez2() {
        super("JAVA9", 3);
    }

    @Override // p000.gz2
    /* renamed from: a */
    public final Type mo2179a(Type type) {
        return gz2.f17891a.mo2179a(type);
    }

    @Override // p000.gz2
    /* renamed from: b */
    public final String mo4650b(Type type) {
        return gz2.f17892b.mo4650b(type);
    }

    @Override // p000.gz2
    /* renamed from: d */
    public final Type mo2180d(Type type) {
        return (Type) Preconditions.checkNotNull(type);
    }
}
