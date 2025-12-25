package p000;

import java.io.Serializable;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class l21 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final EnumMap f22302a;

    public l21(EnumMap enumMap) {
        this.f22302a = enumMap;
    }

    public Object readResolve() {
        return new m21(this.f22302a);
    }
}
