package p000;

import com.google.common.base.Equivalence;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class y90 extends Equivalence implements Serializable {

    /* renamed from: a */
    public static final y90 f28871a = new Equivalence();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f28871a;
    }

    @Override // com.google.common.base.Equivalence
    public final boolean doEquivalent(Object obj, Object obj2) {
        return false;
    }

    @Override // com.google.common.base.Equivalence
    public final int doHash(Object obj) {
        return System.identityHashCode(obj);
    }
}
