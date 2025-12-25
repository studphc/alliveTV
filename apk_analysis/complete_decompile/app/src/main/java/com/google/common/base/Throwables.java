package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;
import p000.ca1;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Throwables {

    /* renamed from: a */
    public static final Object f14500a;

    /* renamed from: b */
    public static final Method f14501b;

    /* renamed from: c */
    public static final Method f14502c;

    /* JADX WARN: Removed duplicated region for block: B:9:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Object obj;
        Method method;
        Method method2;
        Method method3 = null;
        try {
            obj = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            obj = null;
        }
        f14500a = obj;
        if (obj != null) {
            try {
                method = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
            } catch (ThreadDeath e2) {
                throw e2;
            } catch (Throwable unused2) {
            }
            f14501b = method;
            if (obj != null) {
                try {
                    try {
                        method2 = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceDepth", Throwable.class);
                    } catch (ThreadDeath e3) {
                        throw e3;
                    } catch (Throwable unused3) {
                        method2 = null;
                    }
                    if (method2 != null) {
                        method2.invoke(obj, new Throwable());
                        method3 = method2;
                    }
                } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused4) {
                }
            }
            f14502c = method3;
        }
        method = null;
        f14501b = method;
        if (obj != null) {
        }
        f14502c = method3;
    }

    public static List<Throwable> getCausalChain(Throwable th) {
        Preconditions.checkNotNull(th);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th);
        boolean z = false;
        Throwable th2 = th;
        while (true) {
            th = th.getCause();
            if (th != null) {
                arrayList.add(th);
                if (th != th2) {
                    if (z) {
                        th2 = th2.getCause();
                    }
                    z = !z;
                } else {
                    throw new IllegalArgumentException("Loop in causal chain detected.", th);
                }
            } else {
                return Collections.unmodifiableList(arrayList);
            }
        }
    }

    @CheckForNull
    @GwtIncompatible
    public static <X extends Throwable> X getCauseAs(Throwable th, Class<X> cls) {
        try {
            return cls.cast(th.getCause());
        } catch (ClassCastException e) {
            e.initCause(th);
            throw e;
        }
    }

    public static Throwable getRootCause(Throwable th) {
        boolean z = false;
        Throwable th2 = th;
        while (true) {
            Throwable cause = th.getCause();
            if (cause != null) {
                if (cause != th2) {
                    if (z) {
                        th2 = th2.getCause();
                    }
                    z = !z;
                    th = cause;
                } else {
                    throw new IllegalArgumentException("Loop in causal chain detected.", cause);
                }
            } else {
                return th;
            }
        }
    }

    @GwtIncompatible
    public static String getStackTraceAsString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @GwtIncompatible
    @Deprecated
    public static List<StackTraceElement> lazyStackTrace(Throwable th) {
        if (lazyStackTraceIsLazy()) {
            Preconditions.checkNotNull(th);
            return new ca1(th);
        }
        return Collections.unmodifiableList(Arrays.asList(th.getStackTrace()));
    }

    @GwtIncompatible
    @Deprecated
    public static boolean lazyStackTraceIsLazy() {
        if (f14501b != null && f14502c != null) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException propagate(Throwable th) {
        throwIfUnchecked(th);
        throw new RuntimeException(th);
    }

    @GwtIncompatible
    @Deprecated
    public static <X extends Throwable> void propagateIfInstanceOf(@CheckForNull Throwable th, Class<X> cls) {
        if (th != null) {
            throwIfInstanceOf(th, cls);
        }
    }

    @GwtIncompatible
    @Deprecated
    public static void propagateIfPossible(@CheckForNull Throwable th) {
        if (th != null) {
            throwIfUnchecked(th);
        }
    }

    @GwtIncompatible
    public static <X extends Throwable> void throwIfInstanceOf(Throwable th, Class<X> cls) {
        Preconditions.checkNotNull(th);
        if (!cls.isInstance(th)) {
        } else {
            throw cls.cast(th);
        }
    }

    public static void throwIfUnchecked(Throwable th) {
        Preconditions.checkNotNull(th);
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                return;
            } else {
                throw ((Error) th);
            }
        }
        throw ((RuntimeException) th);
    }

    @GwtIncompatible
    public static <X extends Throwable> void propagateIfPossible(@CheckForNull Throwable th, Class<X> cls) {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    @GwtIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@CheckForNull Throwable th, Class<X1> cls, Class<X2> cls2) {
        Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th, cls2);
    }
}
