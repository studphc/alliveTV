package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* renamed from: androidx.appcompat.widget.k */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0102k implements View.OnKeyListener {

    /* renamed from: a */
    public final /* synthetic */ SearchView f1623a;

    public ViewOnKeyListenerC0102k(SearchView searchView) {
        this.f1623a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        int length;
        SearchView searchView = this.f1623a;
        if (searchView.f1388f0 == null) {
            return false;
        }
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f1393p;
        if (searchAutoComplete.isPopupShowing() && searchAutoComplete.getListSelection() != -1) {
            if (searchView.f1388f0 == null || searchView.f1377R == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
                return false;
            }
            if (i != 66 && i != 84 && i != 61) {
                if (i != 21 && i != 22) {
                    if (i != 19) {
                        return false;
                    }
                    searchAutoComplete.getListSelection();
                    return false;
                }
                if (i == 21) {
                    length = 0;
                } else {
                    length = searchAutoComplete.length();
                }
                searchAutoComplete.setSelection(length);
                searchAutoComplete.setListSelection(0);
                searchAutoComplete.clearListSelection();
                searchAutoComplete.m276a();
                return true;
            }
            return searchView.m266g(searchAutoComplete.getListSelection());
        }
        if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0 || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        searchView.getContext().startActivity(searchView.m262c(null, "android.intent.action.SEARCH", null, searchAutoComplete.getText().toString()));
        return true;
    }
}
