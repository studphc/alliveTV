package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: androidx.emoji2.text.f */
/* loaded from: classes.dex */
public final class C0239f extends EmojiCompat.MetadataRepoLoaderCallback {

    /* renamed from: a */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f4238a;

    /* renamed from: b */
    public final /* synthetic */ ThreadPoolExecutor f4239b;

    public C0239f(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f4238a = metadataRepoLoaderCallback;
        this.f4239b = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
    public final void onFailed(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f4239b;
        try {
            this.f4238a.onFailed(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
    public final void onLoaded(MetadataRepo metadataRepo) {
        ThreadPoolExecutor threadPoolExecutor = this.f4239b;
        try {
            this.f4238a.onLoaded(metadataRepo);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
