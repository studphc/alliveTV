package p000;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

/* loaded from: classes2.dex */
public final class gw1 extends AtomicReference implements BiConsumer {
    private static final long serialVersionUID = 45838553147237545L;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Throwable th = (Throwable) obj2;
        BiConsumer m5544l = ki0.m5544l(get());
        if (m5544l != null) {
            m5544l.accept(obj, th);
        }
    }
}
