package p000;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.C0095d;
import androidx.core.view.GravityCompat;

/* renamed from: k4 */
/* loaded from: classes.dex */
public final class C1378k4 extends MenuPopupHelper {

    /* renamed from: m */
    public final /* synthetic */ C0095d f20744m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1378k4(C0095d c0095d, Context context, MenuBuilder menuBuilder, View view) {
        super(context, menuBuilder, view, true, R.attr.actionOverflowMenuStyle);
        this.f20744m = c0095d;
        setGravity(GravityCompat.END);
        setPresenterCallback(c0095d.f1611s);
    }

    @Override // androidx.appcompat.view.menu.MenuPopupHelper
    public final void onDismiss() {
        MenuBuilder menuBuilder;
        MenuBuilder menuBuilder2;
        C0095d c0095d = this.f20744m;
        menuBuilder = ((BaseMenuPresenter) c0095d).mMenu;
        if (menuBuilder != null) {
            menuBuilder2 = ((BaseMenuPresenter) c0095d).mMenu;
            menuBuilder2.close();
        }
        c0095d.f1607o = null;
        super.onDismiss();
    }
}
