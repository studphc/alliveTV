package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellingNode;

/* loaded from: classes2.dex */
public final class g51 extends JobCancellingNode {

    /* renamed from: e */
    public static final AtomicIntegerFieldUpdater f17544e = AtomicIntegerFieldUpdater.newUpdater(g51.class, "_invoked");

    @Volatile
    private volatile int _invoked;

    /* renamed from: d */
    public final Function1 f17545d;

    public g51(Function1 function1) {
        this.f17545d = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (f17544e.compareAndSet(this, 0, 1)) {
            this.f17545d.invoke(th);
        }
    }
}
