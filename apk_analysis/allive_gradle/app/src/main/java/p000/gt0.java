package p000;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandleSupport;

/* loaded from: classes.dex */
public final class gt0 extends kt0 {

    /* renamed from: a */
    public final /* synthetic */ Fragment f17829a;

    public gt0(Fragment fragment) {
        this.f17829a = fragment;
    }

    @Override // p000.kt0
    /* renamed from: a */
    public final void mo4992a() {
        Bundle bundle;
        Fragment fragment = this.f17829a;
        fragment.f4442Y.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(fragment);
        Bundle bundle2 = fragment.f4446b;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("registryState");
        } else {
            bundle = null;
        }
        fragment.f4442Y.performRestore(bundle);
    }
}
