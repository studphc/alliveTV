package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class b31 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final w21 f7880a;

    public b31(w21 w21Var) {
        this.f7880a = w21Var;
    }

    public Object readResolve() {
        return this.f7880a.keySet();
    }
}
