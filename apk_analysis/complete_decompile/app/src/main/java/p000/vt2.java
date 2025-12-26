package p000;

import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class vt2 extends TimeoutException {
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
