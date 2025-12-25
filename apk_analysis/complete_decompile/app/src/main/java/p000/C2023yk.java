package p000;

import java.util.concurrent.Future;
import kotlin.Unit;
import kotlinx.coroutines.JobNode;

/* renamed from: yk */
/* loaded from: classes2.dex */
public final class C2023yk extends JobNode {

    /* renamed from: d */
    public final Future f28992d;

    public C2023yk(Future future) {
        this.f28992d = future;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (th != null) {
            this.f28992d.cancel(false);
        }
    }
}
