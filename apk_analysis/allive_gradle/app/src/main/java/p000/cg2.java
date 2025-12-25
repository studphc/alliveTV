package p000;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.sync.SemaphoreKt;

/* loaded from: classes2.dex */
public final class cg2 extends Segment {

    /* renamed from: d */
    public final AtomicReferenceArray f8361d;

    public cg2(long j, cg2 cg2Var, int i) {
        super(j, cg2Var, i);
        int i2;
        i2 = SemaphoreKt.f22129f;
        this.f8361d = new AtomicReferenceArray(i2);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int getNumberOfSlots() {
        int i;
        i = SemaphoreKt.f22129f;
        return i;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final void onCancellation(int i, Throwable th, CoroutineContext coroutineContext) {
        Symbol symbol;
        symbol = SemaphoreKt.f22128e;
        this.f8361d.set(i, symbol);
        onSlotCleaned();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    }
}
