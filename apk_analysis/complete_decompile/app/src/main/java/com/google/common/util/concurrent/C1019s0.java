package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.common.util.concurrent.s0 */
/* loaded from: classes2.dex */
public final class C1019s0 {

    /* renamed from: a */
    public final ConcurrentMap f15423a = new MapMaker().weakKeys().makeMap();

    /* renamed from: b */
    public final ConcurrentMap f15424b = new MapMaker().weakKeys().makeMap();

    /* renamed from: c */
    public final String f15425c;

    public C1019s0(String str) {
        this.f15425c = (String) Preconditions.checkNotNull(str);
    }

    /* renamed from: a */
    public final void m4355a(CycleDetectingLockFactory.Policy policy, List list) {
        boolean z;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1019s0 c1019s0 = (C1019s0) it.next();
            if (this != c1019s0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Attempted to acquire multiple locks with the same rank %s", c1019s0.f15425c);
            ConcurrentMap concurrentMap = this.f15423a;
            if (!concurrentMap.containsKey(c1019s0)) {
                ConcurrentMap concurrentMap2 = this.f15424b;
                CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException = (CycleDetectingLockFactory.PotentialDeadlockException) concurrentMap2.get(c1019s0);
                if (potentialDeadlockException != null) {
                    policy.handlePotentialDeadlock(new CycleDetectingLockFactory.PotentialDeadlockException(c1019s0, this, potentialDeadlockException.getConflictingStackTrace()));
                } else {
                    C1017r0 m4356b = c1019s0.m4356b(this, Sets.newIdentityHashSet());
                    if (m4356b == null) {
                        concurrentMap.put(c1019s0, new C1017r0(c1019s0, this));
                    } else {
                        CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException2 = new CycleDetectingLockFactory.PotentialDeadlockException(c1019s0, this, m4356b);
                        concurrentMap2.put(c1019s0, potentialDeadlockException2);
                        policy.handlePotentialDeadlock(potentialDeadlockException2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final C1017r0 m4356b(C1019s0 c1019s0, Set set) {
        if (!set.add(this)) {
            return null;
        }
        ConcurrentMap concurrentMap = this.f15423a;
        C1017r0 c1017r0 = (C1017r0) concurrentMap.get(c1019s0);
        if (c1017r0 != null) {
            return c1017r0;
        }
        for (Map.Entry entry : concurrentMap.entrySet()) {
            C1019s0 c1019s02 = (C1019s0) entry.getKey();
            C1017r0 m4356b = c1019s02.m4356b(c1019s0, set);
            if (m4356b != null) {
                C1017r0 c1017r02 = new C1017r0(c1019s02, this);
                c1017r02.setStackTrace(((C1017r0) entry.getValue()).getStackTrace());
                c1017r02.initCause(m4356b);
                return c1017r02;
            }
        }
        return null;
    }
}
