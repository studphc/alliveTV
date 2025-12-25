package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.LeanbackTransitionHelper;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.BrowseFrameLayout;
import p000.cu2;

/* loaded from: classes.dex */
public class TitleHelper {

    /* renamed from: a */
    public final ViewGroup f6236a;

    /* renamed from: b */
    public final View f6237b;

    /* renamed from: c */
    public final Object f6238c;

    /* renamed from: d */
    public final Object f6239d;

    /* renamed from: e */
    public final Object f6240e;

    /* renamed from: f */
    public final Object f6241f;

    /* renamed from: g */
    public final C0402w2 f6242g = new C0402w2(this);

    public TitleHelper(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null) {
            this.f6236a = viewGroup;
            this.f6237b = view;
            this.f6238c = LeanbackTransitionHelper.loadTitleOutTransition(viewGroup.getContext());
            this.f6239d = LeanbackTransitionHelper.loadTitleInTransition(viewGroup.getContext());
            this.f6240e = TransitionHelper.createScene(viewGroup, new cu2(this, 0));
            this.f6241f = TransitionHelper.createScene(viewGroup, new cu2(this, 1));
            return;
        }
        throw new IllegalArgumentException("Views may not be null");
    }

    public BrowseFrameLayout.OnFocusSearchListener getOnFocusSearchListener() {
        return this.f6242g;
    }

    public ViewGroup getSceneRoot() {
        return this.f6236a;
    }

    public View getTitleView() {
        return this.f6237b;
    }

    public void showTitle(boolean z) {
        if (z) {
            TransitionHelper.runTransition(this.f6240e, this.f6239d);
        } else {
            TransitionHelper.runTransition(this.f6241f, this.f6238c);
        }
    }
}
