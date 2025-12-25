package kotlinx.coroutines.debug.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* renamed from: kotlinx.coroutines.debug.internal.a */
/* loaded from: classes2.dex */
public final class C1422a extends Lambda implements Function1 {

    /* renamed from: b */
    public static final C1422a f21544b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(!DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, (DebugProbesImpl.CoroutineOwner) obj));
    }
}
