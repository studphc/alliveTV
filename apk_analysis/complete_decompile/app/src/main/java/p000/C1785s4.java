package p000;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo;
import androidx.appcompat.widget.ActivityChooserModel$ActivitySorter;
import androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* renamed from: s4 */
/* loaded from: classes.dex */
public final class C1785s4 implements ActivityChooserModel$ActivitySorter {

    /* renamed from: a */
    public final HashMap f26232a;

    public C1785s4(int i) {
        switch (i) {
            case 1:
                this.f26232a = new HashMap();
                return;
            case 2:
                this.f26232a = new HashMap();
                return;
            default:
                this.f26232a = new HashMap();
                return;
        }
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel$ActivitySorter
    public void sort(Intent intent, List list, List list2) {
        HashMap hashMap = this.f26232a;
        hashMap.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = (ActivityChooserModel$ActivityResolveInfo) list.get(i);
            activityChooserModel$ActivityResolveInfo.weight = RecyclerView.f7068F0;
            ActivityInfo activityInfo = activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo;
            hashMap.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityChooserModel$ActivityResolveInfo);
        }
        float f = 1.0f;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = (ActivityChooserModel$HistoricalRecord) list2.get(size2);
            ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = (ActivityChooserModel$ActivityResolveInfo) hashMap.get(activityChooserModel$HistoricalRecord.activity);
            if (activityChooserModel$ActivityResolveInfo2 != null) {
                activityChooserModel$ActivityResolveInfo2.weight = (activityChooserModel$HistoricalRecord.weight * f) + activityChooserModel$ActivityResolveInfo2.weight;
                f *= 0.95f;
            }
        }
        Collections.sort(list);
    }
}
