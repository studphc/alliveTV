package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.core.widget.TextViewCompat;
import java.util.Random;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public abstract class StreamingTextView extends EditText {

    /* renamed from: f */
    public static final Pattern f6221f = Pattern.compile("\\S+");

    /* renamed from: g */
    public static final C0394u2 f6222g = new Property(Integer.class, "streamPosition");

    /* renamed from: a */
    public final Random f6223a;

    /* renamed from: b */
    public Bitmap f6224b;

    /* renamed from: c */
    public Bitmap f6225c;

    /* renamed from: d */
    public int f6226d;

    /* renamed from: e */
    public ObjectAnimator f6227e;

    public StreamingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6223a = new Random();
    }

    public static boolean isLayoutRtl(View view) {
        if (1 == view.getLayoutDirection()) {
            return true;
        }
        return false;
    }

    public int getStreamPosition() {
        return this.f6226d;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6224b = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), androidx.leanback.R.drawable.lb_text_dot_one), (int) (r0.getWidth() * 1.3f), (int) (r0.getHeight() * 1.3f), false);
        this.f6225c = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), androidx.leanback.R.drawable.lb_text_dot_two), (int) (r0.getWidth() * 1.3f), (int) (r0.getHeight() * 1.3f), false);
        reset();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.leanback.widget.StreamingTextView");
    }

    public abstract void reset();

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setStreamPosition(int i) {
        this.f6226d = i;
        invalidate();
    }
}
