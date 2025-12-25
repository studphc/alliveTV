package p000;

import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.hisona.allive.C1090x;

/* loaded from: classes2.dex */
public final class q72 implements View.OnFocusChangeListener {

    /* renamed from: a */
    public final /* synthetic */ int f25480a;

    /* renamed from: b */
    public final /* synthetic */ Object f25481b;

    public /* synthetic */ q72(int i, Object obj) {
        this.f25480a = i;
        this.f25481b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f25480a) {
            case 0:
                C1090x c1090x = (C1090x) this.f25481b;
                if (z) {
                    c1090x.f16020v.f15904x0 = c1090x.getAbsoluteAdapterPosition();
                    return;
                } else {
                    if (c1090x.f16020v.f15904x0 == c1090x.getAbsoluteAdapterPosition()) {
                        c1090x.f16020v.f15904x0 = -1;
                        return;
                    }
                    return;
                }
            default:
                SearchView searchView = (SearchView) this.f25481b;
                View.OnFocusChangeListener onFocusChangeListener = searchView.f1372M;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z);
                    return;
                }
                return;
        }
    }
}
