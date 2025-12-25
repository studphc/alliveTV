package p000;

import com.google.common.io.Closeables;
import java.io.Closeable;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: sp */
/* loaded from: classes2.dex */
public final class C1806sp implements InterfaceC1880up {

    /* renamed from: a */
    public static final C1806sp f26512a = new Object();

    @Override // p000.InterfaceC1880up
    /* renamed from: a */
    public final void mo7395a(Closeable closeable, Throwable th, Throwable th2) {
        Logger logger = Closeables.f15068a;
        Level level = Level.WARNING;
        String valueOf = String.valueOf(closeable);
        logger.log(level, AbstractC1726qj.m7054j(valueOf.length() + 42, "Suppressing exception thrown when closing ", valueOf), th2);
    }
}
