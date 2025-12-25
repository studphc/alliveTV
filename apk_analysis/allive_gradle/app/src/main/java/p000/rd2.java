package p000;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class rd2 extends Lambda implements Function2 {

    /* renamed from: b */
    public static final rd2 f25940b = new Lambda(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(((Number) obj).intValue() + 1);
    }
}
