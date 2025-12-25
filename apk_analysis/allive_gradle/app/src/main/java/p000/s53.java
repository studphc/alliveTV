package p000;

import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class s53 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f26251a;

    /* renamed from: b */
    public final /* synthetic */ WindowDecorActionBar f26252b;

    public /* synthetic */ s53(WindowDecorActionBar windowDecorActionBar, int i) {
        this.f26251a = i;
        this.f26252b = windowDecorActionBar;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        View view2;
        switch (this.f26251a) {
            case 0:
                WindowDecorActionBar windowDecorActionBar = this.f26252b;
                if (windowDecorActionBar.f659u && (view2 = windowDecorActionBar.f646h) != null) {
                    view2.setTranslationY(RecyclerView.f7068F0);
                    windowDecorActionBar.f643e.setTranslationY(RecyclerView.f7068F0);
                }
                windowDecorActionBar.f643e.setVisibility(8);
                windowDecorActionBar.f643e.setTransitioning(false);
                windowDecorActionBar.f664z = null;
                ActionMode.Callback callback = windowDecorActionBar.f654p;
                if (callback != null) {
                    callback.onDestroyActionMode(windowDecorActionBar.f653o);
                    windowDecorActionBar.f653o = null;
                    windowDecorActionBar.f654p = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = windowDecorActionBar.f642d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    return;
                }
                return;
            default:
                WindowDecorActionBar windowDecorActionBar2 = this.f26252b;
                windowDecorActionBar2.f664z = null;
                windowDecorActionBar2.f643e.requestLayout();
                return;
        }
    }
}
