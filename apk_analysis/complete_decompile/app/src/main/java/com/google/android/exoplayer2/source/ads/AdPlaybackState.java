package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class AdPlaybackState implements Bundleable {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;

    /* renamed from: a */
    public final AdGroup[] f11097a;
    public final int adGroupCount;
    public final long adResumePositionUs;

    @Nullable
    public final Object adsId;
    public final long contentDurationUs;
    public final int removedAdGroupCount;
    public static final AdPlaybackState NONE = new AdPlaybackState(null, new AdGroup[0], 0, C0643C.TIME_UNSET, 0);

    /* renamed from: b */
    public static final AdGroup f11096b = new AdGroup(0).withAdCount(0);
    public static final Bundleable.Creator<AdPlaybackState> CREATOR = new C1255h3(2);

    /* loaded from: classes.dex */
    public static final class AdGroup implements Bundleable {
        public static final Bundleable.Creator<AdGroup> CREATOR = new C1255h3(3);
        public final long contentResumeOffsetUs;
        public final int count;
        public final long[] durationsUs;
        public final boolean isServerSideInserted;
        public final int[] states;
        public final long timeUs;
        public final Uri[] uris;

        public AdGroup(long j) {
            this(j, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        /* renamed from: a */
        public static long[] m2755a(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C0643C.TIME_UNSET);
            return copyOf;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.timeUs == adGroup.timeUs && this.count == adGroup.count && Arrays.equals(this.uris, adGroup.uris) && Arrays.equals(this.states, adGroup.states) && Arrays.equals(this.durationsUs, adGroup.durationsUs) && this.contentResumeOffsetUs == adGroup.contentResumeOffsetUs && this.isServerSideInserted == adGroup.isServerSideInserted) {
                return true;
            }
            return false;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(@IntRange(from = -1) int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.states;
                if (i3 >= iArr.length || this.isServerSideInserted || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public boolean hasUnplayedAds() {
            if (this.count == -1) {
                return true;
            }
            for (int i = 0; i < this.count; i++) {
                int i2 = this.states[i];
                if (i2 == 0 || i2 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.count * 31;
            long j = this.timeUs;
            int hashCode = (Arrays.hashCode(this.durationsUs) + ((Arrays.hashCode(this.states) + ((((i + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.uris)) * 31)) * 31)) * 31;
            long j2 = this.contentResumeOffsetUs;
            return ((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.isServerSideInserted ? 1 : 0);
        }

        public boolean shouldPlayAdGroup() {
            if (this.count != -1 && getFirstAdIndexToPlay() >= this.count) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(Integer.toString(0, 36), this.timeUs);
            bundle.putInt(Integer.toString(1, 36), this.count);
            bundle.putParcelableArrayList(Integer.toString(2, 36), new ArrayList<>(Arrays.asList(this.uris)));
            bundle.putIntArray(Integer.toString(3, 36), this.states);
            bundle.putLongArray(Integer.toString(4, 36), this.durationsUs);
            bundle.putLong(Integer.toString(5, 36), this.contentResumeOffsetUs);
            bundle.putBoolean(Integer.toString(6, 36), this.isServerSideInserted);
            return bundle;
        }

        @CheckResult
        public AdGroup withAdCount(int i) {
            int[] iArr = this.states;
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            long[] m2755a = m2755a(this.durationsUs, i);
            return new AdGroup(this.timeUs, i, copyOf, (Uri[]) Arrays.copyOf(this.uris, i), m2755a, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAdDurationsUs(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = m2755a(jArr, uriArr.length);
            } else if (this.count != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new AdGroup(this.timeUs, this.count, this.states, this.uris, jArr, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAdState(int i, @IntRange(from = 0) int i2) {
            boolean z;
            int i3 = this.count;
            boolean z2 = false;
            if (i3 != -1 && i2 >= i3) {
                z = false;
            } else {
                z = true;
            }
            Assertions.checkArgument(z);
            int[] iArr = this.states;
            int length = iArr.length;
            int max = Math.max(i2 + 1, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            int i4 = copyOf[i2];
            if (i4 == 0 || i4 == 1 || i4 == i) {
                z2 = true;
            }
            Assertions.checkArgument(z2);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyOf.length) {
                jArr = m2755a(jArr, copyOf.length);
            }
            long[] jArr2 = jArr;
            Uri[] uriArr = this.uris;
            if (uriArr.length != copyOf.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, copyOf.length);
            }
            Uri[] uriArr2 = uriArr;
            copyOf[i2] = i;
            return new AdGroup(this.timeUs, this.count, copyOf, uriArr2, jArr2, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAdUri(Uri uri, @IntRange(from = 0) int i) {
            int[] iArr = this.states;
            int length = iArr.length;
            int max = Math.max(i + 1, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyOf.length) {
                jArr = m2755a(jArr, copyOf.length);
            }
            long[] jArr2 = jArr;
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyOf.length);
            uriArr[i] = uri;
            copyOf[i] = 1;
            return new AdGroup(this.timeUs, this.count, copyOf, uriArr, jArr2, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAllAdsReset() {
            int i;
            if (this.count == -1) {
                return this;
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = copyOf[i2];
                if (i3 == 3 || i3 == 2 || i3 == 4) {
                    if (this.uris[i2] == null) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    copyOf[i2] = i;
                }
            }
            return new AdGroup(this.timeUs, length, copyOf, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(this.timeUs, 0, new int[0], new Uri[0], new long[0], this.contentResumeOffsetUs, this.isServerSideInserted);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                int i2 = copyOf[i];
                if (i2 == 1 || i2 == 0) {
                    copyOf[i] = 2;
                }
            }
            return new AdGroup(this.timeUs, length, copyOf, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withContentResumeOffsetUs(long j) {
            return new AdGroup(this.timeUs, this.count, this.states, this.uris, this.durationsUs, j, this.isServerSideInserted);
        }

        @CheckResult
        public AdGroup withIsServerSideInserted(boolean z) {
            return new AdGroup(this.timeUs, this.count, this.states, this.uris, this.durationsUs, this.contentResumeOffsetUs, z);
        }

        @CheckResult
        public AdGroup withTimeUs(long j) {
            return new AdGroup(j, this.count, this.states, this.uris, this.durationsUs, this.contentResumeOffsetUs, this.isServerSideInserted);
        }

        public AdGroup(long j, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.timeUs = j;
            this.count = i;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
            this.contentResumeOffsetUs = j2;
            this.isServerSideInserted = z;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AdState {
    }

    public AdPlaybackState(Object obj, AdGroup[] adGroupArr, long j, long j2, int i) {
        this.adsId = obj;
        this.adResumePositionUs = j;
        this.contentDurationUs = j2;
        this.adGroupCount = adGroupArr.length + i;
        this.f11097a = adGroupArr;
        this.removedAdGroupCount = i;
    }

    public static AdPlaybackState fromAdPlaybackState(Object obj, AdPlaybackState adPlaybackState) {
        int i = adPlaybackState.adGroupCount - adPlaybackState.removedAdGroupCount;
        AdGroup[] adGroupArr = new AdGroup[i];
        for (int i2 = 0; i2 < i; i2++) {
            AdGroup adGroup = adPlaybackState.f11097a[i2];
            long j = adGroup.timeUs;
            int i3 = adGroup.count;
            int[] iArr = adGroup.states;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            Uri[] uriArr = adGroup.uris;
            Uri[] uriArr2 = (Uri[]) Arrays.copyOf(uriArr, uriArr.length);
            long[] jArr = adGroup.durationsUs;
            adGroupArr[i2] = new AdGroup(j, i3, copyOf, uriArr2, Arrays.copyOf(jArr, jArr.length), adGroup.contentResumeOffsetUs, adGroup.isServerSideInserted);
        }
        return new AdPlaybackState(obj, adGroupArr, adPlaybackState.adResumePositionUs, adPlaybackState.contentDurationUs, adPlaybackState.removedAdGroupCount);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (Util.areEqual(this.adsId, adPlaybackState.adsId) && this.adGroupCount == adPlaybackState.adGroupCount && this.adResumePositionUs == adPlaybackState.adResumePositionUs && this.contentDurationUs == adPlaybackState.contentDurationUs && this.removedAdGroupCount == adPlaybackState.removedAdGroupCount && Arrays.equals(this.f11097a, adPlaybackState.f11097a)) {
            return true;
        }
        return false;
    }

    public AdGroup getAdGroup(@IntRange(from = 0) int i) {
        int i2 = this.removedAdGroupCount;
        if (i < i2) {
            return f11096b;
        }
        return this.f11097a[i - i2];
    }

    public int getAdGroupIndexAfterPositionUs(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != C0643C.TIME_UNSET && j >= j2) {
            return -1;
        }
        int i = this.removedAdGroupCount;
        while (i < this.adGroupCount && ((getAdGroup(i).timeUs != Long.MIN_VALUE && getAdGroup(i).timeUs <= j) || !getAdGroup(i).shouldPlayAdGroup())) {
            i++;
        }
        if (i >= this.adGroupCount) {
            return -1;
        }
        return i;
    }

    public int getAdGroupIndexForPositionUs(long j, long j2) {
        int i = this.adGroupCount - 1;
        while (i >= 0 && j != Long.MIN_VALUE) {
            long j3 = getAdGroup(i).timeUs;
            if (j3 == Long.MIN_VALUE) {
                if (j2 != C0643C.TIME_UNSET && j >= j2) {
                    break;
                }
                i--;
            } else {
                if (j >= j3) {
                    break;
                }
                i--;
            }
        }
        if (i < 0 || !getAdGroup(i).hasUnplayedAds()) {
            return -1;
        }
        return i;
    }

    public int hashCode() {
        int hashCode;
        int i = this.adGroupCount * 31;
        Object obj = this.adsId;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return ((((((((i + hashCode) * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + this.removedAdGroupCount) * 31) + Arrays.hashCode(this.f11097a);
    }

    public boolean isAdInErrorState(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        AdGroup adGroup;
        int i3;
        if (i >= this.adGroupCount || (i3 = (adGroup = getAdGroup(i)).count) == -1 || i2 >= i3 || adGroup.states[i2] != 4) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (AdGroup adGroup : this.f11097a) {
            arrayList.add(adGroup.toBundle());
        }
        bundle.putParcelableArrayList(Integer.toString(1, 36), arrayList);
        bundle.putLong(Integer.toString(2, 36), this.adResumePositionUs);
        bundle.putLong(Integer.toString(3, 36), this.contentDurationUs);
        bundle.putInt(Integer.toString(4, 36), this.removedAdGroupCount);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=");
        sb.append(this.adsId);
        sb.append(", adResumePositionUs=");
        sb.append(this.adResumePositionUs);
        sb.append(", adGroups=[");
        int i = 0;
        while (true) {
            AdGroup[] adGroupArr = this.f11097a;
            if (i < adGroupArr.length) {
                sb.append("adGroup(timeUs=");
                sb.append(adGroupArr[i].timeUs);
                sb.append(", ads=[");
                for (int i2 = 0; i2 < adGroupArr[i].states.length; i2++) {
                    sb.append("ad(state=");
                    int i3 = adGroupArr[i].states[i2];
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        sb.append('?');
                                    } else {
                                        sb.append('!');
                                    }
                                } else {
                                    sb.append('P');
                                }
                            } else {
                                sb.append('S');
                            }
                        } else {
                            sb.append('R');
                        }
                    } else {
                        sb.append('_');
                    }
                    sb.append(", durationUs=");
                    sb.append(adGroupArr[i].durationsUs[i2]);
                    sb.append(')');
                    if (i2 < adGroupArr[i].states.length - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("])");
                if (i < adGroupArr.length - 1) {
                    sb.append(", ");
                }
                i++;
            } else {
                sb.append("])");
                return sb.toString();
            }
        }
    }

    @CheckResult
    public AdPlaybackState withAdCount(@IntRange(from = 0) int i, @IntRange(from = 1) int i2) {
        boolean z;
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int i3 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        if (adGroupArr[i3].count == i2) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr[i3].withAdCount(i2);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        Assertions.checkState(this.removedAdGroupCount == 0);
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        for (int i = 0; i < this.adGroupCount; i++) {
            adGroupArr2[i] = adGroupArr2[i].withAdDurationsUs(jArr[i]);
        }
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdGroupTimeUs(@IntRange(from = 0) int i, long j) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i2] = adGroupArr[i2].withTimeUs(j);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdLoadError(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdState(4, i2);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdResumePositionUs(long j) {
        if (this.adResumePositionUs == j) {
            return this;
        }
        return new AdPlaybackState(this.adsId, this.f11097a, j, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdUri(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, Uri uri) {
        int i3 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdUri(uri, i2);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withContentDurationUs(long j) {
        if (this.contentDurationUs == j) {
            return this;
        }
        return new AdPlaybackState(this.adsId, this.f11097a, this.adResumePositionUs, j, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withContentResumeOffsetUs(@IntRange(from = 0) int i, long j) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        if (adGroupArr[i2].contentResumeOffsetUs == j) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i2] = adGroupArr2[i2].withContentResumeOffsetUs(j);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withIsServerSideInserted(@IntRange(from = 0) int i, boolean z) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        if (adGroupArr[i2].isServerSideInserted == z) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i2] = adGroupArr2[i2].withIsServerSideInserted(z);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withNewAdGroup(@IntRange(from = 0) int i, long j) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup adGroup = new AdGroup(j);
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayAppend(adGroupArr, adGroup);
        System.arraycopy(adGroupArr2, i2, adGroupArr2, i2 + 1, adGroupArr.length - i2);
        adGroupArr2[i2] = adGroup;
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withPlayedAd(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdState(3, i2);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withRemovedAdGroupCount(@IntRange(from = 0) int i) {
        boolean z;
        int i2 = this.removedAdGroupCount;
        if (i2 == i) {
            return this;
        }
        if (i > i2) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int i3 = this.adGroupCount - i;
        AdGroup[] adGroupArr = new AdGroup[i3];
        System.arraycopy(this.f11097a, i - this.removedAdGroupCount, adGroupArr, 0, i3);
        return new AdPlaybackState(this.adsId, adGroupArr, this.adResumePositionUs, this.contentDurationUs, i);
    }

    @CheckResult
    public AdPlaybackState withResetAdGroup(@IntRange(from = 0) int i) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i2] = adGroupArr2[i2].withAllAdsReset();
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withSkippedAd(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdState(2, i2);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withSkippedAdGroup(@IntRange(from = 0) int i) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i2] = adGroupArr2[i2].withAllAdsSkipped();
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(@IntRange(from = 0) int i, long... jArr) {
        int i2 = i - this.removedAdGroupCount;
        AdGroup[] adGroupArr = this.f11097a;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i2] = adGroupArr2[i2].withAdDurationsUs(jArr);
        return new AdPlaybackState(this.adsId, adGroupArr2, this.adResumePositionUs, this.contentDurationUs, this.removedAdGroupCount);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdPlaybackState(Object obj, long... jArr) {
        this(obj, r3, 0L, C0643C.TIME_UNSET, 0);
        int length = jArr.length;
        AdGroup[] adGroupArr = new AdGroup[length];
        for (int i = 0; i < length; i++) {
            adGroupArr[i] = new AdGroup(jArr[i]);
        }
    }
}
