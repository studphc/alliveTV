package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* loaded from: classes2.dex */
public final class et2 extends Lambda implements Function2 {

    /* renamed from: b */
    public static final et2 f16980b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ThreadContextElement threadContextElement = (ThreadContextElement) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (threadContextElement == null) {
            if (element instanceof ThreadContextElement) {
                return (ThreadContextElement) element;
            }
            return null;
        }
        return threadContextElement;
    }
}
