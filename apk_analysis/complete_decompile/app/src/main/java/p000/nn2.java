package p000;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes2.dex */
public final class nn2 implements SharingStarted {

    /* renamed from: a */
    public final long f23426a;

    /* renamed from: b */
    public final long f23427b;

    public nn2(long j, long j2) {
        this.f23426a = j;
        this.f23427b = j2;
        if (j >= 0) {
            if (j2 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.SharingStarted
    public final Flow command(StateFlow stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new ln2(this, null)), new SuspendLambda(2, null)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof nn2) {
            nn2 nn2Var = (nn2) obj;
            if (this.f23426a == nn2Var.f23426a && this.f23427b == nn2Var.f23427b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f23426a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.f23427b;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        List createListBuilder = AbstractC1167eq.createListBuilder(2);
        long j = this.f23426a;
        if (j > 0) {
            createListBuilder.add("stopTimeout=" + j + "ms");
        }
        long j2 = this.f23427b;
        if (j2 < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + j2 + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.joinToString$default(AbstractC1167eq.build(createListBuilder), null, null, null, 0, null, null, 63, null) + ')';
    }
}
