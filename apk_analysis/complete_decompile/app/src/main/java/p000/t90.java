package p000;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class t90 extends Converter implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final Class f26727b;

    public t90(Class cls) {
        this.f26727b = (Class) Preconditions.checkNotNull(cls);
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return Enum.valueOf(this.f26727b, (String) obj);
    }

    @Override // com.google.common.base.Converter, com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof t90) {
            return this.f26727b.equals(((t90) obj).f26727b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f26727b.hashCode();
    }

    public final String toString() {
        String name = this.f26727b.getName();
        return AbstractC1726qj.m7059o("Enums.stringConverter(", name, ".class)", name.length() + 29);
    }
}
