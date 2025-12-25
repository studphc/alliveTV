package p000;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: cr */
/* loaded from: classes2.dex */
public final class C1095cr extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ CoroutineContext[] f16084b;

    /* renamed from: c */
    public final /* synthetic */ Ref.IntRef f16085c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1095cr(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        super(2);
        this.f16084b = coroutineContextArr;
        this.f16085c = intRef;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        Intrinsics.checkNotNullParameter((Unit) obj, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(element, "element");
        Ref.IntRef intRef = this.f16085c;
        int i = intRef.element;
        intRef.element = i + 1;
        this.f16084b[i] = element;
        return Unit.INSTANCE;
    }
}
