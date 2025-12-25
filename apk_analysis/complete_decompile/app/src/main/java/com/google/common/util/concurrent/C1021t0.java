package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;

/* renamed from: com.google.common.util.concurrent.t0 */
/* loaded from: classes2.dex */
public enum C1021t0 extends CycleDetectingLockFactory.Policies {
    public C1021t0() {
        super("THROW", 0);
    }

    @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
    public final void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException) {
        throw potentialDeadlockException;
    }
}
