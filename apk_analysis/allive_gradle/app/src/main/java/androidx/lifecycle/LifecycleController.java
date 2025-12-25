package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import p000.y71;

@Metadata(m5568d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Landroidx/lifecycle/LifecycleController;", "", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Lkotlinx/coroutines/Job;", "parentJob", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "", "finish", "()V", "lifecycle-common"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@MainThread
@SourceDebugExtension({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
/* loaded from: classes.dex */
public final class LifecycleController {

    /* renamed from: a */
    public final Lifecycle f6485a;

    /* renamed from: b */
    public final Lifecycle.State f6486b;

    /* renamed from: c */
    public final DispatchQueue f6487c;

    /* renamed from: d */
    public final y71 f6488d;

    public LifecycleController(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State minState, @NotNull DispatchQueue dispatchQueue, @NotNull Job parentJob) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minState, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics.checkNotNullParameter(parentJob, "parentJob");
        this.f6485a = lifecycle;
        this.f6486b = minState;
        this.f6487c = dispatchQueue;
        y71 y71Var = new y71(0, this, parentJob);
        this.f6488d = y71Var;
        if (lifecycle.getF6494d() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(parentJob, (CancellationException) null, 1, (Object) null);
            finish();
        } else {
            lifecycle.addObserver(y71Var);
        }
    }

    @MainThread
    public final void finish() {
        this.f6485a.removeObserver(this.f6488d);
        this.f6487c.finish();
    }
}
