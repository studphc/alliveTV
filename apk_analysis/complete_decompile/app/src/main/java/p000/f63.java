package p000;

import android.view.Window;
import com.google.android.exoplayer2.C0643C;

/* loaded from: classes.dex */
public final class f63 extends e63 {
    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: e */
    public final boolean mo1008e() {
        if ((this.f4018a.getDecorView().getSystemUiVisibility() & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.AbstractC0224t
    /* renamed from: h */
    public final void mo1010h(boolean z) {
        if (z) {
            Window window = this.f4018a;
            window.clearFlags(C0643C.BUFFER_FLAG_FIRST_SAMPLE);
            window.addFlags(Integer.MIN_VALUE);
            m1006l(16);
            return;
        }
        m1007m(16);
    }
}
