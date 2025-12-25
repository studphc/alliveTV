package p000;

import com.google.common.collect.ImmutableSet;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class y31 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object[] f28820a;

    public y31(Object[] objArr) {
        this.f28820a = objArr;
    }

    public Object readResolve() {
        return ImmutableSet.copyOf(this.f28820a);
    }
}
