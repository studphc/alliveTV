package p000;

import android.animation.TimeAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public final class ad2 implements TimeAnimator.TimeListener {

    /* renamed from: h */
    public static final DecelerateInterpolator f135h = new DecelerateInterpolator(2.0f);

    /* renamed from: a */
    public final RowPresenter f136a;

    /* renamed from: b */
    public final Presenter.ViewHolder f137b;

    /* renamed from: c */
    public final TimeAnimator f138c;

    /* renamed from: d */
    public final int f139d;

    /* renamed from: e */
    public final DecelerateInterpolator f140e;

    /* renamed from: f */
    public float f141f;

    /* renamed from: g */
    public float f142g;

    public ad2(ItemBridgeAdapter.ViewHolder viewHolder) {
        TimeAnimator timeAnimator = new TimeAnimator();
        this.f138c = timeAnimator;
        this.f136a = (RowPresenter) viewHolder.getPresenter();
        this.f137b = viewHolder.getViewHolder();
        timeAnimator.setTimeListener(this);
        this.f139d = viewHolder.itemView.getResources().getInteger(R.integer.lb_browse_rows_anim_duration);
        this.f140e = f135h;
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public final void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
        float f;
        TimeAnimator timeAnimator2 = this.f138c;
        if (timeAnimator2.isRunning()) {
            int i = this.f139d;
            if (j >= i) {
                timeAnimator2.end();
                f = 1.0f;
            } else {
                f = (float) (j / i);
            }
            DecelerateInterpolator decelerateInterpolator = this.f140e;
            if (decelerateInterpolator != null) {
                f = decelerateInterpolator.getInterpolation(f);
            }
            this.f136a.setSelectLevel(this.f137b, (f * this.f142g) + this.f141f);
        }
    }
}
