package androidx.emoji2.text;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import p000.ExecutorC1700pu;

/* loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* renamed from: k */
    public static final FontProviderHelper f4215k = new FontProviderHelper();

    /* loaded from: classes.dex */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {

        /* renamed from: a */
        public final long f4216a;

        /* renamed from: b */
        public long f4217b;

        public ExponentialBackoffRetryPolicy(long j) {
            this.f4216a = j;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.f4217b == 0) {
                this.f4217b = SystemClock.uptimeMillis();
                return 0L;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.f4217b;
            long j = this.f4216a;
            if (uptimeMillis > j) {
                return -1L;
            }
            return Math.min(Math.max(uptimeMillis, 1000L), j - uptimeMillis);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class FontProviderHelper {
        @Nullable
        public Typeface buildTypeface(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) {
            return FontsContractCompat.buildTypeface(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context context, @NonNull FontRequest fontRequest) {
            return FontsContractCompat.fetchFonts(context, null, fontRequest);
        }

        public void registerObserver(@NonNull Context context, @NonNull Uri uri, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new C0243j(context, fontRequest, f4215k));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(@Nullable Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(new ExecutorC1700pu(handler));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setLoadingExecutor(@NonNull Executor executor) {
        C0243j c0243j = (C0243j) getMetadataRepoLoader();
        synchronized (c0243j.f4300d) {
            c0243j.f4302f = executor;
        }
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setRetryPolicy(@Nullable RetryPolicy retryPolicy) {
        C0243j c0243j = (C0243j) getMetadataRepoLoader();
        synchronized (c0243j.f4300d) {
            c0243j.f4304h = retryPolicy;
        }
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
        super(new C0243j(context, fontRequest, fontProviderHelper));
    }
}
