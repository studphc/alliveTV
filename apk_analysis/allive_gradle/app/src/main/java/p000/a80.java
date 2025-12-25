package p000;

import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class a80 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f75a;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f75a) {
            case 0:
                try {
                    TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (EmojiCompat.isConfigured()) {
                        EmojiCompat.get().load();
                    }
                    return;
                } finally {
                    TraceCompat.endSection();
                }
            case 1:
            case 2:
                return;
            case 3:
                ye0.m8306z(19);
                return;
            case 4:
                ye0.m8306z(20);
                return;
            case 5:
                ye0.m8306z(21);
                return;
            case 6:
                ye0.m8306z(22);
                return;
            case 7:
                ye0.m8306z(23);
                return;
            case 8:
                ye0.m8306z(4);
                return;
            case 9:
                ye0.m8306z(19);
                return;
            case 10:
                ye0.m8306z(20);
                return;
            case 11:
                ye0.m8306z(21);
                return;
            case 12:
                ye0.m8306z(22);
                return;
            case 13:
                ye0.m8306z(23);
                return;
            case 14:
                return;
            case 15:
                ye0.m8306z(19);
                return;
            case 16:
                ye0.m8306z(20);
                return;
            case 17:
                ye0.m8306z(21);
                return;
            case 18:
                ye0.m8306z(22);
                return;
            case 19:
                ye0.m8306z(23);
                return;
            case 20:
                ye0.m8306z(4);
                return;
            case 21:
                ye0.m8306z(19);
                return;
            case 22:
                ye0.m8306z(20);
                return;
            case 23:
                ye0.m8306z(21);
                return;
            case 24:
                ye0.m8306z(22);
                return;
            default:
                ye0.m8306z(23);
                return;
        }
    }

    public String toString() {
        switch (this.f75a) {
            case 1:
                return "EmptyRunnable";
            default:
                return super.toString();
        }
    }

    /* renamed from: a */
    private final void m38a() {
    }

    /* renamed from: b */
    private final void m39b() {
    }

    /* renamed from: c */
    private final void m40c() {
    }
}
