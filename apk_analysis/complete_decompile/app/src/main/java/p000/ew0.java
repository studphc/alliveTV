package p000;

import java.util.concurrent.CancellationException;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

/* loaded from: classes2.dex */
public final /* synthetic */ class ew0 implements BiFunction {

    /* renamed from: a */
    public final /* synthetic */ int f17006a;

    /* renamed from: b */
    public final /* synthetic */ Object f17007b;

    public /* synthetic */ ew0(int i, Object obj) {
        this.f17006a = i;
        this.f17007b = obj;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f17006a) {
            case 0:
                return ((hd0) this.f17007b).invoke(obj, (Throwable) obj2);
            default:
                Job job = (Job) this.f17007b;
                Throwable th = (Throwable) obj2;
                CancellationException cancellationException = null;
                if (th != null) {
                    if (th instanceof CancellationException) {
                        cancellationException = (CancellationException) th;
                    }
                    if (cancellationException == null) {
                        cancellationException = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", th);
                    }
                }
                job.cancel(cancellationException);
                return Unit.INSTANCE;
        }
    }
}
