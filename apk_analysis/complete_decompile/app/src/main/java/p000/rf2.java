package p000;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class rf2 implements TextView.OnEditorActionListener {

    /* renamed from: a */
    public final /* synthetic */ SearchView f25956a;

    public rf2(SearchView searchView) {
        this.f25956a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f25956a.m268i();
        return true;
    }
}
