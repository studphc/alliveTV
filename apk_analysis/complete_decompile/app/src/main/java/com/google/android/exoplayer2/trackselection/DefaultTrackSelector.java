package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.C0716a;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import p000.C0556bg;
import p000.C1255h3;
import p000.C1702pw;
import p000.ExecutorC1700pu;
import p000.n10;
import p000.o10;
import p000.p10;
import p000.q10;
import p000.qa2;

/* loaded from: classes.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    protected static final int SELECTION_ELIGIBILITY_ADAPTIVE = 2;
    protected static final int SELECTION_ELIGIBILITY_FIXED = 1;
    protected static final int SELECTION_ELIGIBILITY_NO = 0;

    /* renamed from: j */
    public static final Ordering f11888j = Ordering.from(new C0556bg(3));

    /* renamed from: k */
    public static final Ordering f11889k = Ordering.from(new C0556bg(4));

    @Nullable
    public final Context context;

    /* renamed from: d */
    public final Object f11890d;

    /* renamed from: e */
    public final ExoTrackSelection.Factory f11891e;

    /* renamed from: f */
    public final boolean f11892f;

    /* renamed from: g */
    public Parameters f11893g;

    /* renamed from: h */
    public final p10 f11894h;

    /* renamed from: i */
    public AudioAttributes f11895i;

    /* loaded from: classes.dex */
    public static final class Parameters extends TrackSelectionParameters implements Bundleable {
        public static final Bundleable.Creator<Parameters> CREATOR;

        @Deprecated
        public static final Parameters DEFAULT;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT;

        /* renamed from: a */
        public final SparseArray f11896a;
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedDecoderSupportAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowMultipleAdaptiveSelections;
        public final boolean allowVideoMixedDecoderSupportAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;

        /* renamed from: b */
        public final SparseBooleanArray f11897b;
        public final boolean constrainAudioChannelCountToDeviceCapabilities;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean tunnelingEnabled;

        /* loaded from: classes.dex */
        public static final class Builder extends TrackSelectionParameters.Builder {

            /* renamed from: A */
            public boolean f11898A;

            /* renamed from: B */
            public boolean f11899B;

            /* renamed from: C */
            public boolean f11900C;

            /* renamed from: D */
            public boolean f11901D;

            /* renamed from: E */
            public boolean f11902E;

            /* renamed from: F */
            public boolean f11903F;

            /* renamed from: G */
            public boolean f11904G;

            /* renamed from: H */
            public boolean f11905H;

            /* renamed from: I */
            public boolean f11906I;

            /* renamed from: J */
            public boolean f11907J;

            /* renamed from: K */
            public boolean f11908K;

            /* renamed from: L */
            public boolean f11909L;

            /* renamed from: M */
            public boolean f11910M;

            /* renamed from: N */
            public final SparseArray f11911N;

            /* renamed from: O */
            public final SparseBooleanArray f11912O;

            @Deprecated
            public Builder() {
                this.f11911N = new SparseArray();
                this.f11912O = new SparseBooleanArray();
                m2883c();
            }

            /* renamed from: c */
            public final void m2883c() {
                this.f11898A = true;
                this.f11899B = false;
                this.f11900C = true;
                this.f11901D = false;
                this.f11902E = true;
                this.f11903F = false;
                this.f11904G = false;
                this.f11905H = false;
                this.f11906I = false;
                this.f11907J = true;
                this.f11908K = true;
                this.f11909L = false;
                this.f11910M = true;
            }

            @Deprecated
            public Builder clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
                SparseArray sparseArray = this.f11911N;
                Map map = (Map) sparseArray.get(i);
                if (map != null && map.containsKey(trackGroupArray)) {
                    map.remove(trackGroupArray);
                    if (map.isEmpty()) {
                        sparseArray.remove(i);
                    }
                }
                return this;
            }

            @Deprecated
            public Builder clearSelectionOverrides(int i) {
                SparseArray sparseArray = this.f11911N;
                Map map = (Map) sparseArray.get(i);
                if (map != null && !map.isEmpty()) {
                    sparseArray.remove(i);
                }
                return this;
            }

            public Builder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
                this.f11905H = z;
                return this;
            }

            public Builder setAllowAudioMixedDecoderSupportAdaptiveness(boolean z) {
                this.f11906I = z;
                return this;
            }

            public Builder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
                this.f11903F = z;
                return this;
            }

            public Builder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
                this.f11904G = z;
                return this;
            }

            public Builder setAllowMultipleAdaptiveSelections(boolean z) {
                this.f11910M = z;
                return this;
            }

            public Builder setAllowVideoMixedDecoderSupportAdaptiveness(boolean z) {
                this.f11901D = z;
                return this;
            }

            public Builder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
                this.f11899B = z;
                return this;
            }

            public Builder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
                this.f11900C = z;
                return this;
            }

            public Builder setConstrainAudioChannelCountToDeviceCapabilities(boolean z) {
                this.f11907J = z;
                return this;
            }

            @Deprecated
            public Builder setDisabledTextTrackSelectionFlags(int i) {
                return setIgnoredTextSelectionFlags(i);
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            @Deprecated
            public /* bridge */ /* synthetic */ TrackSelectionParameters.Builder setDisabledTrackTypes(Set set) {
                return setDisabledTrackTypes((Set<Integer>) set);
            }

            public Builder setExceedAudioConstraintsIfNecessary(boolean z) {
                this.f11902E = z;
                return this;
            }

            public Builder setExceedRendererCapabilitiesIfNecessary(boolean z) {
                this.f11908K = z;
                return this;
            }

            public Builder setExceedVideoConstraintsIfNecessary(boolean z) {
                this.f11898A = z;
                return this;
            }

            public Builder setRendererDisabled(int i, boolean z) {
                SparseBooleanArray sparseBooleanArray = this.f11912O;
                if (sparseBooleanArray.get(i) == z) {
                    return this;
                }
                if (z) {
                    sparseBooleanArray.put(i, true);
                } else {
                    sparseBooleanArray.delete(i);
                }
                return this;
            }

            @Deprecated
            public Builder setSelectionOverride(int i, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
                SparseArray sparseArray = this.f11911N;
                Map map = (Map) sparseArray.get(i);
                if (map == null) {
                    map = new HashMap();
                    sparseArray.put(i, map);
                }
                if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                    return this;
                }
                map.put(trackGroupArray, selectionOverride);
                return this;
            }

            public Builder setTunnelingEnabled(boolean z) {
                this.f11909L = z;
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
                super.addOverride(trackSelectionOverride);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Parameters build() {
                return new Parameters(this);
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder clearOverride(TrackGroup trackGroup) {
                super.clearOverride(trackGroup);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder clearOverrides() {
                super.clearOverrides();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder clearOverridesOfType(int i) {
                super.clearOverridesOfType(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder clearVideoSizeConstraints() {
                super.clearVideoSizeConstraints();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder clearViewportSizeConstraints() {
                super.clearViewportSizeConstraints();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder set(TrackSelectionParameters trackSelectionParameters) {
                super.set(trackSelectionParameters);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            @Deprecated
            public Builder setDisabledTrackTypes(Set<Integer> set) {
                super.setDisabledTrackTypes(set);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setForceHighestSupportedBitrate(boolean z) {
                super.setForceHighestSupportedBitrate(z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setForceLowestBitrate(boolean z) {
                super.setForceLowestBitrate(z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setIgnoredTextSelectionFlags(int i) {
                super.setIgnoredTextSelectionFlags(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMaxAudioBitrate(int i) {
                super.setMaxAudioBitrate(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMaxAudioChannelCount(int i) {
                super.setMaxAudioChannelCount(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMaxVideoBitrate(int i) {
                super.setMaxVideoBitrate(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMaxVideoFrameRate(int i) {
                super.setMaxVideoFrameRate(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMaxVideoSize(int i, int i2) {
                super.setMaxVideoSize(i, i2);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMaxVideoSizeSd() {
                super.setMaxVideoSizeSd();
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMinVideoBitrate(int i) {
                super.setMinVideoBitrate(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMinVideoFrameRate(int i) {
                super.setMinVideoFrameRate(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setMinVideoSize(int i, int i2) {
                super.setMinVideoSize(i, i2);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
                super.setOverrideForType(trackSelectionOverride);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredAudioLanguage(@Nullable String str) {
                super.setPreferredAudioLanguage(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredAudioLanguages(String... strArr) {
                super.setPreferredAudioLanguages(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredAudioMimeType(@Nullable String str) {
                super.setPreferredAudioMimeType(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredAudioMimeTypes(String... strArr) {
                super.setPreferredAudioMimeTypes(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredAudioRoleFlags(int i) {
                super.setPreferredAudioRoleFlags(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredTextLanguage(@Nullable String str) {
                super.setPreferredTextLanguage(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
                super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredTextLanguages(String... strArr) {
                super.setPreferredTextLanguages(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredTextRoleFlags(int i) {
                super.setPreferredTextRoleFlags(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredVideoMimeType(@Nullable String str) {
                super.setPreferredVideoMimeType(str);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredVideoMimeTypes(String... strArr) {
                super.setPreferredVideoMimeTypes(strArr);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setPreferredVideoRoleFlags(int i) {
                super.setPreferredVideoRoleFlags(i);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setSelectUndeterminedTextLanguage(boolean z) {
                super.setSelectUndeterminedTextLanguage(z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setTrackTypeDisabled(int i, boolean z) {
                super.setTrackTypeDisabled(i, z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setViewportSize(int i, int i2, boolean z) {
                super.setViewportSize(i, i2, z);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
                super.setViewportSizeToPhysicalDisplaySize(context, z);
                return this;
            }

            @Deprecated
            public Builder clearSelectionOverrides() {
                SparseArray sparseArray = this.f11911N;
                if (sparseArray.size() == 0) {
                    return this;
                }
                sparseArray.clear();
                return this;
            }

            public Builder(Context context) {
                super(context);
                this.f11911N = new SparseArray();
                this.f11912O = new SparseBooleanArray();
                m2883c();
            }

            public Builder(Parameters parameters) {
                super(parameters);
                this.f11898A = parameters.exceedVideoConstraintsIfNecessary;
                this.f11899B = parameters.allowVideoMixedMimeTypeAdaptiveness;
                this.f11900C = parameters.allowVideoNonSeamlessAdaptiveness;
                this.f11901D = parameters.allowVideoMixedDecoderSupportAdaptiveness;
                this.f11902E = parameters.exceedAudioConstraintsIfNecessary;
                this.f11903F = parameters.allowAudioMixedMimeTypeAdaptiveness;
                this.f11904G = parameters.allowAudioMixedSampleRateAdaptiveness;
                this.f11905H = parameters.allowAudioMixedChannelCountAdaptiveness;
                this.f11906I = parameters.allowAudioMixedDecoderSupportAdaptiveness;
                this.f11907J = parameters.constrainAudioChannelCountToDeviceCapabilities;
                this.f11908K = parameters.exceedRendererCapabilitiesIfNecessary;
                this.f11909L = parameters.tunnelingEnabled;
                this.f11910M = parameters.allowMultipleAdaptiveSelections;
                SparseArray sparseArray = new SparseArray();
                int i = 0;
                while (true) {
                    SparseArray sparseArray2 = parameters.f11896a;
                    if (i < sparseArray2.size()) {
                        sparseArray.put(sparseArray2.keyAt(i), new HashMap((Map) sparseArray2.valueAt(i)));
                        i++;
                    } else {
                        this.f11911N = sparseArray;
                        this.f11912O = parameters.f11897b.clone();
                        return;
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder(Bundle bundle) {
                super(bundle);
                ImmutableList fromBundleList;
                SparseArray fromBundleSparseArray;
                SparseBooleanArray sparseBooleanArray;
                m2883c();
                Parameters parameters = Parameters.DEFAULT_WITHOUT_CONTEXT;
                setExceedVideoConstraintsIfNecessary(bundle.getBoolean(TrackSelectionParameters.keyForField(1000), parameters.exceedVideoConstraintsIfNecessary));
                setAllowVideoMixedMimeTypeAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1001), parameters.allowVideoMixedMimeTypeAdaptiveness));
                setAllowVideoNonSeamlessAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1002), parameters.allowVideoNonSeamlessAdaptiveness));
                setAllowVideoMixedDecoderSupportAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1014), parameters.allowVideoMixedDecoderSupportAdaptiveness));
                setExceedAudioConstraintsIfNecessary(bundle.getBoolean(TrackSelectionParameters.keyForField(1003), parameters.exceedAudioConstraintsIfNecessary));
                setAllowAudioMixedMimeTypeAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1004), parameters.allowAudioMixedMimeTypeAdaptiveness));
                setAllowAudioMixedSampleRateAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1005), parameters.allowAudioMixedSampleRateAdaptiveness));
                setAllowAudioMixedChannelCountAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1006), parameters.allowAudioMixedChannelCountAdaptiveness));
                setAllowAudioMixedDecoderSupportAdaptiveness(bundle.getBoolean(TrackSelectionParameters.keyForField(1015), parameters.allowAudioMixedDecoderSupportAdaptiveness));
                setConstrainAudioChannelCountToDeviceCapabilities(bundle.getBoolean(TrackSelectionParameters.keyForField(1016), parameters.constrainAudioChannelCountToDeviceCapabilities));
                setExceedRendererCapabilitiesIfNecessary(bundle.getBoolean(TrackSelectionParameters.keyForField(1007), parameters.exceedRendererCapabilitiesIfNecessary));
                setTunnelingEnabled(bundle.getBoolean(TrackSelectionParameters.keyForField(1008), parameters.tunnelingEnabled));
                setAllowMultipleAdaptiveSelections(bundle.getBoolean(TrackSelectionParameters.keyForField(1009), parameters.allowMultipleAdaptiveSelections));
                this.f11911N = new SparseArray();
                int[] intArray = bundle.getIntArray(TrackSelectionParameters.keyForField(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.keyForField(1011));
                if (parcelableArrayList == null) {
                    fromBundleList = ImmutableList.m3902of();
                } else {
                    fromBundleList = BundleableUtil.fromBundleList(TrackGroupArray.CREATOR, parcelableArrayList);
                }
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(TrackSelectionParameters.keyForField(1012));
                if (sparseParcelableArray == null) {
                    fromBundleSparseArray = new SparseArray();
                } else {
                    fromBundleSparseArray = BundleableUtil.fromBundleSparseArray(SelectionOverride.CREATOR, sparseParcelableArray);
                }
                if (intArray != null && intArray.length == fromBundleList.size()) {
                    for (int i = 0; i < intArray.length; i++) {
                        setSelectionOverride(intArray[i], (TrackGroupArray) fromBundleList.get(i), (SelectionOverride) fromBundleSparseArray.get(i));
                    }
                }
                int[] intArray2 = bundle.getIntArray(TrackSelectionParameters.keyForField(1013));
                if (intArray2 == null) {
                    sparseBooleanArray = new SparseBooleanArray();
                } else {
                    SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(intArray2.length);
                    for (int i2 : intArray2) {
                        sparseBooleanArray2.append(i2, true);
                    }
                    sparseBooleanArray = sparseBooleanArray2;
                }
                this.f11912O = sparseBooleanArray;
            }
        }

        static {
            Parameters build = new Builder().build();
            DEFAULT_WITHOUT_CONTEXT = build;
            DEFAULT = build;
            CREATOR = new C1255h3(16);
        }

        public Parameters(Builder builder) {
            super(builder);
            this.exceedVideoConstraintsIfNecessary = builder.f11898A;
            this.allowVideoMixedMimeTypeAdaptiveness = builder.f11899B;
            this.allowVideoNonSeamlessAdaptiveness = builder.f11900C;
            this.allowVideoMixedDecoderSupportAdaptiveness = builder.f11901D;
            this.exceedAudioConstraintsIfNecessary = builder.f11902E;
            this.allowAudioMixedMimeTypeAdaptiveness = builder.f11903F;
            this.allowAudioMixedSampleRateAdaptiveness = builder.f11904G;
            this.allowAudioMixedChannelCountAdaptiveness = builder.f11905H;
            this.allowAudioMixedDecoderSupportAdaptiveness = builder.f11906I;
            this.constrainAudioChannelCountToDeviceCapabilities = builder.f11907J;
            this.exceedRendererCapabilitiesIfNecessary = builder.f11908K;
            this.tunnelingEnabled = builder.f11909L;
            this.allowMultipleAdaptiveSelections = builder.f11910M;
            this.f11896a = builder.f11911N;
            this.f11897b = builder.f11912O;
        }

        public static Parameters getDefaults(Context context) {
            return new Builder(context).build();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(parameters) && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.allowVideoMixedDecoderSupportAdaptiveness == parameters.allowVideoMixedDecoderSupportAdaptiveness && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.allowAudioMixedDecoderSupportAdaptiveness == parameters.allowAudioMixedDecoderSupportAdaptiveness && this.constrainAudioChannelCountToDeviceCapabilities == parameters.constrainAudioChannelCountToDeviceCapabilities && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingEnabled == parameters.tunnelingEnabled && this.allowMultipleAdaptiveSelections == parameters.allowMultipleAdaptiveSelections) {
                SparseBooleanArray sparseBooleanArray = this.f11897b;
                int size = sparseBooleanArray.size();
                SparseBooleanArray sparseBooleanArray2 = parameters.f11897b;
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        } else {
                            SparseArray sparseArray = this.f11896a;
                            int size2 = sparseArray.size();
                            SparseArray sparseArray2 = parameters.f11896a;
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                TrackGroupArray trackGroupArray = (TrackGroupArray) entry.getKey();
                                                if (map2.containsKey(trackGroupArray) && Util.areEqual(entry.getValue(), map2.get(trackGroupArray))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        public boolean getRendererDisabled(int i) {
            return this.f11897b.get(i);
        }

        @Nullable
        @Deprecated
        public SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = (Map) this.f11896a.get(i);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        @Deprecated
        public boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = (Map) this.f11896a.get(i);
            if (map != null && map.containsKey(trackGroupArray)) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoMixedDecoderSupportAdaptiveness ? 1 : 0)) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedDecoderSupportAdaptiveness ? 1 : 0)) * 31) + (this.constrainAudioChannelCountToDeviceCapabilities ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.tunnelingEnabled ? 1 : 0)) * 31) + (this.allowMultipleAdaptiveSelections ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(TrackSelectionParameters.keyForField(1000), this.exceedVideoConstraintsIfNecessary);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1001), this.allowVideoMixedMimeTypeAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1002), this.allowVideoNonSeamlessAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1014), this.allowVideoMixedDecoderSupportAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1003), this.exceedAudioConstraintsIfNecessary);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1004), this.allowAudioMixedMimeTypeAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1005), this.allowAudioMixedSampleRateAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1006), this.allowAudioMixedChannelCountAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1015), this.allowAudioMixedDecoderSupportAdaptiveness);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1016), this.constrainAudioChannelCountToDeviceCapabilities);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1007), this.exceedRendererCapabilitiesIfNecessary);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1008), this.tunnelingEnabled);
            bundle.putBoolean(TrackSelectionParameters.keyForField(1009), this.allowMultipleAdaptiveSelections);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            int i = 0;
            while (true) {
                SparseArray sparseArray2 = this.f11896a;
                if (i >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i);
                for (Map.Entry entry : ((Map) sparseArray2.valueAt(i)).entrySet()) {
                    SelectionOverride selectionOverride = (SelectionOverride) entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray.put(arrayList2.size(), selectionOverride);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(TrackSelectionParameters.keyForField(1010), Ints.toArray(arrayList));
                bundle.putParcelableArrayList(TrackSelectionParameters.keyForField(1011), BundleableUtil.toBundleArrayList(arrayList2));
                bundle.putSparseParcelableArray(TrackSelectionParameters.keyForField(1012), BundleableUtil.toBundleSparseArray(sparseArray));
                i++;
            }
            String keyForField = TrackSelectionParameters.keyForField(1013);
            SparseBooleanArray sparseBooleanArray = this.f11897b;
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
                iArr[i2] = sparseBooleanArray.keyAt(i2);
            }
            bundle.putIntArray(keyForField, iArr);
            return bundle;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public Builder buildUpon() {
            return new Builder(this);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {

        /* renamed from: A */
        public final Parameters.Builder f11913A;

        @Deprecated
        public ParametersBuilder() {
            this.f11913A = new Parameters.Builder();
        }

        @Deprecated
        public ParametersBuilder clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            this.f11913A.clearSelectionOverride(i, trackGroupArray);
            return this;
        }

        @Deprecated
        public ParametersBuilder clearSelectionOverrides(int i) {
            this.f11913A.clearSelectionOverrides(i);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
            this.f11913A.setAllowAudioMixedChannelCountAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedDecoderSupportAdaptiveness(boolean z) {
            this.f11913A.setAllowAudioMixedDecoderSupportAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
            this.f11913A.setAllowAudioMixedMimeTypeAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
            this.f11913A.setAllowAudioMixedSampleRateAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowMultipleAdaptiveSelections(boolean z) {
            this.f11913A.setAllowMultipleAdaptiveSelections(z);
            return this;
        }

        public ParametersBuilder setAllowVideoMixedDecoderSupportAdaptiveness(boolean z) {
            this.f11913A.setAllowVideoMixedDecoderSupportAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
            this.f11913A.setAllowVideoMixedMimeTypeAdaptiveness(z);
            return this;
        }

        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
            this.f11913A.setAllowVideoNonSeamlessAdaptiveness(z);
            return this;
        }

        @Deprecated
        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i) {
            this.f11913A.setDisabledTextTrackSelectionFlags(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        @Deprecated
        public /* bridge */ /* synthetic */ TrackSelectionParameters.Builder setDisabledTrackTypes(Set set) {
            return setDisabledTrackTypes((Set<Integer>) set);
        }

        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z) {
            this.f11913A.setExceedAudioConstraintsIfNecessary(z);
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z) {
            this.f11913A.setExceedRendererCapabilitiesIfNecessary(z);
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z) {
            this.f11913A.setExceedVideoConstraintsIfNecessary(z);
            return this;
        }

        public ParametersBuilder setRendererDisabled(int i, boolean z) {
            this.f11913A.setRendererDisabled(i, z);
            return this;
        }

        @Deprecated
        public ParametersBuilder setSelectionOverride(int i, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
            this.f11913A.setSelectionOverride(i, trackGroupArray, selectionOverride);
            return this;
        }

        public ParametersBuilder setTunnelingEnabled(boolean z) {
            this.f11913A.setTunnelingEnabled(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.f11913A.addOverride(trackSelectionOverride);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public Parameters build() {
            return this.f11913A.build();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder clearOverride(TrackGroup trackGroup) {
            this.f11913A.clearOverride(trackGroup);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder clearOverrides() {
            this.f11913A.clearOverrides();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder clearOverridesOfType(int i) {
            this.f11913A.clearOverridesOfType(i);
            return this;
        }

        @Deprecated
        public ParametersBuilder clearSelectionOverrides() {
            this.f11913A.clearSelectionOverrides();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder clearVideoSizeConstraints() {
            this.f11913A.clearVideoSizeConstraints();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder clearViewportSizeConstraints() {
            this.f11913A.clearViewportSizeConstraints();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder set(TrackSelectionParameters trackSelectionParameters) {
            this.f11913A.set(trackSelectionParameters);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        @Deprecated
        public ParametersBuilder setDisabledTrackTypes(Set<Integer> set) {
            this.f11913A.setDisabledTrackTypes(set);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setForceHighestSupportedBitrate(boolean z) {
            this.f11913A.setForceHighestSupportedBitrate(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setForceLowestBitrate(boolean z) {
            this.f11913A.setForceLowestBitrate(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setIgnoredTextSelectionFlags(int i) {
            this.f11913A.setIgnoredTextSelectionFlags(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMaxAudioBitrate(int i) {
            this.f11913A.setMaxAudioBitrate(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMaxAudioChannelCount(int i) {
            this.f11913A.setMaxAudioChannelCount(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMaxVideoBitrate(int i) {
            this.f11913A.setMaxVideoBitrate(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMaxVideoFrameRate(int i) {
            this.f11913A.setMaxVideoFrameRate(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMaxVideoSize(int i, int i2) {
            this.f11913A.setMaxVideoSize(i, i2);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMaxVideoSizeSd() {
            this.f11913A.setMaxVideoSizeSd();
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMinVideoBitrate(int i) {
            this.f11913A.setMinVideoBitrate(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMinVideoFrameRate(int i) {
            this.f11913A.setMinVideoFrameRate(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setMinVideoSize(int i, int i2) {
            this.f11913A.setMinVideoSize(i, i2);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            this.f11913A.setOverrideForType(trackSelectionOverride);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredAudioLanguage(@Nullable String str) {
            this.f11913A.setPreferredAudioLanguage(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredAudioLanguages(String... strArr) {
            this.f11913A.setPreferredAudioLanguages(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredAudioMimeType(@Nullable String str) {
            this.f11913A.setPreferredAudioMimeType(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredAudioMimeTypes(String... strArr) {
            this.f11913A.setPreferredAudioMimeTypes(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredAudioRoleFlags(int i) {
            this.f11913A.setPreferredAudioRoleFlags(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguage(@Nullable String str) {
            this.f11913A.setPreferredTextLanguage(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            this.f11913A.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextLanguages(String... strArr) {
            this.f11913A.setPreferredTextLanguages(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredTextRoleFlags(int i) {
            this.f11913A.setPreferredTextRoleFlags(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredVideoMimeType(@Nullable String str) {
            this.f11913A.setPreferredVideoMimeType(str);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredVideoMimeTypes(String... strArr) {
            this.f11913A.setPreferredVideoMimeTypes(strArr);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setPreferredVideoRoleFlags(int i) {
            this.f11913A.setPreferredVideoRoleFlags(i);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z) {
            this.f11913A.setSelectUndeterminedTextLanguage(z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setTrackTypeDisabled(int i, boolean z) {
            this.f11913A.setTrackTypeDisabled(i, z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setViewportSize(int i, int i2, boolean z) {
            this.f11913A.setViewportSize(i, i2, z);
            return this;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            this.f11913A.setViewportSizeToPhysicalDisplaySize(context, z);
            return this;
        }

        public ParametersBuilder(Context context) {
            this.f11913A = new Parameters.Builder(context);
        }
    }

    /* loaded from: classes.dex */
    public static final class SelectionOverride implements Bundleable {
        public static final Bundleable.Creator<SelectionOverride> CREATOR = new C1255h3(17);
        public final int groupIndex;
        public final int length;
        public final int[] tracks;
        public final int type;

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 0);
        }

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.type == selectionOverride.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.tracks) + (this.groupIndex * 31)) * 31) + this.type;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(Integer.toString(0, 36), this.groupIndex);
            bundle.putIntArray(Integer.toString(1, 36), this.tracks);
            bundle.putInt(Integer.toString(2, 36), this.type);
            return bundle;
        }

        public SelectionOverride(int i, int[] iArr, int i2) {
            this.groupIndex = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.type = i2;
            Arrays.sort(copyOf);
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, new AdaptiveTrackSelection.Factory());
    }

    /* renamed from: a */
    public static int m2878a(int i, int i2) {
        if (i != 0 && i == i2) {
            return Integer.MAX_VALUE;
        }
        return Integer.bitCount(i & i2);
    }

    /* renamed from: b */
    public static void m2879b(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, HashMap hashMap) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i = 0; i < trackGroupArray.length; i++) {
            TrackSelectionOverride trackSelectionOverride2 = trackSelectionParameters.overrides.get(trackGroupArray.get(i));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(trackSelectionOverride2.getType()))) == null || (trackSelectionOverride.trackIndices.isEmpty() && !trackSelectionOverride2.trackIndices.isEmpty()))) {
                hashMap.put(Integer.valueOf(trackSelectionOverride2.getType()), trackSelectionOverride2);
            }
        }
    }

    /* renamed from: d */
    public static Pair m2880d(int i, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, DefaultTrackSelector$TrackInfo$Factory defaultTrackSelector$TrackInfo$Factory, Comparator comparator) {
        int i2;
        RandomAccess randomAccess;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int rendererCount = mappedTrackInfo.getRendererCount();
        int i3 = 0;
        while (i3 < rendererCount) {
            if (i == mappedTrackInfo2.getRendererType(i3)) {
                TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i3);
                for (int i4 = 0; i4 < trackGroups.length; i4++) {
                    TrackGroup trackGroup = trackGroups.get(i4);
                    List create = defaultTrackSelector$TrackInfo$Factory.create(i3, trackGroup, iArr[i3][i4]);
                    boolean[] zArr = new boolean[trackGroup.length];
                    int i5 = 0;
                    while (i5 < trackGroup.length) {
                        q10 q10Var = (q10) create.get(i5);
                        int mo2886a = q10Var.mo2886a();
                        if (zArr[i5] || mo2886a == 0) {
                            i2 = rendererCount;
                        } else {
                            if (mo2886a == 1) {
                                randomAccess = ImmutableList.m3903of(q10Var);
                                i2 = rendererCount;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(q10Var);
                                int i6 = i5 + 1;
                                while (i6 < trackGroup.length) {
                                    q10 q10Var2 = (q10) create.get(i6);
                                    int i7 = rendererCount;
                                    if (q10Var2.mo2886a() == 2 && q10Var.mo2887b(q10Var2)) {
                                        arrayList2.add(q10Var2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    rendererCount = i7;
                                }
                                i2 = rendererCount;
                                randomAccess = arrayList2;
                            }
                            arrayList.add(randomAccess);
                        }
                        i5++;
                        rendererCount = i2;
                    }
                }
            }
            i3++;
            mappedTrackInfo2 = mappedTrackInfo;
            rendererCount = rendererCount;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((q10) list.get(i8)).f25407c;
        }
        q10 q10Var3 = (q10) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(q10Var3.f25406b, iArr2), Integer.valueOf(q10Var3.f25405a));
    }

    public static int getFormatLanguageScore(Format format, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 != null && normalizeUndeterminedLanguageToNull != null) {
            if (!normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) && !normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
                if (!Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, "-")[0])) {
                    return 0;
                }
                return 2;
            }
            return 3;
        }
        if (!z || normalizeUndeterminedLanguageToNull2 != null) {
            return 0;
        }
        return 1;
    }

    public static boolean isSupported(int i, boolean z) {
        int m7016f = qa2.m7016f(i);
        if (m7016f != 4 && (!z || m7016f != 3)) {
            return false;
        }
        return true;
    }

    @Nullable
    public static String normalizeUndeterminedLanguageToNull(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C0643C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    public Parameters.Builder buildUponParameters() {
        return getParameters().buildUpon();
    }

    /* renamed from: c */
    public final void m2881c() {
        boolean z;
        p10 p10Var;
        synchronized (this.f11890d) {
            try {
                if (this.f11893g.constrainAudioChannelCountToDeviceCapabilities && !this.f11892f && Util.SDK_INT >= 32 && (p10Var = this.f11894h) != null && p10Var.f25000b) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            invalidate();
        }
    }

    /* renamed from: e */
    public final void m2882e(Parameters parameters) {
        boolean equals;
        Assertions.checkNotNull(parameters);
        synchronized (this.f11890d) {
            equals = this.f11893g.equals(parameters);
            this.f11893g = parameters;
        }
        if (!equals) {
            if (parameters.constrainAudioChannelCountToDeviceCapabilities && this.context == null) {
                Log.m3027w("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public boolean isSetParametersSupported() {
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public void release() {
        p10 p10Var;
        o10 o10Var;
        synchronized (this.f11890d) {
            try {
                if (Util.SDK_INT >= 32 && (p10Var = this.f11894h) != null && (o10Var = p10Var.f25002d) != null && p10Var.f25001c != null) {
                    p10Var.f24999a.removeOnSpatializerStateChangedListener(o10Var);
                    ((Handler) Util.castNonNull(p10Var.f25001c)).removeCallbacksAndMessages(null);
                    p10Var.f25001c = null;
                    p10Var.f25002d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.release();
    }

    public ExoTrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) {
        String str;
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[rendererCount];
        Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack = selectVideoTrack(mappedTrackInfo, iArr, iArr2, parameters);
        if (selectVideoTrack != null) {
            definitionArr[((Integer) selectVideoTrack.second).intValue()] = (ExoTrackSelection.Definition) selectVideoTrack.first;
        }
        Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack = selectAudioTrack(mappedTrackInfo, iArr, iArr2, parameters);
        if (selectAudioTrack != null) {
            definitionArr[((Integer) selectAudioTrack.second).intValue()] = (ExoTrackSelection.Definition) selectAudioTrack.first;
        }
        if (selectAudioTrack == null) {
            str = null;
        } else {
            Object obj = selectAudioTrack.first;
            str = ((ExoTrackSelection.Definition) obj).group.getFormat(((ExoTrackSelection.Definition) obj).tracks[0]).language;
        }
        Pair<ExoTrackSelection.Definition, Integer> selectTextTrack = selectTextTrack(mappedTrackInfo, iArr, parameters, str);
        if (selectTextTrack != null) {
            definitionArr[((Integer) selectTextTrack.second).intValue()] = (ExoTrackSelection.Definition) selectTextTrack.first;
        }
        for (int i = 0; i < rendererCount; i++) {
            int rendererType = mappedTrackInfo.getRendererType(i);
            if (rendererType != 2 && rendererType != 1 && rendererType != 3) {
                definitionArr[i] = selectOtherTrack(rendererType, mappedTrackInfo.getTrackGroups(i), iArr[i], parameters);
            }
        }
        return definitionArr;
    }

    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, final Parameters parameters) {
        final boolean z = false;
        int i = 0;
        while (true) {
            if (i < mappedTrackInfo.getRendererCount()) {
                if (2 == mappedTrackInfo.getRendererType(i) && mappedTrackInfo.getTrackGroups(i).length > 0) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return m2880d(1, mappedTrackInfo, iArr, new DefaultTrackSelector$TrackInfo$Factory() { // from class: l10
            @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TrackInfo$Factory
            public final List create(int i2, TrackGroup trackGroup, int[] iArr3) {
                int i3 = 0;
                Ordering ordering = DefaultTrackSelector.f11888j;
                DefaultTrackSelector defaultTrackSelector = DefaultTrackSelector.this;
                defaultTrackSelector.getClass();
                m10 m10Var = new m10(i3, defaultTrackSelector);
                ImmutableList.Builder builder = ImmutableList.builder();
                while (i3 < trackGroup.length) {
                    int i4 = i3;
                    builder.add((ImmutableList.Builder) new C0716a(i2, trackGroup, i4, parameters, iArr3[i3], z, m10Var));
                    i3++;
                }
                return builder.build();
            }
        }, new C0556bg(6));
    }

    @Nullable
    public ExoTrackSelection.Definition selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        TrackGroup trackGroup = null;
        n10 n10Var = null;
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroupArray.length; i3++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroup2.length; i4++) {
                if (isSupported(iArr2[i4], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    n10 n10Var2 = new n10(iArr2[i4], trackGroup2.getFormat(i4));
                    if (n10Var != null) {
                        if (ComparisonChain.start().compareFalseFirst(n10Var2.f23193b, n10Var.f23193b).compareFalseFirst(n10Var2.f23192a, n10Var.f23192a).result() <= 0) {
                        }
                    }
                    trackGroup = trackGroup2;
                    i2 = i4;
                    n10Var = n10Var2;
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i2);
    }

    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> selectTextTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters, @Nullable String str) {
        return m2880d(3, mappedTrackInfo, iArr, new C1702pw(13, parameters, str), new C0556bg(7));
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        Parameters parameters;
        int i;
        int i2;
        boolean z;
        boolean z2;
        RendererConfiguration rendererConfiguration;
        ExoTrackSelection.Definition definition;
        p10 p10Var;
        synchronized (this.f11890d) {
            try {
                parameters = this.f11893g;
                if (parameters.constrainAudioChannelCountToDeviceCapabilities && Util.SDK_INT >= 32 && (p10Var = this.f11894h) != null) {
                    Looper looper = (Looper) Assertions.checkStateNotNull(Looper.myLooper());
                    if (p10Var.f25002d == null && p10Var.f25001c == null) {
                        p10Var.f25002d = new o10(this);
                        Handler handler = new Handler(looper);
                        p10Var.f25001c = handler;
                        p10Var.f24999a.addOnSpatializerStateChangedListener(new ExecutorC1700pu(handler), p10Var.f25002d);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int rendererCount2 = mappedTrackInfo.getRendererCount();
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < rendererCount2; i3++) {
            m2879b(mappedTrackInfo.getTrackGroups(i3), parameters, hashMap);
        }
        m2879b(mappedTrackInfo.getUnmappedTrackGroups(), parameters, hashMap);
        int i4 = 0;
        while (true) {
            i = -1;
            ExoTrackSelection.Definition definition2 = null;
            if (i4 >= rendererCount2) {
                break;
            }
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(mappedTrackInfo.getRendererType(i4)));
            if (trackSelectionOverride != null) {
                if (!trackSelectionOverride.trackIndices.isEmpty() && mappedTrackInfo.getTrackGroups(i4).indexOf(trackSelectionOverride.mediaTrackGroup) != -1) {
                    definition2 = new ExoTrackSelection.Definition(trackSelectionOverride.mediaTrackGroup, Ints.toArray(trackSelectionOverride.trackIndices));
                }
                selectAllTracks[i4] = definition2;
            }
            i4++;
        }
        int rendererCount3 = mappedTrackInfo.getRendererCount();
        for (int i5 = 0; i5 < rendererCount3; i5++) {
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i5);
            if (parameters.hasSelectionOverride(i5, trackGroups)) {
                SelectionOverride selectionOverride = parameters.getSelectionOverride(i5, trackGroups);
                if (selectionOverride != null && selectionOverride.tracks.length != 0) {
                    definition = new ExoTrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.type);
                } else {
                    definition = null;
                }
                selectAllTracks[i5] = definition;
            }
        }
        for (int i6 = 0; i6 < rendererCount; i6++) {
            int rendererType = mappedTrackInfo.getRendererType(i6);
            if (parameters.getRendererDisabled(i6) || parameters.disabledTrackTypes.contains(Integer.valueOf(rendererType))) {
                selectAllTracks[i6] = null;
            }
        }
        ExoTrackSelection[] createTrackSelections = this.f11891e.createTrackSelections(selectAllTracks, getBandwidthMeter(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i7 = 0; i7 < rendererCount; i7++) {
            int rendererType2 = mappedTrackInfo.getRendererType(i7);
            if (!parameters.getRendererDisabled(i7) && !parameters.disabledTrackTypes.contains(Integer.valueOf(rendererType2)) && (mappedTrackInfo.getRendererType(i7) == -2 || createTrackSelections[i7] != null)) {
                rendererConfiguration = RendererConfiguration.DEFAULT;
            } else {
                rendererConfiguration = null;
            }
            rendererConfigurationArr[i7] = rendererConfiguration;
        }
        if (parameters.tunnelingEnabled) {
            int i8 = -1;
            int i9 = -1;
            int i10 = 0;
            while (i10 < mappedTrackInfo.getRendererCount()) {
                int rendererType3 = mappedTrackInfo.getRendererType(i10);
                ExoTrackSelection exoTrackSelection = createTrackSelections[i10];
                if ((rendererType3 != 1 && rendererType3 != 2) || exoTrackSelection == null) {
                    i2 = i;
                } else {
                    int[][] iArr3 = iArr[i10];
                    int indexOf = mappedTrackInfo.getTrackGroups(i10).indexOf(exoTrackSelection.getTrackGroup());
                    int i11 = 0;
                    while (true) {
                        if (i11 < exoTrackSelection.length()) {
                            if (qa2.m7018h(iArr3[indexOf][exoTrackSelection.getIndexInTrackGroup(i11)]) != 32) {
                                i2 = -1;
                                break;
                            }
                            i11++;
                        } else if (rendererType3 == 1) {
                            i2 = -1;
                            if (i9 != -1) {
                                z = false;
                                break;
                            }
                            i9 = i10;
                        } else {
                            i2 = -1;
                            if (i8 != -1) {
                                z = false;
                                break;
                            }
                            i8 = i10;
                        }
                    }
                }
                i10++;
                i = i2;
            }
            i2 = i;
            z = true;
            if (i9 != i2 && i8 != i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z & z2) {
                RendererConfiguration rendererConfiguration2 = new RendererConfiguration(true);
                rendererConfigurationArr[i9] = rendererConfiguration2;
                rendererConfigurationArr[i8] = rendererConfiguration2;
            }
        }
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) {
        return m2880d(2, mappedTrackInfo, iArr, new C1702pw(12, parameters, iArr2), new C0556bg(5));
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        boolean equals;
        synchronized (this.f11890d) {
            equals = this.f11895i.equals(audioAttributes);
            this.f11895i = audioAttributes;
        }
        if (!equals) {
            m2881c();
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public void setParameters(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            m2882e((Parameters) trackSelectionParameters);
        }
        m2882e(new Parameters.Builder(getParameters()).set(trackSelectionParameters).build());
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public Parameters getParameters() {
        Parameters parameters;
        synchronized (this.f11890d) {
            parameters = this.f11893g;
        }
        return parameters;
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(context, Parameters.getDefaults(context), factory);
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters) {
        this(context, trackSelectionParameters, new AdaptiveTrackSelection.Factory());
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, (Context) null);
    }

    @Deprecated
    public void setParameters(ParametersBuilder parametersBuilder) {
        m2882e(parametersBuilder.build());
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context);
    }

    public void setParameters(Parameters.Builder builder) {
        m2882e(builder.build());
    }

    public DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, Context context) {
        Spatializer spatializer;
        this.f11890d = new Object();
        p10 p10Var = null;
        this.context = context != null ? context.getApplicationContext() : null;
        this.f11891e = factory;
        if (trackSelectionParameters instanceof Parameters) {
            this.f11893g = (Parameters) trackSelectionParameters;
        } else {
            this.f11893g = (context == null ? Parameters.DEFAULT_WITHOUT_CONTEXT : Parameters.getDefaults(context)).buildUpon().set(trackSelectionParameters).build();
        }
        this.f11895i = AudioAttributes.DEFAULT;
        boolean z = context != null && Util.isTv(context);
        this.f11892f = z;
        if (!z && context != null && Util.SDK_INT >= 32) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                spatializer = audioManager.getSpatializer();
                p10Var = new p10(spatializer);
            }
            this.f11894h = p10Var;
        }
        if (this.f11893g.constrainAudioChannelCountToDeviceCapabilities && context == null) {
            Log.m3027w("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
