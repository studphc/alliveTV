package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.dx0;
import p000.wd0;
import p000.xd0;

@GwtIncompatible
/* loaded from: classes.dex */
public class FinalizableReferenceQueue implements Closeable {

    /* renamed from: d */
    public static final Logger f14476d = Logger.getLogger(FinalizableReferenceQueue.class.getName());

    /* renamed from: e */
    public static final Method f14477e;

    /* renamed from: a */
    public final ReferenceQueue f14478a;

    /* renamed from: b */
    public final PhantomReference f14479b;

    /* renamed from: c */
    public final boolean f14480c;

    static {
        xd0[] xd0VarArr = {new wd0(15), new wd0(0), new dx0(14)};
        for (int i = 0; i < 3; i++) {
            Class mo4626e = xd0VarArr[i].mo4626e();
            if (mo4626e != null) {
                try {
                    f14477e = mo4626e.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
                    return;
                } catch (NoSuchMethodException e) {
                    throw new AssertionError(e);
                }
            }
        }
        throw new AssertionError();
    }

    public FinalizableReferenceQueue() {
        boolean z = true;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.f14478a = referenceQueue;
        PhantomReference phantomReference = new PhantomReference(this, referenceQueue);
        this.f14479b = phantomReference;
        try {
            f14477e.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (Throwable th) {
            f14476d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            z = false;
        }
        this.f14480c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m3764a() {
        if (this.f14480c) {
            return;
        }
        while (true) {
            Reference poll = this.f14478a.poll();
            if (poll != 0) {
                poll.clear();
                try {
                    ((FinalizableReference) poll).finalizeReferent();
                } catch (Throwable th) {
                    f14476d.log(Level.SEVERE, "Error cleaning up after reference.", th);
                }
            } else {
                return;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f14479b.enqueue();
        m3764a();
    }
}
