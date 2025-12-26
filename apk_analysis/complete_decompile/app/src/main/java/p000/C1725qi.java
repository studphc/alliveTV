package p000;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

/* renamed from: qi */
/* loaded from: classes2.dex */
public final class C1725qi extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f25593b;

    /* renamed from: c */
    public final /* synthetic */ Object f25594c;

    /* renamed from: d */
    public final /* synthetic */ Object f25595d;

    /* renamed from: e */
    public final /* synthetic */ Object f25596e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1725qi(Object obj, Object obj2, Object obj3, int i) {
        super(1);
        this.f25593b = i;
        this.f25594c = obj;
        this.f25595d = obj2;
        this.f25596e = obj3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Exception exc;
        switch (this.f25593b) {
            case 0:
                Symbol channel_closed = BufferedChannelKt.getCHANNEL_CLOSED();
                Object obj2 = this.f25594c;
                if (obj2 != channel_closed) {
                    OnUndeliveredElementKt.callUndeliveredElement(((BufferedChannel) this.f25595d).onUndeliveredElement, obj2, ((SelectInstance) this.f25596e).getContext());
                }
                return Unit.INSTANCE;
            case 1:
                OnUndeliveredElementKt.callUndeliveredElement((Function1) this.f25595d, this.f25594c, (CoroutineContext) this.f25596e);
                return Unit.INSTANCE;
            default:
                if (((Throwable) obj) instanceof CancellationException) {
                    ((CancellationTokenSource) this.f25594c).cancel();
                } else {
                    Deferred deferred = (Deferred) this.f25595d;
                    Throwable completionExceptionOrNull = deferred.getCompletionExceptionOrNull();
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f25596e;
                    if (completionExceptionOrNull == null) {
                        taskCompletionSource.setResult(deferred.getCompleted());
                    } else {
                        if (completionExceptionOrNull instanceof Exception) {
                            exc = (Exception) completionExceptionOrNull;
                        } else {
                            exc = null;
                        }
                        if (exc == null) {
                            exc = new RuntimeExecutionException(completionExceptionOrNull);
                        }
                        taskCompletionSource.setException(exc);
                    }
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1725qi(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        super(1);
        this.f25593b = 1;
        this.f25595d = function1;
        this.f25594c = obj;
        this.f25596e = coroutineContext;
    }
}
