package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.InlineMe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import p000.ee0;

/* loaded from: classes.dex */
public final class MediaItem implements Bundleable {
    public static final String DEFAULT_MEDIA_ID = "";
    public final ClippingConfiguration clippingConfiguration;

    @Deprecated
    public final ClippingProperties clippingProperties;
    public final LiveConfiguration liveConfiguration;

    @Nullable
    public final LocalConfiguration localConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;

    @Nullable
    @Deprecated
    public final PlaybackProperties playbackProperties;
    public final RequestMetadata requestMetadata;
    public static final MediaItem EMPTY = new Builder().build();
    public static final Bundleable.Creator<MediaItem> CREATOR = new ee0(11);

    /* loaded from: classes.dex */
    public static final class AdsConfiguration {
        public final Uri adTagUri;

        @Nullable
        public final Object adsId;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public Uri f9388a;

            /* renamed from: b */
            public Object f9389b;

            public Builder(Uri uri) {
                this.f9388a = uri;
            }

            public AdsConfiguration build() {
                return new AdsConfiguration(this);
            }

            public Builder setAdTagUri(Uri uri) {
                this.f9388a = uri;
                return this;
            }

            public Builder setAdsId(@Nullable Object obj) {
                this.f9389b = obj;
                return this;
            }
        }

        public AdsConfiguration(Builder builder) {
            this.adTagUri = builder.f9388a;
            this.adsId = builder.f9389b;
        }

        public Builder buildUpon() {
            return new Builder(this.adTagUri).setAdsId(this.adsId);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            if (this.adTagUri.equals(adsConfiguration.adTagUri) && Util.areEqual(this.adsId, adsConfiguration.adsId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = this.adTagUri.hashCode() * 31;
            Object obj = this.adsId;
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            return hashCode + i;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public String f9390a;

        /* renamed from: b */
        public Uri f9391b;

        /* renamed from: c */
        public String f9392c;

        /* renamed from: g */
        public String f9396g;

        /* renamed from: i */
        public AdsConfiguration f9398i;

        /* renamed from: j */
        public Object f9399j;

        /* renamed from: k */
        public MediaMetadata f9400k;

        /* renamed from: d */
        public ClippingConfiguration.Builder f9393d = new ClippingConfiguration.Builder();

        /* renamed from: e */
        public DrmConfiguration.Builder f9394e = new DrmConfiguration.Builder();

        /* renamed from: f */
        public List f9395f = Collections.emptyList();

        /* renamed from: h */
        public ImmutableList f9397h = ImmutableList.m3902of();

        /* renamed from: l */
        public LiveConfiguration.Builder f9401l = new LiveConfiguration.Builder();

        /* renamed from: m */
        public RequestMetadata f9402m = RequestMetadata.EMPTY;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.exoplayer2.MediaItem$LocalConfiguration] */
        public MediaItem build() {
            boolean z;
            PlaybackProperties playbackProperties;
            DrmConfiguration.Builder builder = this.f9394e;
            if (builder.f9410b != null && builder.f9409a == null) {
                z = false;
            } else {
                z = true;
            }
            Assertions.checkState(z);
            Uri uri = this.f9391b;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.f9392c;
                DrmConfiguration.Builder builder2 = this.f9394e;
                if (builder2.f9409a != null) {
                    drmConfiguration = builder2.build();
                }
                playbackProperties = new LocalConfiguration(uri, str, drmConfiguration, this.f9398i, this.f9395f, this.f9396g, this.f9397h, this.f9399j);
            } else {
                playbackProperties = null;
            }
            String str2 = this.f9390a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties buildClippingProperties = this.f9393d.buildClippingProperties();
            LiveConfiguration build = this.f9401l.build();
            MediaMetadata mediaMetadata = this.f9400k;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.EMPTY;
            }
            return new MediaItem(str3, buildClippingProperties, playbackProperties, build, mediaMetadata, this.f9402m);
        }

        @Deprecated
        public Builder setAdTagUri(@Nullable String str) {
            return setAdTagUri(str != null ? Uri.parse(str) : null);
        }

        public Builder setAdsConfiguration(@Nullable AdsConfiguration adsConfiguration) {
            this.f9398i = adsConfiguration;
            return this;
        }

        @Deprecated
        public Builder setClipEndPositionMs(long j) {
            this.f9393d.setEndPositionMs(j);
            return this;
        }

