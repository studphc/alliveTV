package androidx.emoji2.text;

import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.emoji2.text.d */
/* loaded from: classes.dex */
public final class RunnableC0237d implements Runnable {

    /* renamed from: a */
    public final ArrayList f4235a;

    /* renamed from: b */
    public final Throwable f4236b;

    /* renamed from: c */
    public final int f4237c;

    public RunnableC0237d(List list, int i, Throwable th) {
        Preconditions.checkNotNull(list, "initCallbacks cannot be null");
        this.f4235a = new ArrayList(list);
        this.f4237c = i;
        this.f4236b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f4235a;
        int size = arrayList.size();
        int i = 0;
        if (this.f4237c != 1) {
            while (i < size) {
                ((EmojiCompat.InitCallback) arrayList.get(i)).onFailed(this.f4236b);
                i++;
            }
        } else {
            while (i < size) {
                ((EmojiCompat.InitCallback) arrayList.get(i)).onInitialized();
                i++;
            }
        }
    }
}
