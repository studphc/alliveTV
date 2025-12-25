package p000;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobNode;

/* loaded from: classes2.dex */
public final class h51 extends JobNode {

    /* renamed from: d */
    public final Function1 f17943d;

    public h51(Function1 function1) {
        this.f17943d = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.f17943d.invoke(th);
    }
}
