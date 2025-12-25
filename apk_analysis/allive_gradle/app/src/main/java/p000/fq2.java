package p000;

import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes2.dex */
public final class fq2 extends SharedFlowImpl implements StateFlow {
    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(((Number) getLastReplayedLocked()).intValue());
        }
        return valueOf;
    }

    /* renamed from: n */
    public final void m4827n(int i) {
        synchronized (this) {
            tryEmit(Integer.valueOf(((Number) getLastReplayedLocked()).intValue() + i));
        }
    }
}
