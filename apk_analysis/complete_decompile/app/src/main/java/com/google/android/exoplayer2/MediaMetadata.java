package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import p000.ee0;

/* loaded from: classes.dex */
public final class MediaMetadata implements Bundleable {
    public static final int FOLDER_TYPE_ALBUMS = 2;
    public static final int FOLDER_TYPE_ARTISTS = 3;
    public static final int FOLDER_TYPE_GENRES = 4;
    public static final int FOLDER_TYPE_MIXED = 0;
    public static final int FOLDER_TYPE_NONE = -1;
    public static final int FOLDER_TYPE_PLAYLISTS = 5;
    public static final int FOLDER_TYPE_TITLES = 1;
    public static final int FOLDER_TYPE_YEARS = 6;
    public static final int PICTURE_TYPE_ARTIST_PERFORMER = 8;
    public static final int PICTURE_TYPE_A_BRIGHT_COLORED_FISH = 17;
    public static final int PICTURE_TYPE_BACK_COVER = 4;
    public static final int PICTURE_TYPE_BAND_ARTIST_LOGO = 19;
    public static final int PICTURE_TYPE_BAND_ORCHESTRA = 10;
    public static final int PICTURE_TYPE_COMPOSER = 11;
    public static final int PICTURE_TYPE_CONDUCTOR = 9;
    public static final int PICTURE_TYPE_DURING_PERFORMANCE = 15;
    public static final int PICTURE_TYPE_DURING_RECORDING = 14;
    public static final int PICTURE_TYPE_FILE_ICON = 1;
    public static final int PICTURE_TYPE_FILE_ICON_OTHER = 2;
    public static final int PICTURE_TYPE_FRONT_COVER = 3;
    public static final int PICTURE_TYPE_ILLUSTRATION = 18;
    public static final int PICTURE_TYPE_LEAD_ARTIST_PERFORMER = 7;
    public static final int PICTURE_TYPE_LEAFLET_PAGE = 5;
    public static final int PICTURE_TYPE_LYRICIST = 12;
    public static final int PICTURE_TYPE_MEDIA = 6;
    public static final int PICTURE_TYPE_MOVIE_VIDEO_SCREEN_CAPTURE = 16;
    public static final int PICTURE_TYPE_OTHER = 0;
    public static final int PICTURE_TYPE_PUBLISHER_STUDIO_LOGO = 20;
    public static final int PICTURE_TYPE_RECORDING_LOCATION = 13;

    @Nullable
    public final CharSequence albumArtist;

    @Nullable
    public final CharSequence albumTitle;

    @Nullable
    public final CharSequence artist;

    @Nullable
    public final byte[] artworkData;

    @Nullable
    public final Integer artworkDataType;

    @Nullable
    public final Uri artworkUri;

    @Nullable
    public final CharSequence compilation;

    @Nullable
    public final CharSequence composer;

    @Nullable
    public final CharSequence conductor;

    @Nullable
    public final CharSequence description;

    @Nullable
    public final Integer discNumber;

    @Nullable
    public final CharSequence displayTitle;

    @Nullable
    public final Bundle extras;

    @Nullable
    public final Integer folderType;

    @Nullable
    public final CharSequence genre;

    @Nullable
    public final Boolean isPlayable;

    @Nullable
    public final Rating overallRating;

    @Nullable
    public final Integer recordingDay;

    @Nullable
    public final Integer recordingMonth;

    @Nullable
    public final Integer recordingYear;

    @Nullable
    public final Integer releaseDay;

    @Nullable
    public final Integer releaseMonth;

    @Nullable
    public final Integer releaseYear;

    @Nullable
    public final CharSequence station;

    @Nullable
    public final CharSequence subtitle;

    @Nullable
    public final CharSequence title;

    @Nullable
    public final Integer totalDiscCount;

    @Nullable
    public final Integer totalTrackCount;

    @Nullable
    public final Integer trackNumber;

    @Nullable
    public final Rating userRating;

    @Nullable
    public final CharSequence writer;

