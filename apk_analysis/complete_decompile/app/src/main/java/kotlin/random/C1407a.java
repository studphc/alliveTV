package kotlin.random;

import java.io.Serializable;

/* renamed from: kotlin.random.a */
/* loaded from: classes2.dex */
public final class C1407a implements Serializable {

    /* renamed from: a */
    public static final C1407a f21211a = new Object();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return Random.INSTANCE;
    }
}
