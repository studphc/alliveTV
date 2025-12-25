package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.appcompat.R;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;
import p000.AbstractC1497l3;
import p000.AbstractC1577n9;
import p000.AbstractC1975x9;
import p000.C1151ea;
import p000.C1345j8;
import p000.C1346j9;
import p000.C1383k9;
import p000.C1540m9;
import p000.o63;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView, OnReceiveContentViewBehavior, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* renamed from: a */
    public final C1345j8 f1150a;

    /* renamed from: b */
    public final C1151ea f1151b;

    /* renamed from: c */
    public final C1540m9 f1152c;

    /* renamed from: d */
    public final TextViewOnReceiveContentListener f1153d;

    /* renamed from: e */
    public final C1383k9 f1154e;

    /* renamed from: f */
    public C1346j9 f1155f;

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1156a = false;

        /* renamed from: b */
        public int f1157b;

        /* renamed from: c */
        public int f1158c;

        /* renamed from: d */
        public int f1159d;

        /* renamed from: e */
        public int f1160e;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapObject;
            int mapObject2;
            int mapObject3;
            int mapObject4;
            mapObject = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1157b = mapObject;
            mapObject2 = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1158c = mapObject2;
            mapObject3 = propertyMapper.mapObject("drawableTint", R.attr.drawableTint);
            this.f1159d = mapObject3;
            mapObject4 = propertyMapper.mapObject("drawableTintMode", R.attr.drawableTintMode);
            this.f1160e = mapObject4;
            this.f1156a = true;
        }

        public void readProperties(@NonNull AppCompatEditText appCompatEditText, @NonNull PropertyReader propertyReader) {
            if (this.f1156a) {
                propertyReader.readObject(this.f1157b, appCompatEditText.getBackgroundTintList());
                propertyReader.readObject(this.f1158c, appCompatEditText.getBackgroundTintMode());
                propertyReader.readObject(this.f1159d, appCompatEditText.getCompoundDrawableTintList());
                propertyReader.readObject(this.f1160e, appCompatEditText.getCompoundDrawableTintMode());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    public AppCompatEditText(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    @RequiresApi(26)
    @UiThread
    private C1346j9 getSuperCaller() {
        if (this.f1155f == null) {
            this.f1155f = new C1346j9(this);
        }
        return this.f1155f;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            c1345j8.m5407a();
        }
        C1151ea c1151ea = this.f1151b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            return c1345j8.m5408b();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            return c1345j8.m5409c();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1151b.m4673d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1151b.m4674e();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        C1540m9 c1540m9;
        if (Build.VERSION.SDK_INT < 28 && (c1540m9 = this.f1152c) != null) {
            TextClassifier textClassifier = (TextClassifier) c1540m9.f22855c;
            if (textClassifier == null) {
                return AbstractC1975x9.m8150a((TextView) c1540m9.f22854b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.f1154e.f20791b.isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        String[] onReceiveContentMimeTypes;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1151b.getClass();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 && onCreateInputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, getText());
        }
        o63.m6478x(onCreateInputConnection, editorInfo, this);
        if (onCreateInputConnection != null && i <= 30 && (onReceiveContentMimeTypes = ViewCompat.getOnReceiveContentMimeTypes(this)) != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, onReceiveContentMimeTypes);
            onCreateInputConnection = InputConnectionCompat.createWrapper(this, onCreateInputConnection, editorInfo);
        }
        return this.f1154e.f20791b.onCreateInputConnection(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && i < 33) {
            ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = AbstractC1577n9.m6320a(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat contentInfoCompat) {
        return this.f1153d.onReceiveContent(this, contentInfoCompat);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        ClipData primaryClip;
        int i2;
        if (Build.VERSION.SDK_INT < 31 && ViewCompat.getOnReceiveContentMimeTypes(this) != null && (i == 16908322 || i == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                primaryClip = null;
            } else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(primaryClip, 1);
                if (i == 16908322) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                ViewCompat.performReceiveContent(this, builder.setFlags(i2).build());
            }
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            c1345j8.m5411e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            c1345j8.m5412f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1151b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1151ea c1151ea = this.f1151b;
        if (c1151ea != null) {
            c1151ea.m4672b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean z) {
        this.f1154e.f20791b.setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener keyListener) {
        super.setKeyListener(this.f1154e.m5512a(keyListener));
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            c1345j8.m5414h(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C1345j8 c1345j8 = this.f1150a;
        if (c1345j8 != null) {
            c1345j8.m5415i(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C1151ea c1151ea = this.f1151b;
        c1151ea.m4680k(colorStateList);
        c1151ea.m4672b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C1151ea c1151ea = this.f1151b;
        c1151ea.m4681l(mode);
        c1151ea.m4672b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C1151ea c1151ea = this.f1151b;
        if (c1151ea != null) {
            c1151ea.m4676g(i, context);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        C1540m9 c1540m9;
        if (Build.VERSION.SDK_INT < 28 && (c1540m9 = this.f1152c) != null) {
            c1540m9.f22855c = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C1345j8 c1345j8 = new C1345j8(this);
        this.f1150a = c1345j8;
        c1345j8.m5410d(attributeSet, i);
        C1151ea c1151ea = new C1151ea(this);
        this.f1151b = c1151ea;
        c1151ea.m4675f(attributeSet, i);
        c1151ea.m4672b();
        this.f1152c = new C1540m9(this);
        this.f1153d = new TextViewOnReceiveContentListener();
        C1383k9 c1383k9 = new C1383k9(this);
        this.f1154e = c1383k9;
        c1383k9.m5513b(attributeSet, i);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = super.isFocusable();
        boolean isClickable = super.isClickable();
        boolean isLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener m5512a = c1383k9.m5512a(keyListener);
        if (m5512a == keyListener) {
            return;
        }
        super.setKeyListener(m5512a);
        super.setRawInputType(inputType);
        super.setFocusable(isFocusable);
        super.setClickable(isClickable);
        super.setLongClickable(isLongClickable);
    }
}
