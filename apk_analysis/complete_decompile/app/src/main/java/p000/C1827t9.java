package p000;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.ListFragment;

/* renamed from: t9 */
/* loaded from: classes.dex */
public final class C1827t9 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f26725a;

    /* renamed from: b */
    public final /* synthetic */ Object f26726b;

    public /* synthetic */ C1827t9(int i, Object obj) {
        this.f26725a = i;
        this.f26726b = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.f26725a) {
            case 0:
                C1901v9 c1901v9 = (C1901v9) this.f26726b;
                c1901v9.f27675N.setSelection(i);
                if (c1901v9.f27675N.getOnItemClickListener() != null) {
                    c1901v9.f27675N.performItemClick(view, i, c1901v9.f27672K.getItemId(i));
                }
                c1901v9.dismiss();
                return;
            case 1:
                ((ListFragment) this.f26726b).onListItemClick((ListView) adapterView, view, i, j);
                return;
            default:
                ((SearchView) this.f26726b).m266g(i);
                return;
        }
    }
}