    @Nullable
    @Deprecated
    public final Integer year;
    public static final MediaMetadata EMPTY = new Builder().build();
    public static final Bundleable.Creator<MediaMetadata> CREATOR = new ee0(15);

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: A */
        public Integer f9433A;

        /* renamed from: B */
        public CharSequence f9434B;

        /* renamed from: C */
        public CharSequence f9435C;

        /* renamed from: D */
        public CharSequence f9436D;

        /* renamed from: E */
        public Bundle f9437E;

        /* renamed from: a */
        public CharSequence f9438a;

        /* renamed from: b */
        public CharSequence f9439b;

        /* renamed from: c */
        public CharSequence f9440c;

        /* renamed from: d */
        public CharSequence f9441d;

        /* renamed from: e */
        public CharSequence f9442e;

        /* renamed from: f */
        public CharSequence f9443f;

        /* renamed from: g */
        public CharSequence f9444g;

        /* renamed from: h */
        public Rating f9445h;

        /* renamed from: i */
        public Rating f9446i;

        /* renamed from: j */
        public byte[] f9447j;

        /* renamed from: k */
        public Integer f9448k;

        /* renamed from: l */
        public Uri f9449l;

        /* renamed from: m */
        public Integer f9450m;

        /* renamed from: n */
        public Integer f9451n;

        /* renamed from: o */
        public Integer f9452o;

        /* renamed from: p */
        public Boolean f9453p;

        /* renamed from: q */
        public Integer f9454q;

        /* renamed from: r */
        public Integer f9455r;

        /* renamed from: s */
        public Integer f9456s;

        /* renamed from: t */
        public Integer f9457t;

        /* renamed from: u */
        public Integer f9458u;

        /* renamed from: v */
        public Integer f9459v;

        /* renamed from: w */
        public CharSequence f9460w;

        /* renamed from: x */
        public CharSequence f9461x;

        /* renamed from: y */
        public CharSequence f9462y;

        /* renamed from: z */
        public Integer f9463z;

        public MediaMetadata build() {
            return new MediaMetadata(this);
        }

        public Builder maybeSetArtworkData(byte[] bArr, int i) {
            if (this.f9447j == null || Util.areEqual(Integer.valueOf(i), 3) || !Util.areEqual(this.f9448k, 3)) {
                this.f9447j = (byte[]) bArr.clone();
                this.f9448k = Integer.valueOf(i);
            }
            return this;
        }

