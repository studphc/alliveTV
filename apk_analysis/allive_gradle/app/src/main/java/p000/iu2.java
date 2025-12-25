package p000;

import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final /* synthetic */ class iu2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f20270a;

    /* renamed from: b */
    public final /* synthetic */ Toolbar f20271b;

    public /* synthetic */ iu2(Toolbar toolbar, int i) {
        this.f20270a = i;
        this.f20271b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20270a) {
            case 0:
                this.f20271b.collapseActionView();
                return;
            default:
                this.f20271b.invalidateMenu();
                return;
        }
    }
}
