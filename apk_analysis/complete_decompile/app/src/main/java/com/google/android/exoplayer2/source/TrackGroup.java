package com.google.android.exoplayer2.source;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.Lists;
import java.util.Arrays;
import p000.t82;
import p000.ye0;

/* loaded from: classes.dex */
public final class TrackGroup implements Bundleable {
    public static final Bundleable.Creator<TrackGroup> CREATOR = new t82(7);

    /* renamed from: a */
    public final Format[] f11087a;

    /* renamed from: b */
    public int f11088b;

    /* renamed from: id */
    public final String f11089id;
    public final int length;
    public final int type;

    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }

    /* renamed from: a */
    public static void m2754a(String str, String str2, String str3, int i) {
        Log.m3024e("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    @CheckResult
    public TrackGroup copyWithId(String str) {
        return new TrackGroup(str, this.f11087a);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.f11089id.equals(trackGroup.f11089id) && Arrays.equals(this.f11087a, trackGroup.f11087a)) {
            return true;
        }
        return false;
    }

    public Format getFormat(int i) {
        return this.f11087a[i];
    }

    public int hashCode() {
        if (this.f11088b == 0) {
            this.f11088b = ye0.m8286f(527, 31, this.f11089id) + Arrays.hashCode(this.f11087a);
        }
        return this.f11088b;
    }

    public int indexOf(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.f11087a;
            if (i < formatArr.length) {
                if (format == formatArr[i]) {
                    return i;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Integer.toString(0, 36), BundleableUtil.toBundleArrayList(Lists.newArrayList(this.f11087a)));
        bundle.putString(Integer.toString(1, 36), this.f11089id);
        return bundle;
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.checkArgument(formatArr.length > 0);
        this.f11089id = str;
        this.f11087a = formatArr;
        this.length = formatArr.length;
        int trackType = MimeTypes.getTrackType(formatArr[0].sampleMimeType);
        this.type = trackType == -1 ? MimeTypes.getTrackType(formatArr[0].containerMimeType) : trackType;
        String str2 = formatArr[0].language;
        str2 = (str2 == null || str2.equals(C0643C.LANGUAGE_UNDETERMINED)) ? "" : str2;
        int i = formatArr[0].roleFlags | 16384;
        for (int i2 = 1; i2 < formatArr.length; i2++) {
            String str3 = formatArr[i2].language;
            if (!str2.equals((str3 == null || str3.equals(C0643C.LANGUAGE_UNDETERMINED)) ? "" : str3)) {
                m2754a("languages", formatArr[0].language, formatArr[i2].language, i2);
                return;
            } else {
                if (i != (formatArr[i2].roleFlags | 16384)) {
                    m2754a("role flags", Integer.toBinaryString(formatArr[0].roleFlags), Integer.toBinaryString(formatArr[i2].roleFlags), i2);
                    return;
                }
            }
        }
    }
}