        public Builder populate(@Nullable MediaMetadata mediaMetadata) {
            if (mediaMetadata == null) {
                return this;
            }
            CharSequence charSequence = mediaMetadata.title;
            if (charSequence != null) {
                setTitle(charSequence);
            }
            CharSequence charSequence2 = mediaMetadata.artist;
            if (charSequence2 != null) {
                setArtist(charSequence2);
            }
            CharSequence charSequence3 = mediaMetadata.albumTitle;
            if (charSequence3 != null) {
                setAlbumTitle(charSequence3);
            }
            CharSequence charSequence4 = mediaMetadata.albumArtist;
            if (charSequence4 != null) {
                setAlbumArtist(charSequence4);
            }
            CharSequence charSequence5 = mediaMetadata.displayTitle;
            if (charSequence5 != null) {
                setDisplayTitle(charSequence5);
            }
            CharSequence charSequence6 = mediaMetadata.subtitle;
            if (charSequence6 != null) {
                setSubtitle(charSequence6);
            }
            CharSequence charSequence7 = mediaMetadata.description;
            if (charSequence7 != null) {
                setDescription(charSequence7);
            }
            Rating rating = mediaMetadata.userRating;
            if (rating != null) {
                setUserRating(rating);
            }
            Rating rating2 = mediaMetadata.overallRating;
            if (rating2 != null) {
                setOverallRating(rating2);
            }
            byte[] bArr = mediaMetadata.artworkData;
            if (bArr != null) {
                setArtworkData(bArr, mediaMetadata.artworkDataType);
            }
            Uri uri = mediaMetadata.artworkUri;
            if (uri != null) {
                setArtworkUri(uri);
            }
            Integer num = mediaMetadata.trackNumber;
            if (num != null) {
                setTrackNumber(num);
            }
            Integer num2 = mediaMetadata.totalTrackCount;
            if (num2 != null) {
                setTotalTrackCount(num2);
            }
            Integer num3 = mediaMetadata.folderType;
            if (num3 != null) {
                setFolderType(num3);
            }
            Boolean bool = mediaMetadata.isPlayable;
            if (bool != null) {
                setIsPlayable(bool);
            }
            Integer num4 = mediaMetadata.year;
            if (num4 != null) {
                setRecordingYear(num4);
            }
            Integer num5 = mediaMetadata.recordingYear;
            if (num5 != null) {
                setRecordingYear(num5);
            }
            Integer num6 = mediaMetadata.recordingMonth;
            if (num6 != null) {
                setRecordingMonth(num6);
            }
            Integer num7 = mediaMetadata.recordingDay;
            if (num7 != null) {
                setRecordingDay(num7);
            }
            Integer num8 = mediaMetadata.releaseYear;
            if (num8 != null) {
                setReleaseYear(num8);
            }
            Integer num9 = mediaMetadata.releaseMonth;
            if (num9 != null) {
                setReleaseMonth(num9);
            }
            Integer num10 = mediaMetadata.releaseDay;
            if (num10 != null) {
                setReleaseDay(num10);
            }
            CharSequence charSequence8 = mediaMetadata.writer;
            if (charSequence8 != null) {
                setWriter(charSequence8);
            }
            CharSequence charSequence9 = mediaMetadata.composer;
            if (charSequence9 != null) {
                setComposer(charSequence9);
            }
            CharSequence charSequence10 = mediaMetadata.conductor;
            if (charSequence10 != null) {
                setConductor(charSequence10);
            }
            Integer num11 = mediaMetadata.discNumber;
            if (num11 != null) {
                setDiscNumber(num11);
            }
            Integer num12 = mediaMetadata.totalDiscCount;
            if (num12 != null) {
                setTotalDiscCount(num12);
            }
            CharSequence charSequence11 = mediaMetadata.genre;
            if (charSequence11 != null) {
                setGenre(charSequence11);
            }
            CharSequence charSequence12 = mediaMetadata.compilation;
            if (charSequence12 != null) {
                setCompilation(charSequence12);
            }
            CharSequence charSequence13 = mediaMetadata.station;
            if (charSequence13 != null) {
                setStation(charSequence13);
            }
            Bundle bundle = mediaMetadata.extras;
            if (bundle != null) {
                setExtras(bundle);
            }
            return this;
        }

        public Builder populateFromMetadata(Metadata metadata) {
            for (int i = 0; i < metadata.length(); i++) {
                metadata.get(i).populateMediaMetadata(this);
            }
            return this;
        }

        public Builder setAlbumArtist(@Nullable CharSequence charSequence) {
            this.f9441d = charSequence;
            return this;
        }

        public Builder setAlbumTitle(@Nullable CharSequence charSequence) {
            this.f9440c = charSequence;
            return this;
        }

        public Builder setArtist(@Nullable CharSequence charSequence) {
            this.f9439b = charSequence;
            return this;
        }

        @Deprecated
        public Builder setArtworkData(@Nullable byte[] bArr) {
            return setArtworkData(bArr, null);
        }

        public Builder setArtworkUri(@Nullable Uri uri) {
            this.f9449l = uri;
            return this;
        }

        public Builder setCompilation(@Nullable CharSequence charSequence) {
            this.f9435C = charSequence;
            return this;
        }

        public Builder setComposer(@Nullable CharSequence charSequence) {
            this.f9461x = charSequence;
            return this;
        }

        public Builder setConductor(@Nullable CharSequence charSequence) {
            this.f9462y = charSequence;
            return this;
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.f9444g = charSequence;
            return this;
        }

