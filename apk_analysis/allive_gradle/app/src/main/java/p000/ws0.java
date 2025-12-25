package p000;

import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.emoji2.text.C0243j;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.emoji2.text.MetadataRepo;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final /* synthetic */ class ws0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28314a;

    /* renamed from: b */
    public final /* synthetic */ C0243j f28315b;

    public /* synthetic */ ws0(C0243j c0243j, int i) {
        this.f28314a = i;
        this.f28315b = c0243j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28314a) {
            case 0:
                C0243j c0243j = this.f28315b;
                synchronized (c0243j.f4300d) {
                    try {
                        if (c0243j.f4305i != null) {
                            try {
                                FontsContractCompat.FontInfo m1087c = c0243j.m1087c();
                                int resultCode = m1087c.getResultCode();
                                if (resultCode == 2) {
                                    synchronized (c0243j.f4300d) {
                                        try {
                                            FontRequestEmojiCompatConfig.RetryPolicy retryPolicy = c0243j.f4304h;
                                            if (retryPolicy != null) {
                                                long retryDelay = retryPolicy.getRetryDelay();
                                                if (retryDelay >= 0) {
                                                    c0243j.m1088d(m1087c.getUri(), retryDelay);
                                                    return;
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                                if (resultCode == 0) {
                                    try {
                                        TraceCompat.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                        Typeface buildTypeface = c0243j.f4299c.buildTypeface(c0243j.f4297a, m1087c);
                                        ByteBuffer mmap = TypefaceCompatUtil.mmap(c0243j.f4297a, null, m1087c.getUri());
                                        if (mmap != null && buildTypeface != null) {
                                            MetadataRepo create = MetadataRepo.create(buildTypeface, mmap);
                                            TraceCompat.endSection();
                                            synchronized (c0243j.f4300d) {
                                                try {
                                                    EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = c0243j.f4305i;
                                                    if (metadataRepoLoaderCallback != null) {
                                                        metadataRepoLoaderCallback.onLoaded(create);
                                                    }
                                                } finally {
                                                }
                                            }
                                            c0243j.m1085a();
                                            return;
                                        }
                                        throw new RuntimeException("Unable to open file.");
                                    } catch (Throwable th) {
                                        TraceCompat.endSection();
                                        throw th;
                                    }
                                }
                                throw new RuntimeException("fetchFonts result is not OK. (" + resultCode + ")");
                            } catch (Throwable th2) {
                                synchronized (c0243j.f4300d) {
                                    try {
                                        EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = c0243j.f4305i;
                                        if (metadataRepoLoaderCallback2 != null) {
                                            metadataRepoLoaderCallback2.onFailed(th2);
                                        }
                                        c0243j.m1085a();
                                        return;
                                    } finally {
                                    }
                                }
                            }
                        }
                        return;
                    } finally {
                    }
                }
            default:
                this.f28315b.m1086b();
                return;
        }
    }
}
