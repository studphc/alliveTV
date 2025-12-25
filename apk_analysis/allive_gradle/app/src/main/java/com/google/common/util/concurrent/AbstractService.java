package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.AbstractC1726qj;
import p000.w91;
import p000.x91;

@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractService implements Service {

    /* renamed from: h */
    public static final C1000j f15264h = new Object();

    /* renamed from: i */
    public static final C1002k f15265i = new Object();

    /* renamed from: j */
    public static final C1006m f15266j;

    /* renamed from: k */
    public static final C1006m f15267k;

    /* renamed from: l */
    public static final C1004l f15268l;

    /* renamed from: m */
    public static final C1004l f15269m;

    /* renamed from: n */
    public static final C1004l f15270n;

    /* renamed from: o */
    public static final C1004l f15271o;

    /* renamed from: a */
    public final Monitor f15272a = new Monitor();

    /* renamed from: b */
    public final C1014q f15273b = new C1014q(this);

    /* renamed from: c */
    public final C1016r f15274c = new C1016r(this);

    /* renamed from: d */
    public final C1012p f15275d = new C1012p(this);

    /* renamed from: e */
    public final C1018s f15276e = new C1018s(this);

    /* renamed from: f */
    public final x91 f15277f = new x91();

    /* renamed from: g */
    public volatile C1020t f15278g = new C1020t(Service.State.NEW);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.common.util.concurrent.j] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, com.google.common.util.concurrent.k] */
    static {
        Service.State state = Service.State.STARTING;
        f15266j = new C1006m(state);
        Service.State state2 = Service.State.RUNNING;
        f15267k = new C1006m(state2);
        f15268l = new C1004l(Service.State.NEW);
        f15269m = new C1004l(state);
        f15270n = new C1004l(state2);
        f15271o = new C1004l(Service.State.STOPPING);
    }

    /* renamed from: a */
    public final void m4315a(Service.State state) {
        Service.State state2 = state();
        if (state2 != state) {
            if (state2 == Service.State.FAILED) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(state);
                StringBuilder m7062r = AbstractC1726qj.m7062r(valueOf2.length() + valueOf.length() + 56, "Expected the service ", valueOf, " to be ", valueOf2);
                m7062r.append(", but the service has FAILED");
                throw new IllegalStateException(m7062r.toString(), failureCause());
            }
            String valueOf3 = String.valueOf(this);
            String valueOf4 = String.valueOf(state);
            String valueOf5 = String.valueOf(state2);
            throw new IllegalStateException(AbstractC1726qj.m7061q(AbstractC1726qj.m7062r(valueOf5.length() + valueOf4.length() + valueOf3.length() + 38, "Expected the service ", valueOf3, " to be ", valueOf4), ", but was ", valueOf5));
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        x91 x91Var = this.f15277f;
        x91Var.getClass();
        Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        x91Var.f28481a.add(new w91(listener, executor));
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        Monitor monitor = this.f15272a;
        monitor.enterWhenUninterruptibly(this.f15275d);
        try {
            m4315a(Service.State.RUNNING);
        } finally {
            monitor.leave();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        Monitor monitor = this.f15272a;
        monitor.enterWhenUninterruptibly(this.f15276e);
        try {
            m4315a(Service.State.TERMINATED);
        } finally {
            monitor.leave();
        }
    }

    /* renamed from: b */
    public final void m4316b() {
        if (!this.f15272a.isOccupiedByCurrentThread()) {
            this.f15277f.m8151a();
        }
    }

    /* renamed from: c */
    public final void m4317c(Service.State state) {
        int i = AbstractC1010o.f15410a[state.ordinal()];
        x91 x91Var = this.f15277f;
        switch (i) {
            case 1:
                x91Var.m8152b(f15268l);
                return;
            case 2:
                x91Var.m8152b(f15269m);
                return;
            case 3:
                x91Var.m8152b(f15270n);
                return;
            case 4:
                x91Var.m8152b(f15271o);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    @Beta
    @ForOverride
    public void doCancelStart() {
    }

    @ForOverride
    public abstract void doStart();

    @ForOverride
    public abstract void doStop();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        boolean z;
        C1020t c1020t = this.f15278g;
        Service.State state = Service.State.FAILED;
        Service.State state2 = c1020t.f15426a;
        if (state2 == state) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "failureCause() is only valid if the service has failed, service is %s", state2);
        Throwable th = c1020t.f15428c;
        Objects.requireNonNull(th);
        return th;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        if (state() == Service.State.RUNNING) {
            return true;
        }
        return false;
    }

    public final void notifyFailed(Throwable th) {
        Preconditions.checkNotNull(th);
        this.f15272a.enter();
        try {
            Service.State state = state();
            int i = AbstractC1010o.f15410a[state.ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3 && i != 4) {
                    if (i != 5) {
                    }
                } else {
                    this.f15278g = new C1020t(Service.State.FAILED, false, th);
                    this.f15277f.m8152b(new C1008n(state, th));
                }
                return;
            }
            String valueOf = String.valueOf(state);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Failed while in state:");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString(), th);
        } finally {
            this.f15272a.leave();
            m4316b();
        }
    }

    public final void notifyStarted() {
        this.f15272a.enter();
        try {
            if (this.f15278g.f15426a == Service.State.STARTING) {
                if (this.f15278g.f15427b) {
                    this.f15278g = new C1020t(Service.State.STOPPING);
                    doStop();
                } else {
                    this.f15278g = new C1020t(Service.State.RUNNING);
                    this.f15277f.m8152b(f15265i);
                }
                this.f15272a.leave();
                m4316b();
                return;
            }
            String valueOf = String.valueOf(this.f15278g.f15426a);
            StringBuilder sb = new StringBuilder(valueOf.length() + 43);
            sb.append("Cannot notifyStarted() when the service is ");
            sb.append(valueOf);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            notifyFailed(illegalStateException);
            throw illegalStateException;
        } catch (Throwable th) {
            this.f15272a.leave();
            m4316b();
            throw th;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0011. Please report as an issue. */
    public final void notifyStopped() {
        this.f15272a.enter();
        try {
            Service.State state = state();
            switch (AbstractC1010o.f15410a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    String valueOf = String.valueOf(state);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 43);
                    sb.append("Cannot notifyStopped() when the service is ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                case 2:
                case 3:
                case 4:
                    this.f15278g = new C1020t(Service.State.TERMINATED);
                    m4317c(state);
                    return;
                default:
                    return;
            }
        } finally {
            this.f15272a.leave();
            m4316b();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (this.f15272a.enterIf(this.f15273b)) {
            try {
                this.f15278g = new C1020t(Service.State.STARTING);
                this.f15277f.m8152b(f15264h);
                doStart();
            } finally {
                try {
                    return this;
                } finally {
                }
            }
            return this;
        }
        String valueOf = String.valueOf(this);
        throw new IllegalStateException(AbstractC1726qj.m7059o("Service ", valueOf, " has already been started", valueOf.length() + 33));
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        C1020t c1020t = this.f15278g;
        boolean z = c1020t.f15427b;
        Service.State state = c1020t.f15426a;
        if (z && state == Service.State.STARTING) {
            return Service.State.STOPPING;
        }
        return state;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0018. Please report as an issue. */
    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        Service.State state;
        int i;
        C1006m c1006m;
        if (this.f15272a.enterIf(this.f15274c)) {
            try {
                state = state();
                i = AbstractC1010o.f15410a[state.ordinal()];
                c1006m = f15266j;
            } finally {
                try {
                } finally {
                }
            }
            switch (i) {
                case 1:
                    this.f15278g = new C1020t(Service.State.TERMINATED);
                    m4317c(Service.State.NEW);
                    break;
                case 2:
                    this.f15278g = new C1020t(Service.State.STARTING, true, null);
                    this.f15277f.m8152b(c1006m);
                    doCancelStart();
                    break;
                case 3:
                    this.f15278g = new C1020t(Service.State.STOPPING);
                    Service.State state2 = Service.State.RUNNING;
                    Service.State state3 = Service.State.STARTING;
                    x91 x91Var = this.f15277f;
                    if (state2 == state3) {
                        x91Var.m8152b(c1006m);
                    } else {
                        x91Var.m8152b(f15267k);
                    }
                    doStop();
                    break;
                case 4:
                case 5:
                case 6:
                    String valueOf = String.valueOf(state);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 45);
                    sb.append("isStoppable is incorrectly implemented, saw: ");
                    sb.append(valueOf);
                    throw new AssertionError(sb.toString());
            }
        }
        return this;
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        String valueOf = String.valueOf(state());
        return AbstractC1726qj.m7055k(valueOf.length() + simpleName.length() + 3, simpleName, " [", valueOf, "]");
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) {
        Monitor monitor = this.f15272a;
        if (monitor.enterWhenUninterruptibly(this.f15275d, j, timeUnit)) {
            try {
                m4315a(Service.State.RUNNING);
                return;
            } finally {
                monitor.leave();
            }
        }
        String valueOf = String.valueOf(this);
        throw new TimeoutException(AbstractC1726qj.m7059o("Timed out waiting for ", valueOf, " to reach the RUNNING state.", valueOf.length() + 50));
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) {
        Monitor monitor = this.f15272a;
        if (monitor.enterWhenUninterruptibly(this.f15276e, j, timeUnit)) {
            try {
                m4315a(Service.State.TERMINATED);
            } finally {
                monitor.leave();
            }
        } else {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(state());
            throw new TimeoutException(AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 65, "Timed out waiting for ", valueOf, " to reach a terminal state. Current state: ", valueOf2));
        }
    }
}
