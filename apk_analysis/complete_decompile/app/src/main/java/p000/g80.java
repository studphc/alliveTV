package p000;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.viewsintegration.EmojiKeyListener$EmojiCompatHandleKeyDownHelper;

/* loaded from: classes.dex */
public final class g80 implements KeyListener {

    /* renamed from: a */
    public final KeyListener f17599a;

    /* renamed from: b */
    public final EmojiKeyListener$EmojiCompatHandleKeyDownHelper f17600b;

    public g80(KeyListener keyListener) {
        EmojiKeyListener$EmojiCompatHandleKeyDownHelper emojiKeyListener$EmojiCompatHandleKeyDownHelper = new EmojiKeyListener$EmojiCompatHandleKeyDownHelper();
        this.f17599a = keyListener;
        this.f17600b = emojiKeyListener$EmojiCompatHandleKeyDownHelper;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.f17599a.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f17599a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        if (!this.f17600b.handleKeyDown(editable, i, keyEvent) && !this.f17599a.onKeyDown(view, editable, i, keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f17599a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f17599a.onKeyUp(view, editable, i, keyEvent);
    }
}
