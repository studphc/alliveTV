package p000;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

/* loaded from: classes.dex */
public final class ut0 implements FragmentOnAttachListener {

    /* renamed from: a */
    public final /* synthetic */ Fragment f27435a;

    public ut0(Fragment fragment) {
        this.f27435a = fragment;
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
        this.f27435a.onAttachFragment(fragment);
    }
}
