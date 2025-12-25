package p000;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;

/* renamed from: k5 */
/* loaded from: classes.dex */
public final class C1379k5 extends ActivityOptionsCompat {

    /* renamed from: a */
    public final ActivityOptions f20747a;

    public C1379k5(ActivityOptions activityOptions) {
        this.f20747a = activityOptions;
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public final Rect getLaunchBounds() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return AbstractC1573n5.m6304a(this.f20747a);
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public final void requestUsageTimeReport(PendingIntent pendingIntent) {
        AbstractC1536m5.m6054c(this.f20747a, pendingIntent);
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public final ActivityOptionsCompat setLaunchBounds(Rect rect) {
        if (Build.VERSION.SDK_INT < 24) {
            return this;
        }
        return new C1379k5(AbstractC1573n5.m6305b(this.f20747a, rect));
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public final ActivityOptionsCompat setShareIdentityEnabled(boolean z) {
        if (Build.VERSION.SDK_INT < 34) {
            return this;
        }
        return new C1379k5(AbstractC1610o5.m6440a(this.f20747a, z));
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public final Bundle toBundle() {
        return this.f20747a.toBundle();
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public final void update(ActivityOptionsCompat activityOptionsCompat) {
        if (activityOptionsCompat instanceof C1379k5) {
            this.f20747a.update(((C1379k5) activityOptionsCompat).f20747a);
        }
    }
}
