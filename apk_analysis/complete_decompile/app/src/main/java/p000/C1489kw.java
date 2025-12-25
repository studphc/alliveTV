package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* renamed from: kw */
/* loaded from: classes.dex */
public final class C1489kw extends Converter implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final Converter f22221b;

    /* renamed from: c */
    public final Converter f22222c;

    public C1489kw(Converter converter, Converter converter2) {
        this.f22221b = converter;
        this.f22222c = converter2;
    }

    @Override // com.google.common.base.Converter
    /* renamed from: a */
    public final Object mo3761a(Object obj) {
        return this.f22221b.mo3761a(this.f22222c.mo3761a(obj));
    }

    @Override // com.google.common.base.Converter
    /* renamed from: b */
    public final Object mo3762b(Object obj) {
        return this.f22222c.mo3762b(this.f22221b.mo3762b(obj));
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
        if (!(obj instanceof C1489kw)) {
            return false;
        }
        C1489kw c1489kw = (C1489kw) obj;
        if (!this.f22221b.equals(c1489kw.f22221b) || !this.f22222c.equals(c1489kw.f22222c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f22222c.hashCode() + (this.f22221b.hashCode() * 31);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f22221b);
        String valueOf2 = String.valueOf(this.f22222c);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 10, valueOf, ".andThen(", valueOf2, ")");
    }
}
