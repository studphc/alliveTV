package p000;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class e80 extends EmojiCompat.InitCallback {

    /* renamed from: a */
    public final WeakReference f16706a;

    /* renamed from: b */
    public final WeakReference f16707b;

    public e80(TextView textView, f80 f80Var) {
        this.f16706a = new WeakReference(textView);
        this.f16707b = new WeakReference(f80Var);
    }

    @Override // androidx.emoji2.text.EmojiCompat.InitCallback
    public final void onInitialized() {
        InputFilter[] filters;
        CharSequence text;
        CharSequence process;
        super.onInitialized();
        TextView textView = (TextView) this.f16706a.get();
        InputFilter inputFilter = (InputFilter) this.f16707b.get();
        if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (!textView.isAttachedToWindow() || text == (process = EmojiCompat.get().process((text = textView.getText())))) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(process);
                    int selectionEnd = Selection.getSelectionEnd(process);
                    textView.setText(process);
                    if (process instanceof Spannable) {
                        Spannable spannable = (Spannable) process;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }
}
