package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import java.util.ArrayList;
import java.util.Iterator;
import p000.pu2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: c */
    public Interpolator f811c;

    /* renamed from: d */
    public ViewPropertyAnimatorListener f812d;

    /* renamed from: e */
    public boolean f813e;

    /* renamed from: b */
    public long f810b = -1;

    /* renamed from: f */
    public final pu2 f814f = new pu2(this);

    /* renamed from: a */
    public final ArrayList f809a = new ArrayList();

    public void cancel() {
        if (!this.f813e) {
            return;
        }
        Iterator it = this.f809a.iterator();
        while (it.hasNext()) {
            ((ViewPropertyAnimatorCompat) it.next()).cancel();
        }
        this.f813e = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f813e) {
            this.f809a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        ArrayList arrayList = this.f809a;
        arrayList.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        arrayList.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.f813e) {
            this.f810b = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.f813e) {
            this.f811c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f813e) {
            this.f812d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (this.f813e) {
            return;
        }
        Iterator it = this.f809a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
            long j = this.f810b;
            if (j >= 0) {
                viewPropertyAnimatorCompat.setDuration(j);
            }
            Interpolator interpolator = this.f811c;
            if (interpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(interpolator);
            }
            if (this.f812d != null) {
                viewPropertyAnimatorCompat.setListener(this.f814f);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.f813e = true;
    }
}