        public Builder setDiscNumber(@Nullable Integer num) {
            this.f9463z = num;
            return this;
        }

        public Builder setDisplayTitle(@Nullable CharSequence charSequence) {
            this.f9442e = charSequence;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.f9437E = bundle;
            return this;
        }

        public Builder setFolderType(@Nullable Integer num) {
            this.f9452o = num;
            return this;
        }

        public Builder setGenre(@Nullable CharSequence charSequence) {
            this.f9434B = charSequence;
            return this;
        }

        public Builder setIsPlayable(@Nullable Boolean bool) {
            this.f9453p = bool;
            return this;
        }

        public Builder setOverallRating(@Nullable Rating rating) {
            this.f9446i = rating;
            return this;
        }

        public Builder setRecordingDay(@IntRange(from = 1, m153to = 31) @Nullable Integer num) {
            this.f9456s = num;
            return this;
        }

        public Builder setRecordingMonth(@IntRange(from = 1, m153to = 12) @Nullable Integer num) {
            this.f9455r = num;
            return this;
        }

        public Builder setRecordingYear(@Nullable Integer num) {
            this.f9454q = num;
            return this;
        }

        public Builder setReleaseDay(@IntRange(from = 1, m153to = 31) @Nullable Integer num) {
            this.f9459v = num;
            return this;
        }

        public Builder setReleaseMonth(@IntRange(from = 1, m153to = 12) @Nullable Integer num) {
            this.f9458u = num;
            return this;
        }

        public Builder setReleaseYear(@Nullable Integer num) {
            this.f9457t = num;
            return this;
        }

        public Builder setStation(@Nullable CharSequence charSequence) {
            this.f9436D = charSequence;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.f9443f = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f9438a = charSequence;
            return this;
        }

        public Builder setTotalDiscCount(@Nullable Integer num) {
            this.f9433A = num;
            return this;
        }

        public Builder setTotalTrackCount(@Nullable Integer num) {
            this.f9451n = num;
            return this;
        }

        public Builder setTrackNumber(@Nullable Integer num) {
            this.f9450m = num;
            return this;
        }

        public Builder setUserRating(@Nullable Rating rating) {
            this.f9445h = rating;
            return this;
        }

        public Builder setWriter(@Nullable CharSequence charSequence) {
            this.f9460w = charSequence;
            return this;
        }

        @Deprecated
        public Builder setYear(@Nullable Integer num) {
            return setRecordingYear(num);
        }

        public Builder setArtworkData(@Nullable byte[] bArr, @Nullable Integer num) {
            this.f9447j = bArr == null ? null : (byte[]) bArr.clone();
            this.f9448k = num;
            return this;
        }

