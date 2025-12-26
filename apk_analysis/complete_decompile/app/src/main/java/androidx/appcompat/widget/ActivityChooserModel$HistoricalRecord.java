package androidx.appcompat.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class ActivityChooserModel$HistoricalRecord {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public ActivityChooserModel$HistoricalRecord(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ActivityChooserModel$HistoricalRecord.class != obj.getClass()) {
            return false;
        }
        ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = (ActivityChooserModel$HistoricalRecord) obj;
        ComponentName componentName = this.activity;
        if (componentName == null) {
            if (activityChooserModel$HistoricalRecord.activity != null) {
                return false;
            }
        } else if (!componentName.equals(activityChooserModel$HistoricalRecord.activity)) {
            return false;
        }
        if (this.time == activityChooserModel$HistoricalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(activityChooserModel$HistoricalRecord.weight)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        ComponentName componentName = this.activity;
        if (componentName == null) {
            hashCode = 0;
        } else {
            hashCode = componentName.hashCode();
        }
        long j = this.time;
        return Float.floatToIntBits(this.weight) + ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public String toString() {
        return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
    }

    public ActivityChooserModel$HistoricalRecord(ComponentName componentName, long j, float f) {
        this.activity = componentName;
        this.time = j;
        this.weight = f;
    }
}
