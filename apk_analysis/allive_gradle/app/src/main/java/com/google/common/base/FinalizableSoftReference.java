package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.SoftReference;
import javax.annotation.CheckForNull;

@GwtIncompatible
/* loaded from: classes.dex */
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    public FinalizableSoftReference(@CheckForNull T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.f14478a);
        finalizableReferenceQueue.m3764a();
    }
}
