package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p003ui.AdViewProvider;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import p000.C0008a7;
import p000.RunnableC2046z6;
import p000.ye0;

/* loaded from: classes.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {

    /* renamed from: w */
    public static final MediaSource.MediaPeriodId f11098w = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: k */
    public final MediaSource f11099k;

    /* renamed from: l */
    public final MediaSource.Factory f11100l;

    /* renamed from: m */
    public final AdsLoader f11101m;

    /* renamed from: n */
    public final AdViewProvider f11102n;

    /* renamed from: o */
    public final DataSpec f11103o;

    /* renamed from: p */
    public final Object f11104p;

    /* renamed from: s */
    public C0688b f11107s;

    /* renamed from: t */
    public Timeline f11108t;

    /* renamed from: u */
    public AdPlaybackState f11109u;

    /* renamed from: q */
    public final Handler f11105q = new Handler(Looper.getMainLooper());

    /* renamed from: r */
    public final Timeline.Period f11106r = new Timeline.Period();

    /* renamed from: v */
    public C0008a7[][] f11110v = new C0008a7[0];

    /* loaded from: classes.dex */
    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Type {
        }

        public AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException(ye0.m8291k(i, "Failed to load ad group "), exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            boolean z;
            if (this.type == 3) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            return (RuntimeException) Assertions.checkNotNull(getCause());
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider) {
        this.f11099k = mediaSource;
        this.f11100l = factory;
        this.f11101m = adsLoader;
        this.f11102n = adViewProvider;
        this.f11103o = dataSpec;
        this.f11104p = obj;
        adsLoader.setSupportedContentTypes(factory.getSupportedTypes());
    }

    /* renamed from: a */
    public final void m2756a() {
        Uri uri;
        AdsMediaSource adsMediaSource;
        AdPlaybackState adPlaybackState = this.f11109u;
        if (adPlaybackState == null) {
            return;
        }
        for (int i = 0; i < this.f11110v.length; i++) {
            int i2 = 0;
            while (true) {
                C0008a7[] c0008a7Arr = this.f11110v[i];
                if (i2 < c0008a7Arr.length) {
                    C0008a7 c0008a7 = c0008a7Arr[i2];
                    AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i);
                    if (c0008a7 != null && c0008a7.f65d == null) {
                        Uri[] uriArr = adGroup.uris;
                        if (i2 < uriArr.length && (uri = uriArr[i2]) != null) {
                            MediaItem.Builder uri2 = new MediaItem.Builder().setUri(uri);
                            MediaItem.LocalConfiguration localConfiguration = this.f11099k.getMediaItem().localConfiguration;
                            if (localConfiguration != null) {
                                uri2.setDrmConfiguration(localConfiguration.drmConfiguration);
                            }
                            MediaSource createMediaSource = this.f11100l.createMediaSource(uri2.build());
                            c0008a7.f65d = createMediaSource;
                            c0008a7.f64c = uri;
                            int i3 = 0;
                            while (true) {
                                ArrayList arrayList = c0008a7.f63b;
                                int size = arrayList.size();
                                adsMediaSource = c0008a7.f67f;
                                if (i3 >= size) {
                                    break;
                                }
                                MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) arrayList.get(i3);
                                maskingMediaPeriod.setMediaSource(createMediaSource);
                                maskingMediaPeriod.setPrepareListener(new C0687a(adsMediaSource, uri));
                                i3++;
                            }
                            adsMediaSource.prepareChildSource(c0008a7.f62a, createMediaSource);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    /* renamed from: b */
    public final void m2757b() {
        Timeline timeline;
        Timeline timeline2 = this.f11108t;
        AdPlaybackState adPlaybackState = this.f11109u;
        if (adPlaybackState != null && timeline2 != null) {
            if (adPlaybackState.adGroupCount == 0) {
                refreshSourceInfo(timeline2);
                return;
            }
            long[][] jArr = new long[this.f11110v.length];
            int i = 0;
            while (true) {
                C0008a7[][] c0008a7Arr = this.f11110v;
                if (i < c0008a7Arr.length) {
                    jArr[i] = new long[c0008a7Arr[i].length];
                    int i2 = 0;
                    while (true) {
                        C0008a7[] c0008a7Arr2 = this.f11110v[i];
                        if (i2 < c0008a7Arr2.length) {
                            C0008a7 c0008a7 = c0008a7Arr2[i2];
                            long[] jArr2 = jArr[i];
                            long j = C0643C.TIME_UNSET;
                            if (c0008a7 != null && (timeline = c0008a7.f66e) != null) {
                                j = timeline.getPeriod(0, c0008a7.f67f.f11106r).getDurationUs();
                            }
                            jArr2[i2] = j;
                            i2++;
                        }
                    }
                    i++;
                } else {
                    this.f11109u = adPlaybackState.withAdDurationsUs(jArr);
                    refreshSourceInfo(new SinglePeriodAdTimeline(timeline2, this.f11109u));
                    return;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        if (((AdPlaybackState) Assertions.checkNotNull(this.f11109u)).adGroupCount > 0 && mediaPeriodId.isAd()) {
            int i = mediaPeriodId.adGroupIndex;
            int i2 = mediaPeriodId.adIndexInAdGroup;
            C0008a7[][] c0008a7Arr = this.f11110v;
            C0008a7[] c0008a7Arr2 = c0008a7Arr[i];
            if (c0008a7Arr2.length <= i2) {
                c0008a7Arr[i] = (C0008a7[]) Arrays.copyOf(c0008a7Arr2, i2 + 1);
            }
            C0008a7 c0008a7 = this.f11110v[i][i2];
            if (c0008a7 == null) {
                c0008a7 = new C0008a7(this, mediaPeriodId);
                this.f11110v[i][i2] = c0008a7;
                m2756a();
            }
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
            c0008a7.f63b.add(maskingMediaPeriod);
            MediaSource mediaSource = c0008a7.f65d;
            if (mediaSource != null) {
                maskingMediaPeriod.setMediaSource(mediaSource);
                maskingMediaPeriod.setPrepareListener(new C0687a(c0008a7.f67f, (Uri) Assertions.checkNotNull(c0008a7.f64c)));
            }
            Timeline timeline = c0008a7.f66e;
            if (timeline != null) {
                maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
            }
            return maskingMediaPeriod;
        }
        MaskingMediaPeriod maskingMediaPeriod2 = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
        maskingMediaPeriod2.setMediaSource(this.f11099k);
        maskingMediaPeriod2.createPeriod(mediaPeriodId);
        return maskingMediaPeriod2;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.f11099k.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        C0688b c0688b = new C0688b(this);
        this.f11107s = c0688b;
        prepareChildSource(f11098w, this.f11099k);
        this.f11105q.post(new RunnableC2046z6(this, c0688b, 0));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.f10968id;
        if (mediaPeriodId.isAd()) {
            C0008a7 c0008a7 = (C0008a7) Assertions.checkNotNull(this.f11110v[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
            c0008a7.f63b.remove(maskingMediaPeriod);
            maskingMediaPeriod.releasePeriod();
            if (c0008a7.f63b.isEmpty()) {
                if (c0008a7.f65d != null) {
                    c0008a7.f67f.releaseChildSource(c0008a7.f62a);
                }
                this.f11110v[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup] = null;
                return;
            }
            return;
        }
        maskingMediaPeriod.releasePeriod();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        C0688b c0688b = (C0688b) Assertions.checkNotNull(this.f11107s);
        this.f11107s = null;
        c0688b.f11124b = true;
        c0688b.f11123a.removeCallbacksAndMessages(null);
        this.f11108t = null;
        this.f11109u = null;
        this.f11110v = new C0008a7[0];
        this.f11105q.post(new RunnableC2046z6(this, c0688b, 1));
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline) {
        int i = 0;
        if (mediaPeriodId.isAd()) {
            C0008a7 c0008a7 = (C0008a7) Assertions.checkNotNull(this.f11110v[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
            c0008a7.getClass();
            Assertions.checkArgument(timeline.getPeriodCount() == 1);
            if (c0008a7.f66e == null) {
                Object uidOfPeriod = timeline.getUidOfPeriod(0);
                while (true) {
                    ArrayList arrayList = c0008a7.f63b;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) arrayList.get(i);
                    maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(uidOfPeriod, maskingMediaPeriod.f10968id.windowSequenceNumber));
                    i++;
                }
            }
            c0008a7.f66e = timeline;
        } else {
            Assertions.checkArgument(timeline.getPeriodCount() == 1);
            this.f11108t = timeline;
        }
        m2757b();
    }
}
