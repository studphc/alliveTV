package p000;

import android.view.Window;
import androidx.core.view.AbstractC0222r;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* loaded from: classes.dex */
public class e63 extends AbstractC0222r {
    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: f */
    public final boolean mo1009f() {
        if ((this.f4018a.getDecorView().getSystemUiVisibility() & 8192) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: i */
    public final void mo1011i(boolean z) {
        if (z) {
            Window window = this.f4018a;
            window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.addFlags(Integer.MIN_VALUE);
            m1006l(8192);
            return;
        }
        m1007m(8192);
    }
}
