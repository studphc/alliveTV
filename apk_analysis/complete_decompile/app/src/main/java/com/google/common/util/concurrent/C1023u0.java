package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import java.util.logging.Level;

/* renamed from: com.google.common.util.concurrent.u0 */
/* loaded from: classes2.dex */
public enum C1023u0 extends CycleDetectingLockFactory.Policies {
    public C1023u0() {
        super("WARN", 1);
    }

    @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
    public final void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException) {
        CycleDetectingLockFactory.f15309c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
    }
}
