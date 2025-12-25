package p000;

import android.view.ViewGroup;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: u8 */
/* loaded from: classes.dex */
public final class RunnableC1863u8 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f27145a;

    public RunnableC1863u8(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f27145a = layoutInflaterFactory2C0084e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        ViewGroup viewGroup;
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f27145a;
        layoutInflaterFactory2C0084e.f733w.showAtLocation(layoutInflaterFactory2C0084e.f732v, 55, 0, 0);
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = layoutInflaterFactory2C0084e.f735y;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        if (layoutInflaterFactory2C0084e.f686A && (viewGroup = layoutInflaterFactory2C0084e.f687B) != null && viewGroup.isLaidOut()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            layoutInflaterFactory2C0084e.f732v.setAlpha(RecyclerView.f7068F0);
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(layoutInflaterFactory2C0084e.f732v).alpha(1.0f);
            layoutInflaterFactory2C0084e.f735y = alpha;
            alpha.setListener(new C1826t8(0, this));
            return;
        }
        layoutInflaterFactory2C0084e.f732v.setAlpha(1.0f);
        layoutInflaterFactory2C0084e.f732v.setVisibility(0);
    }
}
