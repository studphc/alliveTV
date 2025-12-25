package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* loaded from: classes2.dex */
public final class ft2 extends Lambda implements Function2 {

    /* renamed from: b */
    public static final ft2 f17397b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        it2 it2Var = (it2) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (element instanceof ThreadContextElement) {
            ThreadContextElement threadContextElement = (ThreadContextElement) element;
            Object updateThreadContext = threadContextElement.updateThreadContext(it2Var.f20257a);
            int i = it2Var.f20260d;
            it2Var.f20258b[i] = updateThreadContext;
            it2Var.f20260d = i + 1;
            Intrinsics.checkNotNull(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            it2Var.f20259c[i] = threadContextElement;
        }
        return it2Var;
    }
}
