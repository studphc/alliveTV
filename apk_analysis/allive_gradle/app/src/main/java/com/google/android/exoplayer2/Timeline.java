package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.InlineMe;
import java.util.ArrayList;
import p000.t82;

/* loaded from: classes.dex */
public abstract class Timeline implements Bundleable {
    public static final Timeline EMPTY = new Timeline();
    public static final Bundleable.Creator<Timeline> CREATOR = new t82(4);

    /* loaded from: classes.dex */
    public static final class Period implements Bundleable {
        public static final Bundleable.Creator<Period> CREATOR = new t82(5);

        /* renamed from: a */
        public AdPlaybackState f9496a = AdPlaybackState.NONE;
        public long durationUs;

        /* renamed from: id */
        @Nullable
        public Object f9497id;
        public boolean isPlaceholder;
        public long positionInWindowUs;

        @Nullable
        public Object uid;
        public int windowIndex;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            if (Util.areEqual(this.f9497id, period.f9497id) && Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.positionInWindowUs == period.positionInWindowUs && this.isPlaceholder == period.isPlaceholder && Util.areEqual(this.f9496a, period.f9496a)) {
                return true;
            }
            return false;
        }

        public int getAdCountInAdGroup(int i) {
            return this.f9496a.getAdGroup(i).count;
        }

