package p000;

import android.animation.TimeAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class ed2 implements TimeAnimator.TimeListener {

    /* renamed from: h */
    public static final DecelerateInterpolator f16768h = new DecelerateInterpolator(2.0f);

    /* renamed from: a */
    public final RowPresenter f16769a;

    /* renamed from: b */
    public final Presenter.ViewHolder f16770b;

    /* renamed from: c */
    public final TimeAnimator f16771c;

    /* renamed from: d */
    public final int f16772d;

    /* renamed from: e */
    public final DecelerateInterpolator f16773e;

    /* renamed from: f */
    public float f16774f;

    /* renamed from: g */
    public float f16775g;

    public ed2(ItemBridgeAdapter.ViewHolder viewHolder) {
        TimeAnimator timeAnimator = new TimeAnimator();
        this.f16771c = timeAnimator;
        this.f16769a = (RowPresenter) viewHolder.getPresenter();
        this.f16770b = viewHolder.getViewHolder();
        timeAnimator.setTimeListener(this);
        this.f16772d = viewHolder.itemView.getResources().getInteger(R.integer.lb_browse_rows_anim_duration);
        this.f16773e = f16768h;
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public final void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
        float f;
        TimeAnimator timeAnimator2 = this.f16771c;
        if (timeAnimator2.isRunning()) {
            int i = this.f16772d;
            if (j >= i) {
                timeAnimator2.end();
                f = 1.0f;
            } else {
                f = (float) (j / i);
            }
            DecelerateInterpolator decelerateInterpolator = this.f16773e;
            if (decelerateInterpolator != null) {
                f = decelerateInterpolator.getInterpolation(f);
            }
            this.f16769a.setSelectLevel(this.f16770b, (f * this.f16775g) + this.f16774f);
        }
    }
}
