package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p000.C1749r5;
import p000.ll1;
import p000.ml1;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C1749r5(19);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;

    /* renamed from: a */
    public final String f292a;

    /* renamed from: b */
    public final CharSequence f293b;

    /* renamed from: c */
    public final CharSequence f294c;

    /* renamed from: d */
    public final CharSequence f295d;

    /* renamed from: e */
    public final Bitmap f296e;

    /* renamed from: f */
    public final Uri f297f;

    /* renamed from: g */
    public final Bundle f298g;

    /* renamed from: h */
    public final Uri f299h;

    /* renamed from: i */
    public MediaDescription f300i;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public String f301a;

        /* renamed from: b */
        public CharSequence f302b;

        /* renamed from: c */
        public CharSequence f303c;

        /* renamed from: d */
        public CharSequence f304d;

        /* renamed from: e */
        public Bitmap f305e;

        /* renamed from: f */
        public Uri f306f;

        /* renamed from: g */
        public Bundle f307g;

        /* renamed from: h */
        public Uri f308h;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.f301a, this.f302b, this.f303c, this.f304d, this.f305e, this.f306f, this.f307g, this.f308h);
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.f304d = charSequence;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.f307g = bundle;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            this.f305e = bitmap;
            return this;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            this.f306f = uri;
            return this;
        }

        public Builder setMediaId(@Nullable String str) {
            this.f301a = str;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            this.f308h = uri;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.f303c = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f302b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f292a = str;
        this.f293b = charSequence;
        this.f294c = charSequence2;
        this.f295d = charSequence3;
        this.f296e = bitmap;
        this.f297f = uri;
        this.f298g = bundle;
        this.f299h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        Builder builder = new Builder();
        MediaDescription mediaDescription = (MediaDescription) obj;
        builder.setMediaId(ll1.m5946g(mediaDescription));
        builder.setTitle(ll1.m5948i(mediaDescription));
        builder.setSubtitle(ll1.m5947h(mediaDescription));
        builder.setDescription(ll1.m5942c(mediaDescription));
        builder.setIconBitmap(ll1.m5944e(mediaDescription));
        builder.setIconUri(ll1.m5945f(mediaDescription));
        Bundle m5943d = ll1.m5943d(mediaDescription);
        if (m5943d != null) {
            m5943d = MediaSessionCompat.unparcelWithClassLoader(m5943d);
        }
        if (m5943d != null) {
            uri = (Uri) m5943d.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
        } else {
            uri = null;
        }
        if (uri != null) {
            if (!m5943d.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) || m5943d.size() != 2) {
                m5943d.remove(DESCRIPTION_KEY_MEDIA_URI);
                m5943d.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
            }
            builder.setExtras(bundle);
            if (uri == null) {
                builder.setMediaUri(uri);
            } else {
                builder.setMediaUri(ml1.m6182a(mediaDescription));
            }
            MediaDescriptionCompat build = builder.build();
            build.f300i = mediaDescription;
            return build;
        }
        bundle = m5943d;
        builder.setExtras(bundle);
        if (uri == null) {
        }
        MediaDescriptionCompat build2 = builder.build();
        build2.f300i = mediaDescription;
        return build2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.f295d;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f298g;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.f296e;
    }

    @Nullable
    public Uri getIconUri() {
        return this.f297f;
    }

    public Object getMediaDescription() {
        MediaDescription mediaDescription = this.f300i;
        if (mediaDescription == null) {
            MediaDescription.Builder m5941b = ll1.m5941b();
            ll1.m5953n(m5941b, this.f292a);
            ll1.m5955p(m5941b, this.f293b);
            ll1.m5954o(m5941b, this.f294c);
            ll1.m5949j(m5941b, this.f295d);
            ll1.m5951l(m5941b, this.f296e);
            ll1.m5952m(m5941b, this.f297f);
            ll1.m5950k(m5941b, this.f298g);
            ml1.m6183b(m5941b, this.f299h);
            MediaDescription m5940a = ll1.m5940a(m5941b);
            this.f300i = m5940a;
            return m5940a;
        }
        return mediaDescription;
    }

    @Nullable
    public String getMediaId() {
        return this.f292a;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.f299h;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f294c;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f293b;
    }

    public String toString() {
        return ((Object) this.f293b) + ", " + ((Object) this.f294c) + ", " + ((Object) this.f295d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ((MediaDescription) getMediaDescription()).writeToParcel(parcel, i);
    }
}
