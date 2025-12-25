package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m5569d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "", "register", "()V", "Landroidx/lifecycle/LifecycleOwner;", FirebaseAnalytics.Param.SOURCE, "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "a", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "b", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lifecycle-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {

    /* renamed from: a, reason: from kotlin metadata */
    public final Lifecycle lifecycle;

    /* renamed from: b, reason: from kotlin metadata */
    public final CoroutineContext coroutineContext;

    public LifecycleCoroutineScopeImpl(@NotNull Lifecycle lifecycle, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle().getF6494d() == Lifecycle.State.DESTROYED) {
            JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    @NotNull
    /* renamed from: getLifecycle$lifecycle_common, reason: from getter */
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (getLifecycle().getF6494d().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle().removeObserver(this);
            JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void register() {
        BuildersKt.launch$default(this, Dispatchers.getMain().getImmediate(), null, new C0418d(this, null), 2, null);
    }
}
