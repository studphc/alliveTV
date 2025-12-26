package p000;

import kotlin.Unit;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;

/* loaded from: classes2.dex */
public final class q61 extends JobNode {

    /* renamed from: d */
    public final JobSupport f25460d;

    /* renamed from: e */
    public final r61 f25461e;

    /* renamed from: f */
    public final ChildHandleNode f25462f;

    /* renamed from: g */
    public final Object f25463g;

    public q61(JobSupport jobSupport, r61 r61Var, ChildHandleNode childHandleNode, Object obj) {
        this.f25460d = jobSupport;
        this.f25461e = r61Var;
        this.f25462f = childHandleNode;
        this.f25463g = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        JobSupport.access$continueCompleting(this.f25460d, this.f25461e, this.f25462f, this.f25463g);
    }
}
