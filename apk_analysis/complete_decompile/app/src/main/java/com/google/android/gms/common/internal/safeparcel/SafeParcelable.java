package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface SafeParcelable extends Parcelable {

    @NonNull
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";

    /* loaded from: classes.dex */
    public @interface Class {
        @NonNull
        String creator();

        boolean creatorIsFinal() default true;

        boolean doNotParcelTypeDefaultValues() default false;

        boolean validate() default false;
    }

    /* loaded from: classes.dex */
    public @interface Constructor {
    }

    /* loaded from: classes.dex */
    public @interface Field {
        @NonNull
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        @NonNull
        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        @NonNull
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        /* renamed from: id */
        int m3159id();

        @NonNull
        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* loaded from: classes.dex */
    public @interface Indicator {
        @NonNull
        String getter() default "SAFE_PARCELABLE_NULL_STRING";
    }

    /* loaded from: classes.dex */
    public @interface Param {
        /* renamed from: id */
        int m3160id();
    }

    /* loaded from: classes.dex */
    public @interface RemovedParam {
        @NonNull
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        @NonNull
        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        /* renamed from: id */
        int m3161id();
    }

    /* loaded from: classes.dex */
    public @interface Reserved {
        @NonNull
        int[] value();
    }

    /* loaded from: classes.dex */
    public @interface VersionField {
        @NonNull
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        /* renamed from: id */
        int m3162id();

        @NonNull
        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }
}
