package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.common.util.concurrent.b */
/* loaded from: classes2.dex */
public final class C0979b extends Service.Listener {

    /* renamed from: a */
    public final /* synthetic */ ScheduledExecutorService f15350a;

    public C0979b(ScheduledExecutorService scheduledExecutorService) {
        this.f15350a = scheduledExecutorService;
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void failed(Service.State state, Throwable th) {
        this.f15350a.shutdown();
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void terminated(Service.State state) {
        this.f15350a.shutdown();
    }
}
