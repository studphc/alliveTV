package p000;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* loaded from: classes2.dex */
public final class dt2 extends Lambda implements Function2 {

    /* renamed from: b */
    public static final dt2 f16538b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Integer num;
        int i;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (element instanceof ThreadContextElement) {
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i = num.intValue();
            } else {
                i = 1;
            }
            if (i == 0) {
                return element;
            }
            return Integer.valueOf(i + 1);
        }
        return obj;
    }
}
