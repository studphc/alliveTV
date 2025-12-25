package p000;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertController$RecycleListView;

/* renamed from: m7 */
/* loaded from: classes.dex */
public final class C1538m7 extends ArrayAdapter {

    /* renamed from: a */
    public final /* synthetic */ AlertController$RecycleListView f22833a;

    /* renamed from: b */
    public final /* synthetic */ AlertController$AlertParams f22834b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1538m7(AlertController$AlertParams alertController$AlertParams, Context context, int i, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(context, i, R.id.text1, charSequenceArr);
        this.f22834b = alertController$AlertParams;
        this.f22833a = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f22834b.mCheckedItems;
        if (zArr != null && zArr[i]) {
            this.f22833a.setItemChecked(i, true);
        }
        return view2;
    }
}
