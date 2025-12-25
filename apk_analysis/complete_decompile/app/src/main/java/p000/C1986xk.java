package p000;

import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;

/* renamed from: xk */
/* loaded from: classes2.dex */
public final class C1986xk extends CancelHandler {

    /* renamed from: a */
    public final /* synthetic */ int f28592a;

    /* renamed from: b */
    public final Object f28593b;

    public /* synthetic */ C1986xk(int i, Object obj) {
        this.f28592a = i;
        this.f28593b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        switch (this.f28592a) {
            case 0:
                invoke2(th);
                return Unit.INSTANCE;
            case 1:
                invoke2(th);
                return Unit.INSTANCE;
            default:
                invoke2(th);
                return Unit.INSTANCE;
        }
    }

    public final String toString() {
        switch (this.f28592a) {
            case 0:
                return "CancelFutureOnCancel[" + ((Future) this.f28593b) + ']';
            case 1:
                return "DisposeOnCancel[" + ((DisposableHandle) this.f28593b) + ']';
            default:
                return "InvokeOnCancel[" + DebugStringsKt.getClassSimpleName((Function1) this.f28593b) + '@' + DebugStringsKt.getHexAddress(this) + ']';
        }
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        switch (this.f28592a) {
            case 0:
                if (th != null) {
                    ((Future) this.f28593b).cancel(false);
                    return;
                }
                return;
            case 1:
                ((DisposableHandle) this.f28593b).dispose();
                return;
            default:
                ((Function1) this.f28593b).invoke(th);
                return;
        }
    }
}
