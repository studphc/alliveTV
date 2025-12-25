package p000;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class l91 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ int f22417a;

    /* renamed from: b */
    public final /* synthetic */ Object f22418b;

    public /* synthetic */ l91(int i, Object obj) {
        this.f22417a = i;
        this.f22418b = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        e70 e70Var;
        switch (this.f22417a) {
            case 0:
                if (i != -1 && (e70Var = ((ListPopupWindow) this.f22418b).f1299c) != null) {
                    e70Var.setListSelectionHidden(false);
                    return;
                }
                return;
            default:
                ((SearchView) this.f22418b).m267h(i);
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.f22417a;
    }

    /* renamed from: a */
    private final void m5908a(AdapterView adapterView) {
    }

    /* renamed from: b */
    private final void m5909b(AdapterView adapterView) {
    }
}
