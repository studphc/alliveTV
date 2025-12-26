package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlinx.coroutines.d */
/* loaded from: classes2.dex */
public final class C1419d extends Lambda implements Function1 {

    /* renamed from: b */
    public static final C1419d f21503b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (element instanceof ExecutorCoroutineDispatcher) {
            return (ExecutorCoroutineDispatcher) element;
        }
        return null;
    }
}
