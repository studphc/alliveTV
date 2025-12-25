package p000;

import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: e4 */
/* loaded from: classes.dex */
public final class RunnableC1145e4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16666a;

    /* renamed from: b */
    public final /* synthetic */ ActionBarOverlayLayout f16667b;

    public /* synthetic */ RunnableC1145e4(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f16666a = i;
        this.f16667b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16666a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f16667b;
                actionBarOverlayLayout.m235b();
                actionBarOverlayLayout.f1067w = actionBarOverlayLayout.f1048d.animate().translationY(RecyclerView.f7068F0).setListener(actionBarOverlayLayout.f1068x);
                return;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f16667b;
                actionBarOverlayLayout2.m235b();
                actionBarOverlayLayout2.f1067w = actionBarOverlayLayout2.f1048d.animate().translationY(-actionBarOverlayLayout2.f1048d.getHeight()).setListener(actionBarOverlayLayout2.f1068x);
                return;
        }
    }
}