        @Deprecated
        public Builder setClipRelativeToDefaultPosition(boolean z) {
            this.f9393d.setRelativeToDefaultPosition(z);
            return this;
        }

        @Deprecated
        public Builder setClipRelativeToLiveWindow(boolean z) {
            this.f9393d.setRelativeToLiveWindow(z);
            return this;
        }

        @Deprecated
        public Builder setClipStartPositionMs(@IntRange(from = 0) long j) {
            this.f9393d.setStartPositionMs(j);
            return this;
        }

        @Deprecated
        public Builder setClipStartsAtKeyFrame(boolean z) {
            this.f9393d.setStartsAtKeyFrame(z);
            return this;
        }

        public Builder setClippingConfiguration(ClippingConfiguration clippingConfiguration) {
            this.f9393d = clippingConfiguration.buildUpon();
            return this;
        }

        public Builder setCustomCacheKey(@Nullable String str) {
            this.f9396g = str;
            return this;
        }

        public Builder setDrmConfiguration(@Nullable DrmConfiguration drmConfiguration) {
            DrmConfiguration.Builder builder;
            if (drmConfiguration != null) {
                builder = drmConfiguration.buildUpon();
            } else {
                builder = new DrmConfiguration.Builder();
            }
            this.f9394e = builder;
            return this;
        }

        @Deprecated
        public Builder setDrmForceDefaultLicenseUri(boolean z) {
            this.f9394e.setForceDefaultLicenseUri(z);
            return this;
        }

        @Deprecated
        public Builder setDrmKeySetId(@Nullable byte[] bArr) {
            this.f9394e.setKeySetId(bArr);
            return this;
        }

        @Deprecated
        public Builder setDrmLicenseRequestHeaders(@Nullable Map<String, String> map) {
            DrmConfiguration.Builder builder = this.f9394e;
            if (map == null) {
                map = ImmutableMap.m3923of();
            }
            builder.setLicenseRequestHeaders(map);
            return this;
        }

        @Deprecated
        public Builder setDrmLicenseUri(@Nullable Uri uri) {
            this.f9394e.setLicenseUri(uri);
            return this;
        }

        @Deprecated
        public Builder setDrmMultiSession(boolean z) {
            this.f9394e.setMultiSession(z);
            return this;
        }

        @Deprecated
        public Builder setDrmPlayClearContentWithoutKey(boolean z) {
            this.f9394e.setPlayClearContentWithoutKey(z);
            return this;
        }

        @Deprecated
        public Builder setDrmSessionForClearPeriods(boolean z) {
            this.f9394e.setForceSessionsForAudioAndVideoTracks(z);
            return this;
        }

        @Deprecated
        public Builder setDrmSessionForClearTypes(@Nullable List<Integer> list) {
            DrmConfiguration.Builder builder = this.f9394e;
            if (list == null) {
                list = ImmutableList.m3902of();
            }
            builder.setForcedSessionTrackTypes(list);
            return this;
        }

        @Deprecated
        public Builder setDrmUuid(@Nullable UUID uuid) {
            this.f9394e.f9409a = uuid;
            return this;
        }

        public Builder setLiveConfiguration(LiveConfiguration liveConfiguration) {
            this.f9401l = liveConfiguration.buildUpon();
            return this;
        }

        @Deprecated
        public Builder setLiveMaxOffsetMs(long j) {
            this.f9401l.setMaxOffsetMs(j);
            return this;
        }

        @Deprecated
        public Builder setLiveMaxPlaybackSpeed(float f) {
            this.f9401l.setMaxPlaybackSpeed(f);
            return this;
        }

        @Deprecated
        public Builder setLiveMinOffsetMs(long j) {
            this.f9401l.setMinOffsetMs(j);
            return this;
        }

        @Deprecated
        public Builder setLiveMinPlaybackSpeed(float f) {
            this.f9401l.setMinPlaybackSpeed(f);
            return this;
        }

        @Deprecated
        public Builder setLiveTargetOffsetMs(long j) {
            this.f9401l.setTargetOffsetMs(j);
            return this;
        }

        public Builder setMediaId(String str) {
            this.f9390a = (String) Assertions.checkNotNull(str);
            return this;
        }

        public Builder setMediaMetadata(MediaMetadata mediaMetadata) {
            this.f9400k = mediaMetadata;
            return this;
        }

        public Builder setMimeType(@Nullable String str) {
            this.f9392c = str;
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata) {
            this.f9402m = requestMetadata;
            return this;
        }

