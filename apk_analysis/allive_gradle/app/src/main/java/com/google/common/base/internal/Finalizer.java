package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class Finalizer implements Runnable {

    /* renamed from: d */
    public static final Logger f14509d = Logger.getLogger(Finalizer.class.getName());

    /* renamed from: e */
    public static final Constructor f14510e;

    /* renamed from: f */
    public static final Field f14511f;

    /* renamed from: a */
    public final WeakReference f14512a;

    /* renamed from: b */
    public final PhantomReference f14513b;

    /* renamed from: c */
    public final ReferenceQueue f14514c;

    static {
        Constructor constructor;
        Field field = null;
        try {
            constructor = Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            constructor = null;
        }
        f14510e = constructor;
        if (constructor == null) {
            try {
                Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
                declaredField.setAccessible(true);
                field = declaredField;
            } catch (Throwable unused2) {
                f14509d.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            }
        }
        f14511f = field;
    }

    public Finalizer(Class cls, ReferenceQueue referenceQueue, PhantomReference phantomReference) {
        this.f14514c = referenceQueue;
        this.f14512a = new WeakReference(cls);
        this.f14513b = phantomReference;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(10:5|6|7|(1:9)|10|11|12|(1:14)|16|17)|24|(0)|10|11|12|(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        r7.log(java.util.logging.Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: all -> 0x005a, TRY_LEAVE, TryCatch #0 {all -> 0x005a, blocks: (B:12:0x0052, B:14:0x0056), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void startFinalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        Thread thread;
        Field field;
        if (cls.getName().equals("com.google.common.base.FinalizableReference")) {
            Finalizer finalizer = new Finalizer(cls, referenceQueue, phantomReference);
            String name = Finalizer.class.getName();
            Logger logger = f14509d;
            Constructor constructor = f14510e;
            if (constructor != null) {
                try {
                    thread = (Thread) constructor.newInstance(null, finalizer, name, 0L, Boolean.FALSE);
                } catch (Throwable th) {
                    logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
                }
                if (thread == null) {
                    thread = new Thread(null, finalizer, name);
                }
                thread.setDaemon(true);
                field = f14511f;
                if (field != null) {
                    field.set(thread, null);
                }
                thread.start();
                return;
            }
            thread = null;
            if (thread == null) {
            }
            thread.setDaemon(true);
            field = f14511f;
            if (field != null) {
            }
            thread.start();
            return;
        }
        throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }

    /* renamed from: a */
    public final boolean m3787a(Reference reference) {
        Method method;
        Class cls = (Class) this.f14512a.get();
        if (cls == null) {
            method = null;
        } else {
            try {
                method = cls.getMethod("finalizeReferent", null);
            } catch (NoSuchMethodException e) {
                throw new AssertionError(e);
            }
        }
        if (method == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.f14513b) {
                return false;
            }
            try {
                method.invoke(reference, null);
            } catch (Throwable th) {
                f14509d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.f14514c.poll();
        } while (reference != null);
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (m3787a(this.f14514c.remove())) {
        }
    }
}
