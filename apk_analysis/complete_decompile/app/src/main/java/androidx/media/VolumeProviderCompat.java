package androidx.media;

import android.media.VolumeProvider;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.j43;
import p000.k43;
import p000.l43;

/* loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a */
    public final int f6678a;

    /* renamed from: b */
    public final int f6679b;

    /* renamed from: c */
    public final String f6680c;

    /* renamed from: d */
    public int f6681d;

    /* renamed from: e */
    public Callback f6682e;

    /* renamed from: f */
    public VolumeProvider f6683f;

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public final int getCurrentVolume() {
        return this.f6681d;
    }

    public final int getMaxVolume() {
        return this.f6679b;
    }

    public final int getVolumeControl() {
        return this.f6678a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final String getVolumeControlId() {
        return this.f6680c;
    }

    public Object getVolumeProvider() {
        if (this.f6683f == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f6683f = new j43(this, this.f6678a, this.f6679b, this.f6681d, this.f6680c);
            } else {
                this.f6683f = new k43(this, this.f6678a, this.f6679b, this.f6681d);
            }
        }
        return this.f6683f;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.f6682e = callback;
    }

    public final void setCurrentVolume(int i) {
        this.f6681d = i;
        l43.m5851a((VolumeProvider) getVolumeProvider(), i);
        Callback callback = this.f6682e;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public VolumeProviderCompat(int i, int i2, int i3, @Nullable String str) {
        this.f6678a = i;
        this.f6679b = i2;
        this.f6681d = i3;
        this.f6680c = str;
    }
}
