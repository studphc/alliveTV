package p000;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

/* loaded from: classes.dex */
public final class ht0 extends FragmentContainer {

    /* renamed from: a */
    public final /* synthetic */ Fragment f18165a;

    public ht0(Fragment fragment) {
        this.f18165a = fragment;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final View onFindViewById(int i) {
        Fragment fragment = this.f18165a;
        View view = fragment.f4428K;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a view");
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final boolean onHasView() {
        if (this.f18165a.f4428K != null) {
            return true;
        }
        return false;
    }
}
