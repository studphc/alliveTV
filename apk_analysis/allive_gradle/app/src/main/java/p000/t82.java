package p000;

import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.Interpolator;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.HeartRating;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PercentageRating;
import com.google.android.exoplayer2.StarRating;
import com.google.android.exoplayer2.ThumbRating;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleUtil;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class t82 implements Bundleable.Creator, Consumer, Interpolator, ExtractorsFactory {

    /* renamed from: a */
    public final /* synthetic */ int f26720a;

    public /* synthetic */ t82(int i) {
        this.f26720a = i;
    }

    @Override // com.google.android.exoplayer2.util.Consumer
    public void accept(Object obj) {
        ((de2) obj).f16353b.release();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        int i = this.f26720a;
        return zb0.m8410a(this, uri, map);
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public Bundleable fromBundle(Bundle bundle) {
        boolean z;
        AdPlaybackState adPlaybackState;
        MediaItem mediaItem;
        ImmutableList fromBundleList;
        ImmutableList fromBundleList2;
        boolean z2 = false;
        switch (this.f26720a) {
            case 0:
                int i = bundle.getInt(Integer.toString(0, 36), -1);
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                return ThumbRating.CREATOR.fromBundle(bundle);
                            }
                            throw new IllegalArgumentException(ye0.m8291k(i, "Unknown RatingType: "));
                        }
                        return StarRating.CREATOR.fromBundle(bundle);
                    }
                    return PercentageRating.CREATOR.fromBundle(bundle);
                }
                return HeartRating.CREATOR.fromBundle(bundle);
            case 1:
            default:
                VideoSize videoSize = VideoSize.UNKNOWN;
                return new VideoSize(bundle.getInt(Integer.toString(0, 36), 0), bundle.getInt(Integer.toString(1, 36), 0), bundle.getInt(Integer.toString(2, 36), 0), bundle.getFloat(Integer.toString(3, 36), 1.0f));
            case 2:
                if (bundle.getInt(Integer.toString(0, 36), -1) == 2) {
                    z2 = true;
                }
                Assertions.checkArgument(z2);
                int i2 = bundle.getInt(Integer.toString(1, 36), 5);
                float f = bundle.getFloat(Integer.toString(2, 36), -1.0f);
                if (f == -1.0f) {
                    return new StarRating(i2);
                }
                return new StarRating(i2, f);
            case 3:
                if (bundle.getInt(Integer.toString(0, 36), -1) == 3) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z);
                if (bundle.getBoolean(Integer.toString(1, 36), false)) {
                    return new ThumbRating(bundle.getBoolean(Integer.toString(2, 36), false));
                }
                return new ThumbRating();
            case 4:
                Timeline timeline = Timeline.EMPTY;
                ImmutableList m2418a = Timeline.m2418a(Timeline.Window.CREATOR, BundleUtil.getBinder(bundle, Integer.toString(0, 36)));
                ImmutableList m2418a2 = Timeline.m2418a(Timeline.Period.CREATOR, BundleUtil.getBinder(bundle, Integer.toString(1, 36)));
                int[] intArray = bundle.getIntArray(Integer.toString(2, 36));
                if (intArray == null) {
                    int size = m2418a.size();
                    int[] iArr = new int[size];
                    for (int i3 = 0; i3 < size; i3++) {
                        iArr[i3] = i3;
                    }
                    intArray = iArr;
                }
                return new Timeline.RemotableTimeline(m2418a, m2418a2, intArray);
            case 5:
                int i4 = bundle.getInt(Integer.toString(0, 36), 0);
                long j = bundle.getLong(Integer.toString(1, 36), C0643C.TIME_UNSET);
                long j2 = bundle.getLong(Integer.toString(2, 36), 0L);
                boolean z3 = bundle.getBoolean(Integer.toString(3, 36));
                Bundle bundle2 = bundle.getBundle(Integer.toString(4, 36));
                if (bundle2 != null) {
                    adPlaybackState = AdPlaybackState.CREATOR.fromBundle(bundle2);
                } else {
                    adPlaybackState = AdPlaybackState.NONE;
                }
                AdPlaybackState adPlaybackState2 = adPlaybackState;
                Timeline.Period period = new Timeline.Period();
                period.set(null, null, i4, j, j2, adPlaybackState2, z3);
                return period;
            case 6:
                Object obj = Timeline.Window.SINGLE_WINDOW_UID;
                Bundle bundle3 = bundle.getBundle(Integer.toString(1, 36));
                MediaItem.LiveConfiguration liveConfiguration = null;
                if (bundle3 != null) {
                    mediaItem = MediaItem.CREATOR.fromBundle(bundle3);
                } else {
                    mediaItem = null;
                }
                long j3 = bundle.getLong(Integer.toString(2, 36), C0643C.TIME_UNSET);
                long j4 = bundle.getLong(Integer.toString(3, 36), C0643C.TIME_UNSET);
                long j5 = bundle.getLong(Integer.toString(4, 36), C0643C.TIME_UNSET);
                boolean z4 = bundle.getBoolean(Integer.toString(5, 36), false);
                boolean z5 = bundle.getBoolean(Integer.toString(6, 36), false);
                Bundle bundle4 = bundle.getBundle(Integer.toString(7, 36));
                if (bundle4 != null) {
                    liveConfiguration = MediaItem.LiveConfiguration.CREATOR.fromBundle(bundle4);
                }
                boolean z6 = bundle.getBoolean(Integer.toString(8, 36), false);
                long j6 = bundle.getLong(Integer.toString(9, 36), 0L);
                long j7 = bundle.getLong(Integer.toString(10, 36), C0643C.TIME_UNSET);
                int i5 = bundle.getInt(Integer.toString(11, 36), 0);
                int i6 = bundle.getInt(Integer.toString(12, 36), 0);
                long j8 = bundle.getLong(Integer.toString(13, 36), 0L);
                Timeline.Window window = new Timeline.Window();
                window.set(Timeline.Window.f9502a, mediaItem, null, j3, j4, j5, z4, z5, liveConfiguration, j6, j7, i5, i6, j8);
                window.isPlaceholder = z6;
                return window;
            case 7:
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
                if (parcelableArrayList == null) {
                    fromBundleList = ImmutableList.m3902of();
                } else {
                    fromBundleList = BundleableUtil.fromBundleList(Format.CREATOR, parcelableArrayList);
                }
                return new TrackGroup(bundle.getString(Integer.toString(1, 36), ""), (Format[]) fromBundleList.toArray(new Format[0]));
            case 8:
                TrackGroupArray trackGroupArray = TrackGroupArray.EMPTY;
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(Integer.toString(0, 36));
                if (parcelableArrayList2 == null) {
                    return new TrackGroupArray(new TrackGroup[0]);
                }
                return new TrackGroupArray((TrackGroup[]) BundleableUtil.fromBundleList(TrackGroup.CREATOR, parcelableArrayList2).toArray(new TrackGroup[0]));
            case 9:
                return new TrackSelectionOverride(TrackGroup.CREATOR.fromBundle((Bundle) Assertions.checkNotNull(bundle.getBundle(Integer.toString(0, 36)))), Ints.asList((int[]) Assertions.checkNotNull(bundle.getIntArray(Integer.toString(1, 36)))));
            case 10:
                return TrackSelectionParameters.fromBundle(bundle);
            case 11:
                Tracks tracks = Tracks.EMPTY;
                ArrayList parcelableArrayList3 = bundle.getParcelableArrayList(Integer.toString(0, 36));
                if (parcelableArrayList3 == null) {
                    fromBundleList2 = ImmutableList.m3902of();
                } else {
                    fromBundleList2 = BundleableUtil.fromBundleList(Tracks.Group.CREATOR, parcelableArrayList3);
                }
                return new Tracks(fromBundleList2);
            case 12:
                TrackGroup fromBundle = TrackGroup.CREATOR.fromBundle((Bundle) Assertions.checkNotNull(bundle.getBundle(Integer.toString(0, 36))));
                return new Tracks.Group(fromBundle, bundle.getBoolean(Integer.toString(4, 36), false), (int[]) MoreObjects.firstNonNull(bundle.getIntArray(Integer.toString(1, 36)), new int[fromBundle.length]), (boolean[]) MoreObjects.firstNonNull(bundle.getBooleanArray(Integer.toString(3, 36)), new boolean[fromBundle.length]));
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        switch (this.f26720a) {
            case 13:
                return (float) Easing.getInterpolator("standard").get(f);
            case 14:
                return (float) Easing.getInterpolator("accelerate").get(f);
            case 15:
                return (float) Easing.getInterpolator("decelerate").get(f);
            case 16:
                return (float) Easing.getInterpolator("linear").get(f);
            case 17:
                return (float) Easing.getInterpolator("anticipate").get(f);
            case 18:
                return (float) Easing.getInterpolator("overshoot").get(f);
            default:
                return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(f);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        switch (this.f26720a) {
            case 20:
                return new Extractor[]{new TsExtractor()};
            default:
                return new Extractor[]{new WavExtractor()};
        }
    }
}
