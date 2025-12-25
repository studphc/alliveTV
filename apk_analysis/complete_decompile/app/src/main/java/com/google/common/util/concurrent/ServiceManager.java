package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.AbstractC1726qj;
import p000.C1289i0;
import p000.eh2;
import p000.n82;
import p000.w91;
import p000.x91;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class ServiceManager {

    /* renamed from: c */
    public static final Logger f15336c = Logger.getLogger(ServiceManager.class.getName());

    /* renamed from: d */
    public static final C1033z0 f15337d = new Object();

    /* renamed from: e */
    public static final C0978a1 f15338e = new Object();

    /* renamed from: a */
    public final C0993f1 f15339a;

    /* renamed from: b */
    public final ImmutableList f15340b;

    /* loaded from: classes2.dex */
    public static abstract class Listener {
        public void failure(Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            f15336c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new C1289i0());
            copyOf = ImmutableList.m3903of(new AbstractService());
        }
        C0993f1 c0993f1 = new C0993f1(copyOf);
        this.f15339a = c0993f1;
        this.f15340b = copyOf;
        WeakReference weakReference = new WeakReference(c0993f1);
        UnmodifiableIterator it = copyOf.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Service service = (Service) it.next();
            service.addListener(new C0981b1(service, weakReference), MoreExecutors.directExecutor());
            if (service.state() != Service.State.NEW) {
                z = false;
            }
            Preconditions.checkArgument(z, "Can only manage NEW services, %s", service);
        }
        C0993f1 c0993f12 = this.f15339a;
        Monitor monitor = c0993f12.f15379a;
        monitor.enter();
        try {
            if (!c0993f12.f15384f) {
                c0993f12.f15383e = true;
                return;
            }
            ArrayList newArrayList = Lists.newArrayList();
            UnmodifiableIterator it2 = c0993f12.m4353c().values().iterator();
            while (it2.hasNext()) {
                Service service2 = (Service) it2.next();
                if (service2.state() != Service.State.NEW) {
                    newArrayList.add(service2);
                }
            }
            String valueOf = String.valueOf(newArrayList);
            StringBuilder sb = new StringBuilder(valueOf.length() + 89);
            sb.append("Services started transitioning asynchronously before the ServiceManager was constructed: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        } finally {
            monitor.leave();
        }
    }

    public void addListener(Listener listener, Executor executor) {
        x91 x91Var = this.f15339a.f15388j;
        x91Var.getClass();
        Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        x91Var.f28481a.add(new w91(listener, executor));
    }

    public void awaitHealthy() {
        C0993f1 c0993f1 = this.f15339a;
        C0987d1 c0987d1 = c0993f1.f15386h;
        Monitor monitor = c0993f1.f15379a;
        monitor.enterWhenUninterruptibly(c0987d1);
        try {
            c0993f1.m4351a();
        } finally {
            monitor.leave();
        }
    }

    public void awaitStopped() {
        C0993f1 c0993f1 = this.f15339a;
        C0990e1 c0990e1 = c0993f1.f15387i;
        Monitor monitor = c0993f1.f15379a;
        monitor.enterWhenUninterruptibly(c0990e1);
        monitor.leave();
    }

    public boolean isHealthy() {
        UnmodifiableIterator it = this.f15340b.iterator();
        while (it.hasNext()) {
            if (!((Service) it.next()).isRunning()) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        boolean z;
        ImmutableList immutableList = this.f15340b;
        UnmodifiableIterator it = immutableList.iterator();
        while (it.hasNext()) {
            if (((Service) it.next()).state() == Service.State.NEW) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Not all services are NEW, cannot start %s", this);
        }
        UnmodifiableIterator it2 = immutableList.iterator();
        while (it2.hasNext()) {
            Service service = (Service) it2.next();
            try {
                C0993f1 c0993f1 = this.f15339a;
                Monitor monitor = c0993f1.f15379a;
                monitor.enter();
                IdentityHashMap identityHashMap = c0993f1.f15382d;
                try {
                    if (((Stopwatch) identityHashMap.get(service)) == null) {
                        identityHashMap.put(service, Stopwatch.createStarted());
                    }
                    monitor.leave();
                    service.startAsync();
                } catch (Throwable th) {
                    monitor.leave();
                    throw th;
                    break;
                }
            } catch (IllegalStateException e) {
                Level level = Level.WARNING;
                String valueOf = String.valueOf(service);
                f15336c.log(level, AbstractC1726qj.m7054j(valueOf.length() + 24, "Unable to start Service ", valueOf), (Throwable) e);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        C0993f1 c0993f1 = this.f15339a;
        Monitor monitor = c0993f1.f15379a;
        monitor.enter();
        IdentityHashMap identityHashMap = c0993f1.f15382d;
        try {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(identityHashMap.size());
            for (Map.Entry entry : identityHashMap.entrySet()) {
                Service service = (Service) entry.getKey();
                Stopwatch stopwatch = (Stopwatch) entry.getValue();
                if (!stopwatch.isRunning() && !(service instanceof eh2)) {
                    newArrayListWithCapacity.add(Maps.immutableEntry(service, Long.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS))));
                }
            }
            monitor.leave();
            Collections.sort(newArrayListWithCapacity, Ordering.natural().onResultOf(new n82(6)));
            return ImmutableMap.copyOf(newArrayListWithCapacity);
        } catch (Throwable th) {
            monitor.leave();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator it = this.f15340b.iterator();
        while (it.hasNext()) {
            ((Service) it.next()).stopAsync();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", Collections2.filter(this.f15340b, Predicates.not(Predicates.instanceOf(eh2.class)))).toString();
    }

    public ImmutableSetMultimap<Service.State, Service> servicesByState() {
        return this.f15339a.m4353c();
    }

    public void awaitStopped(long j, TimeUnit timeUnit) {
        C0993f1 c0993f1 = this.f15339a;
        Monitor monitor = c0993f1.f15379a;
        monitor.enter();
        try {
            if (monitor.waitForUninterruptibly(c0993f1.f15387i, j, timeUnit)) {
                return;
            }
            String valueOf = String.valueOf(Multimaps.filterKeys(c0993f1.f15380b, Predicates.not(Predicates.m3777in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
            StringBuilder sb = new StringBuilder(valueOf.length() + 83);
            sb.append("Timeout waiting for the services to stop. The following services have not stopped: ");
            sb.append(valueOf);
            throw new TimeoutException(sb.toString());
        } finally {
            monitor.leave();
        }
    }

    public void awaitHealthy(long j, TimeUnit timeUnit) {
        C0993f1 c0993f1 = this.f15339a;
        Monitor monitor = c0993f1.f15379a;
        monitor.enter();
        try {
            if (monitor.waitForUninterruptibly(c0993f1.f15386h, j, timeUnit)) {
                c0993f1.m4351a();
                return;
            }
            String valueOf = String.valueOf(Multimaps.filterKeys(c0993f1.f15380b, Predicates.m3777in(ImmutableSet.m3973of(Service.State.NEW, Service.State.STARTING))));
            StringBuilder sb = new StringBuilder(valueOf.length() + 93);
            sb.append("Timeout waiting for the services to become healthy. The following services have not started: ");
            sb.append(valueOf);
            throw new TimeoutException(sb.toString());
        } finally {
            monitor.leave();
        }
    }
}
