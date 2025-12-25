package p000;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertController$RecycleListView;

/* renamed from: p7 */
/* loaded from: classes.dex */
public final class C1677p7 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ AlertController$RecycleListView f25052a;

    /* renamed from: b */
    public final /* synthetic */ C1788s7 f25053b;

    /* renamed from: c */
    public final /* synthetic */ AlertController$AlertParams f25054c;

    public C1677p7(AlertController$AlertParams alertController$AlertParams, AlertController$RecycleListView alertController$RecycleListView, C1788s7 c1788s7) {
        this.f25054c = alertController$AlertParams;
        this.f25052a = alertController$RecycleListView;
        this.f25053b = c1788s7;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AlertController$AlertParams alertController$AlertParams = this.f25054c;
        boolean[] zArr = alertController$AlertParams.mCheckedItems;
        AlertController$RecycleListView alertController$RecycleListView = this.f25052a;
        if (zArr != null) {
            zArr[i] = alertController$RecycleListView.isItemChecked(i);
        }
        alertController$AlertParams.mOnCheckboxClickListener.onClick(this.f25053b.f26281b, i, alertController$RecycleListView.isItemChecked(i));
    }
}
