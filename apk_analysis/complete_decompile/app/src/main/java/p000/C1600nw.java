package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* renamed from: nw */
/* loaded from: classes.dex */
public final class C1600nw extends Converter implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final Converter f23507b;

    public C1600nw(Converter converter) {
        this.f23507b = converter;
    }

    @Override // com.google.common.base.Converter
    /* renamed from: a */
    public final Object mo3761a(Object obj) {
        return this.f23507b.mo3762b(obj);
    }

    @Override // com.google.common.base.Converter
    /* renamed from: b */
    public final Object mo3762b(Object obj) {
        return this.f23507b.mo3761a(obj);
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        throw new AssertionError();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        throw new AssertionError();
    }

    @Override // com.google.common.base.Converter, com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (obj instanceof C1600nw) {
            return this.f23507b.equals(((C1600nw) obj).f23507b);
        }
        return false;
    }

    public final int hashCode() {
        return ~this.f23507b.hashCode();
    }

    @Override // com.google.common.base.Converter
    public final Converter reverse() {
        return this.f23507b;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f23507b);
        return AbstractC1726qj.m7054j(valueOf.length() + 10, valueOf, ".reverse()");
    }
}