        public long getAdDurationUs(int i, int i2) {
            AdPlaybackState.AdGroup adGroup = this.f9496a.getAdGroup(i);
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i2];
            }
            return C0643C.TIME_UNSET;
        }

        public int getAdGroupCount() {
            return this.f9496a.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long j) {
            return this.f9496a.getAdGroupIndexAfterPositionUs(j, this.durationUs);
        }

        public int getAdGroupIndexForPositionUs(long j) {
            return this.f9496a.getAdGroupIndexForPositionUs(j, this.durationUs);
        }

        public long getAdGroupTimeUs(int i) {
            return this.f9496a.getAdGroup(i).timeUs;
        }

        public long getAdResumePositionUs() {
            return this.f9496a.adResumePositionUs;
        }

        public int getAdState(int i, int i2) {
            AdPlaybackState.AdGroup adGroup = this.f9496a.getAdGroup(i);
            if (adGroup.count != -1) {
                return adGroup.states[i2];
            }
            return 0;
        }

        @Nullable
        public Object getAdsId() {
            return this.f9496a.adsId;
        }

        public long getContentResumeOffsetUs(int i) {
            return this.f9496a.getAdGroup(i).contentResumeOffsetUs;
        }

        public long getDurationMs() {
            return Util.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int i) {
            return this.f9496a.getAdGroup(i).getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i, int i2) {
            return this.f9496a.getAdGroup(i).getNextAdIndexToPlay(i2);
        }

        public long getPositionInWindowMs() {
            return Util.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public int getRemovedAdGroupCount() {
            return this.f9496a.removedAdGroupCount;
        }

        public boolean hasPlayedAdGroup(int i) {
            return !this.f9496a.getAdGroup(i).hasUnplayedAds();
        }

        public int hashCode() {
            int hashCode;
            Object obj = this.f9497id;
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            int i2 = (217 + hashCode) * 31;
            Object obj2 = this.uid;
            if (obj2 != null) {
                i = obj2.hashCode();
            }
            int i3 = (((i2 + i) * 31) + this.windowIndex) * 31;
            long j = this.durationUs;
            int i4 = (i3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.positionInWindowUs;
            return this.f9496a.hashCode() + ((((i4 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31);
        }

        public boolean isServerSideInsertedAdGroup(int i) {
            return this.f9496a.getAdGroup(i).isServerSideInserted;
        }

        public Period set(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2) {
            return set(obj, obj2, i, j, j2, AdPlaybackState.NONE, false);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(Integer.toString(0, 36), this.windowIndex);
            bundle.putLong(Integer.toString(1, 36), this.durationUs);
            bundle.putLong(Integer.toString(2, 36), this.positionInWindowUs);
            bundle.putBoolean(Integer.toString(3, 36), this.isPlaceholder);
            bundle.putBundle(Integer.toString(4, 36), this.f9496a.toBundle());
            return bundle;
        }

        public Period set(@Nullable Object obj, @Nullable Object obj2, int i, long j, long j2, AdPlaybackState adPlaybackState, boolean z) {
            this.f9497id = obj;
            this.uid = obj2;
            this.windowIndex = i;
            this.durationUs = j;
            this.positionInWindowUs = j2;
            this.f9496a = adPlaybackState;
            this.isPlaceholder = z;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class RemotableTimeline extends Timeline {

        /* renamed from: a */
        public final ImmutableList f9498a;

        /* renamed from: b */
        public final ImmutableList f9499b;

        /* renamed from: c */
        public final int[] f9500c;

        /* renamed from: d */
        public final int[] f9501d;

        public RemotableTimeline(ImmutableList<Window> immutableList, ImmutableList<Period> immutableList2, int[] iArr) {
            boolean z;
            if (immutableList.size() == iArr.length) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.f9498a = immutableList;
            this.f9499b = immutableList2;
            this.f9500c = iArr;
            this.f9501d = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.f9501d[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getFirstWindowIndex(boolean z) {
            if (isEmpty()) {
                return -1;
            }
            if (!z) {
                return 0;
            }
            return this.f9500c[0];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getLastWindowIndex(boolean z) {
            if (isEmpty()) {
                return -1;
            }
            if (z) {
                return this.f9500c[getWindowCount() - 1];
            }
            return getWindowCount() - 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getNextWindowIndex(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i == getLastWindowIndex(z)) {
                if (i2 == 2) {
                    return getFirstWindowIndex(z);
                }
                return -1;
            }
            if (z) {
                return this.f9500c[this.f9501d[i] + 1];
            }
            return i + 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.Timeline
        public Period getPeriod(int i, Period period, boolean z) {
            Period period2 = (Period) this.f9499b.get(i);
            period.set(period2.f9497id, period2.uid, period2.windowIndex, period2.durationUs, period2.positionInWindowUs, period2.f9496a, period2.isPlaceholder);
            return period;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.f9499b.size();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPreviousWindowIndex(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i == getFirstWindowIndex(z)) {
                if (i2 == 2) {
                    return getLastWindowIndex(z);
                }
                return -1;
            }
            if (z) {
                return this.f9500c[this.f9501d[i] - 1];
            }
            return i - 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.Timeline
        public Window getWindow(int i, Window window, long j) {
            Window window2 = (Window) this.f9498a.get(i);
            window.set(window2.uid, window2.mediaItem, window2.manifest, window2.presentationStartTimeMs, window2.windowStartTimeMs, window2.elapsedRealtimeEpochOffsetMs, window2.isSeekable, window2.isDynamic, window2.liveConfiguration, window2.defaultPositionUs, window2.durationUs, window2.firstPeriodIndex, window2.lastPeriodIndex, window2.positionInFirstPeriodUs);
            window.isPlaceholder = window2.isPlaceholder;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.f9498a.size();
        }
    }

    /* loaded from: classes.dex */
    public static final class Window implements Bundleable {
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;

        @Deprecated
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;

        @Nullable
        public MediaItem.LiveConfiguration liveConfiguration;

        @Nullable
        public Object manifest;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;

        @Nullable
        @Deprecated
        public Object tag;
        public long windowStartTimeMs;
        public static final Object SINGLE_WINDOW_UID = new Object();

        /* renamed from: a */
        public static final Object f9502a = new Object();

        /* renamed from: b */
        public static final MediaItem f9503b = new MediaItem.Builder().setMediaId("com.google.android.exoplayer2.Timeline").setUri(Uri.EMPTY).build();
        public static final Bundleable.Creator<Window> CREATOR = new t82(6);
        public Object uid = SINGLE_WINDOW_UID;
        public MediaItem mediaItem = f9503b;

        /* renamed from: a */
        public final Bundle m2419a(boolean z) {
            MediaItem mediaItem;
            Bundle bundle = new Bundle();
            String num = Integer.toString(1, 36);
            if (z) {
                mediaItem = MediaItem.EMPTY;
            } else {
                mediaItem = this.mediaItem;
            }
            bundle.putBundle(num, mediaItem.toBundle());
            bundle.putLong(Integer.toString(2, 36), this.presentationStartTimeMs);
            bundle.putLong(Integer.toString(3, 36), this.windowStartTimeMs);
            bundle.putLong(Integer.toString(4, 36), this.elapsedRealtimeEpochOffsetMs);
            bundle.putBoolean(Integer.toString(5, 36), this.isSeekable);
            bundle.putBoolean(Integer.toString(6, 36), this.isDynamic);
            MediaItem.LiveConfiguration liveConfiguration = this.liveConfiguration;
            if (liveConfiguration != null) {
                bundle.putBundle(Integer.toString(7, 36), liveConfiguration.toBundle());
            }
            bundle.putBoolean(Integer.toString(8, 36), this.isPlaceholder);
            bundle.putLong(Integer.toString(9, 36), this.defaultPositionUs);
            bundle.putLong(Integer.toString(10, 36), this.durationUs);
            bundle.putInt(Integer.toString(11, 36), this.firstPeriodIndex);
            bundle.putInt(Integer.toString(12, 36), this.lastPeriodIndex);
            bundle.putLong(Integer.toString(13, 36), this.positionInFirstPeriodUs);
            return bundle;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            if (Util.areEqual(this.uid, window.uid) && Util.areEqual(this.mediaItem, window.mediaItem) && Util.areEqual(this.manifest, window.manifest) && Util.areEqual(this.liveConfiguration, window.liveConfiguration) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs) {
                return true;
            }
            return false;
        }

        public long getCurrentUnixTimeMs() {
            return Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
        }

        public long getDefaultPositionMs() {
            return Util.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return Util.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return Util.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = (this.mediaItem.hashCode() + ((this.uid.hashCode() + 217) * 31)) * 31;
            Object obj = this.manifest;
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            int i2 = (hashCode2 + hashCode) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.liveConfiguration;
            if (liveConfiguration != null) {
                i = liveConfiguration.hashCode();
            }
            int i3 = (i2 + i) * 31;
            long j = this.presentationStartTimeMs;
            int i4 = (i3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.windowStartTimeMs;
            int i5 = (i4 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.elapsedRealtimeEpochOffsetMs;
            int i6 = (((((((i5 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31;
            long j4 = this.defaultPositionUs;
            int i7 = (i6 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.durationUs;
            int i8 = (((((i7 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31;
            long j6 = this.positionInFirstPeriodUs;
            return i8 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public boolean isLive() {
            boolean z;
            boolean z2;
            boolean z3 = this.isLive;
            if (this.liveConfiguration != null) {
                z = true;
            } else {
                z = false;
            }
            if (z3 == z) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            if (this.liveConfiguration == null) {
                return false;
            }
            return true;
        }

        public Window set(Object obj, @Nullable MediaItem mediaItem, @Nullable Object obj2, long j, long j2, long j3, boolean z, boolean z2, @Nullable MediaItem.LiveConfiguration liveConfiguration, long j4, long j5, int i, int i2, long j6) {
            MediaItem mediaItem2;
            Object obj3;
            boolean z3;
            MediaItem.LocalConfiguration localConfiguration;
            this.uid = obj;
            if (mediaItem != null) {
                mediaItem2 = mediaItem;
            } else {
                mediaItem2 = f9503b;
            }
            this.mediaItem = mediaItem2;
            if (mediaItem != null && (localConfiguration = mediaItem.localConfiguration) != null) {
                obj3 = localConfiguration.tag;
            } else {
                obj3 = null;
            }
            this.tag = obj3;
            this.manifest = obj2;
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.elapsedRealtimeEpochOffsetMs = j3;
            this.isSeekable = z;
            this.isDynamic = z2;
            if (liveConfiguration != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.isLive = z3;
            this.liveConfiguration = liveConfiguration;
            this.defaultPositionUs = j4;
            this.durationUs = j5;
            this.firstPeriodIndex = i;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j6;
            this.isPlaceholder = false;
            return this;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            return m2419a(false);
        }
    }

    /* renamed from: a */
    public static ImmutableList m2418a(Bundleable.Creator creator, IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.m3902of();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Bundle> list = BundleListRetriever.getList(iBinder);
        for (int i = 0; i < list.size(); i++) {
            builder.add((ImmutableList.Builder) creator.fromBundle(list.get(i)));
        }
        return builder.build();
    }

    public boolean equals(@Nullable Object obj) {
        int lastWindowIndex;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i = 0; i < getWindowCount(); i++) {
            if (!getWindow(i, window).equals(timeline.getWindow(i, window2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            if (!getPeriod(i2, period, true).equals(timeline.getPeriod(i2, period2, true))) {
                return false;
            }
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        if (firstWindowIndex != timeline.getFirstWindowIndex(true) || (lastWindowIndex = getLastWindowIndex(true)) != timeline.getLastWindowIndex(true)) {
            return false;
        }
        while (firstWindowIndex != lastWindowIndex) {
            int nextWindowIndex = getNextWindowIndex(firstWindowIndex, 0, true);
            if (nextWindowIndex != timeline.getNextWindowIndex(firstWindowIndex, 0, true)) {
                return false;
            }
            firstWindowIndex = nextWindowIndex;
        }
        return true;
    }

    public int getFirstWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i, Period period, Window window, int i2, boolean z) {
        int i3 = getPeriod(i, period).windowIndex;
        if (getWindow(i3, window).lastPeriodIndex == i) {
            int nextWindowIndex = getNextWindowIndex(i3, i2, z);
            if (nextWindowIndex == -1) {
                return -1;
            }
            return getWindow(nextWindowIndex, window).firstPeriodIndex;
        }
        return i + 1;
    }

    public int getNextWindowIndex(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == getLastWindowIndex(z)) {
                        return getFirstWindowIndex(z);
                    }
                    return i + 1;
                }
                throw new IllegalStateException();
            }
            return i;
        }
        if (i == getLastWindowIndex(z)) {
            return -1;
        }
        return i + 1;
    }

    public final Period getPeriod(int i, Period period) {
        return getPeriod(i, period, false);
    }

    public abstract Period getPeriod(int i, Period period, boolean z);

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public abstract int getPeriodCount();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @Deprecated
    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i, long j) {
        return getPeriodPositionUs(window, period, i, j);
    }

    public final Pair<Object, Long> getPeriodPositionUs(Window window, Period period, int i, long j) {
        return (Pair) Assertions.checkNotNull(getPeriodPositionUs(window, period, i, j, 0L));
    }

    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == getFirstWindowIndex(z)) {
                        return getLastWindowIndex(z);
                    }
                    return i - 1;
                }
                throw new IllegalStateException();
            }
            return i;
        }
        if (i == getFirstWindowIndex(z)) {
            return -1;
        }
        return i - 1;
    }

    public abstract Object getUidOfPeriod(int i);

    public final Window getWindow(int i, Window window) {
        return getWindow(i, window, 0L);
    }

    public abstract Window getWindow(int i, Window window, long j);

    public abstract int getWindowCount();

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = getWindowCount() + 217;
        for (int i = 0; i < getWindowCount(); i++) {
            windowCount = (windowCount * 31) + getWindow(i, window).hashCode();
        }
        int periodCount = getPeriodCount() + (windowCount * 31);
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            periodCount = (periodCount * 31) + getPeriod(i2, period, true).hashCode();
        }
        int firstWindowIndex = getFirstWindowIndex(true);
        while (firstWindowIndex != -1) {
            periodCount = (periodCount * 31) + firstWindowIndex;
            firstWindowIndex = getNextWindowIndex(firstWindowIndex, 0, true);
        }
        return periodCount;
    }

    public final boolean isEmpty() {
        if (getWindowCount() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isLastPeriod(int i, Period period, Window window, int i2, boolean z) {
        if (getNextPeriodIndex(i, period, window, i2, z) == -1) {
            return true;
        }
        return false;
    }

    public final Bundle toBundle(boolean z) {
        ArrayList arrayList = new ArrayList();
        int windowCount = getWindowCount();
        Window window = new Window();
        for (int i = 0; i < windowCount; i++) {
            arrayList.add(getWindow(i, window, 0L).m2419a(z));
        }
        ArrayList arrayList2 = new ArrayList();
        int periodCount = getPeriodCount();
        Period period = new Period();
        for (int i2 = 0; i2 < periodCount; i2++) {
            arrayList2.add(getPeriod(i2, period, false).toBundle());
        }
        int[] iArr = new int[windowCount];
        if (windowCount > 0) {
            iArr[0] = getFirstWindowIndex(true);
        }
        for (int i3 = 1; i3 < windowCount; i3++) {
            iArr[i3] = getNextWindowIndex(iArr[i3 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        BundleUtil.putBinder(bundle, Integer.toString(0, 36), new BundleListRetriever(arrayList));
        BundleUtil.putBinder(bundle, Integer.toString(1, 36), new BundleListRetriever(arrayList2));
        bundle.putIntArray(Integer.toString(2, 36), iArr);
        return bundle;
    }

    @Nullable
    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @Deprecated
    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i, long j, long j2) {
        return getPeriodPositionUs(window, period, i, j, j2);
    }

    @Nullable
    public final Pair<Object, Long> getPeriodPositionUs(Window window, Period period, int i, long j, long j2) {
        Assertions.checkIndex(i, 0, getWindowCount());
        getWindow(i, window, j2);
        if (j == C0643C.TIME_UNSET) {
            j = window.getDefaultPositionUs();
            if (j == C0643C.TIME_UNSET) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        getPeriod(i2, period);
        while (i2 < window.lastPeriodIndex && period.positionInWindowUs != j) {
            int i3 = i2 + 1;
            if (getPeriod(i3, period).positionInWindowUs > j) {
                break;
            }
            i2 = i3;
        }
        getPeriod(i2, period, true);
        long j3 = j - period.positionInWindowUs;
        long j4 = period.durationUs;
        if (j4 != C0643C.TIME_UNSET) {
            j3 = Math.min(j3, j4 - 1);
        }
        return Pair.create(Assertions.checkNotNull(period.uid), Long.valueOf(Math.max(0L, j3)));
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public final Bundle toBundle() {
        return toBundle(false);
    }
}
