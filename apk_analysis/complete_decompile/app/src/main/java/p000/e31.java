package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class e31 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final w21 f16663a;

    public e31(w21 w21Var) {
        this.f16663a = w21Var;
    }

    public Object readResolve() {
        return this.f16663a.values();
    }
}
