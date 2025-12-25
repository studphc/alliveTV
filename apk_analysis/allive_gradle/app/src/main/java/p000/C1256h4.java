package p000;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.C0095d;

/* renamed from: h4 */
/* loaded from: classes.dex */
public final class C1256h4 extends MenuPopupHelper {

    /* renamed from: m */
    public final /* synthetic */ C0095d f17940m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1256h4(C0095d c0095d, Context context, SubMenuBuilder subMenuBuilder, View view) {
        super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
        Object obj;
        this.f17940m = c0095d;
        if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
            View view2 = c0095d.f1597e;
            if (view2 == null) {
                obj = ((BaseMenuPresenter) c0095d).mMenuView;
                view2 = (View) obj;
            }
            setAnchorView(view2);
        }
        setPresenterCallback(c0095d.f1611s);
    }

    @Override // androidx.appcompat.view.menu.MenuPopupHelper
    public final void onDismiss() {
        C0095d c0095d = this.f17940m;
        c0095d.f1608p = null;
        c0095d.f1612t = 0;
        super.onDismiss();
    }
}
