package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public final class MediaStoreUtil {
    public static boolean isMediaStoreImageUri(Uri uri) {
        if (isMediaStoreUri(uri) && !uri.getPathSegments().contains(MimeTypes.BASE_TYPE_VIDEO)) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri != null && FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        if (isMediaStoreUri(uri) && uri.getPathSegments().contains(MimeTypes.BASE_TYPE_VIDEO)) {
            return true;
        }
        return false;
    }

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }
}
