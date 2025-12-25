package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public class SearchEditText extends StreamingTextView {

    /* renamed from: h */
    public OnKeyboardDismissListener f6152h;

    /* loaded from: classes.dex */
    public interface OnKeyboardDismissListener {
        void onKeyboardDismiss();
    }

    public SearchEditText(Context context) {
        this(context, null);
    }

    @Override // androidx.leanback.widget.StreamingTextView, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.f6152h != null) {
            post(new RunnableC0390t2(this));
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // androidx.leanback.widget.StreamingTextView
    public void reset() {
        this.f6226d = -1;
        ObjectAnimator objectAnimator = this.f6227e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setText("");
    }

    @Override // androidx.leanback.widget.StreamingTextView, android.widget.TextView
    public /* bridge */ /* synthetic */ void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setFinalRecognizedText(CharSequence charSequence) {
        setText(charSequence);
        bringPointIntoView(length());
    }

    public void setOnKeyboardDismissListener(OnKeyboardDismissListener onKeyboardDismissListener) {
        this.f6152h = onKeyboardDismissListener;
    }

    public /* bridge */ /* synthetic */ void updateRecognizedText(String str, List list) {
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.style.TextAppearance_Leanback_SearchTextEdit);
    }

    public void updateRecognizedText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            Matcher matcher = StreamingTextView.f6221f.matcher(str2);
            while (matcher.find()) {
                int start = matcher.start() + length;
                spannableStringBuilder.setSpan(new C0398v2(this, str2.charAt(matcher.start()), start), start, matcher.end() + length, 33);
            }
        }
        this.f6226d = Math.max(str.length(), this.f6226d);
        setText(new SpannedString(spannableStringBuilder));
        bringPointIntoView(length());
        ObjectAnimator objectAnimator = this.f6227e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        int streamPosition = getStreamPosition();
        int length2 = length();
        int i = length2 - streamPosition;
        if (i > 0) {
            if (this.f6227e == null) {
                ObjectAnimator objectAnimator2 = new ObjectAnimator();
                this.f6227e = objectAnimator2;
                objectAnimator2.setTarget(this);
                this.f6227e.setProperty(StreamingTextView.f6222g);
            }
            this.f6227e.setIntValues(streamPosition, length2);
            this.f6227e.setDuration(i * 50);
            this.f6227e.start();
        }
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
