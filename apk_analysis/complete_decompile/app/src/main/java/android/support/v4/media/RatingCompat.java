package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.u82;
import p000.v82;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new u82(0);
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;

    /* renamed from: a */
    public final int f317a;

    /* renamed from: b */
    public final float f318b;

    /* renamed from: c */
    public Object f319c;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Style {
    }

    public RatingCompat(int i, float f) {
        this.f317a = i;
        this.f318b = f;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int m7813b = v82.m7813b(rating);
            if (v82.m7816e(rating)) {
                switch (m7813b) {
                    case 1:
                        ratingCompat = newHeartRating(v82.m7815d(rating));
                        break;
                    case 2:
                        ratingCompat = newThumbRating(v82.m7817f(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(m7813b, v82.m7814c(rating));
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(v82.m7812a(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = newUnratedRating(m7813b);
            }
            ratingCompat.f319c = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z) {
        float f;
        if (z) {
            f = 1.0f;
        } else {
            f = RecyclerView.f7068F0;
        }
        return new RatingCompat(1, f);
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f >= RecyclerView.f7068F0 && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                    return null;
                }
                f2 = 5.0f;
            } else {
                f2 = 4.0f;
            }
        } else {
            f2 = 3.0f;
        }
        if (f >= RecyclerView.f7068F0 && f <= f2) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newThumbRating(boolean z) {
        float f;
        if (z) {
            f = 1.0f;
        } else {
            f = RecyclerView.f7068F0;
        }
        return new RatingCompat(2, f);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f317a;
    }

    public float getPercentRating() {
        if (this.f317a == 6 && isRated()) {
            return this.f318b;
        }
        return -1.0f;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    public Object getRating() {
        if (this.f319c == null) {
            boolean isRated = isRated();
            int i = this.f317a;
            if (isRated) {
                switch (i) {
                    case 1:
                        this.f319c = v82.m7818g(hasHeart());
                        break;
                    case 2:
                        this.f319c = v82.m7821j(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.f319c = v82.m7820i(i, getStarRating());
                        break;
                    case 6:
                        this.f319c = v82.m7819h(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.f319c = v82.m7822k(i);
            }
        }
        return this.f319c;
    }

    public int getRatingStyle() {
        return this.f317a;
    }

    public float getStarRating() {
        int i = this.f317a;
        if ((i == 3 || i == 4 || i == 5) && isRated()) {
            return this.f318b;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        if (this.f317a != 1 || this.f318b != 1.0f) {
            return false;
        }
        return true;
    }

    public boolean isRated() {
        if (this.f318b >= RecyclerView.f7068F0) {
            return true;
        }
        return false;
    }

    public boolean isThumbUp() {
        if (this.f317a != 2 || this.f318b != 1.0f) {
            return false;
        }
        return true;
    }

    public String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f317a);
        sb.append(" rating=");
        float f = this.f318b;
        if (f < RecyclerView.f7068F0) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f);
        }
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f317a);
        parcel.writeFloat(this.f318b);
    }
}
