package p000;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes.dex */
public final class tt0 extends FragmentFactory {

    /* renamed from: b */
    public final /* synthetic */ FragmentManager f26955b;

    public tt0(FragmentManager fragmentManager) {
        this.f26955b = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public final Fragment instantiate(ClassLoader classLoader, String str) {
        FragmentManager fragmentManager = this.f26955b;
        return fragmentManager.getHost().instantiate(fragmentManager.getHost().getContext(), str, null);
    }
}
