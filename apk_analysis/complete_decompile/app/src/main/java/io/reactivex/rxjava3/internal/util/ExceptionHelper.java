package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000.AbstractC1726qj;

/* loaded from: classes2.dex */
public final class ExceptionHelper {
    public static final Throwable TERMINATED = new Throwable("No further exceptions");

    public static boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable compositeException;
        while (true) {
            Throwable th2 = atomicReference.get();
            if (th2 == TERMINATED) {
                return false;
            }
            if (th2 == null) {
                compositeException = th;
            } else {
                compositeException = new CompositeException(th2, th);
            }
            while (!atomicReference.compareAndSet(th2, compositeException)) {
                if (atomicReference.get() != th2) {
                    break;
                }
            }
            return true;
        }
    }

    public static NullPointerException createNullPointerException(String str) {
        return new NullPointerException(nullWarning(str));
    }

    public static List<Throwable> flatten(Throwable th) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(th);
        while (!arrayDeque.isEmpty()) {
            Throwable th2 = (Throwable) arrayDeque.removeFirst();
            if (th2 instanceof CompositeException) {
                List<Throwable> exceptions = ((CompositeException) th2).getExceptions();
                for (int size = exceptions.size() - 1; size >= 0; size--) {
                    arrayDeque.offerFirst(exceptions.get(size));
                }
            } else {
                arrayList.add(th2);
            }
        }
        return arrayList;
    }

    public static <T> T nullCheck(T t, String str) {
        if (t != null) {
            return t;
        }
        throw createNullPointerException(str);
    }

    public static String nullWarning(String str) {
        return AbstractC1726qj.m7057m(str, " Null values are generally not allowed in 3.x operators and sources.");
    }

    public static Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = TERMINATED;
        if (th != th2) {
            return atomicReference.getAndSet(th2);
        }
        return th;
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable th) {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static String timeoutMessage(long j, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException wrapOrThrow(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }
}
