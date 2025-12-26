package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;

/* loaded from: classes2.dex */
public final class td2 extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ SafeCollector f26779b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public td2(SafeCollector safeCollector) {
        super(2);
        this.f26779b = safeCollector;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int intValue = ((Number) obj).intValue();
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        CoroutineContext.Key<?> key = element.getKey();
        CoroutineContext.Element element2 = this.f26779b.collectContext.get(key);
        if (key != Job.INSTANCE) {
            if (element != element2) {
                i = Integer.MIN_VALUE;
            } else {
                i = intValue + 1;
            }
            return Integer.valueOf(i);
        }
        Job job = (Job) element2;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        Job transitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) element, job);
        if (transitiveCoroutineParent == job) {
            if (job != null) {
                intValue++;
            }
            return Integer.valueOf(intValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + transitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
