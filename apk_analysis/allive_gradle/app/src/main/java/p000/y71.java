package p000;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.DispatchQueue;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
public final /* synthetic */ class y71 implements LifecycleEventObserver {

    /* renamed from: a */
    public final /* synthetic */ int f28854a;

    /* renamed from: b */
    public final /* synthetic */ Object f28855b;

    /* renamed from: c */
    public final /* synthetic */ Object f28856c;

    public /* synthetic */ y71(int i, Object obj, Object obj2) {
        this.f28854a = i;
        this.f28855b = obj;
        this.f28856c = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        switch (this.f28854a) {
            case 0:
                LifecycleController this$0 = (LifecycleController) this.f28855b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Job parentJob = (Job) this.f28856c;
                Intrinsics.checkNotNullParameter(parentJob, "$parentJob");
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "<anonymous parameter 1>");
                if (source.getLifecycle().getF6494d() == Lifecycle.State.DESTROYED) {
                    Job.DefaultImpls.cancel$default(parentJob, (CancellationException) null, 1, (Object) null);
                    this$0.finish();
                    return;
                }
                int compareTo = source.getLifecycle().getF6494d().compareTo(this$0.f6486b);
                DispatchQueue dispatchQueue = this$0.f6487c;
                if (compareTo < 0) {
                    dispatchQueue.pause();
                    return;
                } else {
                    dispatchQueue.resume();
                    return;
                }
            default:
                MenuHostHelper menuHostHelper = (MenuHostHelper) this.f28855b;
                menuHostHelper.getClass();
                if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider((MenuProvider) this.f28856c);
                    return;
                }
                return;
        }
    }
}
