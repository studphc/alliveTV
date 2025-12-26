package p000;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;

/* loaded from: classes.dex */
public final class en1 extends FrameLayout implements CollapsibleActionView {

    /* renamed from: a */
    public final android.view.CollapsibleActionView f16916a;

    /* JADX WARN: Multi-variable type inference failed */
    public en1(View view) {
        super(view.getContext());
        this.f16916a = (android.view.CollapsibleActionView) view;
        addView(view);
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void onActionViewCollapsed() {
        this.f16916a.onActionViewCollapsed();
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void onActionViewExpanded() {
        this.f16916a.onActionViewExpanded();
    }
}
