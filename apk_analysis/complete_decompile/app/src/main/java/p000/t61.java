package p000;

import kotlin.Unit;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes2.dex */
public final class t61 extends JobNode {

    /* renamed from: d */
    public final SelectInstance f26706d;

    /* renamed from: e */
    public final /* synthetic */ JobSupport f26707e;

    public t61(JobSupport jobSupport, SelectInstance selectInstance) {
        this.f26707e = jobSupport;
        this.f26706d = selectInstance;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.f26706d.trySelect(this.f26707e, Unit.INSTANCE);
    }
}
