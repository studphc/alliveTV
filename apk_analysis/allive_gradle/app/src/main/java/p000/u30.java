package p000;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes.dex */
public final class u30 implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ DialogFragment f27079a;

    public u30(DialogFragment dialogFragment) {
        this.f27079a = dialogFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogFragment dialogFragment = this.f27079a;
        Dialog dialog = dialogFragment.f4412p0;
        if (dialog != null) {
            dialogFragment.onDismiss(dialog);
        }
    }
}
