package p000;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import androidx.appcompat.widget.ActivityChooserView;

/* renamed from: v4 */
/* loaded from: classes.dex */
public final class C1896v4 extends DataSetObserver {

    /* renamed from: a */
    public final /* synthetic */ int f27645a;

    /* renamed from: b */
    public final /* synthetic */ ActivityChooserView f27646b;

    public /* synthetic */ C1896v4(ActivityChooserView activityChooserView, int i) {
        this.f27645a = i;
        this.f27646b = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        int size;
        switch (this.f27645a) {
            case 0:
                super.onChanged();
                this.f27646b.f1085a.notifyDataSetChanged();
                return;
            default:
                super.onChanged();
                ActivityChooserView activityChooserView = this.f27646b;
                if (activityChooserView.f1085a.getCount() > 0) {
                    activityChooserView.f1089e.setEnabled(true);
                } else {
                    activityChooserView.f1089e.setEnabled(false);
                }
                int m7537f = activityChooserView.f1085a.f28829a.m7537f();
                C1859u4 c1859u4 = activityChooserView.f1085a.f28829a;
                synchronized (c1859u4.f27086a) {
                    c1859u4.m7535c();
                    size = c1859u4.f27088c.size();
                }
                if (m7537f != 1 && (m7537f <= 1 || size <= 0)) {
                    activityChooserView.f1091g.setVisibility(8);
                } else {
                    activityChooserView.f1091g.setVisibility(0);
                    ResolveInfo m7538g = activityChooserView.f1085a.f28829a.m7538g();
                    PackageManager packageManager = activityChooserView.getContext().getPackageManager();
                    activityChooserView.f1092h.setImageDrawable(m7538g.loadIcon(packageManager));
                    if (activityChooserView.f1102r != 0) {
                        activityChooserView.f1091g.setContentDescription(activityChooserView.getContext().getString(activityChooserView.f1102r, m7538g.loadLabel(packageManager)));
                    }
                }
                if (activityChooserView.f1091g.getVisibility() == 0) {
                    activityChooserView.f1087c.setBackgroundDrawable(activityChooserView.f1088d);
                    return;
                } else {
                    activityChooserView.f1087c.setBackgroundDrawable(null);
                    return;
                }
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        switch (this.f27645a) {
            case 0:
                super.onInvalidated();
                this.f27646b.f1085a.notifyDataSetInvalidated();
                return;
            default:
                super.onInvalidated();
                return;
        }
    }
}
