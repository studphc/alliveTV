package p000;

import android.media.Rating;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class v82 {
    @DoNotInline
    /* renamed from: a */
    public static float m7812a(Rating rating) {
        return rating.getPercentRating();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m7813b(Rating rating) {
        return rating.getRatingStyle();
    }

    @DoNotInline
    /* renamed from: c */
    public static float m7814c(Rating rating) {
        return rating.getStarRating();
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m7815d(Rating rating) {
        return rating.hasHeart();
    }

    @DoNotInline
    /* renamed from: e */
    public static boolean m7816e(Rating rating) {
        return rating.isRated();
    }

    @DoNotInline
    /* renamed from: f */
    public static boolean m7817f(Rating rating) {
        return rating.isThumbUp();
    }

    @DoNotInline
    /* renamed from: g */
    public static Rating m7818g(boolean z) {
        return Rating.newHeartRating(z);
    }

    @DoNotInline
    /* renamed from: h */
    public static Rating m7819h(float f) {
        return Rating.newPercentageRating(f);
    }

    @DoNotInline
    /* renamed from: i */
    public static Rating m7820i(int i, float f) {
        return Rating.newStarRating(i, f);
    }

    @DoNotInline
    /* renamed from: j */
    public static Rating m7821j(boolean z) {
        return Rating.newThumbRating(z);
    }

    @DoNotInline
    /* renamed from: k */
    public static Rating m7822k(int i) {
        return Rating.newUnratedRating(i);
    }
}
