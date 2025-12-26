package p000;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public final class af2 implements TextWatcher {

    /* renamed from: a */
    public final /* synthetic */ ze2 f162a;

    /* renamed from: b */
    public final /* synthetic */ SearchBar f163b;

    public af2(SearchBar searchBar, ze2 ze2Var) {
        this.f163b = searchBar;
        this.f162a = ze2Var;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SearchBar searchBar = this.f163b;
        if (searchBar.f6149x) {
            return;
        }
        Handler handler = searchBar.f6134i;
        ze2 ze2Var = this.f162a;
        handler.removeCallbacks(ze2Var);
        handler.post(ze2Var);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
