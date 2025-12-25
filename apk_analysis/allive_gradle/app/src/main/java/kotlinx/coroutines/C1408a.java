package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlinx.coroutines.a */
/* loaded from: classes2.dex */
public final class C1408a extends Lambda implements Function1 {

    /* renamed from: b */
    public static final C1408a f21434b = new Lambda(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj;
        if (element instanceof CoroutineDispatcher) {
            return (CoroutineDispatcher) element;
        }
        return null;
    }
}
