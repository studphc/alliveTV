package p000;

import android.view.View;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.C0723e;
import com.google.android.exoplayer2.p003ui.C0726h;
import com.google.android.exoplayer2.p003ui.C0729k;
import com.google.android.exoplayer2.p003ui.C0731m;
import com.google.android.exoplayer2.p003ui.R;
import com.google.android.exoplayer2.p003ui.StyledPlayerControlView;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final /* synthetic */ class mp2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f23050a;

    /* renamed from: b */
    public final /* synthetic */ Object f23051b;

    public /* synthetic */ mp2(int i, Object obj) {
        this.f23050a = i;
        this.f23051b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f23050a) {
            case 0:
                StyledPlayerControlView.m2926a((StyledPlayerControlView) this.f23051b);
                return;
            case 1:
                StyledPlayerControlView styledPlayerControlView = ((C0723e) this.f23051b).f12334f;
                Player player = styledPlayerControlView.f12193O;
                if (player != null) {
                    ((Player) Util.castNonNull(styledPlayerControlView.f12193O)).setTrackSelectionParameters(player.getTrackSelectionParameters().buildUpon().clearOverridesOfType(1).setTrackTypeDisabled(1, false).build());
                    styledPlayerControlView.f12223k0.f12345e[1] = styledPlayerControlView.getResources().getString(R.string.exo_track_selection_auto);
                    styledPlayerControlView.f12227m0.dismiss();
                    return;
                }
                return;
            case 2:
                C0726h c0726h = (C0726h) this.f23051b;
                int adapterPosition = c0726h.getAdapterPosition();
                StyledPlayerControlView styledPlayerControlView2 = c0726h.f12343w;
                if (adapterPosition == 0) {
                    styledPlayerControlView2.m2928c(styledPlayerControlView2.f12225l0);
                    return;
                } else if (adapterPosition == 1) {
                    styledPlayerControlView2.m2928c(styledPlayerControlView2.f12235q0);
                    return;
                } else {
                    styledPlayerControlView2.f12227m0.dismiss();
                    return;
                }
            case 3:
                StyledPlayerControlView styledPlayerControlView3 = ((C0729k) this.f23051b).f12350f;
                Player player2 = styledPlayerControlView3.f12193O;
                if (player2 != null) {
                    styledPlayerControlView3.f12193O.setTrackSelectionParameters(player2.getTrackSelectionParameters().buildUpon().clearOverridesOfType(3).setIgnoredTextSelectionFlags(-3).build());
                    styledPlayerControlView3.f12227m0.dismiss();
                    return;
                }
                return;
            default:
                C0731m c0731m = (C0731m) this.f23051b;
                c0731m.m2971g();
                if (view.getId() == R.id.exo_overflow_show) {
                    c0731m.f12372q.start();
                    return;
                } else {
                    if (view.getId() == R.id.exo_overflow_hide) {
                        c0731m.f12373r.start();
                        return;
                    }
                    return;
                }
        }
    }
}
