package p000;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* renamed from: ml */
/* loaded from: classes.dex */
public final class C1552ml extends Converter implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: b */
    public final CaseFormat f22971b;

    /* renamed from: c */
    public final CaseFormat f22972c;

    public C1552ml(CaseFormat caseFormat, CaseFormat caseFormat2) {
        this.f22971b = (CaseFormat) Preconditions.checkNotNull(caseFormat);
        this.f22972c = (CaseFormat) Preconditions.checkNotNull(caseFormat2);
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return this.f22972c.m3756to(this.f22971b, (String) obj);
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return this.f22971b.m3756to(this.f22972c, (String) obj);
    }

    @Override // com.google.common.base.Converter, com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (!(obj instanceof C1552ml)) {
            return false;
        }
        C1552ml c1552ml = (C1552ml) obj;
        if (!this.f22971b.equals(c1552ml.f22971b) || !this.f22972c.equals(c1552ml.f22972c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f22971b.hashCode() ^ this.f22972c.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f22971b);
        String valueOf2 = String.valueOf(this.f22972c);
        return AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 14, valueOf, ".converterTo(", valueOf2, ")");
    }
}
