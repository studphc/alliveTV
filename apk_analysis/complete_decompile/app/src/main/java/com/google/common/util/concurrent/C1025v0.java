package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;

/* renamed from: com.google.common.util.concurrent.v0 */
/* loaded from: classes2.dex */
public enum C1025v0 extends CycleDetectingLockFactory.Policies {
    public C1025v0() {
        super("DISABLED", 2);
    }

    @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
    public final void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException) {
    }
}
