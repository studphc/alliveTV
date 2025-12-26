package p000;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: x8 */
/* loaded from: classes.dex */
public final class C1974x8 implements ActionMode.Callback {

    /* renamed from: a */
    public final ActionMode.Callback f28462a;

    /* renamed from: b */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f28463b;

    public C1974x8(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e, ActionMode.Callback callback) {
        this.f28463b = layoutInflaterFactory2C0084e;
        this.f28462a = callback;
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f28462a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f28462a.onCreateActionMode(actionMode, menu);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        this.f28462a.onDestroyActionMode(actionMode);
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f28463b;
        if (layoutInflaterFactory2C0084e.f733w != null) {
            layoutInflaterFactory2C0084e.f722l.getDecorView().removeCallbacks(layoutInflaterFactory2C0084e.f734x);
        }
        if (layoutInflaterFactory2C0084e.f732v != null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = layoutInflaterFactory2C0084e.f735y;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(layoutInflaterFactory2C0084e.f732v).alpha(RecyclerView.f7068F0);
            layoutInflaterFactory2C0084e.f735y = alpha;
            alpha.setListener(new C1826t8(1, this));
        }
        AppCompatCallback appCompatCallback = layoutInflaterFactory2C0084e.f724n;
        if (appCompatCallback != null) {
            appCompatCallback.onSupportActionModeFinished(layoutInflaterFactory2C0084e.f731u);
        }
        layoutInflaterFactory2C0084e.f731u = null;
        ViewCompat.requestApplyInsets(layoutInflaterFactory2C0084e.f687B);
        layoutInflaterFactory2C0084e.m178B();
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewCompat.requestApplyInsets(this.f28463b.f687B);
        return this.f28462a.onPrepareActionMode(actionMode, menu);
    }
}
