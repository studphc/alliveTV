package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;
import javax.annotation.CheckForNull;

@GwtIncompatible
/* loaded from: classes.dex */
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    public FinalizableWeakReference(@CheckForNull T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.f14478a);
        finalizableReferenceQueue.m3764a();
    }
}
