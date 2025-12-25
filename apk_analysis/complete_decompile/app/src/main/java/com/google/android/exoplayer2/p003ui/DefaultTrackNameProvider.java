package com.google.android.exoplayer2.p003ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

/* loaded from: classes.dex */
public class DefaultTrackNameProvider implements TrackNameProvider {

    /* renamed from: a */
    public final Resources f12053a;

    public DefaultTrackNameProvider(Resources resources) {
        this.f12053a = (Resources) Assertions.checkNotNull(resources);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m2897a(Format format) {
        String str;
        String m2899c;
        Locale locale;
        String str2 = format.language;
        String str3 = "";
        if (!TextUtils.isEmpty(str2) && !C0643C.LANGUAGE_UNDETERMINED.equals(str2)) {
            if (Util.SDK_INT >= 21) {
                locale = Locale.forLanguageTag(str2);
            } else {
                locale = new Locale(str2);
            }
            Locale defaultDisplayLocale = Util.getDefaultDisplayLocale();
            str = locale.getDisplayName(defaultDisplayLocale);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int offsetByCodePoints = str.offsetByCodePoints(0, 1);
                    str = str.substring(0, offsetByCodePoints).toUpperCase(defaultDisplayLocale) + str.substring(offsetByCodePoints);
                } catch (IndexOutOfBoundsException unused) {
                }
                m2899c = m2899c(str, m2898b(format));
                if (!TextUtils.isEmpty(m2899c)) {
                    if (!TextUtils.isEmpty(format.label)) {
                        str3 = format.label;
                    }
                    return str3;
                }
                return m2899c;
            }
        }
        str = "";
        m2899c = m2899c(str, m2898b(format));
        if (!TextUtils.isEmpty(m2899c)) {
        }
    }

    /* renamed from: b */
    public final String m2898b(Format format) {
        String str;
        int i = format.roleFlags & 2;
        Resources resources = this.f12053a;
        if (i != 0) {
            str = resources.getString(R.string.exo_track_role_alternate);
        } else {
            str = "";
        }
        if ((format.roleFlags & 4) != 0) {
            str = m2899c(str, resources.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            str = m2899c(str, resources.getString(R.string.exo_track_role_commentary));
        }
        if ((format.roleFlags & 1088) != 0) {
            return m2899c(str, resources.getString(R.string.exo_track_role_closed_captions));
        }
        return str;
    }

    /* renamed from: c */
    public final String m2899c(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.f12053a.getString(R.string.exo_item_list, str, str2);
                }
            }
        }
        return str;
    }

    @Override // com.google.android.exoplayer2.p003ui.TrackNameProvider
    public String getTrackName(Format format) {
        String m2897a;
        String str;
        String str2;
        int trackType = MimeTypes.getTrackType(format.sampleMimeType);
        if (trackType == -1) {
            if (MimeTypes.getVideoMediaMimeType(format.codecs) == null) {
                if (MimeTypes.getAudioMediaMimeType(format.codecs) == null) {
                    if (format.width == -1 && format.height == -1) {
                        if (format.channelCount == -1 && format.sampleRate == -1) {
                            trackType = -1;
                        }
                    }
                }
                trackType = 1;
            }
            trackType = 2;
        }
        Resources resources = this.f12053a;
        String str3 = "";
        if (trackType == 2) {
            String m2898b = m2898b(format);
            int i = format.width;
            int i2 = format.height;
            if (i == -1 || i2 == -1) {
                str2 = "";
            } else {
                str2 = resources.getString(R.string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
            }
            int i3 = format.bitrate;
            if (i3 != -1) {
                str3 = resources.getString(R.string.exo_track_bitrate, Float.valueOf(i3 / 1000000.0f));
            }
            m2897a = m2899c(m2898b, str2, str3);
        } else if (trackType == 1) {
            String m2897a2 = m2897a(format);
            int i4 = format.channelCount;
            if (i4 == -1 || i4 < 1) {
                str = "";
            } else if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 6 && i4 != 7) {
                        if (i4 != 8) {
                            str = resources.getString(R.string.exo_track_surround);
                        } else {
                            str = resources.getString(R.string.exo_track_surround_7_point_1);
                        }
                    } else {
                        str = resources.getString(R.string.exo_track_surround_5_point_1);
                    }
                } else {
                    str = resources.getString(R.string.exo_track_stereo);
                }
            } else {
                str = resources.getString(R.string.exo_track_mono);
            }
            int i5 = format.bitrate;
            if (i5 != -1) {
                str3 = resources.getString(R.string.exo_track_bitrate, Float.valueOf(i5 / 1000000.0f));
            }
            m2897a = m2899c(m2897a2, str, str3);
        } else {
            m2897a = m2897a(format);
        }
        if (m2897a.length() == 0) {
            return resources.getString(R.string.exo_track_unknown);
        }
        return m2897a;
    }
}
