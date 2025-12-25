package androidx.emoji2.text;

import android.os.Build;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Set;
import p000.c80;
import p000.yy2;

/* renamed from: androidx.emoji2.text.b */
/* loaded from: classes.dex */
public final class C0235b extends EmojiCompat.MetadataRepoLoaderCallback {

    /* renamed from: a */
    public final /* synthetic */ C0236c f4232a;

    public C0235b(C0236c c0236c) {
        this.f4232a = c0236c;
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
    public final void onFailed(Throwable th) {
        ((EmojiCompat) this.f4232a.f17677a).m1060b(th);
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
    public final void onLoaded(MetadataRepo metadataRepo) {
        Set<int[]> m8369s;
        C0236c c0236c = this.f4232a;
        if (metadataRepo == null) {
            ((EmojiCompat) c0236c.f17677a).m1060b(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        }
        c0236c.f4234c = metadataRepo;
        MetadataRepo metadataRepo2 = c0236c.f4234c;
        EmojiCompat emojiCompat = (EmojiCompat) c0236c.f17677a;
        EmojiCompat.SpanFactory spanFactory = emojiCompat.f4190g;
        EmojiCompat.GlyphChecker glyphChecker = emojiCompat.f4197n;
        boolean z = emojiCompat.f4192i;
        int[] iArr = emojiCompat.f4193j;
        if (Build.VERSION.SDK_INT >= 34) {
            m8369s = c80.m2207a();
        } else {
            m8369s = yy2.m8369s();
        }
        c0236c.f4233b = new C0242i(metadataRepo2, spanFactory, glyphChecker, z, iArr, m8369s);
        EmojiCompat emojiCompat2 = (EmojiCompat) c0236c.f17677a;
        emojiCompat2.getClass();
        ArrayList arrayList = new ArrayList();
        emojiCompat2.f4184a.writeLock().lock();
        try {
            emojiCompat2.f4186c = 1;
            arrayList.addAll(emojiCompat2.f4185b);
            emojiCompat2.f4185b.clear();
            emojiCompat2.f4184a.writeLock().unlock();
            emojiCompat2.f4187d.post(new RunnableC0237d(arrayList, emojiCompat2.f4186c, null));
        } catch (Throwable th) {
            emojiCompat2.f4184a.writeLock().unlock();
            throw th;
        }
    }
}
