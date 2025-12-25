package androidx.appcompat.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class ActivityChooserModel$ActivityResolveInfo implements Comparable<ActivityChooserModel$ActivityResolveInfo> {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityChooserModel$ActivityResolveInfo(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityChooserModel$ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityChooserModel$ActivityResolveInfo) obj).weight)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.weight) + 31;
    }

    public String toString() {
        return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
    }

    @Override // java.lang.Comparable
    public int compareTo(ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo) {
        return Float.floatToIntBits(activityChooserModel$ActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
}
