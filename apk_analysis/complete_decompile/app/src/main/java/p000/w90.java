package p000;

import com.google.common.base.Equivalence;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class w90 extends Equivalence implements Serializable {

    /* renamed from: a */
    public static final w90 f28101a = new Equivalence();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f28101a;
    }

    @Override // com.google.common.base.Equivalence
    public final boolean doEquivalent(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    @Override // com.google.common.base.Equivalence
    public final int doHash(Object obj) {
        return obj.hashCode();
    }
}
