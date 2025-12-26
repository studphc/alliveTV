package p000;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.sync.SemaphoreKt;

/* loaded from: classes2.dex */
public final /* synthetic */ class zf2 extends FunctionReferenceImpl implements Function2 {

    /* renamed from: h */
    public static final zf2 f29359h = new FunctionReferenceImpl(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return SemaphoreKt.access$createSegment(((Number) obj).longValue(), (cg2) obj2);
    }
}
