package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p000.RunnableC1609o4;

@KeepForSdk
/* loaded from: classes.dex */
public class NamedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    public final String f13668a;

    /* renamed from: b */
    public final ThreadFactory f13669b = Executors.defaultThreadFactory();

    @KeepForSdk
    public NamedThreadFactory(@NonNull String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.f13668a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.f13669b.newThread(new RunnableC1609o4(3, runnable));
        newThread.setName(this.f13668a);
        return newThread;
    }
}
