package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import p000.ViewOnClickListenerC1578na;

/* loaded from: classes.dex */
public class AppCompatViewInflater {

    /* renamed from: b */
    public static final Class[] f624b = {Context.class, AttributeSet.class};

    /* renamed from: c */
    public static final int[] f625c = {R.attr.onClick};

    /* renamed from: d */
    public static final int[] f626d = {R.attr.accessibilityHeading};

    /* renamed from: e */
    public static final int[] f627e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f */
    public static final int[] f628f = {R.attr.screenReaderFocusable};

    /* renamed from: g */
    public static final String[] f629g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h */
    public static final SimpleArrayMap f630h = new SimpleArrayMap();

    /* renamed from: a */
    public final Object[] f631a = new Object[2];

    /* renamed from: a */
    public final View m167a(Context context, String str, String str2) {
        String concat;
        SimpleArrayMap simpleArrayMap = f630h;
        Constructor constructor = (Constructor) simpleArrayMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f624b);
            simpleArrayMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f631a);
    }

    /* renamed from: b */
    public final void m168b(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    @NonNull
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    @NonNull
    public AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    @NonNull
    public AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    @NonNull
    public AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    @NonNull
    public AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @NonNull
    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    @NonNull
    public AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    @NonNull
    public AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    @NonNull
    public AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @NonNull
    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @NonNull
    public AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    @Nullable
    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public final View createView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        char c;
        View createRatingBar;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
            int resourceId = z2 ? obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
            if (z3 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0)) != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
            obtainStyledAttributes.recycle();
            if (resourceId != 0 && (!(context2 instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context2).getThemeResId() != resourceId)) {
                context2 = new ContextThemeWrapper(context2, resourceId);
            }
        }
        if (z4) {
            context2 = TintContextWrapper.wrap(context2);
        }
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                createRatingBar = createRatingBar(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 1:
                createRatingBar = createCheckedTextView(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 2:
                createRatingBar = createMultiAutoCompleteTextView(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 3:
                createRatingBar = createTextView(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 4:
                createRatingBar = createImageButton(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 5:
                createRatingBar = createSeekBar(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 6:
                createRatingBar = createSpinner(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 7:
                createRatingBar = createRadioButton(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case '\b':
                createRatingBar = createToggleButton(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case '\t':
                createRatingBar = createImageView(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case '\n':
                createRatingBar = createAutoCompleteTextView(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case 11:
                createRatingBar = createCheckBox(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case '\f':
                createRatingBar = createEditText(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            case '\r':
                createRatingBar = createButton(context2, attributeSet);
                m168b(createRatingBar, str);
                break;
            default:
                createRatingBar = createView(context2, str, attributeSet);
                break;
        }
        if (createRatingBar == null && context != context2) {
            Object[] objArr = this.f631a;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = context2;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i = 0;
                    while (true) {
                        String[] strArr = f629g;
                        if (i < 3) {
                            View m167a = m167a(context2, str, strArr[i]);
                            if (m167a != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                createRatingBar = m167a;
                            } else {
                                i++;
                            }
                        } else {
                            createRatingBar = null;
                        }
                    }
                } else {
                    View m167a2 = m167a(context2, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    createRatingBar = m167a2;
                }
            } catch (Exception unused) {
                createRatingBar = null;
            } finally {
                objArr[0] = null;
                objArr[1] = null;
            }
        }
        if (createRatingBar != null) {
            Context context3 = createRatingBar.getContext();
            if ((context3 instanceof ContextWrapper) && createRatingBar.hasOnClickListeners()) {
                TypedArray obtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, f625c);
                String string = obtainStyledAttributes2.getString(0);
                if (string != null) {
                    createRatingBar.setOnClickListener(new ViewOnClickListenerC1578na(createRatingBar, string));
                }
                obtainStyledAttributes2.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, f626d);
                if (obtainStyledAttributes3.hasValue(0)) {
                    ViewCompat.setAccessibilityHeading(createRatingBar, obtainStyledAttributes3.getBoolean(0, false));
                }
                obtainStyledAttributes3.recycle();
                TypedArray obtainStyledAttributes4 = context2.obtainStyledAttributes(attributeSet, f627e);
                if (obtainStyledAttributes4.hasValue(0)) {
                    ViewCompat.setAccessibilityPaneTitle(createRatingBar, obtainStyledAttributes4.getString(0));
                }
                obtainStyledAttributes4.recycle();
                TypedArray obtainStyledAttributes5 = context2.obtainStyledAttributes(attributeSet, f628f);
                if (obtainStyledAttributes5.hasValue(0)) {
                    ViewCompat.setScreenReaderFocusable(createRatingBar, obtainStyledAttributes5.getBoolean(0, false));
                }
                obtainStyledAttributes5.recycle();
            }
        }
        return createRatingBar;
    }
}
