package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.PhantomReference;
import javax.annotation.CheckForNull;

@GwtIncompatible
/* loaded from: classes.dex */
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    public FinalizablePhantomReference(@CheckForNull T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.f14478a);
        finalizableReferenceQueue.m3764a();
    }
}
