package p000;

import com.google.common.io.Closeables;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: tp */
/* loaded from: classes2.dex */
public final class C1843tp implements InterfaceC1880up {

    /* renamed from: a */
    public final Method f26914a;

    public C1843tp(Method method) {
        this.f26914a = method;
    }

    @Override // p000.InterfaceC1880up
    /* renamed from: a */
    public final void mo7395a(Closeable closeable, Throwable th, Throwable th2) {
        if (th == th2) {
            return;
        }
        try {
            this.f26914a.invoke(th, th2);
        } catch (Throwable unused) {
            Logger logger = Closeables.f15068a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(closeable);
            logger.log(level, AbstractC1726qj.m7054j(valueOf.length() + 42, "Suppressing exception thrown when closing ", valueOf), th2);
        }
    }
}
