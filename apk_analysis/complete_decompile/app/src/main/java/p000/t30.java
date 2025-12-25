package p000;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import com.hisona.allive.C1069c0;
import com.hisona.allive.ProgressDialog;
import com.hisona.allive.SnsLoginDialogFragment;
import com.hisona.allive.TvingLoginDialogFragment;

/* loaded from: classes.dex */
public final class t30 implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    public final /* synthetic */ int f26677a;

    /* renamed from: b */
    public final /* synthetic */ Object f26678b;

    public /* synthetic */ t30(int i, Object obj) {
        this.f26677a = i;
        this.f26678b = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.f26677a) {
            case 0:
                DialogFragment dialogFragment = (DialogFragment) this.f26678b;
                Dialog dialog = dialogFragment.f4412p0;
                if (dialog != null) {
                    dialogFragment.onCancel(dialog);
                    return;
                }
                return;
            case 1:
                DialogInterface.OnCancelListener onCancelListener = ((ProgressDialog) this.f26678b).f15910d;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                    return;
                }
                return;
            case 2:
                SnsLoginDialogFragment snsLoginDialogFragment = (SnsLoginDialogFragment) this.f26678b;
                snsLoginDialogFragment.f15950u0.stopLoading();
                if (snsLoginDialogFragment.getDialog() != null) {
                    snsLoginDialogFragment.getDialog().dismiss();
                    return;
                }
                return;
            case 3:
                TvingLoginDialogFragment tvingLoginDialogFragment = (TvingLoginDialogFragment) this.f26678b;
                tvingLoginDialogFragment.f15957u0.stopLoading();
                if (tvingLoginDialogFragment.getDialog() != null) {
                    tvingLoginDialogFragment.getDialog().dismiss();
                    return;
                }
                return;
            default:
                ((C1069c0) this.f26678b).cancel();
                return;
        }
    }
}
