package p000;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActivityChooserView;

/* renamed from: y4 */
/* loaded from: classes.dex */
public final class C2007y4 extends BaseAdapter {

    /* renamed from: a */
    public C1859u4 f28829a;

    /* renamed from: b */
    public int f28830b = 4;

    /* renamed from: c */
    public boolean f28831c;

    /* renamed from: d */
    public boolean f28832d;

    /* renamed from: e */
    public boolean f28833e;

    /* renamed from: f */
    public final /* synthetic */ ActivityChooserView f28834f;

    public C2007y4(ActivityChooserView activityChooserView) {
        this.f28834f = activityChooserView;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int m7537f = this.f28829a.m7537f();
        if (!this.f28831c && this.f28829a.m7538g() != null) {
            m7537f--;
        }
        int min = Math.min(m7537f, this.f28830b);
        if (this.f28833e) {
            return min + 1;
        }
        return min;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                return null;
            }
            throw new IllegalArgumentException();
        }
        if (!this.f28831c && this.f28829a.m7538g() != null) {
            i++;
        }
        return this.f28829a.m7536e(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.f28833e && i == getCount() - 1) {
            return 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        ActivityChooserView activityChooserView = this.f28834f;
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                if (view == null || view.getId() != 1) {
                    View inflate = LayoutInflater.from(activityChooserView.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(R.id.title)).setText(activityChooserView.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    return inflate;
                }
                return view;
            }
            throw new IllegalArgumentException();
        }
        if (view == null || view.getId() != R.id.list_item) {
            view = LayoutInflater.from(activityChooserView.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
        }
        PackageManager packageManager = activityChooserView.getContext().getPackageManager();
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
        imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
        ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
        if (this.f28831c && i == 0 && this.f28832d) {
            view.setActivated(true);
        } else {
            view.setActivated(false);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }
}
