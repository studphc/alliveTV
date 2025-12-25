package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000.ExecutorC2014yb;
import p000.ys0;

/* loaded from: classes.dex */
public class FontsContractCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";

    /* loaded from: classes.dex */
    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    /* loaded from: classes.dex */
    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;

        /* renamed from: a */
        public final int f3725a;

        /* renamed from: b */
        public final FontInfo[] f3726b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public FontFamilyResult(int i, @Nullable FontInfo[] fontInfoArr) {
            this.f3725a = i;
            this.f3726b = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            return this.f3726b;
        }

        public int getStatusCode() {
            return this.f3725a;
        }
    }

    /* loaded from: classes.dex */
    public static class FontInfo {

        /* renamed from: a */
        public final Uri f3727a;

        /* renamed from: b */
        public final int f3728b;

        /* renamed from: c */
        public final int f3729c;

        /* renamed from: d */
        public final boolean f3730d;

        /* renamed from: e */
        public final int f3731e;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i, @IntRange(from = 1, m153to = 1000) int i2, boolean z, int i3) {
            this.f3727a = (Uri) Preconditions.checkNotNull(uri);
            this.f3728b = i;
            this.f3729c = i2;
            this.f3730d = z;
            this.f3731e = i3;
        }

        public int getResultCode() {
            return this.f3731e;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.f3728b;
        }

        @NonNull
        public Uri getUri() {
            return this.f3727a;
        }

        @IntRange(from = 1, m153to = 1000)
        public int getWeight() {
            return this.f3729c;
        }

        public boolean isItalic() {
            return this.f3730d;
        }
    }

    /* loaded from: classes.dex */
    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* loaded from: classes.dex */
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) {
        return AbstractC0189d.m882a(context, cancellationSignal, fontRequest);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface getFontSync(Context context, FontRequest fontRequest, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z, int i, int i2) {
        return requestFont(context, fontRequest, i2, z, i, ResourcesCompat.FontCallback.getHandler(handler), new TypefaceCompat.ResourcesCallbackAdapter(fontCallback));
    }

    @VisibleForTesting
    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) {
        return AbstractC0189d.m883b(packageManager, fontRequest, resources);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
    }

    public static void requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        C0188c c0188c = new C0188c(fontRequestCallback);
        AbstractC0193h.m885b(context.getApplicationContext(), fontRequest, 0, new ExecutorC2014yb(3, handler), c0188c);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static void resetCache() {
        AbstractC0193h.f3754a.evictAll();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public static void resetTypefaceCache() {
        AbstractC0193h.f3754a.evictAll();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, int i, boolean z, @IntRange(from = 0) int i2, @NonNull Handler handler, @NonNull FontRequestCallback fontRequestCallback) {
        C0188c c0188c = new C0188c(fontRequestCallback, handler);
        if (z) {
            LruCache lruCache = AbstractC0193h.f3754a;
            String str = fontRequest.f3724f + "-" + i;
            Typeface typeface = (Typeface) AbstractC0193h.f3754a.get(str);
            if (typeface != null) {
                handler.post(new RunnableC0186a(fontRequestCallback, typeface));
                return typeface;
            }
            if (i2 == -1) {
                C0192g m884a = AbstractC0193h.m884a(str, context, fontRequest, i);
                c0188c.m881a(m884a);
                return m884a.f3752a;
            }
            try {
                try {
                    try {
                        C0192g c0192g = (C0192g) AbstractC0193h.f3755b.submit(new ys0(str, context, fontRequest, i)).get(i2, TimeUnit.MILLISECONDS);
                        c0188c.m881a(c0192g);
                        return c0192g.f3752a;
                    } catch (InterruptedException e) {
                        throw e;
                    }
                } catch (ExecutionException e2) {
                    throw new RuntimeException(e2);
                } catch (TimeoutException unused) {
                    throw new InterruptedException("timeout");
                }
            } catch (InterruptedException unused2) {
                c0188c.f3745b.post(new RunnableC0187b(c0188c.f3744a, -3));
                return null;
            }
        }
        return AbstractC0193h.m885b(context, fontRequest, i, null, c0188c);
    }
}
