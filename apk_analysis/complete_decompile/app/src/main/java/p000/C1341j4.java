package p000;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.C0093b;
import androidx.appcompat.widget.C0095d;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.PopupMenu;

/* renamed from: j4 */
/* loaded from: classes.dex */
public final class C1341j4 extends ForwardingListener {

    /* renamed from: j */
    public final /* synthetic */ int f20366j;

    /* renamed from: k */
    public final /* synthetic */ Object f20367k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1341j4(Object obj, View view, int i) {
        super(view);
        this.f20366j = i;
        this.f20367k = obj;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final ShowableListMenu getPopup() {
        switch (this.f20366j) {
            case 0:
                C1378k4 c1378k4 = ((C0093b) this.f20367k).f1596d.f1607o;
                if (c1378k4 == null) {
                    return null;
                }
                return c1378k4.getPopup();
            case 1:
                return ((ActivityChooserView) this.f20367k).getListPopupWindow();
            case 2:
                return (ListPopupWindow) this.f20367k;
            default:
                return ((PopupMenu) this.f20367k).f1332d.getPopup();
        }
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStarted() {
        switch (this.f20366j) {
            case 0:
                ((C0093b) this.f20367k).f1596d.m316l();
                return true;
            case 1:
                ((ActivityChooserView) this.f20367k).showPopup();
                return true;
            case 2:
            default:
                return super.onForwardingStarted();
            case 3:
                ((PopupMenu) this.f20367k).show();
                return true;
        }
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStopped() {
        switch (this.f20366j) {
            case 0:
                C0095d c0095d = ((C0093b) this.f20367k).f1596d;
                if (c0095d.f1609q != null) {
                    return false;
                }
                c0095d.m312h();
                return true;
            case 1:
                ((ActivityChooserView) this.f20367k).dismissPopup();
                return true;
            case 2:
            default:
                return super.onForwardingStopped();
            case 3:
                ((PopupMenu) this.f20367k).dismiss();
                return true;
        }
    }
}
