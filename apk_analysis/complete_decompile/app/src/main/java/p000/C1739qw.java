package p000;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

/* renamed from: qw */
/* loaded from: classes.dex */
public final class C1739qw extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f25779b;

    /* renamed from: c */
    public final /* synthetic */ Deferred f25780c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1739qw(CallbackToFutureAdapter.Completer completer, Deferred deferred) {
        super(1);
        this.f25779b = completer;
        this.f25780c = deferred;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        CallbackToFutureAdapter.Completer completer = this.f25779b;
        if (th != null) {
            if (th instanceof CancellationException) {
                completer.setCancelled();
            } else {
                completer.setException(th);
            }
        } else {
            completer.set(this.f25780c.getCompleted());
        }
        return Unit.INSTANCE;
    }
}
