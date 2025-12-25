package p000;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0088b;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0091e;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: w4 */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC1933w4 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    public final /* synthetic */ int f28064a;

    /* renamed from: b */
    public final /* synthetic */ Object f28065b;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC1933w4(int i, Object obj) {
        this.f28064a = i;
        this.f28065b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f28064a) {
            case 0:
                ActivityChooserView activityChooserView = (ActivityChooserView) this.f28065b;
                if (activityChooserView.isShowingPopup()) {
                    if (!activityChooserView.isShown()) {
                        activityChooserView.getListPopupWindow().dismiss();
                        return;
                    }
                    activityChooserView.getListPopupWindow().show();
                    ActionProvider actionProvider = activityChooserView.f1094j;
                    if (actionProvider != null) {
                        actionProvider.subUiVisibilityChanged(true);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                AppCompatSpinner appCompatSpinner = (AppCompatSpinner) this.f28065b;
                if (!appCompatSpinner.getInternalPopup().isShowing()) {
                    appCompatSpinner.f1208f.mo7233d(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    return;
                }
                return;
            case 2:
                C1901v9 c1901v9 = (C1901v9) this.f28065b;
                AppCompatSpinner appCompatSpinner2 = c1901v9.f27675N;
                if (appCompatSpinner2.isAttachedToWindow() && appCompatSpinner2.getGlobalVisibleRect(c1901v9.f27673L)) {
                    c1901v9.m7824g();
                    super/*androidx.appcompat.widget.ListPopupWindow*/.show();
                    return;
                } else {
                    c1901v9.dismiss();
                    return;
                }
            case 3:
                ViewOnKeyListenerC0088b viewOnKeyListenerC0088b = (ViewOnKeyListenerC0088b) this.f28065b;
                if (viewOnKeyListenerC0088b.isShowing()) {
                    ArrayList arrayList = viewOnKeyListenerC0088b.f971i;
                    if (arrayList.size() > 0 && !((C1236gl) arrayList.get(0)).f17746a.isModal()) {
                        View view = viewOnKeyListenerC0088b.f978p;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((C1236gl) it.next()).f17746a.show();
                            }
                            return;
                        }
                        viewOnKeyListenerC0088b.dismiss();
                        return;
                    }
                    return;
                }
                return;
            default:
                ViewOnKeyListenerC0091e viewOnKeyListenerC0091e = (ViewOnKeyListenerC0091e) this.f28065b;
                if (viewOnKeyListenerC0091e.isShowing() && !viewOnKeyListenerC0091e.f1002i.isModal()) {
                    View view2 = viewOnKeyListenerC0091e.f1007n;
                    if (view2 != null && view2.isShown()) {
                        viewOnKeyListenerC0091e.f1002i.show();
                        return;
                    } else {
                        viewOnKeyListenerC0091e.dismiss();
                        return;
                    }
                }
                return;
        }
    }
}
