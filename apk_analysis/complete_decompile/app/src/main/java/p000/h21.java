package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class h21 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final w92 f17933a;

    public h21(w92 w92Var) {
        this.f17933a = w92Var;
    }

    public Object readResolve() {
        return this.f17933a.asList();
    }
}
