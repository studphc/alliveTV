package p000;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class jg1 extends Converter implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final BiMap f20497b;

    public jg1(BiMap biMap) {
        this.f20497b = (BiMap) Preconditions.checkNotNull(biMap);
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        boolean z;
        V v = this.f20497b.inverse().get(obj);
        if (v != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "No non-null mapping present for input: %s", obj);
        return v;
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        boolean z;
        V v = this.f20497b.get(obj);
        if (v != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "No non-null mapping present for input: %s", obj);
        return v;
    }

    @Override // com.google.common.base.Converter, com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof jg1) {
            return this.f20497b.equals(((jg1) obj).f20497b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f20497b.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f20497b);
        return AbstractC1726qj.m7059o("Maps.asConverter(", valueOf, ")", valueOf.length() + 18);
    }
}
