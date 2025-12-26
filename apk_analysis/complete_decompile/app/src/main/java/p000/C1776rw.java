package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CopyableThreadContextElement;

/* renamed from: rw */
/* loaded from: classes2.dex */
public final class C1776rw extends Lambda implements Function2 {

    /* renamed from: b */
    public static final C1776rw f26166b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineContext coroutineContext = (CoroutineContext) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (element instanceof CopyableThreadContextElement) {
            return coroutineContext.plus(((CopyableThreadContextElement) element).copyForChild());
        }
        return coroutineContext.plus(element);
    }
}
