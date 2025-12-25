package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.Service;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.logging.Level;
import p000.AbstractC1726qj;
import p000.eh2;
import p000.x91;

/* renamed from: com.google.common.util.concurrent.f1 */
/* loaded from: classes2.dex */
public final class C0993f1 {

    /* renamed from: a */
    public final Monitor f15379a = new Monitor();

    /* renamed from: b */
    public final SetMultimap f15380b;

    /* renamed from: c */
    public final Multiset f15381c;

    /* renamed from: d */
    public final IdentityHashMap f15382d;

    /* renamed from: e */
    public boolean f15383e;

    /* renamed from: f */
    public boolean f15384f;

    /* renamed from: g */
    public final int f15385g;

    /* renamed from: h */
    public final C0987d1 f15386h;

    /* renamed from: i */
    public final C0990e1 f15387i;

    /* renamed from: j */
    public final x91 f15388j;

    public C0993f1(ImmutableList immutableList) {
        SetMultimap build = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
        this.f15380b = build;
        this.f15381c = build.keys();
        this.f15382d = Maps.newIdentityHashMap();
        this.f15386h = new C0987d1(this);
        this.f15387i = new C0990e1(this);
        this.f15388j = new x91();
        this.f15385g = immutableList.size();
        build.putAll(Service.State.NEW, immutableList);
    }

    /* renamed from: a */
    public final void m4351a() {
        Service.State state = Service.State.RUNNING;
        if (this.f15381c.count(state) == this.f15385g) {
            return;
        }
        String valueOf = String.valueOf(Multimaps.filterKeys(this.f15380b, Predicates.not(Predicates.equalTo(state))));
        throw new IllegalStateException(AbstractC1726qj.m7054j(valueOf.length() + 79, "Expected to be healthy after starting. The following services are not running: ", valueOf));
    }

    /* renamed from: b */
    public final void m4352b() {
        Preconditions.checkState(!this.f15379a.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
        this.f15388j.m8151a();
    }

    /* renamed from: c */
    public final ImmutableSetMultimap m4353c() {
        ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
        Monitor monitor = this.f15379a;
        monitor.enter();
        try {
            for (Map.Entry entry : this.f15380b.entries()) {
                if (!(entry.getValue() instanceof eh2)) {
                    builder.put(entry);
                }
            }
            monitor.leave();
            return builder.build();
        } catch (Throwable th) {
            monitor.leave();
            throw th;
        }
    }

    /* renamed from: d */
    public final void m4354d(Service service, Service.State state, Service.State state2) {
        boolean z;
        SetMultimap setMultimap = this.f15380b;
        Multiset multiset = this.f15381c;
        Preconditions.checkNotNull(service);
        if (state != state2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Monitor monitor = this.f15379a;
        monitor.enter();
        try {
            this.f15384f = true;
            if (!this.f15383e) {
                monitor.leave();
                m4352b();
                return;
            }
            Preconditions.checkState(setMultimap.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
            Preconditions.checkState(setMultimap.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
            IdentityHashMap identityHashMap = this.f15382d;
            Stopwatch stopwatch = (Stopwatch) identityHashMap.get(service);
            if (stopwatch == null) {
                stopwatch = Stopwatch.createStarted();
                identityHashMap.put(service, stopwatch);
            }
            Service.State state3 = Service.State.RUNNING;
            if (state2.compareTo(state3) >= 0 && stopwatch.isRunning()) {
                stopwatch.stop();
                if (!(service instanceof eh2)) {
                    ServiceManager.f15336c.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                }
            }
            Service.State state4 = Service.State.FAILED;
            x91 x91Var = this.f15388j;
            if (state2 == state4) {
                x91Var.m8152b(new C0984c1(service));
            }
            int count = multiset.count(state3);
            int i = this.f15385g;
            if (count == i) {
                x91Var.m8152b(ServiceManager.f15337d);
            } else if (multiset.count(Service.State.TERMINATED) + multiset.count(state4) == i) {
                x91Var.m8152b(ServiceManager.f15338e);
            }
            monitor.leave();
            m4352b();
        } catch (Throwable th) {
            monitor.leave();
            m4352b();
            throw th;
        }
    }
}
