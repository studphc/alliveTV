package p000;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo;
import androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* renamed from: z4 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC2044z4 implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ ActivityChooserView f29241a;

    public ViewOnClickListenerC2044z4(ActivityChooserView activityChooserView) {
        this.f29241a = activityChooserView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityChooserView activityChooserView = this.f29241a;
        int i = 0;
        if (view == activityChooserView.f1091g) {
            activityChooserView.dismissPopup();
            ResolveInfo m7538g = this.f29241a.f1085a.f28829a.m7538g();
            C1859u4 c1859u4 = this.f29241a.f1085a.f28829a;
            synchronized (c1859u4.f27086a) {
                try {
                    c1859u4.m7535c();
                    ArrayList arrayList = c1859u4.f27087b;
                    int size = arrayList.size();
                    while (true) {
                        if (i < size) {
                            if (((ActivityChooserModel$ActivityResolveInfo) arrayList.get(i)).resolveInfo != m7538g) {
                                i++;
                            }
                        } else {
                            i = -1;
                            break;
                        }
                    }
                } finally {
                }
            }
            Intent m7534b = this.f29241a.f1085a.f28829a.m7534b(i);
            if (m7534b != null) {
                m7534b.addFlags(524288);
                this.f29241a.getContext().startActivity(m7534b);
                return;
            }
            return;
        }
        if (view == activityChooserView.f1089e) {
            activityChooserView.f1099o = false;
            activityChooserView.m238a(activityChooserView.f1100p);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ActivityChooserView activityChooserView = this.f29241a;
        PopupWindow.OnDismissListener onDismissListener = activityChooserView.f1098n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        ActionProvider actionProvider = activityChooserView.f1094j;
        if (actionProvider != null) {
            actionProvider.subUiVisibilityChanged(false);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        float f;
        int itemViewType = ((C2007y4) adapterView.getAdapter()).getItemViewType(i);
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                this.f29241a.m238a(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException();
        }
        this.f29241a.dismissPopup();
        ActivityChooserView activityChooserView = this.f29241a;
        if (activityChooserView.f1099o) {
            if (i > 0) {
                C1859u4 c1859u4 = activityChooserView.f1085a.f28829a;
                synchronized (c1859u4.f27086a) {
                    try {
                        c1859u4.m7535c();
                        ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = (ActivityChooserModel$ActivityResolveInfo) c1859u4.f27087b.get(i);
                        ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = (ActivityChooserModel$ActivityResolveInfo) c1859u4.f27087b.get(0);
                        if (activityChooserModel$ActivityResolveInfo2 != null) {
                            f = (activityChooserModel$ActivityResolveInfo2.weight - activityChooserModel$ActivityResolveInfo.weight) + 5.0f;
                        } else {
                            f = 1.0f;
                        }
                        ActivityInfo activityInfo = activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo;
                        c1859u4.m7533a(new ActivityChooserModel$HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f));
                    } finally {
                    }
                }
                return;
            }
            return;
        }
        C2007y4 c2007y4 = activityChooserView.f1085a;
        if (!c2007y4.f28831c) {
            i++;
        }
        Intent m7534b = c2007y4.f28829a.m7534b(i);
        if (m7534b != null) {
            m7534b.addFlags(524288);
            this.f29241a.getContext().startActivity(m7534b);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ActivityChooserView activityChooserView = this.f29241a;
        if (view == activityChooserView.f1091g) {
            if (activityChooserView.f1085a.getCount() > 0) {
                activityChooserView.f1099o = true;
                activityChooserView.m238a(activityChooserView.f1100p);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
