package p000;

import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class wz2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: b */
    public static final Logger f28408b = Logger.getLogger(wz2.class.getName());

    /* renamed from: a */
    public final Runtime f28409a;

    public wz2(Runtime runtime) {
        this.f28409a = runtime;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Runtime runtime = this.f28409a;
        try {
            f28408b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
        } finally {
            try {
            } finally {
            }
        }
    }
}
