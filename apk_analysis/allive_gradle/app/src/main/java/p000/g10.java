package p000;

import android.util.Log;
import androidx.fragment.app.C0253h;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class g10 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17518a;

    /* renamed from: b */
    public final /* synthetic */ SpecialEffectsController.Operation f17519b;

    /* renamed from: c */
    public final /* synthetic */ C0253h f17520c;

    public /* synthetic */ g10(SpecialEffectsController.Operation operation, C0253h c0253h, int i) {
        this.f17518a = i;
        this.f17519b = operation;
        this.f17520c = c0253h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17518a) {
            case 0:
                SpecialEffectsController.Operation operation = this.f17519b;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                C0253h this$0 = this.f17520c;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
                }
                operation.completeEffect(this$0);
                return;
            default:
                SpecialEffectsController.Operation operation2 = this.f17519b;
                Intrinsics.checkNotNullParameter(operation2, "$operation");
                C0253h this$02 = this.f17520c;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Transition for operation " + operation2 + " has completed");
                }
                operation2.completeEffect(this$02);
                return;
        }
    }
}
