package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p000.t82;

/* loaded from: classes.dex */
public class TrackSelectionParameters implements Bundleable {

    @Deprecated
    public static final Bundleable.Creator<TrackSelectionParameters> CREATOR;

    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    protected static final int FIELD_CUSTOM_ID_BASE = 1000;
    public final ImmutableSet<Integer> disabledTrackTypes;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int ignoredTextSelectionFlags;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> overrides;
    public final ImmutableList<String> preferredAudioLanguages;
    public final ImmutableList<String> preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final ImmutableList<String> preferredVideoMimeTypes;
    public final int preferredVideoRoleFlags;
    public final boolean selectUndeterminedTextLanguage;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
        CREATOR = new t82(10);
    }

    public TrackSelectionParameters(Builder builder) {
        this.maxVideoWidth = builder.f11929a;
        this.maxVideoHeight = builder.f11930b;
        this.maxVideoFrameRate = builder.f11931c;
        this.maxVideoBitrate = builder.f11932d;
        this.minVideoWidth = builder.f11933e;
        this.minVideoHeight = builder.f11934f;
        this.minVideoFrameRate = builder.f11935g;
        this.minVideoBitrate = builder.f11936h;
        this.viewportWidth = builder.f11937i;
        this.viewportHeight = builder.f11938j;
        this.viewportOrientationMayChange = builder.f11939k;
        this.preferredVideoMimeTypes = builder.f11940l;
        this.preferredVideoRoleFlags = builder.f11941m;
        this.preferredAudioLanguages = builder.f11942n;
        this.preferredAudioRoleFlags = builder.f11943o;
        this.maxAudioChannelCount = builder.f11944p;
        this.maxAudioBitrate = builder.f11945q;
        this.preferredAudioMimeTypes = builder.f11946r;
        this.preferredTextLanguages = builder.f11947s;
        this.preferredTextRoleFlags = builder.f11948t;
        this.ignoredTextSelectionFlags = builder.f11949u;
        this.selectUndeterminedTextLanguage = builder.f11950v;
        this.forceLowestBitrate = builder.f11951w;
        this.forceHighestSupportedBitrate = builder.f11952x;
        this.overrides = ImmutableMap.copyOf((Map) builder.f11953y);
        this.disabledTrackTypes = ImmutableSet.copyOf((Collection) builder.f11954z);
    }

    public static TrackSelectionParameters fromBundle(Bundle bundle) {
        return new Builder(bundle).build();
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    public static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredVideoRoleFlags == trackSelectionParameters.preferredVideoRoleFlags && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.ignoredTextSelectionFlags == trackSelectionParameters.ignoredTextSelectionFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate && this.overrides.equals(trackSelectionParameters.overrides) && this.disabledTrackTypes.equals(trackSelectionParameters.disabledTrackTypes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.disabledTrackTypes.hashCode() + ((this.overrides.hashCode() + ((((((((((((this.preferredTextLanguages.hashCode() + ((this.preferredAudioMimeTypes.hashCode() + ((((((((this.preferredAudioLanguages.hashCode() + ((((this.preferredVideoMimeTypes.hashCode() + ((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31)) * 31) + this.preferredVideoRoleFlags) * 31)) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31)) * 31)) * 31) + this.preferredTextRoleFlags) * 31) + this.ignoredTextSelectionFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31)) * 31);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(6), this.maxVideoWidth);
        bundle.putInt(keyForField(7), this.maxVideoHeight);
        bundle.putInt(keyForField(8), this.maxVideoFrameRate);
        bundle.putInt(keyForField(9), this.maxVideoBitrate);
        bundle.putInt(keyForField(10), this.minVideoWidth);
        bundle.putInt(keyForField(11), this.minVideoHeight);
        bundle.putInt(keyForField(12), this.minVideoFrameRate);
        bundle.putInt(keyForField(13), this.minVideoBitrate);
        bundle.putInt(keyForField(14), this.viewportWidth);
        bundle.putInt(keyForField(15), this.viewportHeight);
        bundle.putBoolean(keyForField(16), this.viewportOrientationMayChange);
        bundle.putStringArray(keyForField(17), (String[]) this.preferredVideoMimeTypes.toArray(new String[0]));
        bundle.putInt(keyForField(25), this.preferredVideoRoleFlags);
        bundle.putStringArray(keyForField(1), (String[]) this.preferredAudioLanguages.toArray(new String[0]));
        bundle.putInt(keyForField(2), this.preferredAudioRoleFlags);
        bundle.putInt(keyForField(18), this.maxAudioChannelCount);
        bundle.putInt(keyForField(19), this.maxAudioBitrate);
        bundle.putStringArray(keyForField(20), (String[]) this.preferredAudioMimeTypes.toArray(new String[0]));
        bundle.putStringArray(keyForField(3), (String[]) this.preferredTextLanguages.toArray(new String[0]));
        bundle.putInt(keyForField(4), this.preferredTextRoleFlags);
        bundle.putInt(keyForField(26), this.ignoredTextSelectionFlags);
        bundle.putBoolean(keyForField(5), this.selectUndeterminedTextLanguage);
        bundle.putBoolean(keyForField(21), this.forceLowestBitrate);
        bundle.putBoolean(keyForField(22), this.forceHighestSupportedBitrate);
        bundle.putParcelableArrayList(keyForField(23), BundleableUtil.toBundleArrayList(this.overrides.values()));
        bundle.putIntArray(keyForField(24), Ints.toArray(this.disabledTrackTypes));
        return bundle;
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public int f11929a;

        /* renamed from: b */
        public int f11930b;

        /* renamed from: c */
        public int f11931c;

        /* renamed from: d */
        public int f11932d;

        /* renamed from: e */
        public int f11933e;

        /* renamed from: f */
        public int f11934f;

        /* renamed from: g */
        public int f11935g;

        /* renamed from: h */
        public int f11936h;

        /* renamed from: i */
        public int f11937i;

        /* renamed from: j */
        public int f11938j;

        /* renamed from: k */
        public boolean f11939k;

        /* renamed from: l */
        public ImmutableList f11940l;

        /* renamed from: m */
        public int f11941m;

        /* renamed from: n */
        public ImmutableList f11942n;

        /* renamed from: o */
        public int f11943o;

        /* renamed from: p */
        public int f11944p;

        /* renamed from: q */
        public int f11945q;

        /* renamed from: r */
        public ImmutableList f11946r;

        /* renamed from: s */
        public ImmutableList f11947s;

        /* renamed from: t */
        public int f11948t;

        /* renamed from: u */
        public int f11949u;

        /* renamed from: v */
        public boolean f11950v;

        /* renamed from: w */
        public boolean f11951w;

        /* renamed from: x */
        public boolean f11952x;

        /* renamed from: y */
        public HashMap f11953y;

        /* renamed from: z */
        public HashSet f11954z;

        @Deprecated
        public Builder() {
            this.f11929a = Integer.MAX_VALUE;
            this.f11930b = Integer.MAX_VALUE;
            this.f11931c = Integer.MAX_VALUE;
            this.f11932d = Integer.MAX_VALUE;
            this.f11937i = Integer.MAX_VALUE;
            this.f11938j = Integer.MAX_VALUE;
            this.f11939k = true;
            this.f11940l = ImmutableList.m3902of();
            this.f11941m = 0;
            this.f11942n = ImmutableList.m3902of();
            this.f11943o = 0;
            this.f11944p = Integer.MAX_VALUE;
            this.f11945q = Integer.MAX_VALUE;
            this.f11946r = ImmutableList.m3902of();
            this.f11947s = ImmutableList.m3902of();
            this.f11948t = 0;
            this.f11949u = 0;
            this.f11950v = false;
            this.f11951w = false;
            this.f11952x = false;
            this.f11953y = new HashMap();
            this.f11954z = new HashSet();
        }

        /* renamed from: b */
        public static ImmutableList m2884b(String[] strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((ImmutableList.Builder) Util.normalizeLanguageCode((String) Assertions.checkNotNull(str)));
            }
            return builder.build();
        }

        /* renamed from: a */
        public final void m2885a(TrackSelectionParameters trackSelectionParameters) {
            this.f11929a = trackSelectionParameters.maxVideoWidth;
            this.f11930b = trackSelectionParameters.maxVideoHeight;
            this.f11931c = trackSelectionParameters.maxVideoFrameRate;
            this.f11932d = trackSelectionParameters.maxVideoBitrate;
            this.f11933e = trackSelectionParameters.minVideoWidth;
            this.f11934f = trackSelectionParameters.minVideoHeight;
            this.f11935g = trackSelectionParameters.minVideoFrameRate;
            this.f11936h = trackSelectionParameters.minVideoBitrate;
            this.f11937i = trackSelectionParameters.viewportWidth;
            this.f11938j = trackSelectionParameters.viewportHeight;
            this.f11939k = trackSelectionParameters.viewportOrientationMayChange;
            this.f11940l = trackSelectionParameters.preferredVideoMimeTypes;
            this.f11941m = trackSelectionParameters.preferredVideoRoleFlags;
            this.f11942n = trackSelectionParameters.preferredAudioLanguages;
            this.f11943o = trackSelectionParameters.preferredAudioRoleFlags;
            this.f11944p = trackSelectionParameters.maxAudioChannelCount;
            this.f11945q = trackSelectionParameters.maxAudioBitrate;
            this.f11946r = trackSelectionParameters.preferredAudioMimeTypes;
            this.f11947s = trackSelectionParameters.preferredTextLanguages;
            this.f11948t = trackSelectionParameters.preferredTextRoleFlags;
            this.f11949u = trackSelectionParameters.ignoredTextSelectionFlags;
            this.f11950v = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.f11951w = trackSelectionParameters.forceLowestBitrate;
            this.f11952x = trackSelectionParameters.forceHighestSupportedBitrate;
            this.f11954z = new HashSet(trackSelectionParameters.disabledTrackTypes);
            this.f11953y = new HashMap(trackSelectionParameters.overrides);
        }

        public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.f11953y.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this);
        }

        public Builder clearOverride(TrackGroup trackGroup) {
            this.f11953y.remove(trackGroup);
            return this;
        }

        public Builder clearOverrides() {
            this.f11953y.clear();
            return this;
        }

        public Builder clearOverridesOfType(int i) {
            Iterator it = this.f11953y.values().iterator();
            while (it.hasNext()) {
                if (((TrackSelectionOverride) it.next()).getType() == i) {
                    it.remove();
                }
            }
            return this;
        }

        public Builder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Builder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Builder set(TrackSelectionParameters trackSelectionParameters) {
            m2885a(trackSelectionParameters);
            return this;
        }

        @Deprecated
        public Builder setDisabledTrackTypes(Set<Integer> set) {
            this.f11954z.clear();
            this.f11954z.addAll(set);
            return this;
        }

        public Builder setForceHighestSupportedBitrate(boolean z) {
            this.f11952x = z;
            return this;
        }

        public Builder setForceLowestBitrate(boolean z) {
            this.f11951w = z;
            return this;
        }

        public Builder setIgnoredTextSelectionFlags(int i) {
            this.f11949u = i;
            return this;
        }

        public Builder setMaxAudioBitrate(int i) {
            this.f11945q = i;
            return this;
        }

        public Builder setMaxAudioChannelCount(int i) {
            this.f11944p = i;
            return this;
        }

        public Builder setMaxVideoBitrate(int i) {
            this.f11932d = i;
            return this;
        }

        public Builder setMaxVideoFrameRate(int i) {
            this.f11931c = i;
            return this;
        }

        public Builder setMaxVideoSize(int i, int i2) {
            this.f11929a = i;
            this.f11930b = i2;
            return this;
        }

        public Builder setMaxVideoSizeSd() {
            return setMaxVideoSize(AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD);
        }

        public Builder setMinVideoBitrate(int i) {
            this.f11936h = i;
            return this;
        }

        public Builder setMinVideoFrameRate(int i) {
            this.f11935g = i;
            return this;
        }

        public Builder setMinVideoSize(int i, int i2) {
            this.f11933e = i;
            this.f11934f = i2;
            return this;
        }

        public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            clearOverridesOfType(trackSelectionOverride.getType());
            this.f11953y.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            return this;
        }

        public Builder setPreferredAudioLanguage(@Nullable String str) {
            if (str == null) {
                return setPreferredAudioLanguages(new String[0]);
            }
            return setPreferredAudioLanguages(str);
        }

        public Builder setPreferredAudioLanguages(String... strArr) {
            this.f11942n = m2884b(strArr);
            return this;
        }

        public Builder setPreferredAudioMimeType(@Nullable String str) {
            if (str == null) {
                return setPreferredAudioMimeTypes(new String[0]);
            }
            return setPreferredAudioMimeTypes(str);
        }

        public Builder setPreferredAudioMimeTypes(String... strArr) {
            this.f11946r = ImmutableList.copyOf(strArr);
            return this;
        }

        public Builder setPreferredAudioRoleFlags(int i) {
            this.f11943o = i;
            return this;
        }

        public Builder setPreferredTextLanguage(@Nullable String str) {
            if (str == null) {
                return setPreferredTextLanguages(new String[0]);
            }
            return setPreferredTextLanguages(str);
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            CaptioningManager captioningManager;
            int i = Util.SDK_INT;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.f11948t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f11947s = ImmutableList.m3903of(Util.getLocaleLanguageTag(locale));
                }
            }
            return this;
        }

        public Builder setPreferredTextLanguages(String... strArr) {
            this.f11947s = m2884b(strArr);
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i) {
            this.f11948t = i;
            return this;
        }

        public Builder setPreferredVideoMimeType(@Nullable String str) {
            if (str == null) {
                return setPreferredVideoMimeTypes(new String[0]);
            }
            return setPreferredVideoMimeTypes(str);
        }

        public Builder setPreferredVideoMimeTypes(String... strArr) {
            this.f11940l = ImmutableList.copyOf(strArr);
            return this;
        }

        public Builder setPreferredVideoRoleFlags(int i) {
            this.f11941m = i;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.f11950v = z;
            return this;
        }

        public Builder setTrackTypeDisabled(int i, boolean z) {
            if (z) {
                this.f11954z.add(Integer.valueOf(i));
            } else {
                this.f11954z.remove(Integer.valueOf(i));
            }
            return this;
        }

        public Builder setViewportSize(int i, int i2, boolean z) {
            this.f11937i = i;
            this.f11938j = i2;
            this.f11939k = z;
            return this;
        }

        public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z);
        }

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        public Builder(TrackSelectionParameters trackSelectionParameters) {
            m2885a(trackSelectionParameters);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Bundle bundle) {
            ImmutableList fromBundleList;
            String keyForField = TrackSelectionParameters.keyForField(6);
            TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
            this.f11929a = bundle.getInt(keyForField, trackSelectionParameters.maxVideoWidth);
            this.f11930b = bundle.getInt(TrackSelectionParameters.keyForField(7), trackSelectionParameters.maxVideoHeight);
            this.f11931c = bundle.getInt(TrackSelectionParameters.keyForField(8), trackSelectionParameters.maxVideoFrameRate);
            this.f11932d = bundle.getInt(TrackSelectionParameters.keyForField(9), trackSelectionParameters.maxVideoBitrate);
            this.f11933e = bundle.getInt(TrackSelectionParameters.keyForField(10), trackSelectionParameters.minVideoWidth);
            this.f11934f = bundle.getInt(TrackSelectionParameters.keyForField(11), trackSelectionParameters.minVideoHeight);
            this.f11935g = bundle.getInt(TrackSelectionParameters.keyForField(12), trackSelectionParameters.minVideoFrameRate);
            this.f11936h = bundle.getInt(TrackSelectionParameters.keyForField(13), trackSelectionParameters.minVideoBitrate);
            this.f11937i = bundle.getInt(TrackSelectionParameters.keyForField(14), trackSelectionParameters.viewportWidth);
            this.f11938j = bundle.getInt(TrackSelectionParameters.keyForField(15), trackSelectionParameters.viewportHeight);
            this.f11939k = bundle.getBoolean(TrackSelectionParameters.keyForField(16), trackSelectionParameters.viewportOrientationMayChange);
            this.f11940l = ImmutableList.copyOf((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(17)), new String[0]));
            this.f11941m = bundle.getInt(TrackSelectionParameters.keyForField(25), trackSelectionParameters.preferredVideoRoleFlags);
            this.f11942n = m2884b((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(1)), new String[0]));
            this.f11943o = bundle.getInt(TrackSelectionParameters.keyForField(2), trackSelectionParameters.preferredAudioRoleFlags);
            this.f11944p = bundle.getInt(TrackSelectionParameters.keyForField(18), trackSelectionParameters.maxAudioChannelCount);
            this.f11945q = bundle.getInt(TrackSelectionParameters.keyForField(19), trackSelectionParameters.maxAudioBitrate);
            this.f11946r = ImmutableList.copyOf((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(20)), new String[0]));
            this.f11947s = m2884b((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(3)), new String[0]));
            this.f11948t = bundle.getInt(TrackSelectionParameters.keyForField(4), trackSelectionParameters.preferredTextRoleFlags);
            this.f11949u = bundle.getInt(TrackSelectionParameters.keyForField(26), trackSelectionParameters.ignoredTextSelectionFlags);
            this.f11950v = bundle.getBoolean(TrackSelectionParameters.keyForField(5), trackSelectionParameters.selectUndeterminedTextLanguage);
            this.f11951w = bundle.getBoolean(TrackSelectionParameters.keyForField(21), trackSelectionParameters.forceLowestBitrate);
            this.f11952x = bundle.getBoolean(TrackSelectionParameters.keyForField(22), trackSelectionParameters.forceHighestSupportedBitrate);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.keyForField(23));
            if (parcelableArrayList == null) {
                fromBundleList = ImmutableList.m3902of();
            } else {
                fromBundleList = BundleableUtil.fromBundleList(TrackSelectionOverride.CREATOR, parcelableArrayList);
            }
            this.f11953y = new HashMap();
            for (int i = 0; i < fromBundleList.size(); i++) {
                TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) fromBundleList.get(i);
                this.f11953y.put(trackSelectionOverride.mediaTrackGroup, trackSelectionOverride);
            }
            int[] iArr = (int[]) MoreObjects.firstNonNull(bundle.getIntArray(TrackSelectionParameters.keyForField(24)), new int[0]);
            this.f11954z = new HashSet();
            for (int i2 : iArr) {
                this.f11954z.add(Integer.valueOf(i2));
            }
        }
    }
}
