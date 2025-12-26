package p000;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MediatorLiveData;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.sync.MutexImpl;

/* renamed from: sq */
/* loaded from: classes2.dex */
public final class C1807sq extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f26524b;

    /* renamed from: c */
    public final /* synthetic */ Object f26525c;

    /* renamed from: d */
    public final /* synthetic */ Object f26526d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1807sq(int i, Object obj, Object obj2) {
        super(1);
        this.f26524b = i;
        this.f26525c = obj;
        this.f26526d = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f26524b) {
            case 0:
                CompletableJob completableJob = (CompletableJob) this.f26525c;
                if (completableJob.isActive()) {
                    completableJob.cancel((CancellationException) new AbortFlowException((FlowCollector) this.f26526d));
                }
                return Unit.INSTANCE;
            case 1:
                try {
                    ((CompletableFuture) this.f26525c).complete(((Deferred) this.f26526d).getCompleted());
                } catch (Throwable th) {
                    ((CompletableFuture) this.f26525c).completeExceptionally(th);
                }
                return Unit.INSTANCE;
            case 2:
                ((CompletableFuture) this.f26525c).cancel(false);
                ((C1247gw) this.f26526d).cont = null;
                return Unit.INSTANCE;
            case 3:
                HandlerContext.access$getHandler$p((HandlerContext) this.f26525c).removeCallbacks((HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1) this.f26526d);
                return Unit.INSTANCE;
            case 4:
                ((MutexImpl) this.f26525c).unlock(this.f26526d);
                return Unit.INSTANCE;
            case 5:
                Ref.BooleanRef booleanRef = (Ref.BooleanRef) this.f26525c;
                boolean z = true;
                if (!booleanRef.element && Intrinsics.areEqual(obj, this.f26526d)) {
                    booleanRef.element = true;
                    z = false;
                }
                return Boolean.valueOf(z);
            case 6:
                ((MediatorLiveData) this.f26525c).setValue(((Function1) this.f26526d).invoke(obj));
                return Unit.INSTANCE;
            default:
                ((MediatorLiveData) this.f26525c).setValue(((Function) this.f26526d).apply(obj));
                return Unit.INSTANCE;
        }
    }
}
