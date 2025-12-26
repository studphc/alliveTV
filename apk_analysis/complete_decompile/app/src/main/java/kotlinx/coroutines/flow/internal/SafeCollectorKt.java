package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import p000.sd2;

@Metadata(m5568d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, m5569d2 = {"kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SafeCollectorKt {

    /* renamed from: a */
    public static final Function3 f21994a;

    static {
        sd2 sd2Var = sd2.f26389h;
        Intrinsics.checkNotNull(sd2Var, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f21994a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(sd2Var, 3);
    }
}
