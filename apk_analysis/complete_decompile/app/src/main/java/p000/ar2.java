package p000;

import androidx.appcompat.widget.SwitchCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ar2 extends EmojiCompat.InitCallback {

    /* renamed from: a */
    public final WeakReference f7727a;

    public ar2(SwitchCompat switchCompat) {
        this.f7727a = new WeakReference(switchCompat);
    }

    @Override // androidx.emoji2.text.EmojiCompat.InitCallback
    public final void onFailed(Throwable th) {
        SwitchCompat switchCompat = (SwitchCompat) this.f7727a.get();
        if (switchCompat != null) {
            switchCompat.m280c();
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.InitCallback
    public final void onInitialized() {
        SwitchCompat switchCompat = (SwitchCompat) this.f7727a.get();
        if (switchCompat != null) {
            switchCompat.m280c();
        }
    }
}
