package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p000.RunnableC1609o4;

@KeepForSdk
/* loaded from: classes.dex */
public class NumberedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    public final String f13670a;

    /* renamed from: b */
    public final AtomicInteger f13671b = new AtomicInteger();

    /* renamed from: c */
    public final ThreadFactory f13672c = Executors.defaultThreadFactory();

    @KeepForSdk
    public NumberedThreadFactory(@NonNull String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.f13670a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.f13672c.newThread(new RunnableC1609o4(3, runnable));
        newThread.setName(this.f13670a + "[" + this.f13671b.getAndIncrement() + "]");
        return newThread;
    }
}
