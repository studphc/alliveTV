package p000;

import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ForwardingListener;

/* renamed from: p9 */
/* loaded from: classes.dex */
public final class C1679p9 extends ForwardingListener {

    /* renamed from: j */
    public final /* synthetic */ C1901v9 f25067j;

    /* renamed from: k */
    public final /* synthetic */ AppCompatSpinner f25068k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1679p9(AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, C1901v9 c1901v9) {
        super(appCompatSpinner2);
        this.f25068k = appCompatSpinner;
        this.f25067j = c1901v9;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final ShowableListMenu getPopup() {
        return this.f25067j;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final boolean onForwardingStarted() {
        AppCompatSpinner appCompatSpinner = this.f25068k;
        if (!appCompatSpinner.getInternalPopup().isShowing()) {
            appCompatSpinner.f1208f.mo7233d(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
            return true;
        }
        return true;
    }
}
