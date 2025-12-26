package androidx.appcompat.view.menu;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ForwardingListener;

/* renamed from: androidx.appcompat.view.menu.a */
/* loaded from: classes.dex */
public final class C0087a extends ForwardingListener {

    /* renamed from: j */
    public final /* synthetic */ ActionMenuItemView f961j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0087a(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f961j = actionMenuItemView;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final ShowableListMenu getPopup() {
        ActionMenuItemView.PopupCallback popupCallback = this.f961j.f841m;
        if (popupCallback != null) {
            return popupCallback.getPopup();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final boolean onForwardingStarted() {
        ShowableListMenu popup;
        ActionMenuItemView actionMenuItemView = this.f961j;
        MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.f839k;
        if (itemInvoker == null || !itemInvoker.invokeItem(actionMenuItemView.f836h) || (popup = getPopup()) == null || !popup.isShowing()) {
            return false;
        }
        return true;
    }
}
