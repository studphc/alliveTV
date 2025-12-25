package p000;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: br */
/* loaded from: classes2.dex */
public final class C0567br implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final CoroutineContext[] f8134a;

    static {
        final DefaultConstructorMarker defaultConstructorMarker = null;
        new Object(defaultConstructorMarker) { // from class: kotlin.coroutines.CombinedContext$Serialized$Companion
        };
    }

    public C0567br(CoroutineContext[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.f8134a = elements;
    }

    private final Object readResolve() {
        CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
        for (CoroutineContext coroutineContext2 : this.f8134a) {
            coroutineContext = coroutineContext.plus(coroutineContext2);
        }
        return coroutineContext;
    }
}