        public Builder setStreamKeys(@Nullable List<StreamKey> list) {
            List emptyList;
            if (list != null && !list.isEmpty()) {
                emptyList = Collections.unmodifiableList(new ArrayList(list));
            } else {
                emptyList = Collections.emptyList();
            }
            this.f9395f = emptyList;
            return this;
        }

        public Builder setSubtitleConfigurations(List<SubtitleConfiguration> list) {
            this.f9397h = ImmutableList.copyOf((Collection) list);
            return this;
        }

        @Deprecated
        public Builder setSubtitles(@Nullable List<Subtitle> list) {
            ImmutableList m3902of;
            if (list != null) {
                m3902of = ImmutableList.copyOf((Collection) list);
            } else {
                m3902of = ImmutableList.m3902of();
            }
            this.f9397h = m3902of;
            return this;
        }

        public Builder setTag(@Nullable Object obj) {
            this.f9399j = obj;
            return this;
        }

        public Builder setUri(@Nullable String str) {
            return setUri(str == null ? null : Uri.parse(str));
        }

        @Deprecated
        public Builder setAdTagUri(@Nullable Uri uri) {
            return setAdTagUri(uri, null);
        }

        @Deprecated
        public Builder setDrmLicenseUri(@Nullable String str) {
            this.f9394e.setLicenseUri(str);
            return this;
        }

        public Builder setUri(@Nullable Uri uri) {
            this.f9391b = uri;
            return this;
        }

