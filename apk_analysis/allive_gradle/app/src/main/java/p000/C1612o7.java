package p000;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$AlertParams;

/* renamed from: o7 */
/* loaded from: classes.dex */
public final class C1612o7 implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ C1788s7 f23639a;

    /* renamed from: b */
    public final /* synthetic */ AlertController$AlertParams f23640b;

    public C1612o7(AlertController$AlertParams alertController$AlertParams, C1788s7 c1788s7) {
        this.f23640b = alertController$AlertParams;
        this.f23639a = c1788s7;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AlertController$AlertParams alertController$AlertParams = this.f23640b;
        DialogInterface.OnClickListener onClickListener = alertController$AlertParams.mOnClickListener;
        C1788s7 c1788s7 = this.f23639a;
        onClickListener.onClick(c1788s7.f26281b, i);
        if (!alertController$AlertParams.mIsSingleChoice) {
            c1788s7.f26281b.dismiss();
        }
    }
}
