package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.util.List;

/* loaded from: classes.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* renamed from: a */
    public final Context f8931a;

    public ResourceDrawableDecoder(Context context) {
        this.f8931a = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0030  */
    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Resource<Drawable> decode(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Context createPackageContext;
        List<String> pathSegments;
        int parseInt;
        Drawable drawable;
        String authority = uri.getAuthority();
        Context context = this.f8931a;
        if (!authority.equals(context.getPackageName())) {
            try {
                createPackageContext = context.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (!authority.contains(context.getPackageName())) {
                    throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
                }
            }
            pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                List<String> pathSegments2 = uri.getPathSegments();
                String authority2 = uri.getAuthority();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                parseInt = createPackageContext.getResources().getIdentifier(str2, str, authority2);
                if (parseInt == 0) {
                    parseInt = Resources.getSystem().getIdentifier(str2, str, "android");
                }
                if (parseInt == 0) {
                    throw new IllegalArgumentException("Failed to find resource id for: " + uri);
                }
            } else if (pathSegments.size() == 1) {
                try {
                    parseInt = Integer.parseInt(uri.getPathSegments().get(0));
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
                }
            } else {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
            }
            drawable = DrawableDecoderCompat.getDrawable(context, createPackageContext, parseInt);
            if (drawable == null) {
                return new DrawableResource(drawable);
            }
            return null;
        }
        createPackageContext = context;
        pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 2) {
        }
        drawable = DrawableDecoderCompat.getDrawable(context, createPackageContext, parseInt);
        if (drawable == null) {
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull Uri uri, @NonNull Options options) {
        return uri.getScheme().equals("android.resource");
    }
}
