package p000;

import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class m80 extends EmojiCompat.InitCallback {

    /* renamed from: a */
    public final WeakReference f22845a;

    public m80(EditText editText) {
        this.f22845a = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.EmojiCompat.InitCallback
    public final void onInitialized() {
        super.onInitialized();
        n80.m6319a((EditText) this.f22845a.get(), 1);
    }
}
