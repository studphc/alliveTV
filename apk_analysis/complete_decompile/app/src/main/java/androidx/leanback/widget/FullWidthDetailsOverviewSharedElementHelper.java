package androidx.leanback.widget;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import java.lang.ref.WeakReference;
import p000.RunnableC1104d;
import p000.d30;

/* loaded from: classes.dex */
public class FullWidthDetailsOverviewSharedElementHelper extends FullWidthDetailsOverviewRowPresenter.Listener {

    /* renamed from: b */
    public Activity f5668b;

    /* renamed from: c */
    public boolean f5669c;

    /* renamed from: d */
    public String f5670d;

    /* renamed from: a */
    public WeakReference f5667a = new WeakReference(null);

    /* renamed from: e */
    public boolean f5671e = true;

    public boolean getAutoStartSharedElementTransition() {
        return this.f5671e;
    }

    @Override // androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.Listener
    public void onBindLogo(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        WeakReference weakReference = new WeakReference(viewHolder);
        this.f5667a = weakReference;
        if (!this.f5671e) {
            return;
        }
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2 = (FullWidthDetailsOverviewRowPresenter.ViewHolder) weakReference.get();
        if (viewHolder2 != null) {
            ViewCompat.setTransitionName(viewHolder2.getLogoViewHolder().view, null);
        }
        viewHolder.getDetailsDescriptionFrame().postOnAnimation(new RunnableC0373p0(this));
    }

    public void setAutoStartSharedElementTransition(boolean z) {
        this.f5671e = z;
    }

    public void setSharedElementEnterTransition(Activity activity, String str) {
        setSharedElementEnterTransition(activity, str, 5000L);
    }

    public void startPostponedEnterTransition() {
        new Handler().post(new RunnableC1104d(21, this));
    }

    public void setSharedElementEnterTransition(Activity activity, String str, long j) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            throw new IllegalArgumentException();
        }
        if (activity == this.f5668b && TextUtils.equals(str, this.f5670d)) {
            return;
        }
        this.f5668b = activity;
        this.f5670d = str;
        setAutoStartSharedElementTransition(TransitionHelper.getSharedElementEnterTransition(activity.getWindow()) != null);
        ActivityCompat.postponeEnterTransition(this.f5668b);
        if (j > 0) {
            new Handler().postDelayed(new d30(this), j);
        }
    }
}