        @Deprecated
        public Builder setAdTagUri(@Nullable Uri uri, @Nullable Object obj) {
            this.f9398i = uri != null ? new AdsConfiguration.Builder(uri).setAdsId(obj).build() : null;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class ClippingConfiguration implements Bundleable {
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;

        @IntRange(from = 0)
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;
        public static final ClippingConfiguration UNSET = new Builder().build();
        public static final Bundleable.Creator<ClippingProperties> CREATOR = new ee0(12);

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public long f9403a;

            /* renamed from: b */
            public long f9404b = Long.MIN_VALUE;

            /* renamed from: c */
            public boolean f9405c;

            /* renamed from: d */
            public boolean f9406d;

            /* renamed from: e */
            public boolean f9407e;

            public ClippingConfiguration build() {
                return buildClippingProperties();
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.MediaItem$ClippingConfiguration, com.google.android.exoplayer2.MediaItem$ClippingProperties] */
            @Deprecated
            public ClippingProperties buildClippingProperties() {
                return new ClippingConfiguration(this);
            }

            public Builder setEndPositionMs(long j) {
                boolean z;
                if (j != Long.MIN_VALUE && j < 0) {
                    z = false;
                } else {
                    z = true;
                }
                Assertions.checkArgument(z);
                this.f9404b = j;
                return this;
            }

            public Builder setRelativeToDefaultPosition(boolean z) {
                this.f9406d = z;
                return this;
            }

            public Builder setRelativeToLiveWindow(boolean z) {
                this.f9405c = z;
                return this;
            }

            public Builder setStartPositionMs(@IntRange(from = 0) long j) {
                boolean z;
                if (j >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z);
                this.f9403a = j;
                return this;
            }

            public Builder setStartsAtKeyFrame(boolean z) {
                this.f9407e = z;
                return this;
            }
        }

        public ClippingConfiguration(Builder builder) {
            this.startPositionMs = builder.f9403a;
            this.endPositionMs = builder.f9404b;
            this.relativeToLiveWindow = builder.f9405c;
            this.relativeToDefaultPosition = builder.f9406d;
            this.startsAtKeyFrame = builder.f9407e;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.MediaItem$ClippingConfiguration$Builder, java.lang.Object] */
        public Builder buildUpon() {
            ?? obj = new Object();
            obj.f9403a = this.startPositionMs;
            obj.f9404b = this.endPositionMs;
            obj.f9405c = this.relativeToLiveWindow;
            obj.f9406d = this.relativeToDefaultPosition;
            obj.f9407e = this.startsAtKeyFrame;
            return obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            if (this.startPositionMs == clippingConfiguration.startPositionMs && this.endPositionMs == clippingConfiguration.endPositionMs && this.relativeToLiveWindow == clippingConfiguration.relativeToLiveWindow && this.relativeToDefaultPosition == clippingConfiguration.relativeToDefaultPosition && this.startsAtKeyFrame == clippingConfiguration.startsAtKeyFrame) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.startPositionMs;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.endPositionMs;
            return ((((((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(Integer.toString(0, 36), this.startPositionMs);
            bundle.putLong(Integer.toString(1, 36), this.endPositionMs);
            bundle.putBoolean(Integer.toString(2, 36), this.relativeToLiveWindow);
            bundle.putBoolean(Integer.toString(3, 36), this.relativeToDefaultPosition);
            bundle.putBoolean(Integer.toString(4, 36), this.startsAtKeyFrame);
            return bundle;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class ClippingProperties extends ClippingConfiguration {
        public static final ClippingProperties UNSET = new ClippingConfiguration.Builder().buildClippingProperties();
    }

    /* loaded from: classes.dex */
    public static final class DrmConfiguration {

        /* renamed from: a */
        public final byte[] f9408a;
        public final boolean forceDefaultLicenseUri;
        public final ImmutableList<Integer> forcedSessionTrackTypes;
        public final ImmutableMap<String, String> licenseRequestHeaders;

        @Nullable
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;

        @Deprecated
        public final ImmutableMap<String, String> requestHeaders;
        public final UUID scheme;

        @Deprecated
        public final ImmutableList<Integer> sessionForClearTypes;

        @Deprecated
        public final UUID uuid;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public UUID f9409a;

            /* renamed from: b */
            public Uri f9410b;

            /* renamed from: d */
            public boolean f9412d;

            /* renamed from: e */
            public boolean f9413e;

            /* renamed from: f */
            public boolean f9414f;

            /* renamed from: h */
            public byte[] f9416h;

            /* renamed from: c */
            public ImmutableMap f9411c = ImmutableMap.m3923of();

            /* renamed from: g */
            public ImmutableList f9415g = ImmutableList.m3902of();

            public Builder(UUID uuid) {
                this.f9409a = uuid;
            }

            public DrmConfiguration build() {
                return new DrmConfiguration(this);
            }

            @InlineMe(replacement = "this.setForceSessionsForAudioAndVideoTracks(forceSessionsForAudioAndVideoTracks)")
            @Deprecated
            public Builder forceSessionsForAudioAndVideoTracks(boolean z) {
                return setForceSessionsForAudioAndVideoTracks(z);
            }

            public Builder setForceDefaultLicenseUri(boolean z) {
                this.f9414f = z;
                return this;
            }

            public Builder setForceSessionsForAudioAndVideoTracks(boolean z) {
                ImmutableList m3902of;
                if (z) {
                    m3902of = ImmutableList.m3904of(2, 1);
                } else {
                    m3902of = ImmutableList.m3902of();
                }
                setForcedSessionTrackTypes(m3902of);
                return this;
            }

            public Builder setForcedSessionTrackTypes(List<Integer> list) {
                this.f9415g = ImmutableList.copyOf((Collection) list);
                return this;
            }

            public Builder setKeySetId(@Nullable byte[] bArr) {
                byte[] bArr2;
                if (bArr != null) {
                    bArr2 = Arrays.copyOf(bArr, bArr.length);
                } else {
                    bArr2 = null;
                }
                this.f9416h = bArr2;
                return this;
            }

            public Builder setLicenseRequestHeaders(Map<String, String> map) {
                this.f9411c = ImmutableMap.copyOf((Map) map);
                return this;
            }

            public Builder setLicenseUri(@Nullable Uri uri) {
                this.f9410b = uri;
                return this;
            }

            public Builder setMultiSession(boolean z) {
                this.f9412d = z;
                return this;
            }

            public Builder setPlayClearContentWithoutKey(boolean z) {
                this.f9413e = z;
                return this;
            }

            public Builder setScheme(UUID uuid) {
                this.f9409a = uuid;
                return this;
            }

            public Builder setLicenseUri(@Nullable String str) {
                this.f9410b = str == null ? null : Uri.parse(str);
                return this;
            }

            public Builder() {
            }
        }

        public DrmConfiguration(Builder builder) {
            boolean z;
            byte[] bArr;
            if (builder.f9414f && builder.f9410b == null) {
                z = false;
            } else {
                z = true;
            }
            Assertions.checkState(z);
            UUID uuid = (UUID) Assertions.checkNotNull(builder.f9409a);
            this.scheme = uuid;
            this.uuid = uuid;
            this.licenseUri = builder.f9410b;
            ImmutableMap<String, String> immutableMap = builder.f9411c;
            this.requestHeaders = immutableMap;
            this.licenseRequestHeaders = immutableMap;
            this.multiSession = builder.f9412d;
            this.forceDefaultLicenseUri = builder.f9414f;
            this.playClearContentWithoutKey = builder.f9413e;
            ImmutableList<Integer> immutableList = builder.f9415g;
            this.sessionForClearTypes = immutableList;
            this.forcedSessionTrackTypes = immutableList;
            byte[] bArr2 = builder.f9416h;
            if (bArr2 != null) {
                bArr = Arrays.copyOf(bArr2, bArr2.length);
            } else {
                bArr = null;
            }
            this.f9408a = bArr;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.exoplayer2.MediaItem$DrmConfiguration$Builder] */
        public Builder buildUpon() {
            ?? obj = new Object();
            obj.f9409a = this.scheme;
            obj.f9410b = this.licenseUri;
            obj.f9411c = this.licenseRequestHeaders;
            obj.f9412d = this.multiSession;
            obj.f9413e = this.playClearContentWithoutKey;
            obj.f9414f = this.forceDefaultLicenseUri;
            obj.f9415g = this.forcedSessionTrackTypes;
            obj.f9416h = this.f9408a;
            return obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            if (this.scheme.equals(drmConfiguration.scheme) && Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) && Util.areEqual(this.licenseRequestHeaders, drmConfiguration.licenseRequestHeaders) && this.multiSession == drmConfiguration.multiSession && this.forceDefaultLicenseUri == drmConfiguration.forceDefaultLicenseUri && this.playClearContentWithoutKey == drmConfiguration.playClearContentWithoutKey && this.forcedSessionTrackTypes.equals(drmConfiguration.forcedSessionTrackTypes) && Arrays.equals(this.f9408a, drmConfiguration.f9408a)) {
                return true;
            }
            return false;
        }

        @Nullable
        public byte[] getKeySetId() {
            byte[] bArr = this.f9408a;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public int hashCode() {
            int i;
            int hashCode = this.scheme.hashCode() * 31;
            Uri uri = this.licenseUri;
            if (uri != null) {
                i = uri.hashCode();
            } else {
                i = 0;
            }
            return Arrays.hashCode(this.f9408a) + ((this.forcedSessionTrackTypes.hashCode() + ((((((((this.licenseRequestHeaders.hashCode() + ((hashCode + i) * 31)) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31)) * 31);
        }
    }

    /* loaded from: classes.dex */
    public static final class LiveConfiguration implements Bundleable {
        public final long maxOffsetMs;
        public final float maxPlaybackSpeed;
        public final long minOffsetMs;
        public final float minPlaybackSpeed;
        public final long targetOffsetMs;
        public static final LiveConfiguration UNSET = new Builder().build();
        public static final Bundleable.Creator<LiveConfiguration> CREATOR = new ee0(13);

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public long f9417a = C0643C.TIME_UNSET;

            /* renamed from: b */
            public long f9418b = C0643C.TIME_UNSET;

            /* renamed from: c */
            public long f9419c = C0643C.TIME_UNSET;

            /* renamed from: d */
            public float f9420d = -3.4028235E38f;

            /* renamed from: e */
            public float f9421e = -3.4028235E38f;

            public LiveConfiguration build() {
                return new LiveConfiguration(this.f9417a, this.f9418b, this.f9419c, this.f9420d, this.f9421e);
            }

            public Builder setMaxOffsetMs(long j) {
                this.f9419c = j;
                return this;
            }

            public Builder setMaxPlaybackSpeed(float f) {
                this.f9421e = f;
                return this;
            }

            public Builder setMinOffsetMs(long j) {
                this.f9418b = j;
                return this;
            }

            public Builder setMinPlaybackSpeed(float f) {
                this.f9420d = f;
                return this;
            }

            public Builder setTargetOffsetMs(long j) {
                this.f9417a = j;
                return this;
            }
        }

        @Deprecated
        public LiveConfiguration(long j, long j2, long j3, float f, float f2) {
            this.targetOffsetMs = j;
            this.minOffsetMs = j2;
            this.maxOffsetMs = j3;
            this.minPlaybackSpeed = f;
            this.maxPlaybackSpeed = f2;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder, java.lang.Object] */
        public Builder buildUpon() {
            ?? obj = new Object();
            obj.f9417a = this.targetOffsetMs;
            obj.f9418b = this.minOffsetMs;
            obj.f9419c = this.maxOffsetMs;
            obj.f9420d = this.minPlaybackSpeed;
            obj.f9421e = this.maxPlaybackSpeed;
            return obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            if (this.targetOffsetMs == liveConfiguration.targetOffsetMs && this.minOffsetMs == liveConfiguration.minOffsetMs && this.maxOffsetMs == liveConfiguration.maxOffsetMs && this.minPlaybackSpeed == liveConfiguration.minPlaybackSpeed && this.maxPlaybackSpeed == liveConfiguration.maxPlaybackSpeed) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            long j = this.targetOffsetMs;
            long j2 = this.minOffsetMs;
            int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.maxOffsetMs;
            int i3 = (i2 + ((int) ((j3 >>> 32) ^ j3))) * 31;
            float f = this.minPlaybackSpeed;
            int i4 = 0;
            if (f != RecyclerView.f7068F0) {
                i = Float.floatToIntBits(f);
            } else {
                i = 0;
            }
            int i5 = (i3 + i) * 31;
            float f2 = this.maxPlaybackSpeed;
            if (f2 != RecyclerView.f7068F0) {
                i4 = Float.floatToIntBits(f2);
            }
            return i5 + i4;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(Integer.toString(0, 36), this.targetOffsetMs);
            bundle.putLong(Integer.toString(1, 36), this.minOffsetMs);
            bundle.putLong(Integer.toString(2, 36), this.maxOffsetMs);
            bundle.putFloat(Integer.toString(3, 36), this.minPlaybackSpeed);
            bundle.putFloat(Integer.toString(4, 36), this.maxPlaybackSpeed);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public static class LocalConfiguration {

        @Nullable
        public final AdsConfiguration adsConfiguration;

        @Nullable
        public final String customCacheKey;

        @Nullable
        public final DrmConfiguration drmConfiguration;

        @Nullable
        public final String mimeType;
        public final List<StreamKey> streamKeys;
        public final ImmutableList<SubtitleConfiguration> subtitleConfigurations;

        @Deprecated
        public final List<Subtitle> subtitles;

        @Nullable
        public final Object tag;
        public final Uri uri;

        /* JADX WARN: Multi-variable type inference failed */
        public LocalConfiguration(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List list, String str2, ImmutableList immutableList, Object obj) {
            this.uri = uri;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration;
            this.adsConfiguration = adsConfiguration;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitleConfigurations = immutableList;
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i = 0; i < immutableList.size(); i++) {
                SubtitleConfiguration.Builder buildUpon = ((SubtitleConfiguration) immutableList.get(i)).buildUpon();
                buildUpon.getClass();
                builder.add((ImmutableList.Builder) new SubtitleConfiguration(buildUpon));
            }
            this.subtitles = builder.build();
            this.tag = obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            if (this.uri.equals(localConfiguration.uri) && Util.areEqual(this.mimeType, localConfiguration.mimeType) && Util.areEqual(this.drmConfiguration, localConfiguration.drmConfiguration) && Util.areEqual(this.adsConfiguration, localConfiguration.adsConfiguration) && this.streamKeys.equals(localConfiguration.streamKeys) && Util.areEqual(this.customCacheKey, localConfiguration.customCacheKey) && this.subtitleConfigurations.equals(localConfiguration.subtitleConfigurations) && Util.areEqual(this.tag, localConfiguration.tag)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5 = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i2 = (hashCode5 + hashCode) * 31;
            DrmConfiguration drmConfiguration = this.drmConfiguration;
            if (drmConfiguration == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = drmConfiguration.hashCode();
            }
            int i3 = (i2 + hashCode2) * 31;
            AdsConfiguration adsConfiguration = this.adsConfiguration;
            if (adsConfiguration == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = adsConfiguration.hashCode();
            }
            int hashCode6 = (this.streamKeys.hashCode() + ((i3 + hashCode3) * 31)) * 31;
            String str2 = this.customCacheKey;
            if (str2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str2.hashCode();
            }
            int hashCode7 = (this.subtitleConfigurations.hashCode() + ((hashCode6 + hashCode4) * 31)) * 31;
            Object obj = this.tag;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode7 + i;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class PlaybackProperties extends LocalConfiguration {
    }

    /* loaded from: classes.dex */
    public static final class RequestMetadata implements Bundleable {

        @Nullable
        public final Bundle extras;

        @Nullable
        public final Uri mediaUri;

        @Nullable
        public final String searchQuery;
        public static final RequestMetadata EMPTY = new Builder().build();
        public static final Bundleable.Creator<RequestMetadata> CREATOR = new ee0(14);

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public Uri f9422a;

            /* renamed from: b */
            public String f9423b;

            /* renamed from: c */
            public Bundle f9424c;

            public RequestMetadata build() {
                return new RequestMetadata(this);
            }

            public Builder setExtras(@Nullable Bundle bundle) {
                this.f9424c = bundle;
                return this;
            }

            public Builder setMediaUri(@Nullable Uri uri) {
                this.f9422a = uri;
                return this;
            }

            public Builder setSearchQuery(@Nullable String str) {
                this.f9423b = str;
                return this;
            }
        }

        public RequestMetadata(Builder builder) {
            this.mediaUri = builder.f9422a;
            this.searchQuery = builder.f9423b;
            this.extras = builder.f9424c;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.MediaItem$RequestMetadata$Builder, java.lang.Object] */
        public Builder buildUpon() {
            ?? obj = new Object();
            obj.f9422a = this.mediaUri;
            obj.f9423b = this.searchQuery;
            obj.f9424c = this.extras;
            return obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (Util.areEqual(this.mediaUri, requestMetadata.mediaUri) && Util.areEqual(this.searchQuery, requestMetadata.searchQuery)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Uri uri = this.mediaUri;
            int i = 0;
            if (uri == null) {
                hashCode = 0;
            } else {
                hashCode = uri.hashCode();
            }
            int i2 = hashCode * 31;
            String str = this.searchQuery;
            if (str != null) {
                i = str.hashCode();
            }
            return i2 + i;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (this.mediaUri != null) {
                bundle.putParcelable(Integer.toString(0, 36), this.mediaUri);
            }
            if (this.searchQuery != null) {
                bundle.putString(Integer.toString(1, 36), this.searchQuery);
            }
            if (this.extras != null) {
                bundle.putBundle(Integer.toString(2, 36), this.extras);
            }
            return bundle;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class Subtitle extends SubtitleConfiguration {
        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2) {
            this(uri, str, str2, 0);
        }

        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2, int i) {
            this(uri, str, str2, i, 0, null);
        }

        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2, int i, int i2, @Nullable String str3) {
            super(uri, str, str2, i, i2, str3);
        }
    }

    public MediaItem(String str, ClippingProperties clippingProperties, PlaybackProperties playbackProperties, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.mediaId = str;
        this.localConfiguration = playbackProperties;
        this.playbackProperties = playbackProperties;
        this.liveConfiguration = liveConfiguration;
        this.mediaMetadata = mediaMetadata;
        this.clippingConfiguration = clippingProperties;
        this.clippingProperties = clippingProperties;
        this.requestMetadata = requestMetadata;
    }

    public static MediaItem fromUri(String str) {
        return new Builder().setUri(str).build();
    }

    public Builder buildUpon() {
        DrmConfiguration.Builder builder;
        Builder builder2 = new Builder();
        builder2.f9393d = this.clippingConfiguration.buildUpon();
        builder2.f9390a = this.mediaId;
        builder2.f9400k = this.mediaMetadata;
        builder2.f9401l = this.liveConfiguration.buildUpon();
        builder2.f9402m = this.requestMetadata;
        LocalConfiguration localConfiguration = this.localConfiguration;
        if (localConfiguration != null) {
            builder2.f9396g = localConfiguration.customCacheKey;
            builder2.f9392c = localConfiguration.mimeType;
            builder2.f9391b = localConfiguration.uri;
            builder2.f9395f = localConfiguration.streamKeys;
            builder2.f9397h = localConfiguration.subtitleConfigurations;
            builder2.f9399j = localConfiguration.tag;
            DrmConfiguration drmConfiguration = localConfiguration.drmConfiguration;
            if (drmConfiguration != null) {
                builder = drmConfiguration.buildUpon();
            } else {
                builder = new DrmConfiguration.Builder();
            }
            builder2.f9394e = builder;
            builder2.f9398i = localConfiguration.adsConfiguration;
        }
        return builder2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        if (Util.areEqual(this.mediaId, mediaItem.mediaId) && this.clippingConfiguration.equals(mediaItem.clippingConfiguration) && Util.areEqual(this.localConfiguration, mediaItem.localConfiguration) && Util.areEqual(this.liveConfiguration, mediaItem.liveConfiguration) && Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata) && Util.areEqual(this.requestMetadata, mediaItem.requestMetadata)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.mediaId.hashCode() * 31;
        LocalConfiguration localConfiguration = this.localConfiguration;
        if (localConfiguration != null) {
            i = localConfiguration.hashCode();
        } else {
            i = 0;
        }
        return this.requestMetadata.hashCode() + ((this.mediaMetadata.hashCode() + ((this.clippingConfiguration.hashCode() + ((this.liveConfiguration.hashCode() + ((hashCode + i) * 31)) * 31)) * 31)) * 31);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(Integer.toString(0, 36), this.mediaId);
        bundle.putBundle(Integer.toString(1, 36), this.liveConfiguration.toBundle());
        bundle.putBundle(Integer.toString(2, 36), this.mediaMetadata.toBundle());
        bundle.putBundle(Integer.toString(3, 36), this.clippingConfiguration.toBundle());
        bundle.putBundle(Integer.toString(4, 36), this.requestMetadata.toBundle());
        return bundle;
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setUri(uri).build();
    }

    /* loaded from: classes.dex */
    public static class SubtitleConfiguration {

        /* renamed from: id */
        @Nullable
        public final String f9425id;

        @Nullable
        public final String label;

        @Nullable
        public final String language;

        @Nullable
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public Uri f9426a;

            /* renamed from: b */
            public String f9427b;

            /* renamed from: c */
            public String f9428c;

            /* renamed from: d */
            public int f9429d;

            /* renamed from: e */
            public int f9430e;

            /* renamed from: f */
            public String f9431f;

            /* renamed from: g */
            public String f9432g;

            public Builder(Uri uri) {
                this.f9426a = uri;
            }

            public SubtitleConfiguration build() {
                return new SubtitleConfiguration(this);
            }

            public Builder setId(@Nullable String str) {
                this.f9432g = str;
                return this;
            }

            public Builder setLabel(@Nullable String str) {
                this.f9431f = str;
                return this;
            }

            public Builder setLanguage(@Nullable String str) {
                this.f9428c = str;
                return this;
            }

            public Builder setMimeType(@Nullable String str) {
                this.f9427b = str;
                return this;
            }

            public Builder setRoleFlags(int i) {
                this.f9430e = i;
                return this;
            }

            public Builder setSelectionFlags(int i) {
                this.f9429d = i;
                return this;
            }

            public Builder setUri(Uri uri) {
                this.f9426a = uri;
                return this;
            }
        }

        public SubtitleConfiguration(Uri uri, String str, String str2, int i, int i2, String str3) {
            this.uri = uri;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i;
            this.roleFlags = i2;
            this.label = str3;
            this.f9425id = null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.MediaItem$SubtitleConfiguration$Builder, java.lang.Object] */
        public Builder buildUpon() {
            ?? obj = new Object();
            obj.f9426a = this.uri;
            obj.f9427b = this.mimeType;
            obj.f9428c = this.language;
            obj.f9429d = this.selectionFlags;
            obj.f9430e = this.roleFlags;
            obj.f9431f = this.label;
            obj.f9432g = this.f9425id;
            return obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            if (this.uri.equals(subtitleConfiguration.uri) && Util.areEqual(this.mimeType, subtitleConfiguration.mimeType) && Util.areEqual(this.language, subtitleConfiguration.language) && this.selectionFlags == subtitleConfiguration.selectionFlags && this.roleFlags == subtitleConfiguration.roleFlags && Util.areEqual(this.label, subtitleConfiguration.label) && Util.areEqual(this.f9425id, subtitleConfiguration.f9425id)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4 = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i2 = (hashCode4 + hashCode) * 31;
            String str2 = this.language;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i3 = (((((i2 + hashCode2) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str3 = this.label;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i4 = (i3 + hashCode3) * 31;
            String str4 = this.f9425id;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return i4 + i;
        }

        public SubtitleConfiguration(Builder builder) {
            this.uri = builder.f9426a;
            this.mimeType = builder.f9427b;
            this.language = builder.f9428c;
            this.selectionFlags = builder.f9429d;
            this.roleFlags = builder.f9430e;
            this.label = builder.f9431f;
            this.f9425id = builder.f9432g;
        }
    }
}
