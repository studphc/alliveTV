package androidx.leanback.widget;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.GuidedAction;
import java.util.Calendar;

/* loaded from: classes.dex */
public class GuidedDatePickerAction extends GuidedAction {

    /* renamed from: r */
    public String f5826r;

    /* renamed from: s */
    public long f5827s;

    /* renamed from: t */
    public long f5828t = Long.MIN_VALUE;

    /* renamed from: u */
    public long f5829u = Long.MAX_VALUE;

    /* loaded from: classes.dex */
    public static final class Builder extends BuilderBase<Builder> {
        public Builder(@NonNull Context context) {
            super(context);
        }

        @NonNull
        public GuidedDatePickerAction build() {
            GuidedDatePickerAction guidedDatePickerAction = new GuidedDatePickerAction();
            applyDatePickerValues(guidedDatePickerAction);
            return guidedDatePickerAction;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BuilderBase<B extends BuilderBase> extends GuidedAction.BuilderBase<B> {

        /* renamed from: r */
        public String f5830r;

        /* renamed from: s */
        public long f5831s;

        /* renamed from: t */
        public long f5832t;

        /* renamed from: u */
        public long f5833u;

        public BuilderBase(@NonNull Context context) {
            super(context);
            this.f5832t = Long.MIN_VALUE;
            this.f5833u = Long.MAX_VALUE;
            this.f5831s = Calendar.getInstance().getTimeInMillis();
            hasEditableActivatorView(true);
        }

        public final void applyDatePickerValues(@NonNull GuidedDatePickerAction guidedDatePickerAction) {
            applyValues(guidedDatePickerAction);
            guidedDatePickerAction.f5826r = this.f5830r;
            guidedDatePickerAction.f5827s = this.f5831s;
            long j = this.f5832t;
            long j2 = this.f5833u;
            if (j <= j2) {
                guidedDatePickerAction.f5828t = j;
                guidedDatePickerAction.f5829u = j2;
                return;
            }
            throw new IllegalArgumentException("MinDate cannot be larger than MaxDate");
        }

        public B date(long j) {
            this.f5831s = j;
            return this;
        }

        public B datePickerFormat(@Nullable String str) {
            this.f5830r = str;
            return this;
        }

        public B maxDate(long j) {
            this.f5833u = j;
            return this;
        }

        public B minDate(long j) {
            this.f5832t = j;
            return this;
        }
    }

    public long getDate() {
        return this.f5827s;
    }

    @Nullable
    public String getDatePickerFormat() {
        return this.f5826r;
    }

    public long getMaxDate() {
        return this.f5829u;
    }

    public long getMinDate() {
        return this.f5828t;
    }

    @Override // androidx.leanback.widget.GuidedAction
    public void onRestoreInstanceState(@NonNull Bundle bundle, @Nullable String str) {
        setDate(bundle.getLong(str, getDate()));
    }

    @Override // androidx.leanback.widget.GuidedAction
    public void onSaveInstanceState(@NonNull Bundle bundle, @Nullable String str) {
        bundle.putLong(str, getDate());
    }

    public void setDate(long j) {
        this.f5827s = j;
    }
}
