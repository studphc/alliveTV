package com.google.android.exoplayer2.p003ui;

import android.view.View;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public final class AdOverlayInfo {
    public static final int PURPOSE_CLOSE_AD = 2;
    public static final int PURPOSE_CONTROLS = 1;
    public static final int PURPOSE_NOT_VISIBLE = 4;
    public static final int PURPOSE_OTHER = 3;
    public final int purpose;

    @Nullable
    public final String reasonDetail;
    public final View view;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final View f11998a;

        /* renamed from: b */
        public final int f11999b;

        /* renamed from: c */
        public String f12000c;

        public Builder(View view, int i) {
            this.f11998a = view;
            this.f11999b = i;
        }

        public AdOverlayInfo build() {
            return new AdOverlayInfo(this.f11998a, this.f11999b, this.f12000c);
        }

        public Builder setDetailedReason(@Nullable String str) {
            this.f12000c = str;
            return this;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Purpose {
    }

    @Deprecated
    public AdOverlayInfo(View view, int i) {
        this(view, i, null);
    }

    @Deprecated
    public AdOverlayInfo(View view, int i, @Nullable String str) {
        this.view = view;
        this.purpose = i;
        this.reasonDetail = str;
    }
}
