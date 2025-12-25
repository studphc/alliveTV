package p000;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import com.hisona.allive.SnsLoginDialogFragment;
import com.hisona.allive.TvingLoginDialogFragment;

/* loaded from: classes2.dex */
public final class zk2 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f29413a;

    /* renamed from: b */
    public final /* synthetic */ DialogFragment f29414b;

    public /* synthetic */ zk2(DialogFragment dialogFragment, int i) {
        this.f29413a = i;
        this.f29414b = dialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f29413a) {
            case 0:
                SnsLoginDialogFragment snsLoginDialogFragment = (SnsLoginDialogFragment) this.f29414b;
                snsLoginDialogFragment.f15950u0.stopLoading();
                if (snsLoginDialogFragment.getDialog() != null) {
                    snsLoginDialogFragment.getDialog().dismiss();
                    return;
                }
                return;
            default:
                TvingLoginDialogFragment tvingLoginDialogFragment = (TvingLoginDialogFragment) this.f29414b;
                tvingLoginDialogFragment.f15957u0.stopLoading();
                if (tvingLoginDialogFragment.getDialog() != null) {
                    tvingLoginDialogFragment.getDialog().dismiss();
                    return;
                }
                return;
        }
    }
}
