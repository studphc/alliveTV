package p000;

import com.google.common.base.Converter;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* renamed from: lw */
/* loaded from: classes.dex */
public final class C1526lw extends Converter implements Serializable {

    /* renamed from: b */
    public final Function f22683b;

    /* renamed from: c */
    public final Function f22684c;

    public C1526lw(Function function, Function function2) {
        this.f22683b = (Function) Preconditions.checkNotNull(function);
        this.f22684c = (Function) Preconditions.checkNotNull(function2);
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return this.f22684c.apply(obj);
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return this.f22683b.apply(obj);
    }

    @Override // com.google.common.base.Converter, com.google.common.base.Function
    public final boolean equals(Object obj) {
        if (!(obj instanceof C1526lw)) {
            return false;
        }
        C1526lw c1526lw = (C1526lw) obj;
        if (!this.f22683b.equals(c1526lw.f22683b) || !this.f22684c.equals(c1526lw.f22684c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f22684c.hashCode() + (this.f22683b.hashCode() * 31);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f22683b);
        String valueOf2 = String.valueOf(this.f22684c);
        StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 18, "Converter.from(", valueOf, ", ", valueOf2);
        m7062r.append(")");
        return m7062r.toString();
    }
}
