package p000;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import androidx.emoji2.text.EmojiSpan;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class vl2 implements TextWatcher, SpanWatcher {

    /* renamed from: a */
    public final Object f27863a;

    /* renamed from: b */
    public final AtomicInteger f27864b = new AtomicInteger(0);

    public vl2(Object obj) {
        this.f27863a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f27863a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.f27863a).beforeTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (this.f27864b.get() > 0 && (obj instanceof EmojiSpan)) {
            return;
        }
        ((SpanWatcher) this.f27863a).onSpanAdded(spannable, obj, i, i2);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.f27864b.get() > 0 && (obj instanceof EmojiSpan)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (i > i2) {
                i = 0;
            }
            if (i3 > i4) {
                i5 = i;
                i6 = 0;
                ((SpanWatcher) this.f27863a).onSpanChanged(spannable, obj, i5, i2, i6, i4);
            }
        }
        i5 = i;
        i6 = i3;
        ((SpanWatcher) this.f27863a).onSpanChanged(spannable, obj, i5, i2, i6, i4);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (this.f27864b.get() > 0 && (obj instanceof EmojiSpan)) {
            return;
        }
        ((SpanWatcher) this.f27863a).onSpanRemoved(spannable, obj, i, i2);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.f27863a).onTextChanged(charSequence, i, i2, i3);
    }
}
