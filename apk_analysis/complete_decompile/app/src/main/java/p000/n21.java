package p000;

import java.io.Serializable;
import java.util.EnumSet;

/* loaded from: classes.dex */
public final class n21 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final EnumSet f23200a;

    public n21(EnumSet enumSet) {
        this.f23200a = enumSet;
    }

    public Object readResolve() {
        return new o21(this.f23200a.clone());
    }
}
