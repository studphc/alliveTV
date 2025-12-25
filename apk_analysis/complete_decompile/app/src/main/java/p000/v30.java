package p000;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* loaded from: classes.dex */
public final class v30 implements Observer {

    /* renamed from: a */
    public final /* synthetic */ DialogFragment f27637a;

    public v30(DialogFragment dialogFragment) {
        this.f27637a = dialogFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        if (((LifecycleOwner) obj) != null) {
            DialogFragment dialogFragment = this.f27637a;
            if (dialogFragment.f4408l0) {
                View requireView = dialogFragment.requireView();
                if (requireView.getParent() == null) {
                    if (dialogFragment.f4412p0 != null) {
                        if (FragmentManager.isLoggingEnabled(3)) {
                            Log.d(FragmentManager.TAG, "DialogFragment " + this + " setting the content view on " + dialogFragment.f4412p0);
                        }
                        dialogFragment.f4412p0.setContentView(requireView);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
        }
    }
}
