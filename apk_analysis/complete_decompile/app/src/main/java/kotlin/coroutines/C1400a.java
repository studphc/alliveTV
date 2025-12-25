package kotlin.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlin.coroutines.a */
/* loaded from: classes2.dex */
public final class C1400a extends Lambda implements Function2 {

    /* renamed from: b */
    public static final C1400a f21080b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CombinedContext combinedContext;
        CoroutineContext acc = (CoroutineContext) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        Intrinsics.checkNotNullParameter(acc, "acc");
        Intrinsics.checkNotNullParameter(element, "element");
        CoroutineContext minusKey = acc.minusKey(element.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (minusKey != emptyCoroutineContext) {
            ContinuationInterceptor.Companion companion = ContinuationInterceptor.INSTANCE;
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(companion);
            if (continuationInterceptor == null) {
                combinedContext = new CombinedContext(minusKey, element);
            } else {
                CoroutineContext minusKey2 = minusKey.minusKey(companion);
                if (minusKey2 == emptyCoroutineContext) {
                    return new CombinedContext(element, continuationInterceptor);
                }
                combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), continuationInterceptor);
            }
            return combinedContext;
        }
        return element;
    }
}
