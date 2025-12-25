package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.eh2;

/* renamed from: com.google.common.util.concurrent.b1 */
/* loaded from: classes2.dex */
public final class C0981b1 extends Service.Listener {

    /* renamed from: a */
    public final Service f15353a;

    /* renamed from: b */
    public final WeakReference f15354b;

    public C0981b1(Service service, WeakReference weakReference) {
        this.f15353a = service;
        this.f15354b = weakReference;
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void failed(Service.State state, Throwable th) {
        C0993f1 c0993f1 = (C0993f1) this.f15354b.get();
        if (c0993f1 != null) {
            Service service = this.f15353a;
            if (!(service instanceof eh2)) {
                Logger logger = ServiceManager.f15336c;
                Level level = Level.SEVERE;
                String valueOf = String.valueOf(service);
                String valueOf2 = String.valueOf(state);
                StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 34, "Service ", valueOf, " has failed in the ", valueOf2);
                m7062r.append(" state.");
                logger.log(level, m7062r.toString(), th);
            }
            c0993f1.m4354d(service, state, Service.State.FAILED);
        }
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void running() {
        C0993f1 c0993f1 = (C0993f1) this.f15354b.get();
        if (c0993f1 != null) {
            c0993f1.m4354d(this.f15353a, Service.State.STARTING, Service.State.RUNNING);
        }
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void starting() {
        C0993f1 c0993f1 = (C0993f1) this.f15354b.get();
        if (c0993f1 != null) {
            Service.State state = Service.State.NEW;
            Service.State state2 = Service.State.STARTING;
            Service service = this.f15353a;
            c0993f1.m4354d(service, state, state2);
            if (!(service instanceof eh2)) {
                ServiceManager.f15336c.log(Level.FINE, "Starting {0}.", service);
            }
        }
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void stopping(Service.State state) {
        C0993f1 c0993f1 = (C0993f1) this.f15354b.get();
        if (c0993f1 != null) {
            c0993f1.m4354d(this.f15353a, state, Service.State.STOPPING);
        }
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public final void terminated(Service.State state) {
        C0993f1 c0993f1 = (C0993f1) this.f15354b.get();
        if (c0993f1 != null) {
            Service service = this.f15353a;
            if (!(service instanceof eh2)) {
                ServiceManager.f15336c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{service, state});
            }
            c0993f1.m4354d(service, state, Service.State.TERMINATED);
        }
    }
}
