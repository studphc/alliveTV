package p000;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public final class ft0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17395a;

    /* renamed from: b */
    public final /* synthetic */ Fragment f17396b;

    public /* synthetic */ ft0(int i, Fragment fragment) {
        this.f17395a = i;
        this.f17396b = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17395a) {
            case 0:
                this.f17396b.startPostponedEnterTransition();
                return;
            default:
                this.f17396b.m1136a(false);
                return;
        }
    }
}
