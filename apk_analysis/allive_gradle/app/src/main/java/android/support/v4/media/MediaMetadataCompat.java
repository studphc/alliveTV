package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.util.Set;
import p000.C1749r5;
import p000.ye0;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";

    /* renamed from: d */
    public static final ArrayMap f309d;

    /* renamed from: e */
    public static final String[] f310e;

    /* renamed from: f */
    public static final String[] f311f;

    /* renamed from: g */
    public static final String[] f312g;

    /* renamed from: a */
    public final Bundle f313a;

    /* renamed from: b */
    public MediaMetadata f314b;

    /* renamed from: c */
    public MediaDescriptionCompat f315c;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f309d = arrayMap;
        arrayMap.put(METADATA_KEY_TITLE, 1);
        arrayMap.put(METADATA_KEY_ARTIST, 1);
        arrayMap.put(METADATA_KEY_DURATION, 0);
        arrayMap.put(METADATA_KEY_ALBUM, 1);
        arrayMap.put(METADATA_KEY_AUTHOR, 1);
        arrayMap.put(METADATA_KEY_WRITER, 1);
        arrayMap.put(METADATA_KEY_COMPOSER, 1);
        arrayMap.put(METADATA_KEY_COMPILATION, 1);
        arrayMap.put(METADATA_KEY_DATE, 1);
        arrayMap.put(METADATA_KEY_YEAR, 0);
        arrayMap.put(METADATA_KEY_GENRE, 1);
        arrayMap.put(METADATA_KEY_TRACK_NUMBER, 0);
        arrayMap.put(METADATA_KEY_NUM_TRACKS, 0);
        arrayMap.put(METADATA_KEY_DISC_NUMBER, 0);
        arrayMap.put(METADATA_KEY_ALBUM_ARTIST, 1);
        arrayMap.put(METADATA_KEY_ART, 2);
        arrayMap.put(METADATA_KEY_ART_URI, 1);
        arrayMap.put(METADATA_KEY_ALBUM_ART, 2);
        arrayMap.put(METADATA_KEY_ALBUM_ART_URI, 1);
        arrayMap.put(METADATA_KEY_USER_RATING, 3);
        arrayMap.put(METADATA_KEY_RATING, 3);
        arrayMap.put(METADATA_KEY_DISPLAY_TITLE, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_ICON, 2);
        arrayMap.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        arrayMap.put(METADATA_KEY_MEDIA_ID, 1);
        arrayMap.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        arrayMap.put(METADATA_KEY_MEDIA_URI, 1);
        arrayMap.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        f310e = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        f311f = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        f312g = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new C1749r5(20);
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.f313a = bundle2;
        MediaSessionCompat.ensureClassLoader(bundle2);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj != null) {
            Parcel obtain = Parcel.obtain();
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            mediaMetadata.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
            obtain.recycle();
            createFromParcel.f314b = mediaMetadata;
            return createFromParcel;
        }
        return null;
    }

    public boolean containsKey(String str) {
        return this.f313a.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.f313a.getParcelable(str);
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public Bundle getBundle() {
        return new Bundle(this.f313a);
    }

    public MediaDescriptionCompat getDescription() {
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        MediaDescriptionCompat mediaDescriptionCompat = this.f315c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (!TextUtils.isEmpty(text)) {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        } else {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                String[] strArr = f310e;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                CharSequence text2 = getText(strArr[i2]);
                if (!TextUtils.isEmpty(text2)) {
                    charSequenceArr[i] = text2;
                    i++;
                }
                i2 = i3;
            }
        }
        int i4 = 0;
        while (true) {
            String[] strArr2 = f311f;
            uri = null;
            if (i4 < strArr2.length) {
                bitmap = getBitmap(strArr2[i4]);
                if (bitmap != null) {
                    break;
                }
                i4++;
            } else {
                bitmap = null;
                break;
            }
        }
        int i5 = 0;
        while (true) {
            String[] strArr3 = f312g;
            if (i5 < strArr3.length) {
                String string2 = getString(strArr3[i5]);
                if (!TextUtils.isEmpty(string2)) {
                    uri2 = Uri.parse(string2);
                    break;
                }
                i5++;
            } else {
                uri2 = null;
                break;
            }
        }
        String string3 = getString(METADATA_KEY_MEDIA_URI);
        if (!TextUtils.isEmpty(string3)) {
            uri = Uri.parse(string3);
        }
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri2);
        builder.setMediaUri(uri);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f313a;
        if (bundle2.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (bundle2.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        MediaDescriptionCompat build = builder.build();
        this.f315c = build;
        return build;
    }

    public long getLong(String str) {
        return this.f313a.getLong(str, 0L);
    }

    public Object getMediaMetadata() {
        if (this.f314b == null) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.f314b = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.f314b;
    }

    public RatingCompat getRating(String str) {
        try {
            return RatingCompat.fromRating(this.f313a.getParcelable(str));
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public String getString(String str) {
        CharSequence charSequence = this.f313a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence getText(String str) {
        return this.f313a.getCharSequence(str);
    }

    public Set<String> keySet() {
        return this.f313a.keySet();
    }

    public int size() {
        return this.f313a.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f313a);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final Bundle f316a;

        public Builder() {
            this.f316a = new Bundle();
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.f316a);
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            ArrayMap arrayMap = MediaMetadataCompat.f309d;
            if (arrayMap.containsKey(str) && ((Integer) arrayMap.get(str)).intValue() != 2) {
                throw new IllegalArgumentException(ye0.m8296p("The ", str, " key cannot be used to put a Bitmap"));
            }
            this.f316a.putParcelable(str, bitmap);
            return this;
        }

        public Builder putLong(String str, long j) {
            ArrayMap arrayMap = MediaMetadataCompat.f309d;
            if (arrayMap.containsKey(str) && ((Integer) arrayMap.get(str)).intValue() != 0) {
                throw new IllegalArgumentException(ye0.m8296p("The ", str, " key cannot be used to put a long"));
            }
            this.f316a.putLong(str, j);
            return this;
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            ArrayMap arrayMap = MediaMetadataCompat.f309d;
            if (arrayMap.containsKey(str) && ((Integer) arrayMap.get(str)).intValue() != 3) {
                throw new IllegalArgumentException(ye0.m8296p("The ", str, " key cannot be used to put a Rating"));
            }
            this.f316a.putParcelable(str, (Parcelable) ratingCompat.getRating());
            return this;
        }

        public Builder putString(String str, String str2) {
            ArrayMap arrayMap = MediaMetadataCompat.f309d;
            if (arrayMap.containsKey(str) && ((Integer) arrayMap.get(str)).intValue() != 1) {
                throw new IllegalArgumentException(ye0.m8296p("The ", str, " key cannot be used to put a String"));
            }
            this.f316a.putCharSequence(str, str2);
            return this;
        }

        public Builder putText(String str, CharSequence charSequence) {
            ArrayMap arrayMap = MediaMetadataCompat.f309d;
            if (arrayMap.containsKey(str) && ((Integer) arrayMap.get(str)).intValue() != 1) {
                throw new IllegalArgumentException(ye0.m8296p("The ", str, " key cannot be used to put a CharSequence"));
            }
            this.f316a.putCharSequence(str, charSequence);
            return this;
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = new Bundle(mediaMetadataCompat.f313a);
            this.f316a = bundle;
            MediaSessionCompat.ensureClassLoader(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder(MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            for (String str : this.f316a.keySet()) {
                Object obj = this.f316a.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        float f = i;
                        float min = Math.min(f / bitmap.getWidth(), f / bitmap.getHeight());
                        putBitmap(str, Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), true));
                    }
                }
            }
        }
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f313a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
