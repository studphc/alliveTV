package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1774ru;
import p000.ThreadFactoryC1737qu;
import p000.ws0;
import p000.xs0;

/* renamed from: androidx.emoji2.text.j */
/* loaded from: classes.dex */
public final class C0243j implements EmojiCompat.MetadataRepoLoader {

    /* renamed from: a */
    public final Context f4297a;

    /* renamed from: b */
    public final FontRequest f4298b;

    /* renamed from: c */
    public final FontRequestEmojiCompatConfig.FontProviderHelper f4299c;

    /* renamed from: d */
    public final Object f4300d = new Object();

    /* renamed from: e */
    public Handler f4301e;

    /* renamed from: f */
    public Executor f4302f;

    /* renamed from: g */
    public ThreadPoolExecutor f4303g;

    /* renamed from: h */
    public FontRequestEmojiCompatConfig.RetryPolicy f4304h;

    /* renamed from: i */
    public EmojiCompat.MetadataRepoLoaderCallback f4305i;

    /* renamed from: j */
    public xs0 f4306j;

    /* renamed from: k */
    public ws0 f4307k;

    public C0243j(Context context, FontRequest fontRequest, FontRequestEmojiCompatConfig.FontProviderHelper fontProviderHelper) {
        Preconditions.checkNotNull(context, "Context cannot be null");
        Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
        this.f4297a = context.getApplicationContext();
        this.f4298b = fontRequest;
        this.f4299c = fontProviderHelper;
    }

    /* renamed from: a */
    public final void m1085a() {
        synchronized (this.f4300d) {
            try {
                this.f4305i = null;
                xs0 xs0Var = this.f4306j;
                if (xs0Var != null) {
                    this.f4299c.unregisterObserver(this.f4297a, xs0Var);
                    this.f4306j = null;
                }
                Handler handler = this.f4301e;
                if (handler != null) {
                    handler.removeCallbacks(this.f4307k);
                }
                this.f4301e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f4303g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f4302f = null;
                this.f4303g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: b */
    public final void m1086b() {
        synchronized (this.f4300d) {
            try {
                if (this.f4305i == null) {
                    return;
                }
                if (this.f4302f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC1737qu("emojiCompat", 0));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f4303g = threadPoolExecutor;
                    this.f4302f = threadPoolExecutor;
                }
                this.f4302f.execute(new ws0(this, 0));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: c */
    public final FontsContractCompat.FontInfo m1087c() {
        try {
            FontsContractCompat.FontFamilyResult fetchFonts = this.f4299c.fetchFonts(this.f4297a, this.f4298b);
            if (fetchFonts.getStatusCode() == 0) {
                FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                if (fonts != null && fonts.length != 0) {
                    return fonts[0];
                }
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + ")");
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }

    /* renamed from: d */
    public final void m1088d(Uri uri, long j) {
        synchronized (this.f4300d) {
            try {
                Handler handler = this.f4301e;
                if (handler == null) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        handler = AbstractC1774ru.m7303a(Looper.getMainLooper());
                    } else {
                        handler = new Handler(Looper.getMainLooper());
                    }
                    this.f4301e = handler;
                }
                if (this.f4306j == null) {
                    xs0 xs0Var = new xs0(this, handler);
                    this.f4306j = xs0Var;
                    this.f4299c.registerObserver(this.f4297a, uri, xs0Var);
                }
                if (this.f4307k == null) {
                    this.f4307k = new ws0(this, 1);
                }
                handler.postDelayed(this.f4307k, j);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public final void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
        Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
        synchronized (this.f4300d) {
            this.f4305i = metadataRepoLoaderCallback;
        }
        m1086b();
    }
}
