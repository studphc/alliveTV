package p000;

import android.database.DataSetObserver;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public final class o91 extends DataSetObserver {

    /* renamed from: a */
    public final /* synthetic */ int f23668a;

    /* renamed from: b */
    public final /* synthetic */ Object f23669b;

    public /* synthetic */ o91(int i, Object obj) {
        this.f23668a = i;
        this.f23669b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f23668a) {
            case 0:
                ListPopupWindow listPopupWindow = (ListPopupWindow) this.f23669b;
                if (listPopupWindow.isShowing()) {
                    listPopupWindow.show();
                    return;
                }
                return;
            default:
                ((ViewPager) this.f23669b).m1933c();
                return;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f23668a) {
            case 0:
                ((ListPopupWindow) this.f23669b).dismiss();
                return;
            default:
                ((ViewPager) this.f23669b).m1933c();
                return;
        }
    }
}
