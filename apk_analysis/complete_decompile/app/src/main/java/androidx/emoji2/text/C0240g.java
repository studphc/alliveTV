package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.RunnableC0547b7;
import p000.ThreadFactoryC1737qu;

/* renamed from: androidx.emoji2.text.g */
/* loaded from: classes.dex */
public final class C0240g implements EmojiCompat.MetadataRepoLoader {

    /* renamed from: a */
    public final Context f4289a;

    public C0240g(Context context) {
        this.f4289a = context.getApplicationContext();
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public final void load(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC1737qu("EmojiCompatInitializer", 0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new RunnableC0547b7(this, metadataRepoLoaderCallback, threadPoolExecutor, 6));
    }
}