        public Builder populateFromMetadata(List<Metadata> list) {
            for (int i = 0; i < list.size(); i++) {
                Metadata metadata = list.get(i);
                for (int i2 = 0; i2 < metadata.length(); i2++) {
                    metadata.get(i2).populateMediaMetadata(this);
                }
            }
            return this;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FolderType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PictureType {
    }

    public MediaMetadata(Builder builder) {
        this.title = builder.f9438a;
        this.artist = builder.f9439b;
        this.albumTitle = builder.f9440c;
        this.albumArtist = builder.f9441d;
        this.displayTitle = builder.f9442e;
        this.subtitle = builder.f9443f;
        this.description = builder.f9444g;
        this.userRating = builder.f9445h;
        this.overallRating = builder.f9446i;
        this.artworkData = builder.f9447j;
        this.artworkDataType = builder.f9448k;
        this.artworkUri = builder.f9449l;
        this.trackNumber = builder.f9450m;
        this.totalTrackCount = builder.f9451n;
        this.folderType = builder.f9452o;
        this.isPlayable = builder.f9453p;
        Integer num = builder.f9454q;
        this.year = num;
        this.recordingYear = num;
        this.recordingMonth = builder.f9455r;
        this.recordingDay = builder.f9456s;
        this.releaseYear = builder.f9457t;
        this.releaseMonth = builder.f9458u;
        this.releaseDay = builder.f9459v;
        this.writer = builder.f9460w;
        this.composer = builder.f9461x;
        this.conductor = builder.f9462y;
        this.discNumber = builder.f9463z;
        this.totalDiscCount = builder.f9433A;
        this.genre = builder.f9434B;
        this.compilation = builder.f9435C;
        this.station = builder.f9436D;
        this.extras = builder.f9437E;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.exoplayer2.MediaMetadata$Builder] */
    public Builder buildUpon() {
        ?? obj = new Object();
        obj.f9438a = this.title;
        obj.f9439b = this.artist;
        obj.f9440c = this.albumTitle;
        obj.f9441d = this.albumArtist;
        obj.f9442e = this.displayTitle;
        obj.f9443f = this.subtitle;
        obj.f9444g = this.description;
        obj.f9445h = this.userRating;
        obj.f9446i = this.overallRating;
        obj.f9447j = this.artworkData;
        obj.f9448k = this.artworkDataType;
        obj.f9449l = this.artworkUri;
        obj.f9450m = this.trackNumber;
        obj.f9451n = this.totalTrackCount;
        obj.f9452o = this.folderType;
        obj.f9453p = this.isPlayable;
        obj.f9454q = this.recordingYear;
        obj.f9455r = this.recordingMonth;
        obj.f9456s = this.recordingDay;
        obj.f9457t = this.releaseYear;
        obj.f9458u = this.releaseMonth;
        obj.f9459v = this.releaseDay;
        obj.f9460w = this.writer;
        obj.f9461x = this.composer;
        obj.f9462y = this.conductor;
        obj.f9463z = this.discNumber;
        obj.f9433A = this.totalDiscCount;
        obj.f9434B = this.genre;
        obj.f9435C = this.compilation;
        obj.f9436D = this.station;
        obj.f9437E = this.extras;
        return obj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        if (Util.areEqual(this.title, mediaMetadata.title) && Util.areEqual(this.artist, mediaMetadata.artist) && Util.areEqual(this.albumTitle, mediaMetadata.albumTitle) && Util.areEqual(this.albumArtist, mediaMetadata.albumArtist) && Util.areEqual(this.displayTitle, mediaMetadata.displayTitle) && Util.areEqual(this.subtitle, mediaMetadata.subtitle) && Util.areEqual(this.description, mediaMetadata.description) && Util.areEqual(this.userRating, mediaMetadata.userRating) && Util.areEqual(this.overallRating, mediaMetadata.overallRating) && Arrays.equals(this.artworkData, mediaMetadata.artworkData) && Util.areEqual(this.artworkDataType, mediaMetadata.artworkDataType) && Util.areEqual(this.artworkUri, mediaMetadata.artworkUri) && Util.areEqual(this.trackNumber, mediaMetadata.trackNumber) && Util.areEqual(this.totalTrackCount, mediaMetadata.totalTrackCount) && Util.areEqual(this.folderType, mediaMetadata.folderType) && Util.areEqual(this.isPlayable, mediaMetadata.isPlayable) && Util.areEqual(this.recordingYear, mediaMetadata.recordingYear) && Util.areEqual(this.recordingMonth, mediaMetadata.recordingMonth) && Util.areEqual(this.recordingDay, mediaMetadata.recordingDay) && Util.areEqual(this.releaseYear, mediaMetadata.releaseYear) && Util.areEqual(this.releaseMonth, mediaMetadata.releaseMonth) && Util.areEqual(this.releaseDay, mediaMetadata.releaseDay) && Util.areEqual(this.writer, mediaMetadata.writer) && Util.areEqual(this.composer, mediaMetadata.composer) && Util.areEqual(this.conductor, mediaMetadata.conductor) && Util.areEqual(this.discNumber, mediaMetadata.discNumber) && Util.areEqual(this.totalDiscCount, mediaMetadata.totalDiscCount) && Util.areEqual(this.genre, mediaMetadata.genre) && Util.areEqual(this.compilation, mediaMetadata.compilation) && Util.areEqual(this.station, mediaMetadata.station)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.title, this.artist, this.albumTitle, this.albumArtist, this.displayTitle, this.subtitle, this.description, this.userRating, this.overallRating, Integer.valueOf(Arrays.hashCode(this.artworkData)), this.artworkDataType, this.artworkUri, this.trackNumber, this.totalTrackCount, this.folderType, this.isPlayable, this.recordingYear, this.recordingMonth, this.recordingDay, this.releaseYear, this.releaseMonth, this.releaseDay, this.writer, this.composer, this.conductor, this.discNumber, this.totalDiscCount, this.genre, this.compilation, this.station);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(Integer.toString(0, 36), this.title);
        bundle.putCharSequence(Integer.toString(1, 36), this.artist);
        bundle.putCharSequence(Integer.toString(2, 36), this.albumTitle);
        bundle.putCharSequence(Integer.toString(3, 36), this.albumArtist);
        bundle.putCharSequence(Integer.toString(4, 36), this.displayTitle);
        bundle.putCharSequence(Integer.toString(5, 36), this.subtitle);
        bundle.putCharSequence(Integer.toString(6, 36), this.description);
        bundle.putByteArray(Integer.toString(10, 36), this.artworkData);
        bundle.putParcelable(Integer.toString(11, 36), this.artworkUri);
        bundle.putCharSequence(Integer.toString(22, 36), this.writer);
        bundle.putCharSequence(Integer.toString(23, 36), this.composer);
        bundle.putCharSequence(Integer.toString(24, 36), this.conductor);
        bundle.putCharSequence(Integer.toString(27, 36), this.genre);
        bundle.putCharSequence(Integer.toString(28, 36), this.compilation);
        bundle.putCharSequence(Integer.toString(30, 36), this.station);
        if (this.userRating != null) {
            bundle.putBundle(Integer.toString(8, 36), this.userRating.toBundle());
        }
        if (this.overallRating != null) {
            bundle.putBundle(Integer.toString(9, 36), this.overallRating.toBundle());
        }
        if (this.trackNumber != null) {
            bundle.putInt(Integer.toString(12, 36), this.trackNumber.intValue());
        }
        if (this.totalTrackCount != null) {
            bundle.putInt(Integer.toString(13, 36), this.totalTrackCount.intValue());
        }
        if (this.folderType != null) {
            bundle.putInt(Integer.toString(14, 36), this.folderType.intValue());
        }
        if (this.isPlayable != null) {
            bundle.putBoolean(Integer.toString(15, 36), this.isPlayable.booleanValue());
        }
        if (this.recordingYear != null) {
            bundle.putInt(Integer.toString(16, 36), this.recordingYear.intValue());
        }
        if (this.recordingMonth != null) {
            bundle.putInt(Integer.toString(17, 36), this.recordingMonth.intValue());
        }
        if (this.recordingDay != null) {
            bundle.putInt(Integer.toString(18, 36), this.recordingDay.intValue());
        }
        if (this.releaseYear != null) {
            bundle.putInt(Integer.toString(19, 36), this.releaseYear.intValue());
        }
        if (this.releaseMonth != null) {
            bundle.putInt(Integer.toString(20, 36), this.releaseMonth.intValue());
        }
        if (this.releaseDay != null) {
            bundle.putInt(Integer.toString(21, 36), this.releaseDay.intValue());
        }
        if (this.discNumber != null) {
            bundle.putInt(Integer.toString(25, 36), this.discNumber.intValue());
        }
        if (this.totalDiscCount != null) {
            bundle.putInt(Integer.toString(26, 36), this.totalDiscCount.intValue());
        }
        if (this.artworkDataType != null) {
            bundle.putInt(Integer.toString(29, 36), this.artworkDataType.intValue());
        }
        if (this.extras != null) {
            bundle.putBundle(Integer.toString(1000, 36), this.extras);
        }
        return bundle;
    }
}
