package p000;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: r9 */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC1753r9 implements InterfaceC1938w9, DialogInterface.OnClickListener {

    /* renamed from: a */
    public AlertDialog f25904a;

    /* renamed from: b */
    public C1790s9 f25905b;

    /* renamed from: c */
    public CharSequence f25906c;

    /* renamed from: d */
    public final /* synthetic */ AppCompatSpinner f25907d;

    public DialogInterfaceOnClickListenerC1753r9(AppCompatSpinner appCompatSpinner) {
        this.f25907d = appCompatSpinner;
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: a */
    public final CharSequence mo7230a() {
        return this.f25906c;
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: b */
    public final void mo7231b(CharSequence charSequence) {
        this.f25906c = charSequence;
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: c */
    public final void mo7232c(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // p000.InterfaceC1938w9
    /* renamed from: d */
    public final void mo7233d(int i, int i2) {
        if (this.f25905b == null) {
            return;
        }
        AppCompatSpinner appCompatSpinner = this.f25907d;
        AlertDialog.Builder builder = new AlertDialog.Builder(appCompatSpinner.getPopupContext());
        CharSequence charSequence = this.f25906c;
        if (charSequence != null) {
            builder.setTitle(charSequence);
        }
        AlertDialog create = builder.setSingleChoiceItems(this.f25905b, appCompatSpinner.getSelectedItemPosition(), this).create();
        this.f25904a = create;
        ListView listView = create.getListView();
        listView.setTextDirection(i);
        listView.setTextAlignment(i2);
        this.f25904a.show();
    }

    @Override // p000.InterfaceC1938w9
    public final void dismiss() {
        AlertDialog alertDialog = this.f25904a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f25904a = null;
        }
    }

    @Override // p000.InterfaceC1938w9
    public final Drawable getBackground() {
        return null;
    }

    @Override // p000.InterfaceC1938w9
    public final int getHorizontalOffset() {
        return 0;
    }

    @Override // p000.InterfaceC1938w9
    public final int getVerticalOffset() {
        return 0;
    }

    @Override // p000.InterfaceC1938w9
    public final boolean isShowing() {
        AlertDialog alertDialog = this.f25904a;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AppCompatSpinner appCompatSpinner = this.f25907d;
        appCompatSpinner.setSelection(i);
        if (appCompatSpinner.getOnItemClickListener() != null) {
            appCompatSpinner.performItemClick(null, i, this.f25905b.getItemId(i));
        }
        dismiss();
    }

    @Override // p000.InterfaceC1938w9
    public final void setAdapter(ListAdapter listAdapter) {
        this.f25905b = (C1790s9) listAdapter;
    }

    @Override // p000.InterfaceC1938w9
    public final void setBackgroundDrawable(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // p000.InterfaceC1938w9
    public final void setHorizontalOffset(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // p000.InterfaceC1938w9
    public final void setVerticalOffset(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }
}
