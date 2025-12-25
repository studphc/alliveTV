package p000;

import androidx.leanback.app.DetailsFragment;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.app.RowsFragment;
import androidx.leanback.app.RowsSupportFragment;

/* loaded from: classes.dex */
public final class b30 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f7876a;

    /* renamed from: b */
    public int f7877b;

    /* renamed from: c */
    public boolean f7878c = true;

    /* renamed from: d */
    public final /* synthetic */ Object f7879d;

    public /* synthetic */ b30(int i, Object obj) {
        this.f7876a = i;
        this.f7879d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7876a) {
            case 0:
                RowsFragment rowsFragment = ((DetailsFragment) this.f7879d).f4914T;
                if (rowsFragment != null) {
                    rowsFragment.setSelectedPosition(this.f7877b, this.f7878c);
                    return;
                }
                return;
            case 1:
                RowsSupportFragment rowsSupportFragment = ((DetailsSupportFragment) this.f7879d).f4955X0;
                if (rowsSupportFragment != null) {
                    rowsSupportFragment.setSelectedPosition(this.f7877b, this.f7878c);
                    return;
                }
                return;
            case 2:
                RowsFragment rowsFragment2 = ((PlaybackFragment) this.f7879d).f5126e;
                if (rowsFragment2 != null) {
                    rowsFragment2.setSelectedPosition(this.f7877b, this.f7878c);
                    return;
                }
                return;
            default:
                RowsSupportFragment rowsSupportFragment2 = ((PlaybackSupportFragment) this.f7879d).f5179i0;
                if (rowsSupportFragment2 != null) {
                    rowsSupportFragment2.setSelectedPosition(this.f7877b, this.f7878c);
                    return;
                }
                return;
        }
    }
}
