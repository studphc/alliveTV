package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CopyableThreadContextElement;

/* renamed from: tw */
/* loaded from: classes2.dex */
public final class C1850tw extends Lambda implements Function2 {

    /* renamed from: b */
    public static final C1850tw f27002b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (!((Boolean) obj).booleanValue() && !(element instanceof CopyableThreadContextElement)) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
