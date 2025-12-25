package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m5569d2 = {"checkParallelism", "", "", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: classes2.dex */
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int i) {
        if (i >= 1) {
        } else {
            throw new IllegalArgumentException(ye0.m8291k(i, "Expected positive parallelism level, but got ").toString());
        }
    }
}
