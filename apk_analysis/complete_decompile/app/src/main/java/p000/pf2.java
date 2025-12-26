package p000;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class pf2 implements TextWatcher {

    /* renamed from: a */
    public final /* synthetic */ SearchView f25148a;

    public pf2(SearchView searchView) {
        this.f25148a = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SearchView searchView = this.f25148a;
        Editable text = searchView.f1393p.getText();
        searchView.f1385c0 = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        searchView.m273n(!isEmpty);
        searchView.m275p(isEmpty);
        searchView.m269j();
        searchView.m272m();
        if (searchView.f1370K != null && !TextUtils.equals(charSequence, searchView.f1384b0)) {
            searchView.f1370K.onQueryTextChange(charSequence.toString());
        }
        searchView.f1384b0 = charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
