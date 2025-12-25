package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000.AbstractC1726qj;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends PlaybackException {
    public static final Bundleable.Creator<ExoPlaybackException> CREATOR = new C1255h3(23);
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;

    /* renamed from: a */
    public final boolean f9320a;

    @Nullable
    public final MediaPeriodId mediaPeriodId;

    @Nullable
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @Nullable
    public final String rendererName;
    public final int type;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Type {
    }

    public ExoPlaybackException(int i, Exception exc, int i2) {
        this(i, exc, null, i2, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, null, str, 1001, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th, String str, int i, @Nullable Format format, int i2, boolean z, int i3) {
        int i4;
        if (format == null) {
            i4 = 4;
        } else {
            i4 = i2;
        }
        return new ExoPlaybackException(1, th, null, i3, str, i, format, i4, z);
    }

    public static ExoPlaybackException createForSource(IOException iOException, int i) {
        return new ExoPlaybackException(0, iOException, i);
    }

    @Deprecated
    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return createForUnexpected(runtimeException, 1000);
    }

    /* renamed from: a */
    public final ExoPlaybackException m2415a(MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) Util.castNonNull(getMessage()), getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId, this.timestampMs, this.f9320a);
    }

    @Override // com.google.android.exoplayer2.PlaybackException
    public boolean errorInfoEquals(@Nullable PlaybackException playbackException) {
        if (!super.errorInfoEquals(playbackException)) {
            return false;
        }
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) Util.castNonNull(playbackException);
        if (this.type != exoPlaybackException.type || !Util.areEqual(this.rendererName, exoPlaybackException.rendererName) || this.rendererIndex != exoPlaybackException.rendererIndex || !Util.areEqual(this.rendererFormat, exoPlaybackException.rendererFormat) || this.rendererFormatSupport != exoPlaybackException.rendererFormatSupport || !Util.areEqual(this.mediaPeriodId, exoPlaybackException.mediaPeriodId) || this.f9320a != exoPlaybackException.f9320a) {
            return false;
        }
        return true;
    }

    public Exception getRendererException() {
        boolean z = true;
        if (this.type != 1) {
            z = false;
        }
        Assertions.checkState(z);
        return (Exception) Assertions.checkNotNull(getCause());
    }

    public IOException getSourceException() {
        boolean z;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        return (IOException) Assertions.checkNotNull(getCause());
    }

    public RuntimeException getUnexpectedException() {
        boolean z;
        if (this.type == 2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        return (RuntimeException) Assertions.checkNotNull(getCause());
    }

    @Override // com.google.android.exoplayer2.PlaybackException, com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(PlaybackException.keyForField(1001), this.type);
        bundle.putString(PlaybackException.keyForField(1002), this.rendererName);
        bundle.putInt(PlaybackException.keyForField(1003), this.rendererIndex);
        if (this.rendererFormat != null) {
            bundle.putBundle(PlaybackException.keyForField(1004), this.rendererFormat.toBundle());
        }
        bundle.putInt(PlaybackException.keyForField(1005), this.rendererFormatSupport);
        bundle.putBoolean(PlaybackException.keyForField(1006), this.f9320a);
        return bundle;
    }

    public ExoPlaybackException(Bundle bundle) {
        super(bundle);
        this.type = bundle.getInt(PlaybackException.keyForField(1001), 2);
        this.rendererName = bundle.getString(PlaybackException.keyForField(1002));
        this.rendererIndex = bundle.getInt(PlaybackException.keyForField(1003), -1);
        Bundle bundle2 = bundle.getBundle(PlaybackException.keyForField(1004));
        this.rendererFormat = bundle2 == null ? null : Format.CREATOR.fromBundle(bundle2);
        this.rendererFormatSupport = bundle.getInt(PlaybackException.keyForField(1005), 4);
        this.f9320a = bundle.getBoolean(PlaybackException.keyForField(1006), false);
        this.mediaPeriodId = null;
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException, int i) {
        return new ExoPlaybackException(2, runtimeException, i);
    }

    public ExoPlaybackException(String str, Throwable th, int i, int i2, String str2, int i3, Format format, int i4, MediaPeriodId mediaPeriodId, long j, boolean z) {
        super(str, th, i, j);
        Assertions.checkArgument(!z || i2 == 1);
        Assertions.checkArgument(th != null || i2 == 3);
        this.type = i2;
        this.rendererName = str2;
        this.rendererIndex = i3;
        this.rendererFormat = format;
        this.rendererFormatSupport = i4;
        this.mediaPeriodId = mediaPeriodId;
        this.f9320a = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExoPlaybackException(int i, Throwable th, String str, int i2, String str2, int i3, Format format, int i4, boolean z) {
        this(TextUtils.isEmpty(str) ? r0 : AbstractC1726qj.m7058n(r0, ": ", str), th, i2, i, str2, i3, format, i4, null, SystemClock.elapsedRealtime(), z);
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i == 1) {
            str3 = str2 + " error, index=" + i3 + ", format=" + format + ", format_supported=" + Util.getFormatSupportString(i4);
        } else if (i != 3) {
            str3 = "Unexpected runtime error";
        } else {
            str3 = "Remote error";
        }
    }
}
