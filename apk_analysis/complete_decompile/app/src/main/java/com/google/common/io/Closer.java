package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import p000.C1806sp;
import p000.C1843tp;
import p000.InterfaceC1880up;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class Closer implements Closeable {

    /* renamed from: d */
    public static final InterfaceC1880up f15069d;

    /* renamed from: a */
    public final InterfaceC1880up f15070a;

    /* renamed from: b */
    public final ArrayDeque f15071b = new ArrayDeque(4);

    /* renamed from: c */
    public Throwable f15072c;

    static {
        InterfaceC1880up interfaceC1880up;
        try {
            interfaceC1880up = new C1843tp(Throwable.class.getMethod("addSuppressed", Throwable.class));
        } catch (Throwable unused) {
            interfaceC1880up = null;
        }
        if (interfaceC1880up == null) {
            interfaceC1880up = C1806sp.f26512a;
        }
        f15069d = interfaceC1880up;
    }

    public Closer(InterfaceC1880up interfaceC1880up) {
        this.f15070a = (InterfaceC1880up) Preconditions.checkNotNull(interfaceC1880up);
    }

    public static Closer create() {
        return new Closer(f15069d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Throwable th = this.f15072c;
        while (true) {
            ArrayDeque arrayDeque = this.f15071b;
            if (arrayDeque.isEmpty()) {
                break;
            }
            Closeable closeable = (Closeable) arrayDeque.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f15070a.mo7395a(closeable, th, th2);
                }
            }
        }
        if (this.f15072c == null && th != null) {
            Throwables.propagateIfPossible(th, IOException.class);
            throw new AssertionError(th);
        }
    }

    @CanIgnoreReturnValue
    public <C extends Closeable> C register(C c) {
        if (c != null) {
            this.f15071b.addFirst(c);
        }
        return c;
    }

    public RuntimeException rethrow(Throwable th) {
        Preconditions.checkNotNull(th);
        this.f15072c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable th, Class<X> cls) {
        Preconditions.checkNotNull(th);
        this.f15072c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th, Class<X1> cls, Class<X2> cls2) {
        Preconditions.checkNotNull(th);
        this.f15072c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls, cls2);
        throw new RuntimeException(th);
    }
}
